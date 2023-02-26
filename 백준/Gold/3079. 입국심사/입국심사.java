import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static long[] spending;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long max = 0;
        spending = new long[N];
        for (int i = 0; i < N; i++) {
            spending[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, spending[i]);
        }

        long start = 0, end = max * M;

        long answer = 0;

        while (start < end) {
            long people = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                people += mid / spending[i];
                
                if (people >= M) break;
            }

            if (M <= people) {
                end = mid;
            } else {
                start = mid + 1;
                answer = Math.max(answer, start);
            }
        }

        System.out.println(answer);
    }
}