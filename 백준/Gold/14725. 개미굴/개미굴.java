import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Trie root = new Trie();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String[] wordArr = new String[t];

            for (int j = 0; j < t; j++) {
                wordArr[j] = st.nextToken();
            }

            insert(wordArr);
        }

        traverse(root, "");
    }

    public static void insert(String[] word) {
        Trie current = root;

        for (int i = 0, size = word.length; i < size; i++) {
            String target = word[i];

            if (!current.children.containsKey(target)) {
                current.children.put(target, new Trie());
            }

            current = current.children.get(target);
        }
    }

    public static void traverse(Trie current, String token) {
        for (String key: current.children.keySet()) {
            System.out.println(token + key);
            traverse(current.children.get(key), token + "--");
        }
    }
}

class Trie {
    Map<String, Trie> children;

    Trie() {
        this.children = new TreeMap<>();
    }
}