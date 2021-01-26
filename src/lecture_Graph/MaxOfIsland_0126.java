package lecture_Graph;

public class MaxOfIsland_0126 {

	// ���� ū ũ���� �� ���ϱ�
	
	public int solve(int[][] grid){
		
		//��üũ
		if(grid==null || grid.length==0 || grid[0].length==0) return 0;
		
		
		int m = grid.length;
		int n = grid[0].length;
		int max = 0; //�����
		
		for (int i=0;i<m;i++){
			for (int j=0;j<n;j++){
				if (grid[i][j]==1){
					// 1�ΰ��� ã���� dfs�� ���� ���� ���ϱ�, ���� �ʱⰪ�� 0
					int area =  dfs(grid,i,j,0);
					// ���� ���� ������ ������ max �� ū �� ����
					max = Math.max(max, area);
				}
			}
		}
		
		return max;
	}
	
	public int dfs(int[][] grid,int i, int j,int area){
		// ��üũ & Ż������
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0) return area;
		
		int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
		
		// �� ������ ��� ���� ��� (= 1, ����) 0���� �ٲٰ� areaũ�� �÷��ֱ�
		grid[i][j]=0;
		area++;
		
		// �����¿� Ȯ��
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
