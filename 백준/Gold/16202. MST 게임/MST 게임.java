import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static List<int[]>[] edges;
    static int answer = 1;
    static boolean[] visited;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        isUsed = new boolean[M + 1];

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[from].add(new int[] {to, i});
            edges[to].add(new int[] {from, i});
        }

        for (int k = 0; k < K; k++) {
            if (answer != 0) {
                PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                    return a[1] - b[1];
                });
                PriorityQueue<Integer> usedEdge = new PriorityQueue<>();

                visited = new boolean[N + 1];
                pq.add(new int[] {1, 0});
                answer = 0;
                int cnt = 0;
                
                while (!pq.isEmpty()) {
                    int[] current = pq.poll();
                    int to = current[0];

                    if (visited[to]) continue;

                    int weight = current[1];
                    cnt++;
                    answer += weight;
                    visited[to] = true;

                    if (cnt == N + 1) break;
                    if (weight != 0) usedEdge.add(weight);

                    for (int[] edge : edges[to]) {
                        int nextTo = edge[0];
                        int nextWeight = edge[1];

                        if (!isUsed[nextWeight]) {
                            pq.add(new int[] {nextTo, nextWeight});
                        }
                    }
                }

                if (cnt != N) answer = 0;
                else isUsed[usedEdge.poll()] = true;
                sb.append(answer).append(" ");

            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb);
    }
}