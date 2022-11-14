//package day08.p1339;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] numbers = new int[10];
    static Map<Character, Integer> hash = new HashMap<>();


    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/day08/p1339/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {

            String word = br.readLine();
            int length = word.length();

            for (int j = 0; j < length; j++) {
                char alphabet = word.charAt(j);
                int value = (int) Math.pow(10, length - j - 1);

                if (!hash.containsKey(alphabet)) {
                    hash.put(alphabet, hash.size());
                }

                int target = hash.get(alphabet);
                numbers[target] += value;
            }
        }

        Arrays.sort(numbers);

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += numbers[i] * i;
        }
        System.out.println(answer);
    }
}