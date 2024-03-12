public class ex24 {
    public static void main(String[] args) {
        // 2차배열
        // 1.
        int [][] arrNum1 = new int[3][3]; // 3행3열 정수형 2차배열
        // 2.
        int [][] arrNum2 = new int[][] {{10,20,30},{40,50,60}}; // 2행3열
        // 3.
        int [][] arrNum3 = {{10,20,30},
                            {40,50,60}}; //2행3열
        // 4.
        int[][] arrNum4 = new int[2][];
        arrNum4[0] = new int[3];
        arrNum4[1] = new int[3];

        // 행의 길이
        System.out.println(arrNum2.length);
        // 열의 길이
        System.out.println(arrNum2[0].length);
        System.out.println(arrNum2[1].length);

        //연습문제
        //1. 2차원 정수배열 nums를 행 3개, 열 3개로 만들고,
        // 모든 행열에 값을 넣되,
        // 랜덤값 정수 1~100 사이의 값을 넣고,
        // 전체를 순환하여 출력하시오.
        //2. 최소값과 최대값을 출력하시오.
        int[][] nums = new int[3][3];
        int max_num = Integer.MIN_VALUE;
        int min_num = Integer.MAX_VALUE;
        for (int i =0; i<nums.length;i++){
            for (int j =0;j<nums[0].length;j++){
                int rand_num = (int)(Math.random()*100)+1;
                nums[i][j] = rand_num;
                if (rand_num > max_num) max_num = rand_num;
                if (rand_num < min_num) min_num = rand_num;
            }
        }
        for(int[] arr : nums){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("최댓값 : "+max_num+" 최솟값 : "+min_num);
        //3.
        // 순돌이네 인쇄소
        // 3x3 2차원 정수배열에 아래와 같은 숫자가 들어있다면,
        // 0 1 0       #  *  #
        // 1 2 0   =>  *  +  #
        // 1 0 0       *  #  #
        // 이렇게 출력이 된다.
        // 0 1 2
        // 1 2 0
        // 2 1 0 이렇게 들어가 있을때 출력결과를 표시하시오.
        int[][] data = { {0, 1, 2},
                {1, 2, 0},
                {2, 1, 0} };
        for (int[] arr : data) {
            for (int i : arr) {
                if (i == 0) System.out.print("# ");
                else if (i == 1) System.out.print("* ");
                else System.out.print("+ ");
            }
            System.out.println();
        }
    }
}
