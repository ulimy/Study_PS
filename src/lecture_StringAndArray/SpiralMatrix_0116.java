package lecture_StringAndArray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_0116 {
	/*
	 ������ ������� �迭 ����ϱ�
	 
	 input : int[][] matrix = { {1,2,3},{4,5,6},{7,8,9} };
	 output : {1,2,3,6,9,8,7,4,5}
	 
	 */
	
	public List<Integer> solve(int[][] matrix){
		
		List<Integer> result = new ArrayList<>();
		
		// ����ִ��� Ȯ��
		if(matrix==null||matrix.length==0) return result;
 		
		// ���۰� �� �̸� ����
		int rowstart=0;
		int rowend = matrix.length-1;
		int colstart=0;
		int colend=matrix[0].length-1;
		
		while(rowstart<=rowend && colstart<=colend){
			
			// ���������� colstart���� end����
			for (int i=colstart;i<=colend;i++){
				result.add(matrix[rowstart][i]);
			}
			rowstart++;
			
			// �Ʒ��� rowstart���� end����
			for (int i=rowstart;i<=rowend;i++){
				result.add(matrix[i][colend]);
			}
			colend--;
			
			// ��������  colend���� start����
			for (int i=colend;i>=colstart;i--){
				result.add(matrix[rowend][i]);
			}
			rowend--;
			
			// ���� rowend���� start����
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
