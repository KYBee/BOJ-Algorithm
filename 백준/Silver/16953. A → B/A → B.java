import java.util.*;
import java.io.*;

public class Main {
    static long A, B;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        Queue<long[]> q = new ArrayDeque<>();
        q.add(new long[] {A, 1});
        long answer = -1;

        while (!q.isEmpty()) {
            long[] current = q.poll();
            long currentNumber = current[0];
            long currentWeight = current[1];

            if (currentNumber == B) {
                answer = currentWeight;
                break;
            }

            //2를 곱한다.
            if (currentNumber * 2 <= B) {
                q.add(new long[] {currentNumber * 2, currentWeight + 1});
            }

            //1을 수의 가장 오른쪽에 추가한다.
            if (currentNumber * 10 + 1 <= B) {
                q.add(new long[] {currentNumber * 10 + 1, currentWeight + 1});
            }
        }
        System.out.println(answer);
    }
}