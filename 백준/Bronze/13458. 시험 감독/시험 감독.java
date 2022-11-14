//package p13458;

import java.util.*;
import java.io.*;

public class Main {

    static int N, B, C;
    static int[] A;
    static long total;

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/p13458/input6.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        total = N;
        for (int i = 0; i < N; i++) {
            A[i] -= B;
            if (A[i] > 0) {
                total += A[i] / C;

                if (A[i] % C != 0) {
                    total++;
                }
            }
        }
        
        System.out.println(total);
    }

}

