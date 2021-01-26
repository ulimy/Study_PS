package lecture_Graph;

public class NumberOfIsland_DFS_0126 {
	
	/* 1-���� 0-�ٴ� ���� ���� ���ϱ�*/
	
	public int solve(char[][] grid){
		
		// ����ó��
		if (grid==null || grid.length==0 || grid[0].length==0) return 0;
		
		// 1�� ã�������� count �ϳ��� �߰� (�� ���� �߰�)
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
	
	// �߰ߵ� 1�� ����� ���� �����¿쿡 1�� �� �ִٸ� ���� ���� ���Եǵ��� ã�� X�� �ٲٱ�
	public void dfs(char[][] grid,int i, int j){
		int m=grid.length;
		int n = grid[0].length;
		
		// ����ó��
		if(i<0||i>=m||j<0||j>=n||grid[i][j]!='1') return;
		
		// �̹� Ȯ�� �� �κ� X�� �ٲٱ�
		grid[i][j]='X';
		
		//�����¿쿡 1�� �ִ��� Ȯ���ϱ�
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
