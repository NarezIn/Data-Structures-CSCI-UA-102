package HW4_Prob3;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class Room {

    // Main Method
    public static void main(String[] args)
    {
        int[] input1 = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};

        int[] input2 = {1,6,3,6,1,6,3,6};

        int answer1;
        int answer2;

        Solution s = new Solution();

        answer1 = s.solution(input1);
        answer2 = s.solution(input2);

        System.out.println("answer1: " + answer1); // "answer1: 3"
        System.out.println("answer2: " + answer2);//0
    }
}
