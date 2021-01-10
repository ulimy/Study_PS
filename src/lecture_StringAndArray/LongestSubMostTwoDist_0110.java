package lecture_StringAndArray;

import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDist_0110 {
	/*
	 �־��� ���ڿ��� �κй��ڿ����� 2������ ���� ������ �����ϴ� �� �� ���� �� ������ �� ã��
	 
	 input : "ccaabbb"
	 output : 5
	 
	 ������ �� : Map �̿�
	 
	 */
	
	public int solve(String s){
		int start=0; // ���ڿ� ����
		int end=0; // ���ڿ� ��
		int length=0;
		int counter=0; // map�� ����ִ� ���� �� (�׻� 2���� ��. 3�̸� ���� ����� ���� �����)
		// ���� �ΰ��� ���� ���� map
		Map<Character, Integer> map = new HashMap<>();
		
		while(end<s.length()){
			char endChar = s.charAt(end);
			// ���ڿ� �� ���� �����ϱ�
			// getOrDefault(endChar, 0)+1 -> 0����, �ι�°���ʹ� +1�ϱ�
			map.put(endChar, map.getOrDefault(endChar, 0)+1);
			
			// 1�̶�� ���ο� ���ڰ� ��ϵǾ��ٴ� ���̹Ƿ� ī���� ����
			if(map.get(endChar)==1) counter++;
			// ���� �ݺ����� �Ѿ��
			end++;
			
			// counter�� 3�̶�� 3��° ������ ���ڿ��� ��Ÿ�� �� ! -> map�� ù��° ����(start) ��������
			while(counter>2){
				// start�� char �����ͼ� map���� �ϳ��� ���̱�
				char startChar = s.charAt(start);
				map.put(startChar, map.get(startChar)-1);
				// 0�� �Ǿ��ٸ� �� ���ΰ��̹Ƿ� counter������
				if(map.get(startChar)==0) counter--;
				// counter�� ������� �������ڷ� �Ѿ�� ��
				start++;
			}
			
			// ���ڿ� ���̴� end-start
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
