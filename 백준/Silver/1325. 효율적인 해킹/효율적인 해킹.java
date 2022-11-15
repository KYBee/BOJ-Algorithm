import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;
    static int maxValue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            answer[i]++;
            dfs(i);
        }

        for (int i = 1; i <= N; i++) {
            maxValue = Math.max(maxValue, answer[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (answer[i] == maxValue) sb.append(i + " ");
        }
        System.out.println(sb);
    }

    public static void dfs(int idx) {
        visited[idx] = true;

        for (int next : graph[idx]) {
            if (visited[next]) continue;
            answer[next]++;
            dfs(next);
        }
    }
}