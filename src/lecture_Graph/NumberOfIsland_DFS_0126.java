package lecture_Graph;

public class NumberOfIsland_DFS_0126 {
	
	/* 1-육지 0-바다 섬의 개수 구하기*/
	
	public int solve(char[][] grid){
		return 0;
	}
	
	public static void main(String[] args){
		char[][] grid= {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
			   };

		NumberOfIsland_DFS_0126 a = new NumberOfIsland_DFS_0126();
		System.out.println(a.solve(grid));
	}
}
