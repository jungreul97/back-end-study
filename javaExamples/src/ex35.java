class StaticClass{
    int a;
    static int b;
    static {
        b = 5;
        System.out.println("static block!");
    }
    //생성자함수 -> new를 할때 호출됨! 직접 호출 해야 됨
    StaticClass(){
        a = 3;
        b = 7;
    }
}
public class ex35 {
    public static void main(String[] args) {
        System.out.println(StaticClass.b); // 5
        StaticClass s = new StaticClass();
        System.out.println(StaticClass.b); // 7
    }
}
