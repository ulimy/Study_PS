package lecture_StringAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams_0116 {
	
	/*
	 input : String txt = "BACDGABCDA" String pat = "ABCD"
	 output : [0,5,6]
	 
	 txt�ȿ� pat�� ���� ������� ����ִ� ���� ���� �ε��� ���ϱ�
	 
	 1. pat�� ����ִ� ���ڵ��� �ƽ�Ű���� �迭�� ��´�.
	 2. ���� for������ pat�� ũ�⸸ŭ�� txt�� �ƽ�Ű���� �迭�� ��´�.
	 3. 1�� 2�� ������ ���� ���ڵ�� ������ ��!
	 
	 */
	
	// ��� ������ �� �𸣴� �迭 ��� List �̿�
	public List<Integer> solve(String txt, String pat){
		List<Integer> result = new ArrayList<>();
		
		// ����ְų�, pat�� �� ��ٸ� �� ä�� return
		if(txt==null || txt.length()==0 || pat==null || pat.length()==0 || txt.length()<pat.length()){
			return result;
		}
		
		// �ƽ�Ű�� ���� ex)A�� �ƽ�Ű�� 65 ���� patArr[65]=1 ������ 0
		int[] patArr = new int[256];
		for (int i=0;i<pat.length();i++){
			patArr[pat.charAt(i)]++;
		}
		
		// txt �տ������� ���ʴ�� Ȯ��. pat���� ���� �޺κ��� Ȯ���� �ʿ� ������ �� ��������
		for (int i=0;i<txt.length()-pat.length()+1;i++){
			int[] txtArr = new int[256];
			for (int j=0;j<pat.length();j++){
				txtArr[txt.charAt(i+j)]++;
			}
			// txtArr�� patArr�� ���ٸ� ���ڰ� ��� �����ϴ� �������� result�� �߰�
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
