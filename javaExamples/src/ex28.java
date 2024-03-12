
class MyClass {
    //메소드 4가지 패턴
    //선언부
    //매개변수 X 반환형 X
    void func1( ){
        System.out.println("func1");
    }
    //매개변수 O 반환형 X
    void func2(int x, int y){
        System.out.println("func2");
        System.out.println(x +" "+ y);
    }
    //매개변수 X 반환형 O
    int func3( ){
        System.out.println("func3");
        return 10;
    }
    //매개변수 O 반환형 O
    int func4(int x, int y){
        System.out.println("func4");
        return x + y;
    }
}
public class ex28 {
    public static void main(String[] args) {
        //호출부
        MyClass myClass = new MyClass();
        myClass.func1();
        myClass.func2(10,20);
        int result = myClass.func3();
        System.out.println( result );
        result = myClass.func4(10, 20);
        System.out.println( result );
    }
}