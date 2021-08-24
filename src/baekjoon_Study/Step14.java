package baekjoon_Study;

import java.util.Scanner;

public class Step14 {
	
	static int M,N;
	static int[] arr;
	static StringBuilder result = new StringBuilder();
	
	static boolean[] visited;
	
	public static void p_15649(int count){
		
		// count가 M이라면 배열이 가득  찼으므로 print
		if(count==M){
			for(int a : arr) result.append(a+" ");
			result.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++){
			if(!visited[i]){
				// arr에 값 넣기
				arr[count] = i;
				visited[i] = true;
				
				// arr에 다음 값 넣기
				p_15649(count+1);
				
				// arr에 M만큼 담고 출력한 후일테니 false로 다시 바꿔주기
				visited[i] = false;
			}
		}
		
		return;

	}


	public static void p_15650(int count,int num){
		if(count==M){
			for(int a : arr) result.append(a+" ");
			System.out.println(result.toString());
			return;
		}
		
		// 오름차순이므로 앞에서 정한 숫자보다 큰 숫자들 중에서만 고르기
		for(int i=num+1;i<=N;i++){
			arr[count] = i;
			p_15650(count+1,i);
		}
		
		return;
	}

	
	public static void p_15651(int count){
		if(count==M){
			for(int a : arr) result.append(a+" ");
			result.append("\n");
			return;
		}

		// 같은 수를 여러번 골라도 되므로 처음부터 끝까지 반복
		for(int i=1;i<=N;i++){
			arr[count] = i;
			p_15651(count+1);
		}
		
		return;

	}
	
	public static void p_15652(int count,int num){
		if(count==M){
			for(int a : arr) result.append(a+" ");
			result.append("\n");
			return;
		}
		
		// 오름차순이므로 앞에서 정한 숫자보다 큰 숫자들 중에서만 고르기
		// 같은 숫자를 골라도 되므로 num도 포함
		for(int i=num;i<=N;i++){
			arr[count] = i;
			p_15652(count+1,i);
		}
		
		return;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// 길이가 M인 수열
		arr = new int[M];
		
		// 1부터 N까지의 방문여부
		//visited = new boolean[N+1];
		//result.setLength(0);
		//p_15649(0);
		//System.out.println(result.toString());
		
		//result.setLength(0);
		//p_15650(0,0);
		//System.out.println(result.toString());
		
		//result.setLength(0);
		//p_15651(0);
		//System.out.println(result.toString());
		
		//result.setLength(0);
		//p_15652(0,1);
		//System.out.println(result.toString());
		
		sc.close();
		
		return;

	}

}
