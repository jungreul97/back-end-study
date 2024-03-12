//연습문제 - 싱글톤 만들기
//클래스 이름 : HanaAccount
//  필드(private) : 계좌번호(1234), 고객이름(홍길동), 잔액(1000), 이자율(년3%)
//  메소드 : 입금(+100), 출금(-100), 이자계산(1년후 잔액), 잔액조회
class HanaAccount{
    private int account = 1234;
    private String name = "홍길동";
    private double balance = 1000;
    private double rate = 0.03;
    private static HanaAccount singleton;

    static HanaAccount getInstance(){
        if(singleton==null){
            singleton=new HanaAccount();
        }
        return singleton;
    }
    public int getAccount() {
        return account;
    }
    public void setAccount(int account) {
        this.account = account;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }

    public void income(int balance){
        System.out.println("입금:"+balance);
        this.balance += balance;
    }
    public void outcome(int balance){
        System.out.println("출금:"+balance);
        this.balance -= balance;
    }
    public void rebalance(){
        System.out.println("이자 계산 완료");
        this.balance *= (1 + this.rate);
    }

}
public class ex33 {
    public static void main(String[] args) {
        //싱글톤을 호출후
        //1. 입금 메소드 호출
        //2. 출금 메소드 호출
        //3. 이자계산은 이자율을 읽어서 참조한다.
        //   이자계산후 잔액 증가한다.
        //4. 최종 잔액을 출력한다.
        HanaAccount hanaAccount = HanaAccount.getInstance();
        hanaAccount.income(100);
        hanaAccount.outcome(100);
        hanaAccount.rebalance();
        System.out.println("잔액:"+hanaAccount.getBalance());

    }
}