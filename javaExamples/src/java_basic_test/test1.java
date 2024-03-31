package java_basic_test;

import java.util.Arrays;

public class test1 {
    public static void main(String[] args) {
        int[] arrIndex1 = {2,0,1,3,4};
        int[] arrIndex2 = {1,2,0,4,3};
        int[][] arrayNum = {
                {22,92,32,42,52},
                {23,93,33,43,53},
                {24,94,34,33,54},
                {25,95,35,45,55},
                {26,96,36,46,56}};
        int[] pick = new int[5];
        for(int i =0 ;i<5;i++){
            pick[i] = arrayNum[arrIndex1[i]][arrIndex2[i]];
        }
        Arrays.sort(pick);
        System.out.println("뽑힌 수들의 배열 : "+ Arrays.toString(pick));

        int min_num = pick[0];
        int max_num = pick[4];
        System.out.println("최솟값 : "+ min_num );
        System.out.println("최댓값 : "+ max_num );

        int small = 1;
        int big = 1;
        for (int i =0 ; i<5;i++){
            for(int j =0;j<5;j++){
                if (arrayNum[i][j] < min_num) small++;
                if (arrayNum[i][j] > max_num) big++;
            }
        }
        System.out.println("최솟값 "+min_num+"은 전체수에서 "+small+"번째로 작은 수이다.");
        System.out.println("최댓값 "+max_num+"은 전체수에서 "+big+"번째로 작은 수이다.");



    }
}
