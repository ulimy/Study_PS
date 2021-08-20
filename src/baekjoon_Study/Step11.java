package baekjoon_Study;

import java.util.Arrays;
import java.util.Scanner;

//브루트포스
public class Step11 {
	
	public static void p_2798(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++){
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		int result = 0;
		
		for(int i=0;i<N-2;i++){
			for(int j=i+1;j<N-1;j++){
				for(int k=j+1;k<N;k++){
					int sum = arr[i]+arr[j]+arr[k];
					if(sum<=M && sum>=result) result=sum;
				}
			}
		}
		
		System.out.println(result);
		
		return;
	}
	
	public static void p_2231(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		int i;
		boolean check = false;
		
		for(i=1;i<num;i++){
			int result = i;
			int M = i;
			
			while(M>0){
				result += M%10;
				M /= 10;
			}
			
			if(result==num) {
				check = true;
				break;
			}
		}
		
		if(check){
			System.out.println(i);
		}else{
			System.out.println(0);
		}
		
		return;
	}
	
	public static void p_7568(){
		
		class Person{
			int x,y;
			Person(int x,int y){
				this.x = x;
				this.y = y;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		Person[] people = new Person[count];
		int[] score = new int[count];
		Arrays.fill(score, 1);
		
		for(int i=0;i<count;i++){
			people[i] = new Person(sc.nextInt(),sc.nextInt());
		}
		
		for(int j=0;j<count;j++){
			for(int k=0;k<count;k++){
				if(j!=k && people[j].x<people[k].x && people[j].y<people[k].y) score[j]++;
			}
		}
		sc.close();
		
		StringBuilder result = new StringBuilder();
		for(int s : score){
			result.append(s+" ");
		}
		
		System.out.println(result.toString());

		return;
		
	}
	
	public static void p_1018(){
		
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		char[][] arr = new char[M][N];
		
		for(int i=0;i<M;i++){
			arr[i] = sc.next().toCharArray();
		}
		
		sc.close();
		
		int min = 64;
		char[] bw = {'B','W'};
		
		for(int i=0;i<=M-8;i++){
			for(int j=0;j<=N-8;j++){
				int b = 0;
				int w = 1;
				int change_b=0;
				int change_w=0;
				
				for(int x=i;x<i+8;x++){
					for(int y=j;y<j+8;y++){
						if(arr[x][y]!=bw[b]) change_b++;
						if(arr[x][y]!=bw[w]) change_w++;
						b = (b+1)%2;
						w = (w+1)%2;
					}
					b = (b+1)%2;
					w = (w+1)%2;
				}
				
				min = Math.min(min,Math.min(change_b, change_w));
				
			}
		}
		
		System.out.println(min);
		
		return;
	}
	
	public static void p_1436(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		int count=0;
		int num=665;
		
		while(count<N){
			num++;
			if(Integer.toString(num).contains("666")) count++;
		}
		
		System.out.println(num);
		
		return;
	}

	public static void main(String[] args) {
		//p_2798();
		//p_2231();
		//p_7568();
		//p_1018();
		p_1436();
		
		return;
	}

}
