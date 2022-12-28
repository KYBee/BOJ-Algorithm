import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static long total;
    static PriorityQueue<Long> card;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        card = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            card.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            long first = card.poll();
            long two = card.poll();

            card.add(first + two);
            card.add(first + two);
        }

        while (!card.isEmpty()) {
            total += card.poll();
        }

        System.out.println(total);
    }
}