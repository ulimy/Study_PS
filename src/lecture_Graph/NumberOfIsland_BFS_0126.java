package lecture_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland_BFS_0126 {
	

	public static void main(String[] args) {
		char[][] grid= {
				{'1','1','0','0','1'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'},
				{'1','0','0','1','1'}
			   };

		NumberOfIsland_BFS_0126 a = new NumberOfIsland_BFS_0126();
		System.out.println(a.solve(grid));

	}

}
