package lecture_StringAndArray;

import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDist_0110 {
	/*
	 주어진 문자열의 부분문자열에서 2가지의 문자 종류만 존재하는 것 중 가장 긴 길이인 것 찾기
	 
	 input : "ccaabbb"
	 output : 5
	 
	 문자의 수 : Map 이용
	 
	 */
	
	public int solve(String s){
		int start=0; // 문자열 시작
		int end=0; // 문자열 끝
		int length=0;
		int counter=0; // map에 들어있는 문자 수 (항상 2여야 함. 3이면 먼저 저장된 문자 지우기)
		// 문자 두개와 개수 담을 map
		Map<Character, Integer> map = new HashMap<>();
		
		while(end<s.length()){
			char endChar = s.charAt(end);
			// 문자와 그 개수 저장하기
			// getOrDefault(endChar, 0)+1 -> 0으로, 두번째부터는 +1하기
			map.put(endChar, map.getOrDefault(endChar, 0)+1);
			
			// 1이라면 새로운 문자가 등록되었다는 뜻이므로 카운터 증가
			if(map.get(endChar)==1) counter++;
			// 다음 반복으로 넘어가기
			end++;
			
			// counter가 3이라면 3번째 종류의 문자열이 나타난 것 ! -> map의 첫번째 문자(start) 지워야함
			while(counter>2){
				// start의 char 가져와서 map개수 하나씩 줄이기
				char startChar = s.charAt(start);
				map.put(startChar, map.get(startChar)-1);
				// 0이 되었다면 다 줄인것이므로 counter내리기
				if(map.get(startChar)==0) counter--;
				// counter에 상관없이 다음문자로 넘어가야 함
				start++;
			}
			
			// 문자열 길이는 end-start
			length = Math.max(length,end-start);
		}
		return length;
	}

	public static void main(String[] args) {
		LongestSubMostTwoDist_0110 a = new LongestSubMostTwoDist_0110();
		String s = "ccaabbbb";
		System.out.println(a.solve(s));
	}

}
