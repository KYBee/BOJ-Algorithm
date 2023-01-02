import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static PriorityQueue<int[]> homeworks;
    static List<int[]> works;
    static int total;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        homeworks = new PriorityQueue<>((a, b) -> {
            int comp = Integer.compare(b[1], a[1]);
            if (comp == 0) Integer.compare(b[0], a[0]);
            return comp;
        });
        works = new ArrayList<>();

        int maxDay = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            works.add(new int[] {day, score});
            maxDay = Math.max(maxDay, day);
        }

        works.sort((a, b) -> {return Integer.compare(b[0], a[0]);});

        int pointer = 0;
        for (int i = maxDay; i > 0; i--) {
            while (pointer < N && works.get(pointer)[0] == i) {
                homeworks.add(works.get(pointer++));
            }

            if (!homeworks.isEmpty()) {
                total += homeworks.poll()[1];
            }
        }

        System.out.println(total);
    }
}