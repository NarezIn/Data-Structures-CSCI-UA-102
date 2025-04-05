package HW4_Part1_Old;

import java.util.*;
 
public class  Solution {

    /*
    To solve the problem, it is allowed to implement an additional class here
    or to utilize JAVA's packges
    */

    public int solution(int n, int[][] costs) {
        //******************** Write your code here ********************//
        // Sort edges based on cost.
        /*
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]);
            }
        });*/

        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        int totalCost = 0;

        while (visited.size() < n) {
            int lowestCost = Integer.MAX_VALUE;
            int[] selectedEdge = null;

            for (int[] edge : costs) {
                int vertex1 = edge[0];
                int vertex2 = edge[1];
                int cost = edge[2];

                if ((visited.contains(vertex1) && !visited.contains(vertex2)) ||
                        (visited.contains(vertex2) && !visited.contains(vertex1))) {
                    if (cost < lowestCost) {
                        lowestCost = cost;
                        selectedEdge = edge;
                    }
                }
            }

            if (selectedEdge != null) {
                totalCost += selectedEdge[2];
                visited.add(selectedEdge[0]);
                visited.add(selectedEdge[1]);
            }
        }

        return totalCost;
        //******************** Write your code here ********************//
    }
}