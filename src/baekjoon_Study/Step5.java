package baekjoon_Study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//1차원배열
public class Step5 {
	
	public static void q_10818(){
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] arr = new int[len];
		
		for(int i=0;i<len;i++){
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(arr);
		
		System.out.println(arr[0]+" "+arr[len-1]);
		
		return;
	}
	
	public static void q_2562(){
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		int index=1;
		 
		for(int i=2;i<=9;i++){
			int num = sc.nextInt();
			if(num>max){
				max = num;
				index = i;
			}
		}
		
		sc.close();
		
		System.out.println(max+"\n"+index);
		
		return;
	}
	
	public static void q_2577(){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt()*sc.nextInt()*sc.nextInt();
		sc.close();
		int[] arr = new int[10];
		Arrays.fill(arr,0);
		
		while(num/10!=0){
			arr[num%10]++;
			num/=10;
		}
		
		arr[num]++;
		
		StringBuilder result = new StringBuilder();
		for(int i : arr){
			result.append(i+"\n");
		}
		
		System.out.println(result.toString());
		
		return;
	}
	
	public static void q_3052(){
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		
		for(int i=0;i<10;i++){
			set.add(sc.nextInt()%42);
		}
		
		System.out.println(set.size());
		
		sc.close();
		
		return;
	}
	
	public static void q_1546(){
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		float[] arr = new float[len];
		float max = 0;
		float avg = 0;
		
		for(int i=0;i<len;i++){
			arr[i] = sc.nextInt();
			if(max<arr[i]) max = arr[i];
		}
		
		for(float n : arr){
			avg+=(n*100/max);
		}
		
		System.out.println(avg/len);
		
		sc.close();
		
		return;
	}
	
	public static void q_8958(){
		Scanner sc = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		int len = sc.nextInt();
		int score,sum;
		
		for(int i=0;i<len;i++){
			char[] arr = sc.next().toCharArray();
			score=0;
			sum=0;
			for(int j=0;j<arr.length;j++){
				switch(arr[j]){
					case 'X': 
						score=0;
						break;
					case 'O':
						sum+=++score;
						break;
				}		
			}
			result.append(sum+"\n");
		}
		
		sc.close();
		
		System.out.println(result.toString());
		
		return;
	}
	
	public static void q_4344(){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int len = sc.nextInt();
		
		for(int i=0;i<len;i++){
			
			int count = sc.nextInt();
			float[] scores = new float[count];
			float avg=0;
			float result=0;
			
			for(int j=0;j<count;j++){
				scores[j] = sc.nextFloat();
				avg+=scores[j];
			}
			avg/=count;
			
			for(float score : scores){
				if(score>avg) result++;
			}
			
			sb.append(String.format("%.3f",result/count*100)+"%\n");
		}
		
		sc.close();
		
		System.out.println(sb.toString());
		
		return;
	}

	public static void main(String[] args) {
//		q_10818();
//		q_2562();
//		q_2577();
//		q_3052();
//		q_1546();
//		q_8958();
		q_4344();
		
		return;

	}

}
