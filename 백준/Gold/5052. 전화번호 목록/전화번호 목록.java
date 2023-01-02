import java.io.*;
import java.util.*;

public class Main {
    static int TC, N;
    static final int NUM = 10;
    static Trie root;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            N = Integer.parseInt(br.readLine());
            root = new Trie();
            String[] str = new String[N];
            for (int j = 0; j < N; j++) {
                str[j] = br.readLine();
                insert(str[j]);
            }

            boolean answer = true;
            for (int j = 0; j < N; j++) {
                if(!search(str[j])) {
                    answer = false;
                    break;
                }
            }
            if(answer) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }

    static class Trie {
        boolean isEnd;
        Trie children[];

        Trie() {
            isEnd = false;
            children = new Trie[NUM];
            for (int i = 0; i < NUM; i++) {
                children[i] = null;
            }
        }
    }

    static void insert(String key) {
        Trie current = root;

        for (int i = 0, size = key.length(); i < size; i++) {
            int target = key.charAt(i) - '0';

            if (current.children[target] == null) {
                current.children[target] = new Trie();
            }
            current = current.children[target];
        }
        current.isEnd = true;
    }

    static boolean search(String key) {
        Trie current = root;

        for (int i = 0, size = key.length(); i < size; i++) {
            int target = key.charAt(i) - '0';
            if (current.isEnd) {
                return false;
            }
            current = current.children[target];
        }
        return true;
    }
}