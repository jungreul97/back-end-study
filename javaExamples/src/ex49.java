// 익명 객체(이름없는 객체 - Anonymous Object)
// : 1회성 메소드(코드뭉치)
// : 한번 쓰고 버릴 코드에 굳이 이름을 붙여서 사용할 필요가 없다.
interface NormalCar{
    void run();
}
// 여러번 쓸거면 정식적으로 클래스를이름을 만들고 구현한다.
class SuperCar implements NormalCar{
    @Override
    public void run() {
        System.out.println("수퍼카가 달린다.");
    }
}
public class ex49 {
    public static void main(String[] args) {
        SuperCar superCar = new SuperCar();
        superCar.run();
        // 일회성 익명 인터페이스 구현 객체를 선언/생성한다.
        NormalCar normalCar = new NormalCar() {
            @Override
            public void run() {
                System.out.println("수퍼카가 달린다.");
            }
        };
        normalCar.run();
    }
}
