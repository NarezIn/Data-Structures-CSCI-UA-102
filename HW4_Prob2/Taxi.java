package HW4_Prob2;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class Taxi {

    // Main Method
    public static void main(String[] args)
    {

        int input1 = 6;
        int input2 = 4;
        int input3 = 6;
        int input4 = 2;
        int[][] input5 = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int answer1;

        int input2_1 = 7;
        int input2_2 = 3;
        int input2_3 = 4;
        int input2_4 = 1;
        int[][] input2_5 = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
        int answer2;

        int input3_1 = 6;
        int input3_2 = 4;
        int input3_3 = 5;
        int input3_4 = 6;
        int[][] input3_5 = {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}};
        int answer3;

        Solution s = new Solution();

        answer1 = s.solution(input1, input2, input3, input4, input5);
        answer2 = s.solution(input2_1, input2_2, input2_3, input2_4, input2_5);
        answer3 = s.solution(input3_1, input3_2, input3_3, input3_4, input3_5);

        System.out.println("answer1: " + answer1); // "answer1: 82"
        System.out.println("answer2: " + answer2); //14
        System.out.println("answer3: " + answer3);//18
    }
}
