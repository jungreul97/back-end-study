public class ex07 {
    public static void main(String[] args) {
        // 연산자
        // 연산자 우선순위
        // 1. 단항 연산자 : ++, -- !(타입) ~(비트반전) = += -=(복합대입연산자)
        //   : 오른쪽이 먼저 연산된다.
        int i = 10;
        int j = 20;
        int k = i = j ;
        System.out.println(k); // 20
        // 2. 다항 연산자 : 이항 삼항연산자
        //   : 왼쪽이 먼저 연산된다.
        int m =i + j + k;
        System.out.println(m); // 60
        // 연산자 우선순위를 소괄호로 구분해서 코드를 심플하게 한다.

        // 형변환 연산자
        float f = (float)10;
        // 나눗셈을 해서 몫과 나머지가 나온다.
        // 10을 3으로 나누면 몫은 3이 나오고 나머지는 1이 나온다.
        // 이때 몫은 / 연산자로 구하고 나머지는 % 연산자로 구한다.

        // 연산자의 종류 - 이항연산자(산비논대)
        // 단항 : ++ -- !(논리반전) (타입) ~(비트반전)      우선순위가 제일 높다
        // 산술 : + - * / % << >> >>>(비트단위 이동연산자) <<<
        // 비교 : < > <= >= == != instanceof(객체비교연산자)
        // 논리 : && ||        & | ^(비트단위 논리 연산자)
        // 삼항 : ? :
        // 대입 : = 복합대입 (+= -= *= /= %= ...)         우선순위가 제일 낮다

        // 비교,논리연산자는 결과값이 true,false로 나온다.
        // 조건절에 주로 사용된다.
        // 나머지는 결과값이 다 값으로 나온다.
    }
}
