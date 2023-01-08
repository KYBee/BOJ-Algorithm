import java.util.*;
import java.io.*;

public class Main {
    static int N, dasom, answer;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dasom = Integer.parseInt(br.readLine());

        for (int i = 0; i < N - 1; i++)
            pq.add(Integer.parseInt(br.readLine()));

        while (!pq.isEmpty() && dasom++ <= pq.peek()) {
            pq.add(pq.poll() - 1);
            answer++;
        }
        System.out.println(answer);
    }
}