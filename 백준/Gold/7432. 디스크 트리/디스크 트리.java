import java.util.*;
import java.io.*;

public class Main {
    static Trie root = new Trie();
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
            insert(br.readLine());

        traverse(root, "");
    }

    public static void insert(String path) {
        Trie current = root;
        String[] paths = path.split("\\\\");

        for (int i = 0, size = paths.length; i < size; i++) {
            if (!current.children.containsKey(paths[i])) {
                current.children.put(paths[i], new Trie());
            }
            current = current.children.get(paths[i]);
        }
    }

    public static void traverse(Trie current, String space) {
        for (Map.Entry<String, Trie> entry : current.children.entrySet()) {
            System.out.println(space + entry.getKey());
            traverse(entry.getValue(), space + " ");
        }
    }
}

class Trie {
    Map<String, Trie> children;

    Trie() {
        children = new TreeMap<>();
    }
}