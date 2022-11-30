//package p9466;

import java.util.*;
import java.io.*;

public class Main {
	public static int TC;
	public static int N;
	public static int[] map;
	public static boolean[] result;
	public static boolean[] visited;
	public static int total = 0;
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/p9466/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		TC = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < TC; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			result = new boolean[N + 1];
			visited = new boolean[N + 1];
				
			map = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			total = 0;
			
			for (int i = 1; i <= N; i++) {
				if (result[i] == true) {
					continue;
				}
				dfs(i);
			}
			
			System.out.println(N - total);
		}
	}
	
	public static void dfs(int current) {
		visited[current] = true;
		int next = map[current];
		
		if (visited[next] != true) {
			dfs(next);
		} else {
			if (result[next] != true) {
				total++;
				while (current != next) {
					next = map[next];
					total++;
				}
			}
		}
		
		result[current] = true;
	}
}
