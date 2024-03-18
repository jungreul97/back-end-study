//자바 종합 실습 - 2인1조
//TCP/IP(소켓) 통신을 이용한 게임만들기
//주제: 틱택토이 게임(OX게임)
//https://lagged.kr/p/1378/

//기능 및 설계 요구사항
//1. 2인용 통신을 이용한 온라인 게임
//2. 서버프로그램 1개 + 클라이언트 프로그램 1개
//   클라 <---> 서버
//3. 서버는 3x3 정수형 2차 배열에 바둑판의 정보를 static으로 가진다.
//4. 0은 빈 칸, 1은 O, 2는 X 이다.
//5. 입력 및 출력 예)
// 클라 : "c1,0,0,O"엔터
// 서버 : 클라1으로부터 정보가 수신되었습니다.
// O - -
// - - -
// - - -
// 클라 :
// O - -
// - - -
// - - -
// 클라 : "c2,0,1,X"
// 서버 : 클라2으로부터 정보가 수신되었습니다.
// O X -
// - - -
// - - -
// 클라 :
// O X -
// - - -
// - - -
// 클라 : "info"엔터
// 서버 : 클라로부터 정보가 수신되었습니다.
// O X -
// - - -
// - - -
// 클라 :
// O X -
// - - -
// - - -

//게임판정
//가로,세로,대각선 방향으로 O/X가 3개 연속되면, 승리하게 된다.

//개발순서
//서버 : int[][] map = new int[3][3];
//클라 : "c1,0,0,O" 문자열을 서버로 전송
//서버 : "c1,0,0,O"을 꼼마 단위로 문자열배열로 만들고,
//       map 정수배열 값을 업데이트한다.
//서버 : "1,0,0,0,0,0,0,0,0" 문자열을 클라1에게 전송한다.
//클라 : "1,0,0,0,0,0,0,0,0" 문자열을 꼼마단위로 분석해서,
//       map 정수배열 값을 업데이트한다.
//서버 : 게임판정을 해서 승리한 클라이언트 이름을 출력한다.

//클라 : "c2,0,1,X" 문자열을 서버로 전송
//서버 : "c2,0,1,X"을 꼼마 단위로 문자열배열로 만들고,
//       map 정수배열 값을 업데이트한다.
//서버 : "1,2,0,0,0,0,0,0,0" 문자열을 클라에게 전송한다.
//클라 : "1,2,0,0,0,0,0,0,0" 문자열을 꼼마단위로 분석해서,
//       map 정수배열 값을 업데이트한다.
//서버 : 게임판정을 해서 승리한 클라이언트 이름을 출력한다.

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    static int[][] map = new int[3][3];

    static void initData(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                map[i][j] = 0;
            }
        }
    }
    static String getMapData(){
        String strMap = "";
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                strMap += ""+map[i][j];
                if( !(i==2 && j==2) ) {
                    strMap += ",";
                }
            }
        }
        return strMap;
    }
    static void dispMap(){
        System.out.println();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(map[i][j] == 0)
                    System.out.print("-");
                else if(map[i][j] == 1)
                    System.out.print("O");
                else
                    System.out.print("X");
            }
            System.out.println();
        }
    }
    static int decideMap(){
        //게임판정 로직
        //총 8개의 경우의 수가 있음.
        //가로 3개 일치, 세로 3개 일치, 대각선 2개 일치
        //resultGame : 0이면 게임중 1이면 C1 승, 2이면 C2 승, 3이면 무승부
        int resultGame = 0;

        for(int k=1; k<3; k++) {
            for (int i = 0; i < 3; i++) {
                if (map[i][0] == k && map[i][1] == k && map[i][2] == k) {
                    resultGame = k;
                    break;
                }
            }
            for (int j = 0; j < 3; j++) {
                if (map[0][j] == k && map[1][j] == k && map[2][j] == k) {
                    resultGame = k;
                    break;
                }
            }
            if (map[0][0] == k && map[1][1] == k && map[2][2] == k) {
                resultGame = k;
            } else if (map[0][2] == k && map[1][1] == k && map[2][0] == k) {
                resultGame = k;
            }
        }

        int zeroCount = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if( map[i][j] == 0  ) {
                    zeroCount++;
                }
            }
        }
        if( zeroCount == 0 && resultGame == 0 ){
            resultGame = 3;//무승부
        }

        return resultGame;
    }
    public static void main(String[] args) {

        initData();

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(
                    new InetSocketAddress("127.0.0.1", 5001) );
            while( true ){
                System.out.println("서버가 연결을 기다리는 중...");
                Socket socket = serverSocket.accept(); //Blocking..대기중..
                InetSocketAddress isa =
                        (InetSocketAddress)socket.getRemoteSocketAddress();
                System.out.println("서버가 연결을 수락함:"+isa.getHostName());

                //"c2,0,0,X" or "info"

                //클라이언트 데이타를 수신한다.
                byte[] bytes = null;
                String message = null;
                InputStream is = socket.getInputStream();
                bytes = new byte[1024]; //1024바이트만큼 버퍼메모리 생성
                int readByteCount = is.read(bytes);
                message = new String(bytes, 0, readByteCount, "UTF-8");
                System.out.println("서버가 데이타받기 성공함.");
                System.out.println("서버가 받은 데이타:"+message);

                //클라로부터 받은 데이타 분석
                //"c1,0,0,1"
                String clientName = "";
                int rowNum = 0;
                int colNum = 0;
                int oxNum = 0;
                String[] arrMsg = message.split(",");
                clientName = arrMsg[0];
                if( clientName.equals("c1") == true ){
                    clientName = "c1";
                }else{
                    clientName = "c2";
                }
                rowNum = Integer.parseInt( arrMsg[1] );
                colNum = Integer.parseInt( arrMsg[2] );
                oxNum = Integer.parseInt( arrMsg[3] );
                map[rowNum][colNum] = oxNum;

                //게임판 출력
                dispMap();
                //게임 판정
                int resultGame = decideMap();
                //0이면 게임중 1이면 C1 승, 2이면 C2 승, 3이면 무승부
                if( resultGame == 1 ){
                    System.out.println("클라1이 승리함!");
                }
                else if( resultGame == 2){
                    System.out.println("클라2가 승리함.");
                }
                else if( resultGame == 3) {
                    System.out.println("무승부임!");
                }

                //서버에서 클라로 데이타 보내기
                OutputStream os = socket.getOutputStream();
                //message = "Hi~ This is Server~";
                message = getMapData();
                bytes = message.getBytes("UTF-8");
                os.write(bytes);
                os.flush(); //버퍼에 있는 데이타 밀어내기
                System.out.println("서버가 클라에게 데이타보내기 성공");

                is.close();
                os.close();
                socket.close();
                if(message.equals("exit")){ //"exit"문자열이면 서버 종료!
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("서버 초기화 에러!");
        }

    }
}
