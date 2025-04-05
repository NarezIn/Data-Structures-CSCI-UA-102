package HW4_Prob4;

import java.io.*;
import java.util.*;
 
public class Solution {
    
    /*
    To solve the problem, it is allowed to implement an additional class and variables here
    or to utilize JAVA's packges
    */

    public boolean solution(int n, int[][] path, int[][] order) {
        // Adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : path) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Map to track prerequisites: key = locked room, value = prerequisite room
        Map<Integer, Integer> lock = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            if(order[i][1] == 0){
                return false;
            }
            lock.put(order[i][0], order[i][1]); // room[1] has room[0] as its prerequisite
        }

        // Visited array to track which rooms have been visited
        boolean[] visited = new boolean[n];
        visited[0] = true;

        // Queue for BFS to visit rooms
        Queue<Integer> readyToVisit = new LinkedList<>();
        readyToVisit.add(0);

        // Set to track unlocked rooms
        Set<Integer> unlocked = new HashSet<>();//?????????????

        while (!readyToVisit.isEmpty()) {
            int current = readyToVisit.poll();

            // Visit all neighbors of the current room.
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    // If the room is unlocked, proceed to visit it.
                    if (unlocked.contains(neighbor) || !lock.containsValue(neighbor)) {
                        visited[neighbor] = true;
                        readyToVisit.add(neighbor);
                    }
                }

                if (lock.containsKey(neighbor)) {
                    int roomToUnlock = lock.get(neighbor);
                    // Only unlock if it hasn't been unlocked before.
                    if (!unlocked.contains(roomToUnlock)) {
                        unlocked.add(roomToUnlock);
                        // If the unlocked room is not visited, mark it as visited and add to the queue.
                        if (!visited[roomToUnlock]) {
                            visited[roomToUnlock] = true;
                            readyToVisit.add(roomToUnlock); // Add the newly unlocked room to the queue.
                        }
                    }
                }
            }
        }

        // Check if all rooms are visited
        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }
        return true;
    }
}
