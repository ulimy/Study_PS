package lecture_Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses_0126 {
	// 하나씩 삭제하여 괄호 쌍이 맞도록 하기
	// 하나씩 지워보기! BFS이용 --> queue
	
	public List<String> solve(String s){
		// 결과값 담을 곳
		List<String> res = new ArrayList<>();
		
		// 널체크
		if(s==null) return res;
		
		Queue<String> queue = new LinkedList<>();
		// 방문 한 곳 확인
		Set<String> visited = new HashSet<>();
		// 초기화
		queue.offer(s);
		visited.add(s);
		boolean found = false;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			for (int i=0;i<size;i++){
				String str = queue.poll();
				// 큐에서 꺼낸 값이 괄호 쌍이 맞는지 확인
				if(isValid(str)){
					res.add(str);
					found=true;
				}
				// found true라면 더는 할 필요 없음. 이미 그 쌍은 true인것.
				if (found) continue;
				
				// 각 자리의 문자 하나씩 지워보기
				for(int j=0;j<str.length();j++){
					// 문자라면 그냥 넘어가기
					if(str.charAt(j)!='(' && str.charAt(j)!=')') continue;
					
					String newStr = str.substring(0,j)+str.substring(j+1);
					// 방문하지 않았다면 큐에 넣고 visited 추가
					if(!visited.contains(newStr)){
						queue.offer(newStr);
						visited.add(newStr);
					}
				}
			}
		}
		
		return res;
	}
	
	public boolean isValid(String str){
		// C->1 )->-1 다 더하면 0인지 확인하는 것
		int count=0;
		for(char c:str.toCharArray()){
			if(c=='('){
				count++;
			}else if(c==')'){
				count--;
				// count가 0보다 작다면 (보다 )가 먼저 나온 것! count가 0이라도 false여야 함 ex>())(
				if(count<0) return false;
			}
		}
		//count 0 이면 true
		return count==0;
	}

	public static void main(String[] args) {
		String s = "(a)())()";
		RemoveInvalidParentheses_0126 a = new RemoveInvalidParentheses_0126();
		System.out.println(a.solve(s));
	}

}
