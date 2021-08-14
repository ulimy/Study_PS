package baekjoon_Study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

// for¹®
public class Step3 {
	
	public static void q_2739(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for(int i=1;i<10;i++){
			System.out.println(N+" * "+i+" = "+(N*i));
		}
		
		return;
	}
	
	public static void q_10950(){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		for(int i=0;i<count;i++){
			System.out.println(sc.nextInt()+sc.nextInt());
		}
		
		sc.close();
		
		return;
	}
	
	public static void q_8393(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		System.out.println(N*(N+1)/2);
		
		return;
	}
	
	public static void q_15552() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0;i<count;i++){
			st = new StringTokenizer(br.readLine());
			bw.write(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+"\n");
		}
		
		bw.flush();
		bw.close();

	}
	
	public static void q_2741(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for(int i=1;i<=N;i++){
			System.out.println(i);
		}
		
		return;
	}

	public static void q_2742(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for(int i=N;i>0;i--){
			System.out.println(i);
		}
		
		return;
	}
	
	public static void q_11021(){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		for(int i=1;i<=count;i++){
			System.out.println("Case #"+i+": "+(sc.nextInt()+sc.nextInt()));
		}
		
		sc.close();
		
		return;
	}
	
	public static void q_11022(){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		for(int i=1;i<=count;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("Case #"+i+": "+a+" + "+b+" = "+(a+b));
		}
		
		sc.close();
		
		return;
	}
	
	public static void q_2438(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for(int i=1;i<=N;i++){
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();
		
		return;
	}
	
	public static void q_2439(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		for(int i=0;i<N;i++){
			StringBuilder line = new StringBuilder();
			for(int j=N-1;j>i;j--){
				line.append(" ");
			}
			for(int j=0;j<=i;j++){
				line.append("*");
			}
			System.out.println(line.toString());
		}
	}
	
	public static void q_10871(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		StringBuilder result = new StringBuilder();
		
		for(int i=0;i<N;i++){
			int input = sc.nextInt();
			if(input<X) result.append(input+" "); 
		}
		
		sc.close();
		
		System.out.println(result.toString());
	}
	
	public static void main(String[] args) throws IOException {
//		q_2739();
//		q_10950();
//		q_8393();
//		q_15552();
//		q_2741();
//		q_2742();
//		q_11021();
//		q_11022();
//		q_2438();
//		q_2439();
		q_10871();
		
		return;
	}

}
