package lecture_StringAndArray;

import java.util.Arrays;

public class FindAnagramsMapping_0116 {
	
	/* 
	 같은 값을 가지지만 순서는 다른 배열 A와 B
	A를 기준으로 B에서의 위치를 구하기
	
	 input : int[] A = {11,27,45,31,50} int[] B = {50,11,31,45,27}
	 output : [1,4,3,2,0]

	 */
	
	public int[] solve(int[] A, int[] B){
		return null;
	}

	public static void main(String[] args) {
		FindAnagramsMapping_0116 a = new FindAnagramsMapping_0116();
		int[] A = {11,27,45,31,50};
		int[] B = {50,11,31,45,27};
		System.out.println(Arrays.toString(a.solve(A,B)));
	}

}
