package lecture_Graph;

public class MaxOfIsland_0126 {

	// 가장 큰 크기의 섬 구하기
	
	public int solve(int[][] grid){
		
		//널체크
		if(grid==null || grid.length==0 || grid[0].length==0) return 0;
		
		
		int m = grid.length;
		int n = grid[0].length;
		int max = 0; //결과값
		
		for (int i=0;i<m;i++){
			for (int j=0;j<n;j++){
				if (grid[i][j]==1){
					// 1인곳을 찾으면 dfs를 통해 면적 구하기, 면적 초기값은 0
					int area =  dfs(grid,i,j,0);
					// 새로 구한 면적과 원래의 max 중 큰 값 저장
					max = Math.max(max, area);
				}
			}
		}
		
		return max;
	}
	
	public int dfs(int[][] grid,int i, int j,int area){
		// 널체크 & 탈출조건
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return area;
		
		int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
		
		// 위 조건을 모두 피한 경우 (= 1, 육지) 0으로 바꾸고 area크기 올려주기
		grid[i][j]=0;
		area++;
		
		// 상하좌우 확인
		for (int[] dir : dirs){
			area = dfs(grid,i+dir[0],j+dir[1],area);
		}
		
		return area;
		
	}

	public static void main(String[] args) {
		MaxOfIsland_0126 a = new MaxOfIsland_0126();
		
		int[][] grid = { 
				{ 1, 1, 0, 1, 1 }, 
				{ 0, 1, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 0 }, 
				{ 1, 1, 0, 1, 1 }, 
				{ 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 1, 1 } };
		
		System.out.println(a.solve(grid));

	}

}
