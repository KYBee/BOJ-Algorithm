import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int T, X;
    static int S = 1;
    static final int MAX = 2000001;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        //Making Index Tree
        while (S < MAX) {
            S *= 2;
        }

        tree = new int[2 * S];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            if (T == 1) {
                insert(S + X);
            } else {
                sb.append(query(1, S, 1, X) - 1).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void insert(int node) {
        tree[node] += 1;
        if (node == 1) return;
        else insert(node / 2);
    }

    public static int query(int left, int right, int node, int count) {
        tree[node] -= 1;

        if (left == right) {
            return left;
        } else {
            int mid = (left + right) / 2;

            if (count <= tree[2 * node]) {
                return query(left, mid, node * 2, count);
            } else {
                return query(mid + 1, right, node * 2 + 1, count - tree[node * 2]);
            }
        }
    }
}