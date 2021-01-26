package lecture_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Maze1_BFS_0126 {
	
	// 1->벽 벽을 맞고 튕긴 공이 도착할 수 있을까?
	// 벽을 인식하고 그 벽 앞에 위치하는 것이 관건
	
	//기본세팅
	int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
	int m;
	int n;
	
	public boolean solve(int[][] maze, int[] start, int[] dest){
		
		//m,n 초기화
		m = maze.length;
		n = maze[0].length;
		
		// 출발과 도착이 같다면 true
		if(start[0]==dest[0] && start[1]==dest[1]) return true;
		
		boolean[][] visited = new boolean[m][n];
		visited[start[0]][start[1]] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {start[0],start[1]});
		
		while(!queue.isEmpty()){
			int[] p = queue.poll();
			//상하좌우
			for(int[] dir : dirs){
				int x = p[0]+dir[0];
				int y = p[1]+dir[1];
				// 값이 0 이어야 들어갈 수 있으므로 0인지 확인
				while(x>=0 && x<m && y>=0 && y<n && maze[x][y]==0){
					// 벽을 만나 while문을 나올때까지 dir 더해가며 계속 반복
					x+=dir[0];
					y+=dir[1];
				}
				// 튀어나왔다면 원상복귀
				x-=dir[0];
				y-=dir[1];
				
				//방문한적 없다면 방문 했다고 바꿔놓기
				if (visited[x][y]) continue;
				visited[x][y] = true;
				
				// 목적지에 도착했다면 끝!
				if(x==dest[0] && y==dest[1]) return true;
			
				//그렇지 않다면 큐에 추가
				queue.offer(new int[] {x,y});
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Maze1_BFS_0126 a = new Maze1_BFS_0126();
		
		int[][] maze= {
				{0,0,1,0,0},
				{0,0,0,0,0},
				{0,0,0,1,0},
				{1,1,0,1,1},
				{0,0,0,0,0}
		};
		int [] start= {0,4};
		int[] dest = {3,2};
		
		System.out.println(a.solve(maze, start,dest));

	}

}
