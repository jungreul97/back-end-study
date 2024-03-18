public class pr02 {
    public static void main(String[] args) {

        //1. HashSet add() 중복된 요소는 추가 불가
        //2. ArrayList contains() 중복 요소 확인

        //로또 번호 발생기
        //1~45 랜덤수 6개
        //중복수가 나오면 재추첨!
        int[] arrLotto = new int[6];
        for(int i=0; i<6; i++){
            int lotto = (int)(Math.random() * 45) + 1;//1~45
            System.out.println( lotto );
            arrLotto[i] = lotto;
            for(int j=1; j<i; j++){
                if(arrLotto[i] == arrLotto[j]){
                    System.out.println("중복수:"+arrLotto[i]);
                    i--; //한번더 추첨
                    break; //비교로직 탈출
                }
            }
        }
    }
}
