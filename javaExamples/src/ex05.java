public class ex05 {
    public static void main(String[] args) {
        String str1 = new String("안녕"); // 새로운 객체 생성
        String str2 = "안녕"; // 같은 내용의 리터럴 객체 있는지 확인
        String str3 = "안녕"; // 같은 내용의 리터럴 객체 있는지 확인
        String str4 = new String("안녕"); // 새로운 객체 생성

        System.out.println(str1 == str2); // false
        System.out.println(str2 == str3); // true
        System.out.println(str3 == str4); // false
        System.out.println(str4 == str1); // false

        // 문자열 연결 연산자 +
        // 산술 연산자 +
        System.out.println("한글"+"만세"); // 한글만세
        System.out.println("한글"+10); // 한글10
        System.out.println(10+"한글"+10); // 10한글10
        System.out.println(10+20); // 30

        System.out.println("한글"+10+20); // 한글1020 => 연산자 우선순위 좌->우
        System.out.println(10+20+"한글"); // 30한글
        // 기본 자료형 => 문자열형 으로 변환
        String str = String.valueOf(10);
        // 문자열형 => 정수형
        int num = Integer.parseInt("10");
        System.out.println(str);
        System.out.println(num);
    }
}
