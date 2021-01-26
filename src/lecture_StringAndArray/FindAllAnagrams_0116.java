package lecture_StringAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams_0116 {
	
	/*
	 input : String txt = "BACDGABCDA" String pat = "ABCD"
	 output : [0,5,6]
	 
	 txt안에 pat가 순서 상관없이 들어있는 곳의 시작 인덱스 구하기
	 
	 1. pat에 들어있는 문자들의 아스키값을 배열에 담는다.
	 2. 이중 for문으로 pat의 크기만큼씩 txt의 아스키값을 배열에 담는다.
	 3. 1과 2가 같으면 같은 문자들로 구성된 것!
	 
	 */
	
	// 몇개를 돌려줄 지 모르니 배열 대신 List 이용
	public List<Integer> solve(String txt, String pat){
		List<Integer> result = new ArrayList<>();
		
		// 비어있거나, pat가 더 길다면 빈 채로 return
		if(txt==null || txt.length()==0 || pat==null || pat.length()==0 || txt.length()<pat.length()){
			return result;
		}
		
		// 아스키값 저장 ex)A는 아스키로 65 따라서 patArr[65]=1 없으면 0
		int[] patArr = new int[256];
		for (int i=0;i<pat.length();i++){
			patArr[pat.charAt(i)]++;
		}
		
		// txt 앞에서부터 차례대로 확인. pat보다 작은 뒷부분은 확인할 필요 없으니 그 전까지만
		for (int i=0;i<txt.length()-pat.length()+1;i++){
			int[] txtArr = new int[256];
			for (int j=0;j<pat.length();j++){
				txtArr[txt.charAt(i+j)]++;
			}
			// txtArr이 patArr과 같다면 문자가 모두 존재하는 것이으로 result에 추가
			if(Arrays.equals(patArr, txtArr)){
				result.add(i);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		FindAllAnagrams_0116 a = new FindAllAnagrams_0116();
		String txt = "BACDGABCDA";
		String pat = "ABCD";
		System.out.println(a.solve(txt, pat).toString());
	}

}
