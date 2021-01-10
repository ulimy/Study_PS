package lecture_StringAndArray;

import java.util.Arrays;

public class PlusOne_0110 {
	
	/*
	 int ������ �־����� �ϳ��� int��� �����ϰ� 1 ���ؼ� �ٽ� �迭�� �ֱ�
	 
	 input = [9,9,9]
	 output = [1,0,0,0]
	 
	 */

	public int[] solve(int[] digits){
		
		// 1�� �ڸ� index �˾Ƴ���
		int index = digits.length-1;
		// ���� ���� �ö� ��
		int carry=1;
		
		while(index>=0 && carry>0){
			// ���ϰ� 10�̻��� ��츦 ����Ͽ� %10
			digits[index] = (digits[index]+1)%10;
			
			// 0�̶�� 10�� �� �� ���� index���� �� 1 ������� ��
			if(digits[index]==0){
				carry=1;
			}else{
				// 0�� �ƴ϶�� ���� �ε����� �Ѿ� �� �ʿ� ����. carry�� 0���� ���� while�� ������
				carry=0;
			}
			
			// �������� ���� index��
			index--;
		}
		
		// while���� �����µ� carry�� 1�̶�� 999ó�� �ڸ����� �ϳ� �þ ��
		if(carry==1){
			// �� �ո� 1 �������� 0�� ��
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
