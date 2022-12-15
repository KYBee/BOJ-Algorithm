import java.util.*;
import java.io.*;

public class Main {
    static int N, L;
    static Deque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            //1. 넣기
            int current = Integer.parseInt(st.nextToken());

            //2. 자리 배치
            if (dq.isEmpty()) dq.add(new int[]{current, i});
            else {
                while (!dq.isEmpty() && dq.peekLast()[0] > current) {
                    dq.pollLast();
                }
                dq.addLast(new int[] {current, i});
            }

            //3. 출력하기
            while (dq.peekFirst()[1] + L - 1 < i) {
                dq.pollFirst();
            }
            sb.append(dq.peekFirst()[0]).append(" ");
        }
        System.out.print(sb);
    }
}