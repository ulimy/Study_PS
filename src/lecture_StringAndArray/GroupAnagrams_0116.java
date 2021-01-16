package lecture_StringAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_0116 {
	
	/*
	 그룹들 중에서 순서만 다르고 같은 문자열로 이루어진 것들을 모두 뽑기
	 
	 input : {"eat", "tea", "tan", "ate", "nat", "bat"}
	 output : [["ate","eat","tea"],["nat","tan"],["bat"]]
	 
	 */
	
	public List<List<String>> solve(String[] strs){
		List<List<String>> result = new ArrayList<>();
		
		// 비어있는지 확인
		if(strs==null || strs.length==0) return result;
		
		Map<String,List<String>> map = new HashMap<>();
		
		for(String str:strs){
			// char배열로 바꿔 정렬하면 순서가 다른것들도 다 같아짐
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			
			// 정렬한 문자열을 key로 사용하여 map에 대응시키기
			String key = String.valueOf(charArray);
			
			// 이미 map에 있다면? list에 추가
			if(map.containsKey(key)){
				map.get(key).add(str);
			}else{
				// 없다면 한번도 나오지 않는것. 새로 생성.
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(key, list);
			}
		}
		
		// map의 value들만 result에 추가하여 리턴
		result.addAll(map.values());
		
		return result;
	}
	
	
	public static void main(String[] args){
		GroupAnagrams_0116 a = new GroupAnagrams_0116();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(a.solve(strs).toString());
	}
}
