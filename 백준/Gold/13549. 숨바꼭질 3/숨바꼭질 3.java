import java.util.*;
import java.io.*;

public class Main {
    static int time = Integer.MAX_VALUE;
    static int N, K;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {N, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentNumber = current[0];
            int currentWeight = current[1];

            visited[currentNumber] = true;
            if (currentNumber == K) time = Math.min(time, currentWeight);

            if (currentNumber * 2 <= 100000 && !visited[currentNumber * 2]) {
                q.add(new int[] {currentNumber * 2, currentWeight});
            }

            if (currentNumber + 1 <= 100000 && !visited[currentNumber + 1]) {
                q.add(new int[] {currentNumber + 1, currentWeight + 1});
            }

            if (currentNumber - 1 >= 0 && !visited[currentNumber - 1]) {
                q.add(new int[] {currentNumber - 1, currentWeight + 1});
            }
        }

        System.out.println(time);
    }
}