package lecture_Graph;

public class WordSearch_0126 {
	
	// ���� ã��. t/f����
	// �İ��� ����... DFS�̿� -> Stack
	
	// dfs �⺻����
	int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
	int m;
	int n;
	
	public boolean solve(char[][] grid,String word){
		
		// ��üũ
		if (grid==null || grid.length==0 || grid[0].length==0) return false;
		
		// m,n �ʱ�ȭ
		m = grid.length;
		n = grid[0].length;
		
		// �̹� ���ô� �� Ȯ��
		boolean[][] visitied = new boolean[m][n];
		
		for (int i=0;i<m;i++){
			for (int j=0;j<n;j++){
				// 0-> word �߿��� ã������ ��
				if( dfs(grid,visitied,i,j,0,word) ){
					return true;
				}
			}
		}
		
		return true;
	}
	
	public boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int start, String word){
		
		if(start==word.length()) return true; // �̹� ���� ��! true����
		
		// i,j���� ����� Ż��
		if(i<0 || i>=m || j<0 ||j>=n) return false;
		
		// �̹� �湮�ߴٸ� Ż��
		if(visited[i][j]) return false;
		
		// ã������ ���� �ٸ��ٸ� Ż��
		if(grid[i][j]!=word.charAt(start)) return false;
		
		// �� ������ ��� �ƴ϶�� ã�� ��. �湮 ������ true�� ����
		visited[i][j]=true;
		
		//�����¿�� ���� �˻�
		for(int[] dir : dirs){
			// start ��ü�� ���� ������ �ʱ����� start+1
			if(dfs(grid,visited,i+dir[0],j+dir[1],start+1,word)){
				return true;	
			}
		}
		
		// ������ true�� ���ϵ��� �ʰ� ����� �Ѿ�Դٸ� ������ ��. visited ������� �������� false return
		visited[i][j] = false;
		return false;
	}

	public static void main(String[] args) {
		WordSearch_0126 a = new WordSearch_0126();
		
		char[][] grid ={
				  {'A','B','C','E'},
				  {'S','F','C','S'},
				  {'A','D','E','E'}
				};
		String str = "ABCCED";
		
		System.out.println(a.solve(grid,str));

	}

}
