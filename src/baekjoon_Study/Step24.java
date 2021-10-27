package baekjoon_Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// DFS와 BFS
public class Step24 {

	// DFS와 BFS
	public static void p_1260() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		int[][] lines = new int[1001][1001];

		// 간선 정보 저장
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			lines[x][y] = lines[y][x] = 1;
		}

		sc.close();

		// dfs - 재귀 이용하기
		boolean[] visited = new boolean[n + 1];
		Arrays.fill(visited, false);

		// 시작점
		visited[v] = true;
		System.out.print(v + " ");

		dfs_1260(v, lines, visited);
		System.out.println();

		// bfs
		bfs_1260(n, v, lines);

		return;
	}

	public static void dfs_1260(int v, int[][] lines, boolean[] visited) {

		for (int i = 1; i <= 1000; i++) {
			// 연결되어있고 방문한적 없다면 방문처리, 다음 깊이로 진행
			if (lines[v][i] == 1 && !visited[i]) {
				System.out.print(i + " ");
				visited[i] = true;
				dfs_1260(i, lines, visited);
			}
		}

		return;
	}

	public static void bfs_1260(int n, int v, int[][] lines) {

		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder result = new StringBuilder();

		Arrays.fill(visited, false);

		// 시작점
		visited[v] = true;
		queue.offer(v);
		result.append(v + " ");

		while (!queue.isEmpty()) {
			int target = queue.poll();

			for (int i = 1; i <= n; i++) {
				// 연결되어있고 방문하지 않았다면 방문처리
				if (lines[target][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.offer(i);
					result.append(i + " ");
				}
			}
		}

		System.out.println(result.toString());

		return;
	}

	// 바이러스
	public static void p_2606() {
		Scanner sc = new Scanner(System.in);
		int computer = sc.nextInt();
		int count = sc.nextInt();
		int[][] lines = new int[computer + 1][computer + 1];

		for (int i = 0; i < count; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			lines[x][y] = lines[y][x] = 1;
		}

		sc.close();

		System.out.println(bfs_2606(computer, lines));

		return;

	}

	public static int bfs_2606(int n, int[][] lines) {

		int result = 0;

		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();

		// 초기화
		Arrays.fill(visited, false);
		queue.offer(1);
		visited[1] = true;

		// bfs 시작
		while (!queue.isEmpty()) {

			int target = queue.poll();

			for (int i = 1; i <= n; i++) {
				// 연결되어있고 방문하지 않았다면
				if (lines[target][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					result++;
				}
			}
		}

		return result;
	}

	// 단지 번호 붙이기
	public static void p_2667() {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[][] houses = new int[n][n];

		for (int i = 0; i < n; i++) {
			char[] input = sc.nextLine().toCharArray();
			for (int j = 0; j < n; j++) {
				houses[i][j] = input[j] - '0';
			}
		}

		sc.close();

		bfs_2667(n, houses);

		return;
	}

	public static void bfs_2667(int n, int[][] houses) {
		int count = 0; // 단지 수
		List<Integer> list = new ArrayList<>();

		boolean[][] visited = new boolean[n][n];
		Queue<int[]> queue = new LinkedList<>();

		// 방문배열 초기화
		for (boolean[] arr : visited) {
			Arrays.fill(arr, false);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				// 집이 존재하고 방문한 적이 없다면 bfs 시작
				if (houses[i][j] == 1 && !visited[i][j]) {

					count++; // 단지수 증가
					int house = 1; // 단지 내 집의 수

					// 초기화
					queue.offer(new int[] { i, j });
					visited[i][j] = true;

					while (!queue.isEmpty()) {
						int[] target = queue.poll();

						// 상
						if (target[1] + 1 >= 0 && target[1] + 1 < n) { // 범위 확인
							if (houses[target[0]][target[1] + 1] == 1 && !visited[target[0]][target[1] + 1]) {
								visited[target[0]][target[1] + 1] = true;
								queue.offer(new int[] { target[0], target[1] + 1 });
								house++;
							}
						}

						// 하
						if (target[1] - 1 >= 0 && target[1] - 1 < n) { // 범위 확인
							if (houses[target[0]][target[1] - 1] == 1 && !visited[target[0]][target[1] - 1]) {
								visited[target[0]][target[1] - 1] = true;
								queue.offer(new int[] { target[0], target[1] - 1 });
								house++;
							}
						}

						// 좌
						if (target[0] - 1 >= 0 && target[0] - 1 < n) { // 범위 확인
							if (houses[target[0] - 1][target[1]] == 1 && !visited[target[0] - 1][target[1]]) {
								visited[target[0] - 1][target[1]] = true;
								queue.offer(new int[] { target[0] - 1, target[1] });
								house++;
							}
						}

						// 우
						if (target[0] + 1 >= 0 && target[0] + 1 < n) { // 범위 확인
							if (houses[target[0] + 1][target[1]] == 1 && !visited[target[0] + 1][target[1]]) {
								visited[target[0] + 1][target[1]] = true;
								queue.offer(new int[] { target[0] + 1, target[1] });
								house++;
							}
						}
					}

					list.add(house);

				}

			}
		}

		Collections.sort(list);

		StringBuilder result = new StringBuilder(count + "\n");

		for (int i : list) {
			result.append(i + "\n");
		}

		System.out.println(result.toString());

		return;

	}

	// 유기농 배추
	public static void p_1012() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < t; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[][] ground = new int[m][n];

			// 배추 위치
			int num = sc.nextInt();
			for (int j = 0; j < num; j++) {
				ground[sc.nextInt()][sc.nextInt()] = 1;
			}

			result.append(bfs_1012(m, n, ground) + "\n");

		}

		sc.close();

		System.out.println(result.toString());

		return;
	}

	public static int bfs_1012(int m, int n, int[][] ground) {
		int result = 0;

		// ground가 0과 1 뿐이므로 visited 대신 ground를 0으로 바꿔주기
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 1이라면 bfs시작
				if (ground[i][j] == 1) {

					ground[i][j] = 0;
					queue.offer(new int[] { i, j });
					result++;

					while (!queue.isEmpty()) {
						int[] target = queue.poll();

						// 상
						if (target[1] + 1 >= 0 && target[1] + 1 < n) {
							if (ground[target[0]][target[1] + 1] == 1) {
								queue.offer(new int[] { target[0], target[1] + 1 });
								ground[target[0]][target[1] + 1] = 0;
							}
						}

						// 하
						if (target[1] - 1 >= 0 && target[1] - 1 < n) {
							if (ground[target[0]][target[1] - 1] == 1) {
								queue.offer(new int[] { target[0], target[1] - 1 });
								ground[target[0]][target[1] - 1] = 0;
							}
						}

						// 좌
						if (target[0] - 1 >= 0 && target[0] - 1 < m) {
							if (ground[target[0] - 1][target[1]] == 1) {
								queue.offer(new int[] { target[0] - 1, target[1] });
								ground[target[0] - 1][target[1]] = 0;
							}
						}

						// 우
						if (target[0] + 1 >= 0 && target[0] + 1 < m) {
							if (ground[target[0] + 1][target[1]] == 1) {
								queue.offer(new int[] { target[0] + 1, target[1] });
								ground[target[0] + 1][target[1]] = 0;
							}
						}

					}

				}
			}
		}

		return result;
	}

	// 미로탐색
	public static void p_2178() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] maze = new int[n][m];

		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			int index = 0;
			for (char c : s.toCharArray()) {
				maze[i][index] = c - '0';
				index++;
			}
		}

		sc.close();

		System.out.println(bfs_2178(n, m, maze));

		return;
	}

	public static int bfs_2178(int n, int m, int[][] maze) {

		int[][] dist = new int[n][m];
		Queue<int[]> queue = new LinkedList<>();
		int[] x = { 0, 0, -1, 1 }; // 상하좌우 x 방문
		int[] y = { 1, -1, 0, 0 }; // 상하좌우 y 방문

		// 초기화
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], -1);
		}
		dist[0][0] = 1;
		queue.offer(new int[] { 0, 0 });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			// 상하좌우 방문
			for (int i = 0; i < 4; i++) {
				int index_x = cur[0] + x[i];
				int index_y = cur[1] + y[i];

				// 범위 확인
				if (index_x < 0 || index_y < 0 || index_x >= n || index_y >= m) {
					continue;
				}

				// 이동 가능여부 확인
				if (maze[index_x][index_y] == 0) {
					continue;
				}

				// 방문여부 확인
				if (dist[index_x][index_y] > -1) {
					continue;
				}

				// 큐에 넣고 방문 처리
				queue.offer(new int[] { index_x, index_y });
				dist[index_x][index_y] = dist[cur[0]][cur[1]] + 1;
			}
		}

		return dist[n - 1][m - 1];
	}

	// 토마토
	public static void p_7576() {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] tomato = new int[n][m];

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tomato[i][j] = sc.nextInt();
				if (tomato[i][j] == 1) {
					queue.offer(new int[] { i, j });
				}
			}
		}

		sc.close();

		System.out.println(bfs_7576(n, m, tomato, queue));

		return;

	}

	public static int bfs_7576(int n, int m, int[][] tomato, Queue<int[]> queue) {
		int[] x = { 0, 0, -1, 1 }; // 상하좌우 x 방문
		int[] y = { 1, -1, 0, 0 }; // 상하좌우 y 방문

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int index_x = cur[0] + x[i];
				int index_y = cur[1] + y[i];

				// 범위 확인
				if (index_x < 0 || index_y < 0 || index_x >= n || index_y >= m) {
					continue;
				}

				// 없거나 이미 익었다면 패스
				if (tomato[index_x][index_y] != 0) {
					continue;
				}

				// 큐에 넣고 방문처리
				queue.offer(new int[] { index_x, index_y });
				tomato[index_x][index_y] = tomato[cur[0]][cur[1]] + 1;

			}
		}

		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tomato[i][j] == 0) { // 익지 않은 토마토 존재
					return -1;
				}
				max = Math.max(max, tomato[i][j]);
			}
		}

		// 첫날은 빼기
		return max - 1;
	}

	// 토마토 - 3차원
	public static void p_7596() {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int h = sc.nextInt();
		int[][][] tomato = new int[h][n][m];

		Queue<int[]> queue = new LinkedList<>();

		for (int k = 0; k < h; k++) {
			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] == 1) {
						queue.offer(new int[] { k, i, j });
					}
				}
			}
			tomato[k] = arr;
		}

		sc.close();

		System.out.println(bfs_7569(h, n, m, tomato, queue));

		return;

	}

	public static int bfs_7569(int h, int n, int m, int[][][] tomato, Queue<int[]> queue) {

		// 상하좌우위아래 이동
		int[][] move = { { 0, 0, 1 }, { 0, 0, -1 }, { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 } };

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int[] mo : move) {

				int x = cur[0] + mo[0];
				int y = cur[1] + mo[1];
				int z = cur[2] + mo[2];

				// 범위 확인
				if (x < 0 || y < 0 || z < 0 || x >= h || y >= n || z >= m) {
					continue;
				}

				// 없거나 이미 익었다면 패스
				if (tomato[x][y][z] != 0) {
					continue;
				}

				queue.offer(new int[] { x, y, z });
				tomato[x][y][z] = tomato[cur[0]][cur[1]][cur[2]] + 1;
			}
		}

		int max = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (tomato[i][j][k] == 0) { // 익지 않은 토마토 존재
						return -1;
					}
					max = Math.max(max, tomato[i][j][k]);
				}
			}
		}

		// 첫날은 빼기
		return max - 1;
	}

	// 숨바꼭질
	public static void p_1697() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();

		if (n == k) { // 이미 같은 경우
			System.out.println(0);
		} else {
			System.out.println(bfs_1697(n, k));
		}

		return;
	}

	public static int bfs_1697(int n, int k) {

		int[] arr = new int[100001];
		Queue<Integer> queue = new LinkedList<>();

		// 초기화
		Arrays.fill(arr, -1);
		arr[n] = 0;
		queue.offer(n);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int index : new int[] { cur - 1, cur + 1, cur * 2 }) {

				// 찾았다면 바로 리턴
				if (index == k) {
					return arr[cur] + 1;
				}

				// 범위 확인
				if (index < 0 || index >= arr.length) {
					continue;
				}

				// 방문여부 확인
				if (arr[index] != -1) {
					continue;
				}

				// 큐에 넣고 방문처리
				queue.offer(index);
				arr[index] = arr[cur] + 1;
			}
		}

		return arr[k];
	}

	// 체스
	public static void p_7562() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < t; i++) {
			int size = sc.nextInt();
			int[] start = new int[] { sc.nextInt(), sc.nextInt() };
			int[] end = new int[] { sc.nextInt(), sc.nextInt() };

			if (start[0] == end[0] && start[1] == end[1]) {
				result.append("0\n");
			} else {
				result.append(bfs_7562(size, start, end) + "\n");
			}

		}

		sc.close();

		System.out.println(result.toString());

		return;
	}

	public static int bfs_7562(int size, int[] start, int[] end) {

		int[][] move = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
		int[][] chess = new int[size][size];

		Queue<int[]> queue = new LinkedList<>();

		// 초기화
		for (int i = 0; i < size; i++) {
			Arrays.fill(chess[i], -1);
		}
		chess[start[0]][start[1]] = 0;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int[] m : move) {
				int x = cur[0] + m[0];
				int y = cur[1] + m[1];

				// 범위 확인
				if (x < 0 || x >= size || y < 0 || y >= size) {
					continue;
				}

				// 도착했다면 바로 리턴
				if (x == end[0] && y == end[1]) {
					return chess[cur[0]][cur[1]] + 1;
				}

				// 방문 확인
				if (chess[x][y] != -1) {
					continue;
				}

				// 큐에 넣고 방문처리
				queue.offer(new int[] { x, y });
				chess[x][y] = chess[cur[0]][cur[1]] + 1;
			}
		}

		return chess[end[0]][end[1]];
	}

	// 벽 부수고 이동하기
	public static void p_2206() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];

		// map정보
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		sc.close();

		if (n == 1 && m == 1) { // 이미 도착
			System.out.println("1");
		} else {
			System.out.println(bfs_2206(n, m, map));
		}

		return;
	}

	public static int bfs_2206(int n, int m, int[][] map) {

		class Point {
			int x;
			int y;
			int wall; // 1 - 부숨
			int dist; // 지금까지 소요된 거리

			public Point(int x, int y, int wall, int dist) {
				super();
				this.x = x;
				this.y = y;
				this.wall = wall;
				this.dist = dist;
			}
		}

		// visited[i][j][0] - 부수지 않고 옴 visited[i][j][1]- 부수고 옴
		boolean[][][] visited = new boolean[n][m][2];
		Queue<Point> queue = new LinkedList<>();

		// 초기화
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		queue.offer(new Point(0, 0, 0, 1));

		// 상하좌우 이동
		int[][] move = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int[] mo : move) {
				int x = p.x + mo[0];
				int y = p.y + mo[1];

				// 도착
				if (x == n - 1 && y == m - 1) {
					return p.dist + 1;
				}

				// 범위 확인
				if (x < 0 || x >= n || y < 0 || y >= m) {
					continue;
				}

				// 벽인 경우
				if (map[x][y] == 1) {
					// 벽을 부수고 오지 않은 경우만 접근 가능, 방문여부 확인
					if (p.wall == 0 && !visited[x][y][1]) {
						queue.offer(new Point(x, y, 1, p.dist + 1));
						visited[x][y][1] = true;
					}
				}

				// 벽이 아닌 경우
				else {
					// 벽을 부순 여부 상관없음. 방문 여부만 확인
					if (!visited[x][y][p.wall]) {
						queue.offer(new Point(x, y, p.wall, p.dist + 1));
						visited[x][y][p.wall] = true;
					}
				}
			}
		}

		// 큐가 끝날때까지 도착 못했다면 실패
		return -1;
	}

	public static void main(String[] args) {
		// p_1260();
		// p_2606();
		// p_2667();
		// p_1012();
		// p_2178();
		// p_7576();
		// p_7596();
		// p_1697();
		// p_7562();
		p_2206();

		return;
	}

}
