import java.util.Scanner;

public class Sample04_컴퓨터와함께369게임하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 1;
        while (num <= 40){
            if (num == 40){
                System.out.println("무승부");
                System.out.println("게임종료");
                break;
            }
            boolean X_check = false; // 3,6,9 포함되어 있는지 CHECK
            String s = String.valueOf(num);
            if (s.contains("3") || s.contains("6") || s.contains("9")) X_check = true;

            if (num%2 == 1) { // 홀수 : 컴퓨터 차례일 때
                if (X_check) System.out.println("컴퓨터 : X");
                else System.out.println("컴퓨터 : "+num);
            }else { // 내 차례일 때
                System.out.print("나 :");
                String input = sc.nextLine();
                if (X_check) {
                    if (!input.equals("X")) {
                        System.out.println("컴퓨터 승!");
                        System.out.println("게임종료");
                        break;
                    }
                } else if (!input.equals(s)) {
                    System.out.println("컴퓨터 승!");
                    System.out.println("게임종료");
                    break;
                }
            }
            num+=1;
        }
    }
}
