package lecture_StringAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_0116 {
	
	/*
	 �׷�� �߿��� ������ �ٸ��� ���� ���ڿ��� �̷���� �͵��� ��� �̱�
	 
	 input : {"eat", "tea", "tan", "ate", "nat", "bat"}
	 output : [["ate","eat","tea"],["nat","tan"],["bat"]]
	 
	 */
	
	public List<List<String>> solve(String[] strs){
		List<List<String>> result = new ArrayList<>();
		
		// ����ִ��� Ȯ��
		if(strs==null || strs.length==0) return result;
		
		Map<String,List<String>> map = new HashMap<>();
		
		for(String str:strs){
			// char�迭�� �ٲ� �����ϸ� ������ �ٸ��͵鵵 �� ������
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			
			// ������ ���ڿ��� key�� ����Ͽ� map�� ������Ű��
			String key = String.valueOf(charArray);
			
			// �̹� map�� �ִٸ�? list�� �߰�
			if(map.containsKey(key)){
				map.get(key).add(str);
			}else{
				// ���ٸ� �ѹ��� ������ �ʴ°�. ���� ����.
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(key, list);
			}
		}
		
		// map�� value�鸸 result�� �߰��Ͽ� ����
		result.addAll(map.values());
		
		return result;
	}
	
	
	public static void main(String[] args){
		GroupAnagrams_0116 a = new GroupAnagrams_0116();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(a.solve(strs).toString());
	}
}
