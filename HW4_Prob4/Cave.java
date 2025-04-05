package HW4_Prob4;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class Cave {

    // Main Method
    public static void main(String[] args)
    {

        int input1 = 9;
        int[][] input2 = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] input3 = {{8,5},{6,7},{4,1}};//true

        boolean answer1;

        int input2_1 = 9;
        int[][] input2_2 = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] input2_3 = {{4,1},{8,7},{6,5}};//false

        Solution s = new Solution();

        answer1 = s.solution(input1, input2, input3);

        boolean answer2;
        answer2 = s.solution(input2_1, input2_2, input2_3);

        System.out.println("answer1: " + answer1); // "answer1: True"
        System.out.println("answer2: " + answer2); //false

        int input5 = 9;
        int[][] input6 = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] input7 = {{8,5},{6,7},{4,0}};
        boolean answer6 = s.solution(input5, input6, input7);

        System.out.println("answer6: " + answer6); // "answer1: false

    }
}
