// 중첩 클래스 : 클래스 안에 클래스가 들어가는 것
// 외부(Outer) 클래스 : 클래스 밖에 클래스를 선언
// 내부(Inner) 클래스 : 클래스 안에 클래스를 선언
// 내부클래스를 사용하는 이유
// : 내부적으로 소비하고 끝나는 클래스는 내부클래스로 선언
class Outer{
    String name = "outer";
    class Inner {
        String name = "inner";
    }
    static class InnerStatic{
        String name = "inner static";
    }
}
public class ex50 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        System.out.println(outer.name);
        Outer.Inner inner = outer.new Inner(); // Outer 객체가 내려와야 됨.
        System.out.println(inner.name);
        Outer.InnerStatic innerStatic = new Outer.InnerStatic();
        System.out.println(innerStatic.name);
    }
}
