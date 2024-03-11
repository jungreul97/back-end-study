import java.util.Scanner;

public class ex19 {
    public static void main(String[] args) {
        //이중반복문
        //구구단 출력하기 2단 ~ 9단 / *1 ~ *9
        for(int i=2; i<10; i++){
            for(int j=1; j<10; j++){
                System.out.println( i + "*" + j + "=" + i*j);
            }
        }
        //연습문제 - 별찍기
        //1. 다음과 같이 출력하시오.
        // 입력 예)
        // 5
        // 출력 예)
        //*****
        //*****
        //*****
        //*****
        //*****
        // 입력 예)
        // 3
        // 출력 예)
        //***
        //***
        //***
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0;i<n;i++){
            for (int j=0;j<n;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //2. 별찍기2
        //입력 예)
        //3
        //출력 예)
        //  *
        // **
        //***
        //입력 예)
        //5
        //출력 예)
        //    *
        //   **
        //  ***
        // ****
        //*****
        n = sc.nextInt();
        for (int i = 1; i < n+1;i++){
            for (int j = n-i; j>0 ; j--){
                System.out.print(" ");
            }
            for (int k = 0;k<i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
        //2. 별찍기3
        //입력 예) 5이상의 홀수
        //5
        //출력 예)
        //*****
        //*  **
        //* * *
        //**  *
        //*****
        //입력 예)
        //7
        //출력 예)
        //*******
        //*    **
        //*   * *
        //*  *  *
        //* *   *
        //**    *
        //*******
        n = sc.nextInt();
        for (int i=0;i<n;i++) {
            if (i == 0 || i == n - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.print("*");
                }
            } else {
                System.out.print("*");
                for (int j = 0; j < n - 2 - i; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                for (int j = 0; j < i - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
}