package lecture_Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses_0126 {
	// �ϳ��� �����Ͽ� ��ȣ ���� �µ��� �ϱ�
	// �ϳ��� ��������! BFS�̿� --> queue
	
	public List<String> solve(String s){
		// ����� ���� ��
		List<String> res = new ArrayList<>();
		
		// ��üũ
		if(s==null) return res;
		
		Queue<String> queue = new LinkedList<>();
		// �湮 �� �� Ȯ��
		Set<String> visited = new HashSet<>();
		// �ʱ�ȭ
		queue.offer(s);
		visited.add(s);
		boolean found = false;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			for (int i=0;i<size;i++){
				String str = queue.poll();
				// ť���� ���� ���� ��ȣ ���� �´��� Ȯ��
				if(isValid(str)){
					res.add(str);
					found=true;
				}
				// found true��� ���� �� �ʿ� ����. �̹� �� ���� true�ΰ�.
				if (found) continue;
				
				// �� �ڸ��� ���� �ϳ��� ��������
				for(int j=0;j<str.length();j++){
					// ���ڶ�� �׳� �Ѿ��
					if(str.charAt(j)!='(' && str.charAt(j)!=')') continue;
					
					String newStr = str.substring(0,j)+str.substring(j+1);
					// �湮���� �ʾҴٸ� ť�� �ְ� visited �߰�
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
		// C->1 )->-1 �� ���ϸ� 0���� Ȯ���ϴ� ��
		int count=0;
		for(char c:str.toCharArray()){
			if(c=='('){
				count++;
			}else if(c==')'){
				count--;
				// count�� 0���� �۴ٸ� (���� )�� ���� ���� ��! count�� 0�̶� false���� �� ex>())(
				if(count<0) return false;
			}
		}
		//count 0 �̸� true
		return count==0;
	}

	public static void main(String[] args) {
		String s = "(a)())()";
		RemoveInvalidParentheses_0126 a = new RemoveInvalidParentheses_0126();
		System.out.println(a.solve(s));
	}

}
