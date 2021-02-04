package lecture_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhonenumber_0204 {
	
	// 주어진 숫자로 표현할 수 있는 모든 조합 구하기 ex) 2->a,b,c
	
	public List<String> solve(String digits) {
		String digitletter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> result = new ArrayList<String>();

		if (digits.length() == 0) return result;
		
		// null상태니까 일단 넣기
		result.add("");
		
		// digits에 있는 숫자 하나씩 뽑아 dfs시작
		for (int i=0;i<digits.length();i++){
			result = combine(result,digitletter[digits.charAt(i)-'0']);
		}
		
		return result;
	}
	
	public List<String> combine(List<String> firstList, String digit){
		List<String> result = new ArrayList<>();
		
		for(int i=0;i<digit.length();i++){
			for(String firStr : firstList){
				result.add(firStr+digit.charAt(i));
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		LetterCombinationsOfPhonenumber_0204 a = new LetterCombinationsOfPhonenumber_0204();
		System.out.println(a.solve("23"));

	}

}
