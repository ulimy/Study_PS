package study_Sort;

import java.util.Arrays;

public class BubbleSort {
	
	// 옆에있는 원소보다 크면 swap
	
	public static void main(String[] args){
		
		int[] arr = {3,9,6,1,2,8,10,4,7,5};
		
		for(int i=0;i<arr.length;i++){
			// i만큼의 맨 뒤 원소들은 이미 정렬 된 상태이므로 arr.length-i까지만 반복
			// 맨 마지막 원소는 그 다음원소와 비교하지 않으므로 -1해주기
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
		return;
	}
}
