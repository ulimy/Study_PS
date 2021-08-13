package baekjoon_Study;

import java.util.Scanner;

//if¹®
public class Step2 {
	
	public static void q_1330(){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		
		if(A>B) System.out.println(">");
		else if(A<B) System.out.println("<");
		else System.out.println("==");
		
		return;
	}
	
	public static void q_9498(){
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		sc.close();
		
		if(score>=90) System.out.println("A");
		else if(score>=80 && score<=89) System.out.println("B");
		else if(score>=70 && score<=79) System.out.println("C");
		else if(score>=60 && score<=69) System.out.println("D");
		else System.out.println("F");
		
		return;
	}
	
	public static void q_2753(){
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		sc.close();
		
		if((year%4==0 && year%100!=0) || year%400==0) System.out.println("1");
		else System.out.println("0");
		
		return;
	}
	
	public static void q_14681(){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		
		if(x>0 && y>0) System.out.println("1");
		else if(x<0 && y>0) System.out.println("2");
		else if(x<0 && y<0) System.out.println("3");
		else System.out.println("4");
		
		return;
	}
	
	public static void q_2884(){
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		sc.close();
		
		minute-=45;
		if(minute<0){
			minute+=60;
			hour--;
			if(hour<0) hour+=24;
		}
		
		System.out.println(hour+" "+minute);
		
		return;
	}
	

	public static void main(String[] args) {
		q_1330();
		q_9498();
		q_2753();
		q_14681();
		q_14681();
		q_2884();
		return;

	}

}
