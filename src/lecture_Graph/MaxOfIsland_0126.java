package lecture_Graph;

public class MaxOfIsland_0126 {

	// 가장 큰 크기의 섬 구하기
	
	public int solve(int[][] grid){
		return 0;
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
