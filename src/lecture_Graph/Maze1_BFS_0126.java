package lecture_Graph;

public class Maze1_BFS_0126 {
	
	// 1->벽 벽을 맞고 튕긴 공이 도착할 수 있을까?
	
	public boolean solve(int[][] maze, int[] start, int[] dest){
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
