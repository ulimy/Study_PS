package lecture_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Maze1_BFS_0126 {
	
	// 1->�� ���� �°� ƨ�� ���� ������ �� ������?
	// ���� �ν��ϰ� �� �� �տ� ��ġ�ϴ� ���� ����
	
	//�⺻����
	int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
	int m;
	int n;
	
	public boolean solve(int[][] maze, int[] start, int[] dest){
		
		//m,n �ʱ�ȭ
		m = maze.length;
		n = maze[0].length;
		
		// ��߰� ������ ���ٸ� true
		if(start[0]==dest[0] && start[1]==dest[1]) return true;
		
		boolean[][] visited = new boolean[m][n];
		visited[start[0]][start[1]] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {start[0],start[1]});
		
		while(!queue.isEmpty()){
			int[] p = queue.poll();
			//�����¿�
			for(int[] dir : dirs){
				int x = p[0]+dir[0];
				int y = p[1]+dir[1];
				// ���� 0 �̾�� �� �� �����Ƿ� 0���� Ȯ��
				while(x>=0 && x<m && y>=0 && y<n && maze[x][y]==0){
					// ���� ���� while���� ���ö����� dir ���ذ��� ��� �ݺ�
					x+=dir[0];
					y+=dir[1];
				}
				// Ƣ��Դٸ� ���󺹱�
				x-=dir[0];
				y-=dir[1];
				
				//�湮���� ���ٸ� �湮 �ߴٰ� �ٲ����
				if (visited[x][y]) continue;
				visited[x][y] = true;
				
				// �������� �����ߴٸ� ��!
				if(x==dest[0] && y==dest[1]) return true;
			
				//�׷��� �ʴٸ� ť�� �߰�
				queue.offer(new int[] {x,y});
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Maze1_BFS_0126 a = new Maze1_BFS_0126();
		
		int[][] maze= {
				{0,0,1,0,0},
				{0,0,0,0,0},
				{0,0,0,1,0},
				{1,1,0,1,1},
				{0,0,0,0,0}
		};
		int [] start= {0,4};
		int[] dest = {3,2};
		
		System.out.println(a.solve(maze, start,dest));

	}

}
