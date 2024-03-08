import java.util.Scanner;

public class Sample01_알바천국 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("요일을 입력하세요(1~7) : ");
        int num = sc.nextInt();
        System.out.println( num == 1 || num == 3 || num == 5 ? "oh my god" : "enjoy");
    }
}
