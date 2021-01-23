package lecture_QueueAndStack;

import java.util.Stack;

public class ValidParentheses_0123 {
	// ��ȣ Ȯ��
	
	public boolean solve(String str){
		
		// ���̰� Ȧ����� �翬�� false
		if(str.length()%2!=0) return false;
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<str.length();i++){
			switch(str.charAt(i)){
			case ')':
				if(!stack.empty() && stack.peek()=='(') stack.pop();
				break;
			case ']':
				if(!stack.empty() && stack.peek()=='[') stack.pop();
				break;
			case '}':
				if(!stack.empty() && stack.peek()=='{') stack.pop();
				break;
		    default :
		    	stack.push(str.charAt(i));
			}
		}
		
		// ��������� �� �������� true
		return stack.empty();
	}
	
	public static void main(String[] args){
		ValidParentheses_0123 a = new ValidParentheses_0123();
		String str_1= "()[]{}";
		String str_2= "(}";
		System.out.println(a.solve(str_1));
		System.out.println(a.solve(str_2));
	}
}
