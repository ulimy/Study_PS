package programmers_Level_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {

	static int[][] pictures;
	static boolean[][] visited;

	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		// 초기화
		pictures = picture;
		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(visited[i], false);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 색칠되어있고, 아직 방문하지 않은 경우
				if (picture[i][j] > 0 && !visited[i][j]) {
					// 지역 하나 추가
					numberOfArea++;
					// bfs 돌려서 면적 알아내기
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(m, n, i, j));
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	public static int bfs(int m, int n, int i, int j) {

		// 큐, 상하좌우 계산할 배열 선언
		Queue<int[]> queue = new LinkedList<>();
		int[][] arr = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		// 초기화
		int area = 0;
		int color = pictures[i][j];
		queue.offer(new int[] { i, j });
		visited[i][j] = true;

		// 색깔 같다면 큐에 넣고, 방문처리
		while (!queue.isEmpty()) {
			int[] target = queue.poll();
			area++;

			for (int[] a : arr) {
				int x = target[0] + a[0];
				int y = target[1] + a[1];

				if (x >= 0 && x < m && y >= 0 && y < n) {
					if (!visited[x][y] && pictures[x][y] == color) {
						queue.offer(new int[] { x, y });
						visited[x][y] = true;
					}
				}

			}

		}

		return area;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6, 4, new int[][] { { 1, 1, 1, 0 }, { 1, 1, 1, 0 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 } })));

	}

}
