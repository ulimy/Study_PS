package baekjoon_Study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

// 문자열
public class Step7 {
	
	public static void q_11654(){
		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0);
		System.out.println((int)c);
		sc.close();
		return;
	}

	public static void q_11720(){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		String str = sc.next();
		sc.close();
		int result=0;
		
		for(int i=0;i<count;i++){
			result+=str.charAt(i)-'0';
		}
		
		System.out.println(result);
		
		return;
	}
	
	public static void q_10809(){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		int[] result = new int[26];
		
		for(int i=0;i<=25;i++){
			result[i] = str.indexOf((i+97));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int r : result){
			sb.append(r+" ");
		}
		
		System.out.println(sb.toString());
		
		return;
	}
	
	public static void q_2675(){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		StringBuilder result = new StringBuilder();
		
		for(int i=0;i<count;i++){
			int repeat = sc.nextInt();
			String str = sc.next();
			StringBuilder sb = new StringBuilder();
			
			for(char c : str.toCharArray()){
				for(int j=0;j<repeat;j++) sb.append(c);
			}
			result.append(sb).append('\n');
		}
		
		sc.close();
		
		System.out.println(result.toString());
		
		return;
	}
	
	public static void q_1157(){
		// A�� 65
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		str = str.toUpperCase();
		
		int[] result = new int[26];
		Arrays.fill(result,0);
		
		for(char c : str.toCharArray()){
			result[c-65]++;
		}
		
		int max=0;
		int index = -1;
		boolean check=false;
		for(int i=0;i<26;i++){
			if(max<result[i]){
				check=false;
				max = result[i];
				index=i;
			}else if(max==result[i])
				check=true;
		}
		
		if(check){
			System.out.println("?");
		}else{
			System.out.println((char)(index+65));
		}
		
		return;
	}
	
	public static void q_1152(){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strs = str.split(" ");
		sc.close();
		
		int result=0;
		for(String s : strs){
			if(!s.equals("")) result++;
		}
		
		System.out.println(result);
		
		return;
	}
	
	public static void q_2908(){
		Scanner sc = new Scanner(System.in);
		StringBuilder a = new StringBuilder(sc.next()).reverse();
		StringBuilder b = new StringBuilder(sc.next()).reverse();
		sc.close();
			
		System.out.println(Math.max(Integer.parseInt(a.toString()), Integer.parseInt(b.toString())));
		
		return;
	}
	
	public static void q_5622(){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		int result=0;
		
		for(char c : str.toCharArray()){
			if(c<=67) result+=3;
			else if(c<=70) result+=4;
			else if(c<=73) result+=5;
			else if(c<=76) result+=6;
			else if(c<=79) result+=7;
			else if(c<=83) result+=8;
			else if(c<=86) result+=9;
			else result+=10;
		}
		
		System.out.println(result);
		
		return;
	}
	
	public static void q_2941(){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		int result=0;
		int index=0;
		
		while(index<str.length()){
			String check = (index<=str.length()-2)?str.substring(index,index+2):"";
			String check_dz = (index<=str.length()-3)?str.substring(index,index+3):"";
			
			if(check_dz.equals("dz=")) {
				index+=3;
			}
			else if(check.equals("c=") 
					 || check.equals("c-") 
					 || check.equals("d-")
					 || check.equals("lj")
					 || check.equals("nj")
					 || check.equals("s=")
					 || check.equals("z=")
					 )index+=2;
			else index++;
			
			result++;
			
		}
		
		System.out.println(result);
		
		return;
	}
	
	public static void q_1316(){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int result=0;
		
		for(int i=0;i<count;i++){
			HashSet<Character> set = new HashSet<>();
			String str = sc.next();
			int index=0;
			boolean check = true;
			
			while(index<str.length()){
				if(set.contains(str.charAt(index))){
					check = false;
					break;
				}else{
					char c = str.charAt(index);
					set.add(c);
					while(index<str.length() && str.charAt(index)==c) index++;
				}
			}
			
			if(check) result++;
		}
		
		sc.close();
		
		System.out.println(result);
		
		return;
	}
		
	public static void main(String[] args) {
		//q_11654();
		//q_11720();
		//q_10809();
		//q_2675();
		//q_1157();
		//q_1152();
		//q_2908();
		//q_5622();
		//q_2941();
		q_1316();
		
		return;

	}

}
