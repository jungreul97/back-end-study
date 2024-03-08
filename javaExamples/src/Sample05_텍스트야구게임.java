import java.util.Random;

public class Sample05_텍스트야구게임 {
    public static void main(String[] args) throws InterruptedException {
        int outcount = 0;
        int num = 1;
        int ball = 0;
        int strike = 0;
        System.out.println(num+"번 타자");
        while (outcount<3){
            Thread.sleep(1000);
            int ball_type = (int)(Math.random()*2);
            if (ball_type == 0) {
                System.out.println("볼~");
                ball++;
            } else {
                System.out.println("스트라이크!");
                strike ++;
            }
            if (ball == 4) {
                System.out.println("1루 진루");
                ball = 0;
                strike = 0;
                num++;
                System.out.println(num+"번 타자");
            }
            else if(strike == 3) {
                System.out.println("삼진 아웃!");
                outcount++;
                num++;
                ball = 0;
                strike = 0;
                System.out.println(num+"번 타자");
            }
            if (outcount == 3) System.out.println("게임종료!");
        }
    }
}
