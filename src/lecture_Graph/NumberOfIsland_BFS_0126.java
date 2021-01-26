package lecture_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland_BFS_0126 {
	
	public int solve(char[][] grid){
		
		// 에러처리
		if (grid==null || grid.length==0 || grid[0].length==0) return 0;
		
		int count=0;
		for (int i=0;i<grid.length;i++){
			for (int j=0;j<grid[i].length;j++){
				if (grid[i][j]=='1'){
					count++;
					bfs(grid,i,j);
				}
			}
		}
		
		return count;
	}
	
	public void bfs(char[][] grid, int i, int j){
		int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
		
		// bfs는 큐 이용하기!
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		
		while(!queue.isEmpty()){
			int size = queue.size();
			int[] point = queue.poll();
			for (int k=0;k<size;k++){
				for (int[] dir: dirs){
					int i1 = point[0]+dir[0];
					int j1 = point[1]+dir[1];
					if (i1>=0 && j1>=0 && i1<grid.length && j1<grid[0].length && grid[i1][j1]=='1'){
						grid[i1][j1]='0';
						queue.offer(new int[] {i1,j1});
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		char[][] grid= {
				{'1','1','0','0','1'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'},
				{'1','0','0','1','1'}
			   };

		NumberOfIsland_BFS_0126 a = new NumberOfIsland_BFS_0126();
		System.out.println(a.solve(grid));

	}

}
