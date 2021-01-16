package lecture_StringAndArray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_0116 {
	/*
	 나선형 모양으로 배열 출력하기
	 
	 input : int[][] matrix = { {1,2,3},{4,5,6},{7,8,9} };
	 output : {1,2,3,6,9,8,7,4,5}
	 
	 */
	
	public List<Integer> solve(int[][] matrix){
		
		List<Integer> result = new ArrayList<>();
		
		// 비어있는지 확인
		if(matrix==null||matrix.length==0) return result;
 		
		// 시작과 끝 미리 선언
		int rowstart=0;
		int rowend = matrix.length-1;
		int colstart=0;
		int colend=matrix[0].length-1;
		
		while(rowstart<=rowend && colstart<=colend){
			
			// 오른쪽으로 colstart부터 end까지
			for (int i=colstart;i<=colend;i++){
				result.add(matrix[rowstart][i]);
			}
			rowstart++;
			
			// 아래로 rowstart부터 end까지
			for (int i=rowstart;i<=rowend;i++){
				result.add(matrix[i][colend]);
			}
			colend--;
			
			// 왼쪽으로  colend부터 start까지
			for (int i=colend;i>=colstart;i--){
				result.add(matrix[rowend][i]);
			}
			rowend--;
			
			// 위로 rowend부터 start까지
			for (int i=rowend;i>=rowstart;i--){
				result.add(matrix[i][colstart]);
			}
			colstart++;
			
		}
		
		return result;
	}

	public static void main(String[] args) {
		SpiralMatrix_0116 a = new SpiralMatrix_0116();
		int[][] matrix = { {1,2,3},
	   					   {4,5,6},
						   {7,8,9} };
		System.out.println(a.solve(matrix).toString());

	}

}
