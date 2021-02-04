package lecture_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_0204 {

	// 주어진 개수만큼의 괄호쌍을 만들 수 있는 모든 경우의 수 구하기 
	// dfs 이용! 괄호를 순서쌍이라고 생각하고 각 숫자가 0이 될때까지 파고들기
	
	public List<String> solve(int n){
		List<String> result = new ArrayList();
		
		dfs(result,"",n,n);
		
		return result;
	}
	
	public void dfs(List<String> result,String str, int left, int right){
		
		// 제약조건
		if(left<0 || right<0 || left>right) return;
		
		// 둘다 0이라면 하나 찾은 것! list에 추가하고 종료
		if(left==0 && right==0){
			result.add(str);
			return;
		}
		
		// 그렇지 않다면 다음 반복 dfs 진행
		dfs(result, str+'(',left-1,right); // 왼쪽 하나 줄이기
		dfs(result,str+')',left,right-1); // 오른쪽 하나 줄이기
		
	}
	
	public static void main(String[] args) {
		GenerateParentheses_0204 a = new GenerateParentheses_0204();
		System.out.println(a.solve(3));
	}

}
