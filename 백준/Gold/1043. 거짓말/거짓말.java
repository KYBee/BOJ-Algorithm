import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int knownCnt;
    static List<Integer> known;
    static ArrayList<Integer>[] parties;
    static int[] parent;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        knownCnt = Integer.parseInt(st.nextToken());
        known = new ArrayList<>();
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < knownCnt; i++) {
            int target = Integer.parseInt(st.nextToken());
            known.add(target);

            parent[target] = 0;
        }

        parties = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            parties[i] = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                parties[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 모든 파티를 한 번 시물레이션 한다.
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> people = parties[i];

            for (int j = 1; j < people.size(); j++) {
                union(people.get(0), people.get(j));
            }
        }

        loop: for (int i = 0; i < M; i++) {
            ArrayList<Integer> people = parties[i];

            for (int j = 0; j < people.size(); j++) {
                if (find(people.get(j)) == 0) continue loop;
            }

            answer++;
        }

        System.out.println(answer);
    }

    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent < bParent) {
            parent[bParent] = aParent;
        } else if (bParent < aParent) {
            parent[aParent] = bParent;
        }
    }

    public static int find(int target) {
        if (parent[target] == target) return target;
        else return parent[target] = find(parent[target]);
    }
}