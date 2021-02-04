package lecture_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_0204 {

	// �־��� ������ŭ�� ��ȣ���� ���� �� �ִ� ��� ����� �� ���ϱ� 
	// dfs �̿�! ��ȣ�� �������̶�� �����ϰ� �� ���ڰ� 0�� �ɶ����� �İ���
	
	public List<String> solve(int n){
		List<String> result = new ArrayList();
		
		dfs(result,"",n,n);
		
		return result;
	}
	
	public void dfs(List<String> result,String str, int left, int right){
		
		// ��������
		if(left<0 || right<0 || left>right) return;
		
		// �Ѵ� 0�̶�� �ϳ� ã�� ��! list�� �߰��ϰ� ����
		if(left==0 && right==0){
			result.add(str);
			return;
		}
		
		// �׷��� �ʴٸ� ���� �ݺ� dfs ����
		dfs(result, str+'(',left-1,right); // ���� �ϳ� ���̱�
		dfs(result,str+')',left,right-1); // ������ �ϳ� ���̱�
		
	}
	
	public static void main(String[] args) {
		GenerateParentheses_0204 a = new GenerateParentheses_0204();
		System.out.println(a.solve(3));
	}

}
