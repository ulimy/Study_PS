package baekjoon_Study;

import java.util.Scanner;

// 입출력과 사칙연산
public class Step1 {
	
	public static void q1_2557(){
		System.out.println("Hello World!");
		return;
	}
	
	public static void q2_10718(){
		System.out.println("강한친구 대한육군\n강한친구 대한육군");
		return;
	}
	
	public static void q_10171(){
		System.out.println("\\    /\\");
		System.out.println(" )  ( \')");
		System.out.println("(  /  )");
		System.out.println(" \\(__)|");
		return;
	}
	
	public static void q_10172(){
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		return;
	}
	
	public static void q_1000(){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		
		System.out.println(A+B);
		
		return;
	}
	
	public static void q_1001(){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		
		System.out.println(A-B);
		
		return;
	}
	
	public static void q_10998(){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		
		System.out.println(A*B);
		
		return;
	}
	
	public static void q_1008(){
		Scanner sc = new Scanner(System.in);
		double A = sc.nextDouble();
		double B = sc.nextDouble();
		sc.close();
		
		System.out.println(A/B);
		
		return;
	}
	
	public static void q_10869(){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		
		System.out.println((A+B)+"\n"+(A-B)+"\n"+(A*B)+"\n"+(A/B)+"\n"+(A%B));
	
		return;
	}
	
	public static void q_10430(){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		sc.close();
		
		System.out.println(((A+B)%C)+"\n"+(((A%C) + (B%C))%C)+"\n"+((A*B)%C)+"\n"+(((A%C)*(B%C))%C));
	
		return;
	}
	
	public static void q_2588(){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();

		System.out.println(A*(B%10));
		System.out.println(A*(B%100/10));
		System.out.println(A*(B/100));
		System.out.println(A*B);
		
		return;
	}
	
	public static void main(String[] args) {
		q1_2557();
		q2_10718();
		q_10171();
		q_10172();
		q_1000();
		q_1001();
		q_10998();
		q_1008();
		q_10869();
		q_10430();
		q_2588();
		return;
	}

}
