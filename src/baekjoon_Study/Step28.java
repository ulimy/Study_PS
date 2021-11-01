package baekjoon_Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 트리
public class Step28 {

	// 트리의 부모 찾기
	public static void p_11725() {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 노드 개수

		List<Integer>[] tree = new ArrayList[n + 1];

		// tree 초기화
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		// edge 정보 저장
		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			tree[a].add(b);
			tree[b].add(a);
		}

		sc.close();

		// 1을 시작으로 BFS 하기!!
		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[n+1];
		int[] parents = new int[n+1]; // i번의 부모 정보
		
		// 초기화
		Arrays.fill(visited, false);
		queue.offer(1);
		
		while(!queue.isEmpty()){
			
			int parent = queue.poll();
			visited[parent] = true;
			
			// 연결된 점들에 대해
			for(int child : tree[parent]){
				// 방문 안해다면 방문처리, 큐에 넣기, 부모 정보 저장
				if(!visited[child]){
					visited[child] = true;
					queue.offer(child);
					parents[child] = parent;
				}
			}
		}
		
		// 결과 출력
		StringBuilder result = new StringBuilder();
		for(int i=2;i<=n;i++){
			result.append(parents[i]+"\n");
		}
		
		System.out.println(result.toString());
		
		return;

	}

	public static void main(String[] args) {
		p_11725();
		
		return;
	}

}
