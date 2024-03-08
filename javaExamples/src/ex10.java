public class ex10 {
    public static void main(String[] args) {
        // << >> >>> 비트단위 이동연산자
        int k = 10;
        String binaryString = String.format("%32s", Integer.toBinaryString(k)).replace(" ","0");
        System.out.println(binaryString);
        // 최상위 비트 0이면 양수, 1이면 음수
        // 컴퓨터가 음수를 만드는 방법
        // 2의 보수 : 1의 보수 + 1
        // 1의 보수 : 0->1 1->0
        // +1 => -1 로 만드는 과정
        // 0000...0001 => 1111....1110 => 1111...1111

        // +1 : 00000...0001
        // -1 : 10000...0001 사람이 생각하기 쉬운 음수
        // -1 : 11111...1111 2의 보수

        // <<< : 왼쪽으로 비트이동 *2의 효과
        //     : LSB(맨왼쪽)은 0이 들어옴.
        //     : MSB는 0이면 0, 1이면 1로 지켜진다.

        int i = 1; // 0000....0001
        System.out.println(i<<1); // 0000...0010
        System.out.println(i<<2); // 0000...0100
        // >> : 오른쪽으로 비트이동 /2의 효과
        //    : 양수이면 MSB(맨오른쪽)이 0이 들어옴.
        //    : 음수이면 MSB가 1이 들어옴.
        // 0 000...0001
        // 0 000...0000
        System.out.println(1 >> 1);
        // 1 111...1111
        // 1 111...1111
        System.out.println(-1 >> 1);

        // >>> : 오른쪽으로 비트이동하되 논리적 이동.
        //     : 양수든 음수든 0이 들어옴.
        // 0 000...0001
        // 0 000...0000
        System.out.println(1 >>> 1);
        // 1 111...1111
        // 0 111...1111 양수의 끝자리 논리적으로만 이동하고 0이 들어온것
        System.out.println(-1 >>> 1);

    }
}
