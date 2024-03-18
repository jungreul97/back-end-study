public class ex57 {
    public static void main(String[] args) {
        //연습문제
        //Account Class의 함수중 출금시 잔액이 부족할 경우
        //사용자 정의 예외를 만들어 처리하시오.
        //출금 동작시 OverdrawnException()이 발생하도록
        HanaAccount2 hanaAccount = new HanaAccount2();
        try {
            hanaAccount.withdraw( 500 );
            hanaAccount.withdraw( 500 );
            hanaAccount.withdraw( 500 );
        } catch (OverdrawnException e) {
            e.printMessage();
        }
    }
}
class HanaAccount2 {
    private static HanaAccount2 hanaAccount;

    static HanaAccount2 getInstance() {
        if (hanaAccount == null) {
            hanaAccount = new HanaAccount2();
        }
        return hanaAccount;
    }

    // 필드 : 계좌번호, 고객이름, 잔액, 이자율
    private int account = 1234;
    private String name = "Hong";
    private long money = 1000;
    private double interestRate = 0.03;

    // 메소드 : 입금, 출금, 이자계산(1년후 잔액), 잔액조회
    void deposit (int money) {
        this.money += money;
    }

    void withdraw (int money) throws OverdrawnException {
        if (this.money < money) {
            throw new OverdrawnException("출금 잔액이 부족합니다.");
        }
        this.money -= money;
        System.out.println("출금 성공 - 잔액:"+this.money);
    }

    void getInterestRate () {
        this.money *= (1 + this.interestRate);
    }

    void getMyMoney() {
        System.out.println(this.money);
    }
}

class OverdrawnException extends Exception {
    String message = "";
    public OverdrawnException(String message) {
        this.message = message;
    }
    public void printMessage() {
        System.out.println(this.message);
    }
}