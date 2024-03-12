// 접근제한자
// : 클래스, 함수, 변수 앞에 위치하여접근을 제한할 때 ㅏ용
// *C언어 : 접근제한자가 없어서, 모든 곳에서 접근 가능
//       : 변수의 변경을 감지하기 어렵다. 유지보수가 어렵다.
// public : 같은 폴더(패키지)에서, 다른 폴더의 클래스에서 접근가능.
// protected : 같은 폴더 + 상속관계 클래스에서 접근가능
// default : 같은 폴더에
// private : 같은 클래스 안에서만 접근 가능(캡슐화,은닉)
//         : Getter/Setter 함수 통해서 접근 가능하도록 허용.
//         : 은행 잔고를 창구를 통해서만 접근가능하도록
class Hong{
    String name = "홍길동"; // default : 같은폴더 + 자기클래스
    public int age = 30; // public : 모든폴더 + 상속관계+ 같은폴더 + 자기클래스
    protected int korScore = 80; // 같은폴더 + 상속관계
    private int engScore = 90; // 자기 클래서에서만 접근가능
    // Getter/Setter 함수를 통해서 접근 가능하도록 한다.

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    void printEngScore(){
        System.out.println(this.engScore);
    }
}

public class ex29 {
    public static void main(String[] args) {
        Hong hong = new Hong();
        System.out.println(hong.getEngScore());
        hong.setEngScore(70);
        // System.out.println(hong.engScore); 다른 클래스에서 접근 불가능
        System.out.println(hong.getEngScore());
    }
}
