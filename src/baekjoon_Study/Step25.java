package baekjoon_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

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

	// 미확인 도착지
	public static void p_9370() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testcase = Integer.parseInt(br.readLine());

		StringBuilder result = new StringBuilder();

		while (testcase-- > 0) {

			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); // 교차로 (정점)
			int m = Integer.parseInt(st.nextToken()); // 도로 (간선)
			int t = Integer.parseInt(st.nextToken()); // 목적지 후보 개수

			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken()); // 출발지
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			// 거리 정보 저장
			List<Node>[] street = new LinkedList[n + 1];
			for (int i = 1; i <= n; i++) {
				street[i] = new LinkedList<>();
			}

			int gh = 0; // gh 사이의 거리

			for (int i = 0; i < m; i++) {

				st = new StringTokenizer(br.readLine(), " ");

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				street[x].add(new Node(y, w));
				street[y].add(new Node(x, w));

				if ((x == g && y == h) || (x == h && y == g)) {
					gh = w;
				}
			}

			// 가능한 도착지
			List<Integer> list = new LinkedList<>();

			for (int i = 0; i < t; i++) {
				int dest = Integer.parseInt(br.readLine());

				// s - dest 최단거리
				int shortest = dijkstra_9370(n, street, s, dest);

				// s - g - h- dest
				int result1 = 0;
				result1 += dijkstra_9370(n, street, s, g);
				result1 += gh;
				result1 += dijkstra_9370(n, street, h, dest);

				// s - h - g - dest
				int result2 = 0;
				result2 += dijkstra_9370(n, street, s, h);
				result2 += gh;
				result2 += dijkstra_9370(n, street, g, dest);

				// 둘중 하나라도 최단거리라면 목적지 가능
				if (result1 == shortest || result2 == shortest) {
					list.add(dest);
				}
			}

			// 결과 담기
			list.sort((a, b) -> a - b);
			for (int l : list) {
				result.append(l + " ");
			}

			result.append("\n");

		}

		System.out.println(result.toString());

		return;

	}

	public static int dijkstra_9370(int n, List<Node>[] street, int start, int end) {

		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		int[] dist = new int[n + 1];

		// 초기화
		Arrays.fill(dist, 100000000);
		dist[start] = 0;
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node target = pq.poll();

			for (Node cur : street[target.index]) {
				if (target.weight + cur.weight < dist[cur.index]) {
					dist[cur.index] = target.weight + cur.weight;
					pq.offer(new Node(cur.index, dist[cur.index]));
				}
			}
		}

		return dist[end];
	}

	// 벨만포드 타임머신
	public static void p_11657() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 도시 (정점)
		int m = Integer.parseInt(st.nextToken()); // 버스노선 (간선)

		List<Node>[] city = new LinkedList[n + 1];

		// city 초기화
		for (int i = 1; i <= n; i++) {
			city[i] = new LinkedList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			city[x].add(new Node(y, w));
		}

		StringBuilder result = new StringBuilder();
		long[] dist = bellmanFord_11687(n, city);

		if (dist == null) {
			result.append("-1"); // 순환 존재
		} else {
			for (int i = 2; i <= n; i++) {
				if (dist[i] == 100000000) {
					result.append("-1\n");
				} else {
					result.append(dist[i] + "\n");
				}
			}
		}

		System.out.println(result.toString());

		return;
	}

	public static long[] bellmanFord_11687(int n, List<Node>[] city) {

		long[] dist = new long[n + 1];
		Arrays.fill(dist, 100000000);
		dist[1] = 0;

		// update 되었는지 확인
		boolean update = false;

		// n-1번 반복
		for (int i = 0; i < n - 1; i++) {

			update = false;

			// 전제 정첨에 대하여
			for (int j = 1; j <= n; j++) {

				// 연결된 점들에 대해 최단거리 초기화
				for (Node node : city[j]) {

					if (dist[j] == 100000000) {
						break;
					}

					if (dist[j] + node.weight < dist[node.index]) {
						dist[node.index] = dist[j] + node.weight;
						update = true;
					}
				}
			}

			// 더이상 업데이트 없다면 그만해도 됨
			if (!update) {
				return dist;
			}

		}

		// 업데이트가 또 일어나면 음수 사이클 발생
		if (update) {
			for (int j = 1; j <= n; j++) {
				for (Node node : city[j]) {
					if (dist[j] == 100000000) {
						break;
					}
					if (dist[j] + node.weight < dist[node.index]) {
						return null; // 발생!!
					}
				}
			}

		}

		return dist;
	}

	// 플로이드와샬
	public static void p_11404() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 도시 (정점)
		int m = Integer.parseInt(br.readLine()); // 버스 (간선)

		int[][] cities = new int[n + 1][n + 1];

		// cities 초기화
		for (int i = 1; i <= n; i++) {
			Arrays.fill(cities[i], 100000000);
			cities[i][i] = 0;
		}

		// 노선 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// 노선이 하나가 아닐수도 있으므로 더 작은값 입력
			cities[start][end] = Math.min(cities[start][end], Integer.parseInt(st.nextToken()));
		}

		// 경유지
		for (int i = 1; i <= n; i++) {
			// 출발지
			for (int j = 1; j <= n; j++) {

				// 경유지 출발지 같으면 넘어가기
				if (i == j) {
					continue;
				}

				// 도착지
				for (int k = 1; k <= n; k++) {

					// 경유지 혹은 출발지와 같으면 넘어가기
					if (i == k || j == k) {
						continue;
					}

					// 경유한게 거리가 더 짧으면 갱신
					if (cities[j][i] + cities[i][k] < cities[j][k]) {
						cities[j][k] = cities[j][i] + cities[i][k];
					}
				}
			}
		}

		// 출력
		StringBuilder result = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				result.append((cities[i][j] == 100000000) ? 0 : cities[i][j]);
				result.append(" ");
			}
			result.append("\n");
		}

		System.out.println(result.toString());

		return;
	}

	public static void main(String[] args) throws IOException {
		// p_1753();
		// p_1504();
		// p_9370();
		// p_11657();
		p_11404();

		return;
	}

}
