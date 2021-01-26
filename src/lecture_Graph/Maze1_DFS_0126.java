package lecture_Graph;

public class Maze1_DFS_0126 {
	
	//기본세팅
	int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
	int m;
	int n;
		
	public boolean solve(int[][] maze, int[] start, int[] dest){
		// 널처리
		if(maze==null || maze.length==0 || maze[0].length==0) return false;
		
		//m,n 초기화
		m = maze.length;
		n = maze[0].length;
		
		boolean[][] visited = new boolean[m][n];
		
		return dfs(maze,start,dest,visited);

	}
	
	public boolean dfs(int[][] maze, int[] start, int[] dest, boolean[][] visited){
		if (start[0] < 0 || start[0] >= m || dest[0] < 0 || dest[1] >= n || visited[start[0]][start[1]]) return false;
	
		visited[start[0]][start[1]] = true;
		// 출발과 도착이 같다면 true
		if(start[0]==dest[0] && start[1]==dest[1]) return true;
		
		for (int[] dir : dirs){
			int x = start[0];
			int y = start[1];
			// 값이 0이어야 진입 가능
			while(x>=0 && x<m && y>=0 && y<n && maze[x][y]==0){
				x+=dir[0];
				y+=dir[1];
			}
			// 원상복귀
			x-=dir[0];
			y-=dir[1];
			
			// new를 선언하여 계속 dfs 돌림으로써  파고들기
			if(dfs(maze, new int[] {x,y}, dest, visited)) return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		Maze1_DFS_0126 a = new Maze1_DFS_0126();
		
		int[][] maze= {
				{0,0,1,0,0},
				{0,0,0,0,0},
				{0,0,0,1,0},
				{1,1,0,1,1},
				{0,0,0,0,0}
		};
		int [] start= {0,4};
		int[] dest = {4,4};
		
		System.out.println(a.solve(maze, start,dest));


	}

}
