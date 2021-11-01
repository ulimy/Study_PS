package baekjoon_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// 트리
public class Step28 {

	public static class Node {
		int index;
		int weight;

		public Node(int index, int weight) {
			super();
			this.index = index;
			this.weight = weight;
		}

	}

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
		boolean visited[] = new boolean[n + 1];
		int[] parents = new int[n + 1]; // i번의 부모 정보

		// 초기화
		Arrays.fill(visited, false);
		queue.offer(1);

		while (!queue.isEmpty()) {

			int parent = queue.poll();
			visited[parent] = true;

			// 연결된 점들에 대해
			for (int child : tree[parent]) {
				// 방문 안해다면 방문처리, 큐에 넣기, 부모 정보 저장
				if (!visited[child]) {
					visited[child] = true;
					queue.offer(child);
					parents[child] = parent;
				}
			}
		}

		// 결과 출력
		StringBuilder result = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			result.append(parents[i] + "\n");
		}

		System.out.println(result.toString());

		return;

	}

	// 트리의 지름
	public static void p_1167() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int v = Integer.parseInt(br.readLine());
		List<Node>[] tree = new ArrayList[v + 1];

		// tree 초기화
		for (int i = 1; i <= v; i++) {
			tree[i] = new ArrayList<>();
		}

		// 간선 정보 저장
		for (int i = 1; i <= v; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			while (true) {
				int index = Integer.parseInt(st.nextToken());
				if (index == -1) {
					break;
				}

				int weight = Integer.parseInt(st.nextToken());

				tree[num].add(new Node(index, weight));
			}
		}

		// 무작위 점 1부터의 거리 구하기
		int[] diameter = bfs_1167(v, tree, 1);

		// 1에서부터 가장 멀리있는 점이 지름을 이루는 두개의 점 중 하나가 됨
		// 제일 큰 값 찾기
		int max_index = 1;
		int max_value = diameter[1];
		for (int i = 2; i <= v; i++) {
			if (max_value < diameter[i]) {
				max_index = i;
				max_value = diameter[i];
			}
		}

		// 지름 구하기
		diameter = bfs_1167(v, tree, max_index);
		int result = -1;
		for (int d : diameter) {
			result = Math.max(d, result);
		}
		System.out.println(result);

		return;
	}

	public static int[] bfs_1167(int v, List<Node>[] tree, int start) {

		// 초기화
		int[] diameter = new int[v + 1];
		boolean[] visited = new boolean[v + 1];
		Arrays.fill(visited, false);

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			int target = queue.poll();
			visited[target] = true;

			// 방문되지 않았다면 방문하고, 길이저장
			for (Node connect : tree[target]) {
				if (!visited[connect.index]) {
					visited[connect.index] = true;
					diameter[connect.index] = diameter[target] + connect.weight;
					queue.offer(connect.index);
				}
			}
		}

		return diameter;

	}

	public static void main(String[] args) throws IOException {
		// p_11725();
		p_1167();
		return;
	}

}
