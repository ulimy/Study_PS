package baekjoon_Study;

import java.util.Scanner;

//while문
public class Step4 {
	
	public static void q_10952(){
		Scanner sc = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		int a,b;
		
		while(true){
			a = sc.nextInt();
			b = sc.nextInt();
			
			if(a==0 && b==0) break;
			
			result.append((a+b)+"\n");
			
		}
		
		sc.close();
		
		System.out.println(result.toString());
		
		return;
	}
	
	public static void q_10951(){
		Scanner sc = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		
		 while(sc.hasNext()){
			result.append((sc.nextInt()+sc.nextInt())+"\n"); 
		 }
		 
		 sc.close();
		 
		 System.out.println(result.toString());
		
		 return;
	}
	
	public static void q_1110(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		int count=1;
		int new_num = num%10*10 + (num/10+num%10)%10;
		
		while(new_num!=num){
			count++;
			new_num = (new_num%10*10)+(new_num/10+new_num%10)%10;
		}
		
		System.out.println(count);
		
		return;
	}

	public static void main(String[] args) {
//		q_10952();
//		q_10951();
		q_1110();
		
		return;

	}

}
