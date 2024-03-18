//람다식 Lambda Expression
//  : JDK 1.8부터 지원
//  : 함수형(코드) 변수 지원하기 위해서 사용함.

//코드를 변수처럼 전달하기 위해서
// 자바 : 객체(클래스-변수/함수), 람다식(비동기적인 코드 처리)
//     : 선언되는 시점과 실행되는 시점이 다른 것.
// 3세대 언어의 특징 - 함수형 언어(블럭형 언어)
//   JS, 스위프트, 코틀린
@FunctionalInterface //람다식 선언시에 사용
interface MyFunc1{
    int calc(int x, int y);
}
public class ex64 {
    public static void main(String[] args) {
        MyFunc1 f1 = ( x, y ) -> { return x+y; };
        System.out.println( f1.calc( 10, 20 ) );
        //코드를 변수처럼 전달하고, 비동기적인 처리를 한다.
        exeFunc( f1 );
    }
    static void exeFunc(MyFunc1 f1){
        System.out.println( f1.calc( 10, 20 ) );
    }
}
