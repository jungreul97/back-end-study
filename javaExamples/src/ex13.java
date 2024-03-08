import java.util.Scanner;

public class ex13 {
    public static void main(String[] args) {
        // Scanner 클래스 함수들
        // nextLine() : 문자열을 입력받되 엔터까지(공백까지)
        // next() : 문자열의 공백까지만 입력 받음.
        // nextInt() : 문자열을 받아서 정수로 반환해줌.
        // nextFloat() :             실수로 변환해줌.
        // nextDouble() :            실수로 반환해줌.
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        System.out.println(str1);

        String str2 = sc.next();
        System.out.println(str2);

        // java.util.InputMismatchException
        // next() 함수에 저장된 버퍼메모리가 정리되지 않아서이다.
        // 해결방안 : nextLine() 함수를 한번 실행해준다.
        sc.nextLine();

        int num1 = sc.nextInt();
        System.out.println(num1);
        sc.close(); // sc객체가 사용중인 메모리 정리
    }
}
