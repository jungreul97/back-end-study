public class ex02 {
    public static void main(String[] args) {
        // 한 줄 주석문
        /*
        여러줄 주석문
        */
        // 출력문
        System.out.println("화면출력");
        System.out.println("화면"+"출력");
        System.out.println("화면"+10+20);
        System.out.println(10+20+"화면");

        // println print printf
        // println : 문자열 한 줄 출력 + 줄 바꿈
        // print : 줄바꿈 x
        // printf : 형식화 된 출력문
        // \n : 줄 바꿈 특수문자
        System.out.println("한 줄 출력 후 줄 바꿈");
        System.out.print("한 줄 출력 후 줄 바꿈 없음");
        System.out.printf("%d\n", 30); // 10진수
        System.out.printf("%o\n", 30); // 8진수
        System.out.printf("%x\n", 30); // 16진수
        System.out.printf("%e\n", 300.0); // 지수형 출력
    }
}