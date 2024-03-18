import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {
    static int[][] map = new int[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Socket socket = null;
        socket = new Socket();
        try {
            socket.connect(
                    //127.0.0.1 : 접속하려는 컴퓨터의 주소를 말함. localhost와 같은 말.
                    new InetSocketAddress("127.0.0.1", 5001)
            );
            System.out.println("서버 접속 성공!");

            //서버에 문자열형으로 데이타를 보내보자.
            byte[] bytes = null;
            String message = null;

            OutputStream os = socket.getOutputStream();
            System.out.println("명령어를 입력하세요(c1,0,0,1):");
            message = sc.nextLine(); //"c1,0,0,1";
            //UTF-8 : 문자인코딩(부호화,암호화) 타입
            //문자인코딩타입 : ASCII(영문), EUC-KR(완성형한글), UTF-8(유니코드-전세계문자)
            //             : cp949(ms949) 윈도우즈 한글 인코딩
            bytes = message.getBytes("UTF-8");
            os.write(bytes);
            os.flush(); //버퍼에 데이타를 다 내보낸다.
            System.out.println("데이타보내기 성공:"+message);

            //서버로부터 데이터 받기
            InputStream is = socket.getInputStream();
            bytes = new byte[1024];
            int readByteCount = is.read(bytes);
            message = new String(bytes, 0, readByteCount, "UTF-8");
            System.out.println("데이타받기 성공:"+message);

            os.close();
            is.close();
        } catch (Exception e) {
            System.out.println("서버 접속 오류!");
        }
    }
}
