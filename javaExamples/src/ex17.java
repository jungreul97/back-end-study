public class ex17 {
    public static void main(String[] args) {
        //런타임 디버깅 사용법
        //*반복문에서 코드의 흐름을 파악하거나, 변수의 값을
        //확인하는 용도로 사용.
        //*print문만으로 전체 맥락을 파악하기 어려울때 사용.
        //실행 > 디버그 (Shift + F9) 기능 이용
        //Break Point(중단점)을 설정한다. CTRL + F8
        //스텝오버(F8) : 다음 줄로 이동
        //스텝인투(F7) : 함수 안으로 이동
        //다시시작(F9) : 계속해서 진행(Resume)
        for (int i = 0;i<5;i++){
            System.out.println(i);
        }
    }
}