package HW4_Prob3;

import java.io.*;
import java.util.*;
 
public class Solution {

    /*
    To solve the problem, it is allowed to implement an additional class here
    or to utilize JAVA's packges
    */

    public int solution(int[] arrows) {
        //******************** Write your code here ********************//
        /* The array to store the movement indicated by number of the arrows. */
        //                 0,      1,      2,      3,       4,        5,       6,       7
        int[][] moves = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        /* The hashmap is used to store the number of times the coordinates have been traversed. */
        Map<String, Boolean> visitedCoor = new HashMap<>();
        Map<String, Boolean> visitedEdge = new HashMap<>();
        /* Starting coordinate is (0, 0), and it is traversed. */
        String curr = "0,0";
        visitedCoor.put(curr, true);
        int room = 0;
        /* Go through the arrows. */
        for (int i = 0; i < arrows.length; i++) {
            int[] move = moves[arrows[i]];
            String next = addMove(curr, move);
            String edge = curr + "->" + next;
            String edgeReverse = next + "->" + curr;

            /* If this is a diagonal move. */
            if(move[0] != 0 && move[1] != 0){
                String midpoint = computerMidpoint(curr, next);
                String firstHalf = curr + "->" + midpoint;
                String first_reverse = midpoint + "->" + curr;
                String secondHalf = midpoint + "->" + next;
                String second_reverse = next + "->" + midpoint;
                if(!visitedEdge.containsKey(firstHalf)){
                    visitedEdge.put(firstHalf, true);
                    visitedEdge.put(first_reverse, true);
                    visitedEdge.put(secondHalf, true);
                    visitedEdge.put(second_reverse, true);
                    if(visitedCoor.containsKey(midpoint)) {
                        room++;
                    }
                }
                visitedCoor.put(midpoint, true);
            }

            if(!visitedEdge.containsKey(edge)) {
                visitedEdge.put(edge, true);
                visitedEdge.put(edgeReverse, true);
                if(visitedCoor.containsKey(next)) {
                    room++;
                }
            }
            visitedCoor.put(curr, true);
            curr = next;
        }
        return room;
        //******************** Write your code here ********************//
    }

    /* This function add the movements based on current coordinates.
     * Returns the coordinates after the movement as a String. */
    public String addMove(String curr, int[] move) {
        String[] currSplit = curr.split(",");
        int coor1 = Integer.parseInt(currSplit[0]) + move[0];
        int coor2 = Integer.parseInt(currSplit[1]) + move[1];
        return Integer.toString(coor1) + "," + Integer.toString(coor2);//Integer.toString() unnecessary??
    }

    /* This is a function to calculate the midpoint if the move is diagonal.
     * The midpoint of a diagonal move should be treated as an independent coordinate. */
    public String computerMidpoint(String curr, String next) {
        String[] currSplit = curr.split(",");
        String[] nextSplit = next.split(",");
        double midX = (double) (Integer.parseInt(currSplit[0]) + Integer.parseInt(nextSplit[0]))/2;
        double midY = (double) (Integer.parseInt(currSplit[1]) + Integer.parseInt(nextSplit[1]))/2;
        return midX + "," + midY;
    }
}
