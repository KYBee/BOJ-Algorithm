import java.util.*;
import java.io.*;

public class Main {
    static final int[] dr = {0, -1, 0, 1};
    static final int[] dc = {-1, 0, 1, 0};

    static int N, M, time;
    static int[][] cheeze;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheeze = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheeze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        loop: while (true) {
            //0. 맵 선언
            boolean[][] visited = new boolean[N][M];
            Queue<int[]> cheezeQueue = new ArrayDeque<>();
            Queue<int[]> emptyQueue = new ArrayDeque<>();

            //1. 일단 맵을 다 탐색
            visited[0][0] = true;
            emptyQueue.add(new int[] {0, 0});

            while (!emptyQueue.isEmpty()) {
                int[] current = emptyQueue.poll();
                int curR = current[0];
                int curC = current[1];

                for (int d = 0; d < 4; d++) {
                    int newR = curR + dr[d];
                    int newC = curC + dc[d];

                    if (0 <= newR && newR < N && 0 <= newC && newC < M && !visited[newR][newC]) {
                        visited[newR][newC] = true;

                        if (cheeze[newR][newC] == 0) emptyQueue.add(new int[]{newR, newC});
                        else cheezeQueue.add(new int[]{newR, newC});
                    }
                }
            }

            if (cheezeQueue.isEmpty()) break loop;
            else {
                Queue<int[]> melting = new ArrayDeque<>();

                while (!cheezeQueue.isEmpty()) {
                    int[] current = cheezeQueue.poll();
                    int curR = current[0];
                    int curC = current[1];
                    int emptySide = 0;

                    for (int d = 0; d < 4; d++) {
                        int newR = curR + dr[d];
                        int newC = curC + dc[d];

                        if (0 <= newR && newR < N && 0 <= newC && newC < M) {
                            if (cheeze[newR][newC] == 0 && visited[newR][newC]) emptySide++;
                        }
                    }

                    if (emptySide >= 2) melting.add(current);
                }

                while (!melting.isEmpty()) {
                    int[] current = melting.poll();
                    int curR = current[0];
                    int curC = current[1];
                    cheeze[curR][curC] = 0;
                }
            }

            time++;
        }

        System.out.println(time);
    }
}