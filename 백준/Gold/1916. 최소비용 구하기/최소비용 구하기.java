import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int start, end;
    static List<int[]>[] graph;
    static int[] path;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        path = new int[N + 1];
        Arrays.fill(path, INF);

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new int[] {to, weight});
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        findPath();
        
        System.out.println(path[end]);
    }

    public static void findPath() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        path[start] = 0;
        pq.add(new int[] {start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (path[current[0]] < current[1]) continue;

            for (int[] next: graph[current[0]]) {
                int weight = path[current[0]] + next[1];

                if (path[next[0]] > weight) {
                    pq.add(new int[] {next[0], weight});
                    path[next[0]] = weight;
                }
            }
        }
    }
}