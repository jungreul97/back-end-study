import java.util.Scanner;

public class ex18 {
    public static void main(String[] args) {
        //반복문의 제어문 : break continue
        //break : 반복문 중단
        //continue : 증감식으로 이동
        for( int i=0; i<10; i++ ){
            if( i > 5 )
                break;
            System.out.println( i );
        }
        for( int i=0; i<10; i++) {
            if( i%2 == 0 ){
                continue;
            }
            System.out.println( i );
        }

        //연습문제 - break,continue
        //1~100사이의 정수 한개 n을 입력받고
        //1부터 n까지의 소수를 출력하시오.
        //소수 조건 : 1과 자신만 나누어 떨어지는 수
        //         : 약수 갯수는 2개
        //입력 예)
        //6
        //출력 예)
        //2
        //3
        //5
        //소수의 갯수는 4개
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 2; i < num+1;i ++){
            int cnt = 0;
            for (int j = 2; j < i; j++){
                if (i % j == 0) cnt++;
                if (cnt > 0) break;
            }
            if (cnt == 0) System.out.println(i);
        }

    }
}