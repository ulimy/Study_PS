package lecture_StringAndArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMapping_0116 {
	
	/* 
	 ���� ���� �������� ������ �ٸ� �迭 A�� B
	A�� �������� B������ ��ġ�� ���ϱ�
	
	 input : int[] A = {11,27,45,31,50} int[] B = {50,11,31,45,27}
	 output : [1,4,3,2,0]
	 
	 Map �̿��ϱ�!
	 Map�� B���� �� ��ġ�� �����ϰ� A�� ������� ������

	 */
	
	public int[] solve(int[] A, int[] B){
		// ������� ���� �迭
		int[] result = new int[A.length];
		Map<Integer,Integer> map = new HashMap<>();
		
		//B ����
		for (int i=0;i<A.length;i++){
			map.put(B[i],i);
		}
		
		//A�� ������
		for (int i=0;i<A.length;i++){
			result[i]=map.get(A[i]);
		}
		
		return result;
	}

	public static void main(String[] args) {
		FindAnagramsMapping_0116 a = new FindAnagramsMapping_0116();
		int[] A = {11,27,45,31,50};
		int[] B = {50,11,31,45,27};
		System.out.println(Arrays.toString(a.solve(A,B)));
	}

}
