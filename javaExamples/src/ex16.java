public class ex16 {
    public static void main(String[] args) {
        //반복문 for while do-while
        //      70%  29%   1%
        //패턴
        //for( 초기화1; 조건식2; 증감식4 ) {
        //  실행문3;
        //}
        // 1 => 2 => 3 => 4 => 234 234 2(false 탈출)
        for( int i=0; i<5; i++ ){
            System.out.println( i );
        }
        //초기식,조건식,증감식을 잘못쓰면 무한루프에 걸린다.
//        for( int i=0;    ; i++ ){
//            System.out.println( i );
//        }
        //무한루프을 만드는 방법
        //1. for( ; ; )
        //2. while( true )

        //연습문제
        //1. 1부터 100까지 3과 5의 배수인 수만 출력하시오.
        //  for문 안에서 if문 사용
        for ( int i = 1; i < 101 ; i ++ ){
            if (i%3 == 0 && i%5 == 0) System.out.println(i);
        }
        //2. 1부터 10까지의 합을 출력하시오.
        //  sum = sum + n;
        int sum = 0;
        for ( int i = 1; i < 11 ; i ++ ){
            sum += i;
        }
        System.out.println(sum);
        //3. 1부터 100까지 끝자리가 3으로 끝나는 수의
        //   갯수(count)를 출력하시오.
        int count = 0;
        for ( int i = 1; i < 101 ; i ++ ){
            if (i%10 == 3) count+=1;
        }
        System.out.println(count);
        //4.
        //영희가 1부터 100까지 번호가 쓰인 징검다리 돌을
        //지나고 있다.
        //뒷자리가 2나 7로 된 돌은 밣지 않고 건너려고 한다.
        //영희가 밣은 벽돌의 갯수와 밣지 않은 벽돌의 갯수를
        //출력하시오.
        // 힌트 : 2 7 12 17 22 27 ... 돌은 밣지 않음.
        //       갯수는 count를 세는 것임.
        //출력 예)
        // 영희가 밣은 벽돌의 갯수:80
        // 밣지 않은 벽돌의 갯수:20
        count  = 0;
        for (int i = 1; i < 101 ; i ++) {
            if (i%10 == 2 || i % 10 == 7) count+=1;
        }
        System.out.println("영희가 밟은 벽돌의 갯수 : "+(100-count));
        System.out.println("밟지 않은 벽돌의 갯수 : "+(count));
    }
}