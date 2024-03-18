import java.util.Scanner;

public class pr01 {
    public static void main(String[] args) {
        //알바천국
        //알바가는 날 : 월1 수3 금5 일7
        //          : 홀수일때 알바한다.
        Scanner scanner = new Scanner(System.in);
        System.out.println("날짜 입력(1~7):");
        int day = scanner.nextInt();
        if( day%2 == 1 ){
            System.out.println("oh my god");
        }else{
            System.out.println("enjoy");
        }
    }
}
