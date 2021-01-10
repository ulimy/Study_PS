package lecture_StringAndArray;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress_0110 {
	
	/*
	 
	 �־��� �̸��Ͽ��� .�� +�޺κ��� ���� �����ϰ� �ߺ��� ������ ���� ���ϱ�
	 
	 �ߺ� ������ ���� Set �̿�
	 
	 */
	
	public int solve(String[] emails){
		
		// 1) Set ����
		Set<String> set = new HashSet<>();
		
		for (String email : emails){
			// @ �պκ� ó��
			String localName = makeLocalName(email);
			// @ �޺κ� ó��
			String domainName = makeDomainName(email);
			
			set.add(localName+"@"+domainName);
		}
		
		return set.size();
	}
	
	// @ �պκ� ó��
	public String makeLocalName(String email){
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<email.length();i++){
			// char �ϳ��ϳ� �̾� �ݺ�
			char c = email.charAt(i);
			
			// .�� ���� ��� ����
			if (c=='.'){
				continue;
			}
			
			// +�� ���� ��� @���� �����̹Ƿ� �ݺ��� ����
			if(c=='+'){
				break;
			}
			
			// @�� ���� ��� �ݺ��� ����
			if(c=='@'){
				break;
			}

			// �� ������ ������ ��� �ƴ϶�� string���� ����ȯ �Ͽ� string�� �߰�
			sb.append(String.valueOf(c));
		}
		
		return sb.toString();
	}
	
	// @ �޺κ� ó��
	public String makeDomainName(String email){
		// @�޺κ� �̾Ƴ���
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
