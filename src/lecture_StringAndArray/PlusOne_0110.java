package lecture_StringAndArray;

import java.util.Arrays;

public class PlusOne_0110 {
	
	/*
	 int 베열이 주어지면 하나의 int라고 생각하고 1 더해서 다시 배열에 넣기
	 
	 input = [9,9,9]
	 output = [1,0,0,0]
	 
	 */

	public int[] solve(int[] digits){
		
		// 1의 자리 index 알아내기
		int index = digits.length-1;
		// 다음 위로 올라갈 값
		int carry=1;
		
		while(index>=0 && carry>0){
			// 더하고 10이상일 경우를 대비하여 %10
			digits[index] = (digits[index]+1)%10;
			
			// 0이라면 10이 된 것 다음 index에서 또 1 더해줘야 함
			if(digits[index]==0){
				carry=1;
			}else{
				// 0이 아니라면 다음 인덱스로 넘어 갈 필요 없음. carry를 0으로 만들어서 while문 끝내기
				carry=0;
			}
			
			// 끝났으니 다음 index로
			index--;
		}
		
		// while문이 끝났는데 carry가 1이라면 999처럼 자릿수가 하나 늘어난 것
		if(carry==1){
			// 맨 앞만 1 나머지는 0이 됨
			digits = new int[digits.length+1];
			digits[0]=1;
		}
		
		return digits;
		
	}
	
	public static void main(String[] args) {
		PlusOne_0110 a = new PlusOne_0110();
		int[] digits ={9,9,9,9}; 
		System.out.println(Arrays.toString(a.solve(digits)));
	}

}
