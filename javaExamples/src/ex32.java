// 싱글톤(Singleton) -> 전역에서 단 하나의 클래스 인스턴스만을 생성하게 강제하는 디자인 패턴
// 프로그램 전반에 걸쳐 오직 하나의 인스턴스만이 존재하게 되어 리소스의 중복 사용을 방지하고 전역적으로 하나의 상태를 관리할 수 있게 됨
// : 프로그램안에서의 유일한 클래스 객체
// : new를 통해서여러개의 객체를 반복적으로 찍어낼 수 있다.
// : 예) 붕어빵1, 붕어빵2, ...
//       절대붕어빵(유일한 붕어빵)
// 유일한 객체가 필요한 이유
// : 유일한 정보를 저장하기 위해서
class FishBun{ // 일반 붕어빵 : 일반 객체
    int bunNo = 10;

}
class UniqueFishBun { // 절대 붕어빵 : 싱글톤
    int bunNo = 30;
    private static UniqueFishBun singleton; // null
    static UniqueFishBun getInstance(){
        if (singleton == null){
            singleton = new UniqueFishBun();
        }
        return singleton;
    }
}
public class ex32 {
    public static void main(String[] args) {
        FishBun bun1 = new FishBun();
        FishBun bun2 = new FishBun();
        FishBun bun3 = new FishBun();
        System.out.println(bun1);//3b07d329
        bun1.bunNo = 20;
        System.out.println(bun2);//41629346
        System.out.println(bun1.bunNo);
        System.out.println(bun2.bunNo);
        // 일반객체는 일관된 데이터를 저장할 수 없다.
        // dynamic하다. 객체의 생성과 소멸이 자유롭게 이루어진다.
        // GC(Garbage Collector)가 메모리를 회수한다.
        UniqueFishBun uBun1 = UniqueFishBun.getInstance();
        UniqueFishBun uBun2 = UniqueFishBun.getInstance();
        System.out.println(uBun1);//6d311334
        System.out.println(uBun2);//6d311334 같은 주소를 공유함
    }
}
