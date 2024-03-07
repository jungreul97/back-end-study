public class ex03 {
    public static void main(String[] args) {
        // 데이터 타입(자료형)
        // 기본 자료형 8개
        // 정수형 : int(4) long(8) short(2) byte(1)
        // 실수형 : float(4) double(8)
        // 논리형 : boolean(1)
        // 문자형(내부적으로 숫자형) : char(2)
        int myInt = 10;
        System.out.println(myInt);
        long myLong = 20L; // L long 리터럴로 초기화 (소문자로 써도 되는데 헷갈림)
        System.out.println(myLong);
        short myShort = 30;
        System.out.println(myShort);
        byte myByte = 40;
        System.out.println(myByte);

        // 실수형
        // float 4
        float myFloat = 6.14f;  // float 리터럴 초기화
        double myDouble = 3.14d; // double 리터럴 초기화
        System.out.println(myFloat);
        System.out.println(myDouble);

        // 논리형 boolean
        boolean myBoolean = true;
        System.out.println(myBoolean);

        // 문자형 char
        char myChar1 = 'A';
        char myChar2 = '가';
        System.out.println(myChar1);
        System.out.println(myChar2);
        System.out.println((int)myChar1);
        System.out.println((int)myChar2);
        System.out.println((char)65);
        System.out.println((char)0xAC00);

        // 참조타입
        // 무자열
        String myString = "문자열ABC";
        String myString2 = new String("문자열");
        System.out.println(myString);
        System.out.println(myString2);

        // 배열
        // 클래스(객체)
        // 열거형

    }
}