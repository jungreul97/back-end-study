// 상속관계에서 생성자 호출되는 순서(초기화 순서)
class Energy{
    int price = 1000;
    // 생성자 자동생성 -> 우클릭 -> 생성 -> 생성자
    public Energy() { // 기본생성자
        System.out.println("Energy - 기본생성자");
    }
    public Energy(int price) {
        this.price = price;
        System.out.println("Energy - 필드가 있는 생성자");
    }
}
class WindEnergy extends Energy{
    int price = 2000;
    public WindEnergy() {
        System.out.println("Wind - 기본생성자");
    }
    public WindEnergy(int price) {
        // 반드시 첫줄에 작성하기
        super(price); // 부모의 필드 생성자 호출!!!! 없으면 부모 기본생성자 호출
        this.price = price;
        System.out.println("Wind - 필드 생성자");
    }
}
// this. : 자기클래스의 필드/메소드 접근
// this() : 자기클래스의 생성자 함수 호출
// super. : 부모클래스의 필드/메소드 접근
// super() : 부모클래스의 생성자 함수 호출
public class ex39 {
    public static void main(String[] args) {
        // Energy - 기본생성자
        // Wind - 기본생성자
        // 부모먼저 호출 되고 자녀 호출
        WindEnergy we1 = new WindEnergy();
        // Energy - 기본생성자
        // Wind - 필드 생성자
        // 부모 기본 -> 자녀 필드
        WindEnergy we2 = new WindEnergy(3000);

    }
}
