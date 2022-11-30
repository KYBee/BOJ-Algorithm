import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static List<Integer>[] graph;
    static int[][] dp;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        //루트 찾기
        int max = 0;
        int root = 0;
        for (int i = 1; i <= N; i++) {
            if (max < graph[i].size()) {
                max = graph[i].size();
                root = i;
            }
        }

        dfs(root);
        System.out.println(Math.min(dp[root][0], dp[root][1]));
    }

    public static void dfs(int n) {
        visited[n] = true;
        dp[n][0] = 0;
        dp[n][1] = 1;

        for (int child: graph[n]) {
            if (!visited[child]) {
                dfs(child);
                dp[n][0] += dp[child][1];
                dp[n][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
