package baekjoon_DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2579 {

	/*
	 ��� ������ ���� ������ ���� ��Ģ�� �ִ�.

	1. ����� �� ���� �� ��ܾ� �Ǵ� �� ��ܾ� ���� �� �ִ�. ��, �� ����� �����鼭 �̾ ���� ����̳�, ���� ���� ������� ���� �� �ִ�.
	2. ���ӵ� �� ���� ����� ��� ��Ƽ��� �� �ȴ�. ��, �������� ��ܿ� ���Ե��� �ʴ´�.
	3. ������ ���� ����� �ݵ�� ��ƾ� �Ѵ�.
	
	���� ù ��° ����� ��� �̾� �� ��° ����̳�, �� ��° ������� ���� �� �ִ�. 
	������, ù ��° ����� ��� �̾� �� ��° ������� �ö󰡰ų�, ù ��°, �� ��°, �� ��° ����� �����ؼ� ��� ���� ���� ����.
	
	�� ��ܿ� ���� �ִ� ������ �־��� �� �� ���ӿ��� ���� �� �ִ� �� ������ �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] nums = new int[len];
		for (int i=0;i<len;i++){
			nums[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[len];
		if(len>=1) dp[0] = nums[0];
		if(len>=2) dp[1] = dp[0]+nums[1];
		if(len>=3) dp[2] = Math.max(nums[0]+nums[2],nums[1]+nums[2]);
		 
		for(int i=3;i<len;i++){
			dp[i] = Math.max(dp[i-2], dp[i-3]+nums[i-1])+nums[i];
		}
		
		System.out.println(dp[len-1]);

	}

}
