import java.io.*;
import java.util.*;

public class Solution_3 {

    public int solution(int[][] maps) {
        //******************** Write your code here ********************//
        int[][] map = new int[maps.length][];
        for (int i = 0; i < map.length; i++) {
            map[i] = Arrays.copyOf(maps[i], maps[i].length);
        }
        if (map[0][0] == 0 || map[map.length - 1][map[0].length - 1] == 0) {
            return -1;
        }
        //start = (1, 1); end = (maps[0].length, maps.length).
        Queue<Integer> row_que = new LinkedList<>();
        Queue<Integer> col_que = new LinkedList<>();

        map[map.length - 1][map[0].length - 1] = 2;

        boolean[][] visited = new boolean[map.length][map[0].length];

        /* Add the starting point to the row queue and column queue. */
        row_que.offer(0);
        col_que.offer(0);
        visited[0][0] = true;

        return BFS(map, row_que, col_que, visited);
        //******************** Write your code here ********************//
    }

    public int BFS(int[][] map, Queue<Integer> row_que, Queue<Integer> col_que, boolean[][] visited){
        int count = 1;
        int nodes_left_layer = 1;
        int nodes_next_layer = 0;
        /* Finish BFS until both queues are empty. */
        int r;
        int c;
        //To        N, S, W, E
        int[] dr = {-1, 1, 0, 0};//direction to diff rows.
        int[] dc = {0, 0, 1, -1};//direction to diff columns.
        boolean reached_end = false;
        while (!row_que.isEmpty()){
            r = row_que.poll();
            c = col_que.poll();//sync with r.
            if (map[r][c] == 2){//exit if reaches the end.
                reached_end = true;
                break;
            }
            int rr;
            int cc;
            for(int i = 0; i < 4; i++){
                rr = r + dr[i];
                cc = c + dc[i];
                if (rr < 0 || cc < 0){
                    continue;
                }
                if (rr > map.length - 1 || cc > map[0].length - 1){//check if needs to -1.
                    continue;
                }
                if(visited[rr][cc]){
                    continue;
                }
                if(map[rr][cc] == 0){//if hit a rock.
                    continue;
                }
                row_que.offer(rr);
                col_que.offer(cc);
                visited[rr][cc] = true;
                nodes_next_layer++;
            }
            nodes_left_layer--;
            if(nodes_left_layer == 0){
                nodes_left_layer = nodes_next_layer;
                nodes_next_layer = 0;
                count++;
            }
        }
        if (reached_end){
            return count;
        }
        return -1;
    }

    // Main Method
    public static void main(String[] args){
        int[][] input1 = {{1,0,1,1,1},
                          {1,0,1,0,1},
                          {1,0,1,1,1},
                          {1,1,1,0,1},//if the destination is locked.
                          {0,0,0,0,1}};

        int[][] inputs = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1, 1} // Irregular grid with a row longer than others
        };

        int answer1;
        int answer2;

        Solution_3 s = new Solution_3();

        answer1 = s.solution(input1);
        answer2 = s.solution(inputs);

        System.out.println("answer1: " + answer1); // "answer1: 11"
        System.out.println("answer2: " + answer2);
    }
}
