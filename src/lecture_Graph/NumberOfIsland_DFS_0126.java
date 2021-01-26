package lecture_Graph;

public class NumberOfIsland_DFS_0126 {
	
	/* 1-육지 0-바다 섬의 개수 구하기*/
	
	public int solve(char[][] grid){
		
		// 에러처리
		if (grid==null || grid.length==0 || grid[0].length==0) return 0;
		
		// 1을 찾을때마다 count 하나씩 추가 (섬 개수 추가)
		int count=0;
		for (int i=0;i<grid.length;i++){
			for (int j=0;j<grid[i].length;j++){
				if (grid[i][j]=='1'){
					count++;
					System.out.println("i : "+i+" j : "+j);
					dfs(grid,i,j);
				}
					
			}
		}
	
		return count;
	}
	
	// 발견된 1과 연결된 곳에 상하좌우에 1이 또 있다면 같은 섬에 포함되도록 찾아 X로 바꾸기
	public void dfs(char[][] grid,int i, int j){
		int m=grid.length;
		int n = grid[0].length;
		
		// 에러처리
		if(i<0||i>=m||j<0||j>=n||grid[i][j]!='1') return;
		
		// 이미 확인 된 부분 X로 바꾸기
		grid[i][j]='X';
		
		//상하좌우에 1이 있는지 확인하기
		dfs(grid,i-1,j);
		dfs(grid,i+1,j);
		dfs(grid,i,j-1);
		dfs(grid,i,j+1);
		
	}
	
	public static void main(String[] args){
		char[][] grid= {
				{'1','1','0','0','1'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'},
				{'1','0','0','1','1'}
			   };

		NumberOfIsland_DFS_0126 a = new NumberOfIsland_DFS_0126();
		System.out.println(a.solve(grid));
	}
}
