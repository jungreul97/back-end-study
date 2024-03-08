import java.util.Scanner;

public class Sample02_로또번호발생기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        int[] arr  = new int[46];
        int T = 0;
        while (T < 6) {
            System.out.println("번호를 입력하세요 ( 1 ~ 45 ) > ");
            int n = sc.nextInt();
            if (arr[n]  == 1){
                str += String.valueOf(n)+"(중복발생! 재추첨) ";
                System.out.println("로또 번호 > "+ str);
                continue;
            }else{
                arr[n] += 1;
                str += String.valueOf(n)+" ";
                System.out.println("로또 번호 > " + str);
                T+=1;
            }
        }
        sc.close();
    }
}
