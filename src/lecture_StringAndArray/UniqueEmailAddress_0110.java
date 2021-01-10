package lecture_StringAndArray;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress_0110 {
	
	/*
	 
	 주어진 이메일에서 .과 +뒷부분은 전부 무시하고 중복을 배제한 개수 구하기
	 
	 중복 배제를 위해 Set 이용
	 
	 */
	
	public int solve(String[] emails){
		
		// 1) Set 선언
		Set<String> set = new HashSet<>();
		
		for (String email : emails){
			// @ 앞부분 처리
			String localName = makeLocalName(email);
			// @ 뒷부분 처리
			String domainName = makeDomainName(email);
			
			set.add(localName+"@"+domainName);
		}
		
		return set.size();
	}
	
	// @ 앞부분 처리
	public String makeLocalName(String email){
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<email.length();i++){
			// char 하나하나 뽑아 반복
			char c = email.charAt(i);
			
			// .이 나온 경우 무시
			if (c=='.'){
				continue;
			}
			
			// +가 나온 경우 @까지 무시이므로 반복문 종료
			if(c=='+'){
				break;
			}
			
			// @가 나온 경우 반복문 종료
			if(c=='@'){
				break;
			}

			// 위 세가지 조건이 모두 아니라면 string으로 형변환 하여 string에 추가
			sb.append(String.valueOf(c));
		}
		
		return sb.toString();
	}
	
	// @ 뒷부분 처리
	public String makeDomainName(String email){
		// @뒷부분 뽑아내기
		return email.substring(email.indexOf('@')+1);
	}

	public static void main(String[] args) {
		UniqueEmailAddress_0110 a = new UniqueEmailAddress_0110(); 
		String[] emails = {"test.email+alex@leetcode.com",
		           "test.e.mail+bob.cathy@leetcode.com",
		           "testemail+david@lee.tcode.com"};
		System.out.println(a.solve(emails));
	}

}
