// final이 클래스 안에서 사용될 때
// 1. fianl 필드 : 상수처럼 동작, 한번 값이 들어가면 다시 대입 안됨.
// 2. final class : 상속 불가
// 3. final 메소드 : 오버라이드 불가
final class FinalClass{
    String name = "파이널 클래스";
    final void disp(){} // 자식 클래스에 오버라이드도 안됨!!!
}
// final class는 상속 불가
//class LastClass extends FinalClass{
//}

public class ex41 {
    public static void main(String[] args) {
        FinalClass fc = new FinalClass();
        // fc.price = 2000; 수정 불가 구문
        // 상수 선언시
        final double PI = 3.141592;
        // PI = 6.13; // 다시 값을 넣으려고 하면 오류

    }
}
