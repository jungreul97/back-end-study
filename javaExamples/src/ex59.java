
//스레드 : Thread 실타래
// : 프로그램안의 작은 프로그램을 의미함.
//스레드 구현 방법
//1. Thread 추상클래스 이용
//2. Runnable 인터페이스 이용
class Printer extends Thread {
    int count = 0;
    @Override
    public void run() {
        //super.run(); 지워야 됨.
        //한번만 실행되기에, 무한반복문 사용한다.
        while (true){
            System.out.println("Printer:"+ count++);
            if( count > 10 ){
                break;
            }
        }
    }
}
class Printer2 implements Runnable{
    int count = 0;
    @Override
    public void run() {
        while (true){
            System.out.println("Printer2:"+ count++);
            if( count > 10 ){
                break;
            }
        }
    }
}
public class ex59 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.start();
        System.out.println("메인스레드 종료됨.");

        Printer2 printer2 = new Printer2();
        Thread t = new Thread( printer2 );
        t.start();
    }
}