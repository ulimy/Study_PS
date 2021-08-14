package baekjoon_Study;

import java.util.Scanner;

//함수
public class Step6 {
	
	public static long sum(int[] a){
		long result = 0;
		
		for(int num : a){
			result+=num;
		}
		
		return result;
	}
	
	public static int d(int n){
		int result=n;
		while(n!=0){
			result+=n%10;
			n/=10;
		}
		return result;
	}
	
	public static void q_4673(){
		boolean[] arr = new boolean[10001];
		
		for(int i=1;i<=10000;i++){
			int num = d(i);
			
			if(num<=10000) arr[num] = true;
		}
		
		StringBuilder result = new StringBuilder();
		for(int i=1;i<=10000;i++){
			if(!arr[i]) result.append(i+"\n");
		}
		
		System.out.println(result.toString());
		
		return;
	}
	
	public static int solve(int N){
		if(N<100) return N;
		else{
			// 1~99 할필요없음
			int count=99;
			
			for(int i=100;i<=N;i++){
				int a = i/100;
				int b = (i%100)/10;
				int c = i%10;
				
				if(a-b == b-c) count++;
			}
			
			return count;
		}
	}
	
	public static void q_1065(){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		if(N==1000) N=999;
		System.out.println(solve(N));
		
		return;
	}
	

	public static void main(String[] args) {
		//q_15596
		//sum(new int[3]);
		
		//q_4673();
		q_1065();
		
	}

}
