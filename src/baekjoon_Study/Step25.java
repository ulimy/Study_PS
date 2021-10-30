package baekjoon_Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 최단경로
public class Step25 {

	public static class Node {

		int index;
		int weight;

		public Node(int index, int weight) {
			super();
			this.index = index;
			this.weight = weight;
		}
	}

	// 다익스트라
	public static void p_1753() {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt(); // 정점 개수
		int e = sc.nextInt(); // 간선 개수
		List<Node>[] graph = new LinkedList[v + 1];

		int start = sc.nextInt(); // 시작점

		// 그래프 초기화
		for (int i = 1; i <= v; i++) {
			graph[i] = new LinkedList<>();
		}

		// 간선정보 저장
		for (int i = 0; i < e; i++) {
			int x = sc.nextInt(); // 정점 1
			int y = sc.nextInt(); // 정점 2
			int w = sc.nextInt(); // 가중치

			graph[x].add(new Node(y, w));
		}

		sc.close();

		dijkstra(v, graph, start);

		return;
	}

	public static void dijkstra(int v, List<Node>[] graph, int start) {

		// 인덱스와 거리를 오름차순으로 저장
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

		boolean[] visited = new boolean[v + 1]; // 방문 확인
		int[] dist = new int[v + 1]; // 거리

		// 방문 배열 초기화
		Arrays.fill(visited, false);

		// 거리 배열 초기화
		Arrays.fill(dist, 100000000);
		dist[start] = 0;

		// 시작점 큐에 넣기
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {

			Node target = pq.poll();

			if (!visited[target.index]) {

				visited[target.index] = true;

				// 연결되어있는 노드 중에서 거리 확인하고 갱신하기
				for (Node n : graph[target.index]) {
					if (target.weight + n.weight < dist[n.index]) {
						dist[n.index] = target.weight + n.weight;
						pq.offer(new Node(n.index, dist[n.index]));
					}
				}

			}

		}

		// 정답 출력
		StringBuilder result = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			result.append(dist[i] == 100000000 ? "INF" : dist[i]);
			result.append("\n");
		}

		System.out.println(result.toString());

		return;

	}

	// 특정한 최단경로
	public static void p_1504() {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt(); // 정점 개수
		int e = sc.nextInt(); // 간선 개수
		List<Node>[] graph = new LinkedList[v + 1];

		// 그래프 초기화
		for (int i = 1; i <= v; i++) {
			graph[i] = new LinkedList<>();
		}

		// 간선정보 저장
		for (int i = 0; i < e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();

			graph[x].add(new Node(y, w));
			graph[y].add(new Node(x, w));
		}

		int v1 = sc.nextInt();
		int v2 = sc.nextInt();

		sc.close();

		// 1 -> v1 -> v2 -> v
		int result1 = 0;
		result1 += dijkstra_1504(v, graph, 1, v1);
		result1 += dijkstra_1504(v, graph, v1, v2);
		result1 += dijkstra_1504(v, graph, v2, v);

		// 1 -> v2 -> v1 -> v
		int result2 = 0;
		result2 += dijkstra_1504(v, graph, 1, v2);
		result2 += dijkstra_1504(v, graph, v2, v1);
		result2 += dijkstra_1504(v, graph, v1, v);

		System.out.println((result1 >= 100000000 && result2 >= 100000000) ? -1 : Math.min(result1, result2));

		return;
	}

	public static int dijkstra_1504(int v, List<Node>[] graph, int start, int end) {

		// 간선 재이동 가능하므로 visited 필요 없음!

		// 가중치 오름차순
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

		// 최단거리
		int[] dist = new int[v + 1];

		// 초기화
		Arrays.fill(dist, 100000000);
		dist[start] = 0;
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {

			Node target = pq.poll();

			// 연결되어있는 배열 전부 조사
			for (Node n : graph[target.index]) {
				if (target.weight + n.weight < dist[n.index]) {
					dist[n.index] = target.weight + n.weight;
					pq.offer(new Node(n.index, dist[n.index]));
				}
			}

		}

		return dist[end];
	}

	public static void main(String[] args) {
		// p_1753();
		p_1504();

		return;
	}

}