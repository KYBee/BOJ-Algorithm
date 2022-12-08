import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static PriorityQueue<Long> books;
    static long result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        books = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            books.add(Long.parseLong(br.readLine()));
        }

        while (books.size() > 1) {
            long first = books.poll(); long second = books.poll();
            result += first + second;
            books.add(first + second);
        }

        System.out.println(result);
    }
}