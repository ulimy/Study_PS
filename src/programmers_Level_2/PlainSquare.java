package programmers_Level_2;

public class PlainSquare {
	
	public static long solution(int w, int h) {
        
        // (w*h) - (w+h-최대공약수)
		long answer = (long)w*(long)h;
        answer -= (w+h-gcd(Math.max(w, h),Math.min(w, h)));
        
        return answer;
    }
	
	public static int gcd(int big,int small){
		
		while(small>0){
			int temp = big%small;
			big = small;
			small = temp;
		}
		
		return big;
	}

	public static void main(String[] args) {
		System.out.println(solution(8,12));

	}

}
