public class ex22 {
    public static void main(String[] args) {
        //연습문제
        //철수가 AI로봇과 가위바위보 게임을 한다.
        //철수가 가위를 낼 확률은 1/10이고, 바위를 낼 확률은 5/10,
        //보를 낼 확률은 4/10이다.
        //AI로봇은 동일한 확률로 가위바위보를 낸다.
        // 팁) 1~10까지 랜덤수를 발생하여 1이면 10%, 2~6이면 50%,
        //    7~10이면 40%의 확률임.
        //철수가 이길 때까지 가위바위보 게임을 한다고 할때
        //과정과 결과를 출력하시오.
        //출력결과
        //철수:가위 AI로봇:가위
        //무승부
        //철수:바위 AI로봇:보
        //로봇 승
        //철수:보 AI로봇:주먹
        //철 수 승!

        while (true){
            int n = (int)(Math.random()*10)+1;
            int rand_num = (int)(Math.random()*3)+1;

            if (n == 1){
                if (rand_num == 1) {
                    System.out.println("철수 : 가위 AI로봇 : 가위");
                    System.out.println("무승부");
                }
                else if (rand_num == 2) {
                    System.out.println("철수 : 가위 AI로봇 : 바위");
                    System.out.println("로봇 승");
                }else{
                    System.out.println("철수 : 가위 AI로봇 : 보");
                    System.out.println("철수 승");
                    break;
                }
            }else if(n == 2){
                if (rand_num == 1) {
                    System.out.println("철수 : 바위 AI로봇 : 가위");
                    System.out.println("철수 승");
                    break;
                }
                else if (rand_num == 2) {
                    System.out.println("철수 : 바위 AI로봇 : 바위");
                    System.out.println("무승부");
                }else{
                    System.out.println("철수 : 바위 AI로봇 : 보");
                    System.out.println("로봇 승");
                }
            }else{
                if (rand_num == 1) {
                    System.out.println("철수 : 보 AI로봇 : 가위");
                    System.out.println("로봇 승");
                }
                else if (rand_num == 2) {
                    System.out.println("철수 : 보 AI로봇 : 바위");
                    System.out.println("철수 승");
                    break;
                }else{
                    System.out.println("철수 : 보 AI로봇 : 보");
                    System.out.println("무승부");
                }
            }

        }
    }
}