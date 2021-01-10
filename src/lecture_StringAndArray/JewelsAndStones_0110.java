package lecture_StringAndArray;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones_0110 {

	/* 
	 J�� Jewel S�� Stone S�� J�� ��� ����ִ��� ��ҹ��� �����Ͽ� ã��
	 
	 input : J="aA" S="aAAbbbb"
	 output : 3
	 
	 Hashset �̿��ϱ� -> �ߺ� ��� X�̹Ƿ� J�� �Ȱ��� ���ڰ� ����ִ��� �ߺ��� �����Ƿ� ���ʿ��� �񱳸� ���� �ʰԵ�
	 
	 */
	
	public int solve(String jew,String stone){
		
		Set<Character> set = new HashSet<>();
		
		// 1) jew�� char�ϳ��ϳ��� �ɰ� set�� ���
		for(char jewChar:jew.toCharArray()){
			set.add(jewChar);
		}
		
		// 2) ������ ���� ����
		int count=0;
		
		// 3) stone�� char�ϳ��ϳ��� �ɰ��� jew�� ��Ƶ� set�� �����ϴ��� Ȯ��
		for(char stoneChar:stone.toCharArray()){
			if(set.contains(stoneChar)){
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args){
		JewelsAndStones_0110 a = new JewelsAndStones_0110();
		String J="aA0", S="aAAbbbb";
		System.out.println(a.solve(J,S));
	}
}
