package lecture_StringAndArray;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones_0110 {

	/* 
	 J는 Jewel S는 Stone S에 J가 몇개나 들어있는지 대소문자 구분하여 찾기
	 
	 input : J="aA" S="aAAbbbb"
	 output : 3
	 
	 Hashset 이용하기 -> 중복 허용 X이므로 J에 똑같은 문자가 들어있더라도 중복이 없으므로 불필요한 비교를 하지 않게됨
	 
	 */
	
	public int solve(String jew,String stone){
		
		Set<Character> set = new HashSet<>();
		
		// 1) jew를 char하나하나로 쪼개 set에 담기
		for(char jewChar:jew.toCharArray()){
			set.add(jewChar);
		}
		
		// 2) 개수를 담을 변수
		int count=0;
		
		// 3) stone을 char하나하나로 쪼개서 jew를 담아둔 set에 존재하는지 확인
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
