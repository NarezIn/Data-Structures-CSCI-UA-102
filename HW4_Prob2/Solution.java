package HW4_Prob2;

import java.io.*;
import java.util.*;
 
public class Solution {

    /*
    To solve the problem, it is allowed to implement an additional class and variables here
    or to utilize JAVA's packges
    */
    public int solution(int n, int s, int a, int b, int[][] fares) {
        //******************** Write your code here ********************//
        Map<Integer, Integer>map = Dijkstra(n, s, fares);
        return calculateCombinedCost(n, s, a, b, fares, map);
        //******************** Write your code here ********************//
    }

    public Map<Integer, Integer> Dijkstra(int n, int s, int[][] fares) {
        /* Store: Node, its price to starting Node. */
        Map<Integer, Integer> map = new HashMap<>();
        /* start to start costs 0*/
        map.put(s, 0);
        /* Instantiate prices from other nodes to starting node */
        for(int i = 1; i <= n; i++){
            map.put(i, map.getOrDefault(i, Integer.MAX_VALUE));
        }
        Queue<Integer> visited = new LinkedList<>();
        ArrayList<Integer> unvisited = new ArrayList<>();
        visited.offer(s);
        for(int j = 1; j <= n; j++){
            if(j != s){
                unvisited.add(j);
            }
        }
        /*
         * End program if visited.size(0) == n;
         * */
        int curr = s;
        int new_price;
        while(visited.size() != n){
            for(int k = 0; k < fares.length; k++){
                /* If the node in fares is the current node
                 * & price to its neighbors are less than the price we have in map. */
                if(!visited.contains(fares[k][0]) || !visited.contains(fares[k][1])) {
                    if (fares[k][0] == curr) {
                        new_price = map.get(curr) + fares[k][2];
                        if (new_price < map.get(fares[k][1])) {
                            map.put(fares[k][1], new_price);/*Old value would be overwritten.*/
                        }
                    } else if (fares[k][1] == curr) {
                        new_price = map.get(curr) + fares[k][2];
                        if (new_price < map.get(fares[k][0])) {
                            map.put(fares[k][0], new_price);/*Old value would be overwritten.*/
                        }
                    }
                }
            }
            /* Delete the m
             * Choosing the one with the smallest price so far, as the next node to visit. */
            curr = deleteMin(map, unvisited);
            visited.offer(curr);
        }
        return map;
    }

    public int deleteMin(Map<Integer, Integer> map, ArrayList<Integer> unvisited){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;//check if this would raise an error.
        for(int l = 0; l < unvisited.size(); l++){
            if(map.get(unvisited.get(l)) < min){
                min = map.get(unvisited.get(l));
                minIndex = l;
            }
        }
        int thing = unvisited.get(minIndex);
        unvisited.remove(minIndex);
        return thing;
    }

    public int calculateCombinedCost(int n, int s, int a, int b, int[][] fares, Map<Integer, Integer>map) {//do we really need fares???
        int minCost = map.get(a) + map.get(b);
        /* i would be each hypothetical shared point.
         * Skip the s itself*/
        for (int i = 1; i <= n; i++) {
            int sharedCost = map.get(i);
            if (sharedCost == Integer.MAX_VALUE){
                continue;
            }
            int minCostToA = getCostBetweenNodes(n, i, a, fares);
            int minCostToB = getCostBetweenNodes(n, i, b, fares);
            if (minCostToA == Integer.MAX_VALUE || minCostToB == Integer.MAX_VALUE){
                continue;
            }
            minCost = Math.min(minCost, (sharedCost + minCostToA + minCostToB));
        }
        return minCost;
    }

    public int getCostBetweenNodes(int n, int x, int y, int[][] fares){
        Map<Integer, Integer> map = Dijkstra(n, x, fares);
        if (map.get(y) == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return map.get(y); // means no direct connection.
    }
}