// 객체지향프로그래밍(OOP)
// 모든 사물을 객체(물건)로 추상화(모델링,설계)하여
// 프로그래밍하는 기법
// 예) 자동차
// 속성(변수,필드)과 행동(메소드,함수)으로 구분한다.

// 클래스 선언부
class Car {
    // 속성 = 변수(필드) = 멤버변수
    int price = 1000;
    // 행동(동작) = 함수(메소드) = 멤버함수
    void run(){ // return이 없는 함수
        System.out.println("달린다.");
    }

}
public class ex25 {
    public static void main(String[] args) {
        // 클래스의 객체 생성 및 호출부
        // 클래스이름 객체이름 = new 클래스이름(); -> 클래스 객체 생성 패턴
        Car car = new Car();
        // 객체이름 뒤에 점을 찍으면 멤버변수/함수에 접근가능.
        System.out.println(car.price);
        car.run();
        // System.out.println(car.run()); -> return 이 없기때문에 오류 발생!
    }
}
