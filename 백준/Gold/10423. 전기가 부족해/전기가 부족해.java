import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static List<int[]>[] graph;
    static int[] electric;
    static boolean[] visited;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        return Integer.compare(a[1], b[1]);
    });

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        electric = new int[K];
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            electric[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight =Integer.parseInt(st.nextToken());

            graph[from].add(new int[] {to, weight});
            graph[to].add(new int[] {from, weight});
        }

        int cnt = 0;
        long total = 0;
        for (int e: electric) {
            visited[e] = true;

            for (int[] next: graph[e]) {
                pq.add(next);
            }

            cnt++;
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curPlace = current[0];
            int curWeight = current[1];

            if (!visited[curPlace]) {
                visited[curPlace] = true;
                total += curWeight;
                cnt++;

                for (int[] next: graph[curPlace]) {
                    if (!visited[next[0]])
                        pq.add(next);
                }
            }

            if (cnt == N) {
                break;
            }
        }
        System.out.println(total);
    }
}