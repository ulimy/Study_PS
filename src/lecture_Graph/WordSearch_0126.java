package lecture_Graph;

public class WordSearch_0126 {
	
	// 글자 찾기. t/f리턴
	// 파고드는 문제... DFS이용 -> Stack
	
	// dfs 기본세팅
	int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
	int m;
	int n;
	
	public boolean solve(char[][] grid,String word){
		
		// 널체크
		if (grid==null || grid.length==0 || grid[0].length==0) return false;
		
		// m,n 초기화
		m = grid.length;
		n = grid[0].length;
		
		// 이미 들어가봤던 곳 확인
		boolean[][] visitied = new boolean[m][n];
		
		for (int i=0;i<m;i++){
			for (int j=0;j<n;j++){
				// 0-> word 중에서 찾으려는 곳
				if( dfs(grid,visitied,i,j,0,word) ){
					return true;
				}
			}
		}
		
		return true;
	}
	
	public boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int start, String word){
		
		if(start==word.length()) return true; // 이미 끝난 것! true리턴
		
		// i,j범위 벗어나면 탈락
		if(i<0 || i>=m || j<0 ||j>=n) return false;
		
		// 이미 방문했다면 탈락
		if(visited[i][j]) return false;
		
		// 찾으려는 값과 다르다면 탈락
		if(grid[i][j]!=word.charAt(start)) return false;
		
		// 위 조건이 모두 아니라면 찾은 것. 방문 했으니 true로 변경
		visited[i][j]=true;
		
		//상하좌우로 새로 검색
		for(int[] dir : dirs){
			// start 자체의 값을 높이지 않기위해 start+1
			if(dfs(grid,visited,i+dir[0],j+dir[1],start+1,word)){
				return true;	
			}
		}
		
		// 위에서 true로 리턴되지 않고 여기로 넘어왔다면 실패인 것. visited 원래대로 돌려놓고 false return
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
