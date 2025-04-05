package HW4_Part1_Old;

class Connecting {

    // Main Method
    public static void main(String[] args)
    {

        int input1 = 4;
        int[][] input2 = {{0,1,1},{0,2,2},{0,3,1},{1,2,5},{1,3,1},{2,3,8}};

        int input2_1 = 5;
        int[][] input2_2 = {{0,1,3},{0,2,7},{0,3,16},{0,4,14},{1,2,2},{1,3,24},{1,4,20},{2,3,10},{2,4,5},{3,4,2}};

        int input3_1 = 7;
        int[][] input3_2 = {{0,1,8},{0,2,9},{0,3,11},{1,4,10},{2,3,13},{2,4,5},{2,5,12},{3,6,8},{5,6,7}};

        int input4_1 = 9;
        int[][] input4_2 = {{0,1,4},{0,7,8},{1,2,8},{1,7,11},{2,3,7},{2,5,4},{2,8,2},{3,4,9},{3,5,14},{4,5,10},{5,6,2},{6,7,1},{6,8,6},{7,8,7}};

        int answer1;
        int answer2;
        int answer3;
        int answer4;

        Solution s = new Solution();

        answer1 = s.solution(input1, input2);
        answer2 = s.solution(input2_1, input2_2);
        answer3 = s.solution(input3_1, input3_2);
        answer4 = s.solution(input4_1, input4_2);

        System.out.println("answer1: " + answer1); // "answer1: 4"
        System.out.println("answer2: " + answer2); // 12 // 20
        System.out.println("answer3: " + answer3); // 48
        System.out.println("answer4: " + answer4); // 37

    }
}
