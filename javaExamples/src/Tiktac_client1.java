import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Tiktac_client1 {
    public static void main(String[] args) {

            while (true){
                Socket socket = null;
                socket = new Socket();
                try {
                    socket.connect(
                            new InetSocketAddress("172.16.21.214", 5001)
                    );
                    System.out.println("서버 접속 성공!");
                    //서버에 문자열형으로 데이타를 보내보자.
                    byte[] bytes = null;
                    String message = null;
                    int[][] map = new int[3][3];

                    OutputStream os = socket.getOutputStream();
                    Scanner sc = new Scanner(System.in);
                    // 데이터 입력 받기
                    System.out.println("유저1 : O를 놓을 위치를 선택하세요(0~2)");
                    System.out.print("x 좌표 : ");
                    int x = sc.nextInt();
                    System.out.print("y 좌표 : ");
                    int y = sc.nextInt();
                    System.out.print("놓을 블럭을 입력하세요(O,X) : ");
                    String block = sc.next();
                    while (x<0 && 3<=x && y<0 && 3<=y && (block.equals("O") || block.equals("X"))){
                        System.out.println("0~2 의 사이 값으로 다시 입력하세요");
                        System.out.print("x 좌표 : ");
                        x = sc.nextInt();
                        System.out.print("y 좌표 : ");
                        y = sc.nextInt();
                        System.out.print("놓을 블럭을 입력하세요(O,X) : ");
                        block = sc.next();
                    }
                    // 전송할 데이터 만들기
                    message = "c1,"+String.valueOf(x)+","+String.valueOf(y)+","+block;

                    bytes = message.getBytes("UTF-8");
                    os.write(bytes);
                    os.flush(); //버퍼에 데이타를 다 내보낸다.
                    System.out.println("데이타보내기 성공!");

                    //서버로부터 데이터 받기
                    InputStream is = socket.getInputStream();
                    bytes = new byte[1024];
                    int readByteCount = is.read(bytes);
                    message = new String(bytes, 0, readByteCount, "UTF-8");
                    System.out.println("데이터 받기 성공 ! : "+message);

                    System.out.println("< 현재 틱택토이 >");
                    List<String> list = Arrays.asList(message.split(","));
                    int x_idx = 0;
                    int y_idx = 0;
                    for (int i=1;i<10;i++) {
                        map[x_idx][y_idx] = Integer.parseInt(list.get(i-1));
                        System.out.print(list.get(i-1)+" ");
                        y_idx+=1;
                        if (i%3 == 0){
                            System.out.println();
                            x_idx += 1;
                            y_idx = 0;
                        }
                    }

                    if ((map[0][0] == 1 && map[0][1] == 1 && map[0][2] == 1) || (map[1][0] == 1 && map[1][1] == 1 && map[1][2] == 1) || (map[2][0] == 1 && map[2][1] == 1 && map[2][2] == 1)
                        || (map[0][0] == 1 && map[1][0] == 1 && map[2][0] == 1) || (map[0][1] == 1 && map[1][1] == 1 && map[2][1] == 1) || (map[0][2] == 1 && map[1][2] == 1 && map[2][2] == 1)
                        || (map[0][0] == 1 && map[1][1] == 1 && map[2][2] == 1) || (map[0][2] == 1 && map[1][1] == 1 && map[2][0] == 1)) {
                        System.out.println("c1 승리 !");
                        break;
                    }else if(((map[0][0] == 2 && map[0][1] == 2 && map[0][2] == 2) || (map[1][0] == 2 && map[1][1] == 2 && map[1][2] == 2) || (map[2][0] == 2 && map[2][1] == 2 && map[2][2] == 2)
                            || (map[0][0] == 2 && map[1][0] == 2 && map[2][0] == 2) || (map[0][1] == 2 && map[1][1] == 2 && map[2][1] == 2) || (map[0][2] == 2 && map[1][2] == 2 && map[2][2] == 2)
                            || (map[0][0] == 2 && map[1][1] == 2 && map[2][2] == 2) || (map[0][2] == 2 && map[1][1] == 2 && map[2][0] == 2)) ){
                        System.out.println("c2 승리 !");
                        break;
                    }
                    os.close();
                    is.close();
            } catch (Exception e) {
                    System.out.println("서버 접속 오류!");
            }
        }
    }
}