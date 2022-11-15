import java.util.*;
import java.io.*;

public class Main {
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, -1, 0, 1};

    static final int N = 5;
    static char[][] graph;
    static boolean[][] visited;
    static int answer;
    static int[] output;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new char[N][N];
        visited = new boolean[N][N];
        output = new int[7];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        combination(0, 0);
        System.out.println(answer);
    }

    public static void combination(int idx, int cnt) {
        if (cnt == 7) {
            calculate();
            return;
        }

        for (int i = idx; i < 25; i++) {
            output[cnt] = i;
            combination(i + 1, cnt + 1);
        }
    }

    public static void calculate() {
        boolean[][] visited = new boolean[N][N];

        Queue<int[]> q = new ArrayDeque<>();
        int starting = output[0];
        int curR = starting / 5;
        int curC = starting % 5;

        visited[curR][curC] = true;
        q.add(new int[] {curR, curC});

        Set<Integer> possible = new HashSet<>();

        for (int i = 1; i < 7; i++) {
            possible.add(output[i]);
        }

        int Dasom = 0;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            curR = current[0];
            curC = current[1];

            if (graph[curR][curC] == 'S') Dasom++;

            for (int i = 0; i < 4; i++) {
                int newR = curR + dr[i];
                int newC = curC + dc[i];

                if (0 <= newR && newR < N && 0 <= newC && newC < N) {
                    if (!visited[newR][newC] && possible.contains(newR * 5 + newC)) {
                        visited[newR][newC] = true;
                        possible.remove(newR * 5 + newC);
                        q.add(new int[] {newR, newC});
                    }
                }
            }
        }
        if (possible.isEmpty() && Dasom >= 4) answer++;
        return;
    }
}