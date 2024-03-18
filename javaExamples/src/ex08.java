public class ex08 {
    public static void main(String[] args) {
        // 단항 : ++ -- !(논리반전) (타입) ~(비트반전)
        int i = 10;
        i ++ ;
        System.out.println(i); // 11
        i--;
        System.out.println(i); // 10

        // 앞++/-- 뒤++/--
        i = 10;
        int j = 20;
        System.out.println(i++ + ++j - i++);
        System.out.println(i);
        System.out.println(j);
        i = 10;
        j = 20;
        System.out.println(--i + j++ - ++j);

        boolean b = true;
        System.out.println(!b); // false
        System.out.println(!!b); // true

        j = 20;
        short s = (short)j; // 작은 타입 <= 큰 타입 : 강제형변환

        int k = 10; // 32bit 000000.....1010
        int m = ~k; //       111111.....0101
        System.out.println(Integer.toBinaryString(k)); // 1010 앞의 0은 생략되어서 나옴
        System.out.println(Integer.toBinaryString(m)); // 11111111111111111111111111110101
    }
}
