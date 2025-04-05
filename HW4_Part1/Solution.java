package HW4_Part1;

import java.util.ArrayList;

public class Solution {

    /*
    To solve the problem, it is allowed to implement an additional class here
    or to utilize JAVA's packges
    */

    public int solution(int n, int[][] costs) {
        //******************** Write your code here ********************//
        ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            graph.add(new ArrayList<>());
        }

        for(int k = 0; k < costs.length; k++){
            graph.get(k).add(costs[k][0]);
            graph.get(k).add(costs[k][1]);
            graph.get(k).add(costs[k][2]);
        }

        return prim(n, graph);
    }

    public int prim(int numV, ArrayList<ArrayList<Integer>> graph){
        ArrayList<ArrayList<Integer>>current = new ArrayList<>();
        Boolean[] visit = new Boolean[numV];
        //visit.add(0);
        int u;
        while(current.size() < graph.size()){
            //u = deleteMin(graph, visit);
            //visit.add(u);
            //current.add(graph.get(u));
            //graph.remove(u);

            //update the cost of vertices adjacent to u
            /*for(int j = 0; j < graph.size(); j++){
                if(graph.get(j).getFirst()[0] == u){//would it always be getFirst()???

                }
            }*/
        }
        int sum = 0;
        for(int l = 0; l < current.size(); l++){
            //sum += current.get(l).getFirst()[1];
        }
        return sum;
    }

    public int deleteMin(ArrayList<ArrayList<int[]>> graph, ArrayList<Integer> current){
        int lowest = Integer.MAX_VALUE;
        int lowestIndex = -1;
        for(int i = 0; i < graph.size(); i++){
            if(graph.get(i).getFirst()[0] == current.getLast()){
                if(graph.get(i).getFirst()[1] < lowest){
                    lowest = graph.get(i).getFirst()[1];
                    lowestIndex = i;
                }
            }
        }
        return graph.get(lowestIndex).get(1)[0];
    }

}
