package lecture_Graph;

public class TopologicalSort_0128 {
	
	// 각 요소들의 선행 순서를 위배하지 않도록 정렬하기
	
	public boolean solve(int courseNumber, int[][] nums) {
		return false;
	}

	public static void main(String[] args) {
		TopologicalSort_0128 a = new TopologicalSort_0128();
		
		int course = 4;
		int[][] nums = { { 1, 0 }, 
				         { 2, 1 },
				         { 3, 2 } };
		
		System.out.println(a.solve(course, nums));

	}

}
