import java.util.*;
import java.io.*;

public class Main {
    static final int[] dr = new int[] {-1, 0, 1, 0, -1, -1, 1, 1};
    static final int[] dc = new int[] {0, -1, 0, 1, -1, 1, -1, 1};
    static int w, h;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            graph = new int[h][w];
            int islandCnt = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //탐색
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && graph[i][j] == 1) {
                        q.add(new int[] {i, j});
                        visited[i][j] = true;
                        islandCnt++;

                        while(!q.isEmpty()) {
                            int[] current = q.poll();
                            int curR = current[0];
                            int curC = current[1];

                            for (int d = 0; d < 8; d++) {
                                int newR = curR + dr[d];
                                int newC = curC + dc[d];

                                if (0 <= newR && newR < h && 0 <= newC && newC < w) {
                                    if (!visited[newR][newC] && graph[newR][newC] == 1) {
                                        visited[newR][newC] = true;
                                        q.add(new int[] {newR, newC});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            sb.append(islandCnt).append("\n");
        }
        System.out.print(sb);
    }
}