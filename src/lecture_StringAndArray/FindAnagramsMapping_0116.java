package lecture_StringAndArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMapping_0116 {
	
	/* 
	 같은 값을 가지지만 순서는 다른 배열 A와 B
	A를 기준으로 B에서의 위치를 구하기
	
	 input : int[] A = {11,27,45,31,50} int[] B = {50,11,31,45,27}
	 output : [1,4,3,2,0]
	 
	 Map 이용하기!
	 Map에 B값과 그 위치를 저장하고 A의 순서대로 꺼내기

	 */
	
	public int[] solve(int[] A, int[] B){
		// 결과값을 담을 배열
		int[] result = new int[A.length];
		Map<Integer,Integer> map = new HashMap<>();
		
		//B 저장
		for (int i=0;i<A.length;i++){
			map.put(B[i],i);
		}
		
		//A로 꺼내기
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
