import java.util.*;
import java.io.*;

public class Main {
    static int N, M, k;
    static long total;
    static int[] parent;
    static int[] friendFee;
    static Set<Integer> pool = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        friendFee = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            friendFee[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            union(from, to);
        }

        for (int i = 1; i <= N; i++) pool.add(find(parent[i]));

        for (Integer key: pool) {
            total += friendFee[key];
        }

        if (total <= k) System.out.println(total);
        else System.out.println("Oh no");
    }

    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent < bParent) {
            parent[bParent] = aParent;
            friendFee[aParent] = friendFee[bParent] = Math.min(friendFee[aParent], friendFee[bParent]);
        } else if (bParent < aParent) {
            parent[aParent] = bParent;
            friendFee[aParent] = friendFee[bParent] = Math.min(friendFee[aParent], friendFee[bParent]);
        }
    }

    public static int find(int target) {
        if (parent[target] == target) return target;
        else return parent[target] = find(parent[target]);
    }
}