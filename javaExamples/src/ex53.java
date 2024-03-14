public class ex53 {
    public static void main(String[] args) {
        // 래퍼 클래스 ( Wrapper Class)
        // 1. 기본자료형 8개를 감싸서 클래스로 만든것
        // 2. 클래스로 만들어야 다형성을 이용가능하다.

        // 기본자료형 8개 : int long short byte char boolean float double
        // 래퍼클래스 : Integer Long Short Byte Character Boolean Float Double
        // 숫자클래스 ; Number <= int long short byre float double

        Integer intValue1 = new Integer(10);
        Integer intValue2 = 10;
        System.out.println(intValue2); // 10
        System.out.println(intValue2.byteValue()); // 10
        System.out.println(intValue2.doubleValue()); // 10.0

        Number number1 = 30;
        Number number2 = 3.14d;
        System.out.println(number1.intValue()); // 30
        System.out.println(number2.intValue()); // 3
    }
}
