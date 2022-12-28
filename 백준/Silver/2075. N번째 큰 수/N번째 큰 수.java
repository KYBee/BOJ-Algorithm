import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static PriorityQueue<Integer> numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numbers = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                numbers.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i < N; i++) {
            numbers.poll();
        }

        System.out.println(numbers.peek());
    }
}