import java.util.*;
import java.io.*;

public class Main {
    static int N, M, t;
    static long total;
    static boolean[] visited;
    static List<int[]>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
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
            graph[to].add(new int[] {from, weight});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        pq.add(new int[] {1, 0});
        int time = -1;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentWeight = current[1];

            if (visited[currentNode]) continue;
            visited[currentNode] = true;

            //맨 처음에는 추가 안하고 넘어가기
            if (time == -1) time++;
            else total += currentWeight + time++ * t;
            
            for (int[] next: graph[currentNode]) {
                int nextNode = next[0];
                int nextWeight = next[1];

                pq.add(new int[] {nextNode, nextWeight});
            }
        }
        System.out.println(total);
    }
}