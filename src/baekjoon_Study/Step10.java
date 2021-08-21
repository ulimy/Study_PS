package baekjoon_Study;

import java.util.Scanner;

// 재귀
public class Step10 {
	
	public static int p_10872(int N,int result){
		if(N>1) result = N * p_10872(N-1,result);
		return result;
	}
	
	public static int p_10870(int n){
		if(n==1) return 1;
		else if(n==0) return 0;
		else{
			return p_10870(n-1)+p_10870(n-2);
		}
	}
	
	public static String p_2447(int N,String input){
		
		if(N==1){
			return "*";
		}else{
			StringBuilder result = new StringBuilder();
			String[] str = p_2447(N/3,input).split("\n");
			
			// 1행
			for(String s : str){
				for(int i=0;i<3;i++){
					result.append(s);
				}	
				result.append("\n");
			}
			
			//2행
			for(String s : str){
				result.append(s);
				for(int i=0;i<s.length();i++){
					result.append(" ");
				}
				result.append(s);
				result.append("\n");
			}
			
			//3행
			for(String s : str){
				for(int i=0;i<3;i++){
					result.append(s);
				}	
				result.append("\n");
			}
			
			return result.toString();
		}

	}
	
	public static int p_11729_count = 0;
	public static StringBuilder p_11729_answer = new StringBuilder();
	
	public static void p_11729(int N,int from,int to,int mid){
		p_11729_count++;
		
		if(N==1){
			p_11729_answer.append(from+" "+to+"\n");
		}else{
			// N-1개는 from에서 mid로
			p_11729(N-1,from,mid,to);
			
			//가장 큰 원판은 from에서 to로
			p_11729_answer.append(from+" "+to+"\n");
			
			// mid로 옮겨졌던 원판들 to로 이동
			p_11729(N-1,mid,to,from);
		}
		
		return;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//10872
		//System.out.println(p_10872(sc.nextInt(),1));
		
		//10870
		//System.out.println(p_10870(sc.nextInt()));
		
		//2447
		//System.out.println(p_2447(sc.nextInt(),""));
		
		//11729
		p_11729(sc.nextInt(),1,3,2);
		p_11729_answer.insert(0, p_11729_count+"\n");
		System.out.println(p_11729_answer.toString());
		
		sc.close();
		return;
	}

}
