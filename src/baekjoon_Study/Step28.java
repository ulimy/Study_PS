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

	// 트리의 지름 2
	public static void p_1967() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 노드 개수
		List<Node>[] tree = new ArrayList[n + 1];

		// tree 초기화
		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		// 간선 정보 저장
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			tree[x].add(new Node(y, w));
			tree[y].add(new Node(x, w));
		}

		// 1부터 가장 끝점 구하기
		int[] diameter = bfs_1967(n, tree, 1);
		int max_index = 1;
		int max_value = diameter[1];
		for (int i = 2; i <= n; i++) {
			if (max_value < diameter[i]) {
				max_index = i;
				max_value = diameter[i];
			}
		}

		// 끝점으로부터 지름 구하기
		diameter = bfs_1967(n, tree, max_index);
		int result = -1;
		for (int d : diameter) {
			result = Math.max(d, result);
		}
		System.out.println(result);

		return;

	}

	public static int[] bfs_1967(int n, List<Node>[] tree, int start) {
		int[] diameter = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();

		// 초기화
		queue.offer(start);
		Arrays.fill(visited, false);

		while (!queue.isEmpty()) {
			int target = queue.poll();
			visited[target] = true;

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

	// 트리 순회
	public static class TreeNode {
		int index;
		TreeNode left;
		TreeNode right;

		public TreeNode(int index) {
			super();
			this.index = index;
		}

	}

	public static TreeNode[] tree;

	public static void p_1991() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		// 트리 초기화
		tree = new TreeNode[n];

		for (int i = 0; i < n; i++) {
			tree[i] = new TreeNode(i);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			// 알파벳 순서이므로 'A'만큼 빼면 위치가 나옴!
			int data = st.nextToken().charAt(0) - 'A';
			int left = st.nextToken().charAt(0) - 'A';
			int right = st.nextToken().charAt(0) - 'A';

			if (left >= 0) {
				tree[data].left = tree[left];
			}

			if (right >= 0) {
				tree[data].right = tree[right];
			}
		}

		System.out.println(preOrder(0));
		System.out.println(inOrder(0));
		System.out.println(postOrder(0));

	}

	// 전위
	public static String preOrder(int cur) {
		StringBuilder result = new StringBuilder();

		// root
		result.append((char) (cur + 'A'));

		// 왼
		if (tree[cur].left != null) {
			result.append(preOrder(tree[cur].left.index));
		}

		// 오
		if (tree[cur].right != null) {
			result.append(preOrder(tree[cur].right.index));
		}

		return result.toString();
	}

	// 중위
	public static String inOrder(int cur) {
		StringBuilder result = new StringBuilder();

		// 왼
		if (tree[cur].left != null) {
			result.append(inOrder(tree[cur].left.index));
		}

		// root
		result.append((char) (cur + 'A'));

		// 오
		if (tree[cur].right != null) {
			result.append(inOrder(tree[cur].right.index));
		}

		return result.toString();
	}

	// 후위
	public static String postOrder(int cur) {
		StringBuilder result = new StringBuilder();

		// 왼
		if (tree[cur].left != null) {
			result.append(postOrder(tree[cur].left.index));
		}

		// 오
		if (tree[cur].right != null) {
			result.append(postOrder(tree[cur].right.index));
		}

		// root
		result.append((char) (cur + 'A'));

		return result.toString();
	}

	// 트리의 순회
	public static int[] pre; // 전위
	public static int[] in; // 중위
	public static int[] post; // 후위
	public static int pre_index = 0;

	public static void p_2263() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		pre = new int[n];
		in = new int[n];
		post = new int[n];
		int[] position = new int[n + 1]; // 인오더에서 position[i] - i노드가 존재하는 위치

		// 인오더 정보 받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			in[i] = Integer.parseInt(st.nextToken());
			position[in[i]] = i;
		}

		// 포스트오더 정보 받기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}

		solve_2263(0, n - 1, 0, n - 1, position, n);

		// 결과 출력
		StringBuilder result = new StringBuilder();
		for (int r : pre) {
			result.append(r + " ");
		}
		System.out.println(result.toString());

		return;

	}

	public static void solve_2263(int i_start, int i_end, int p_start, int p_end, int[] position, int n) {

		if (i_start <= i_end && p_start <= p_end && pre_index < n) {

			int root = post[p_end]; // post의 가장 오른쪽은 항상 루트!
			int root_index = position[root]; // in에서 루트노드의 위치
			int left_count = root_index - i_start; // left 개수

			// root
			pre[pre_index++] = root;

			// 왼
			solve_2263(i_start, root_index - 1, p_start, p_start + left_count - 1, position, n);

			// 오
			solve_2263(root_index + 1, i_end, p_start + left_count, p_end - 1, position, n);

		}

		return;

	}

	public static void main(String[] args) throws IOException {
		// p_11725();
		// p_1167();
		// p_1967();
		// p_1991();
		p_2263();

		return;
	}

}
