package study_Sort;

import java.util.Arrays;

public class InsertionSort {
	
	// 앞의 원소들이 정렬되어있다고 가정하고 자신의 자리 찾기
	
	public static void main(String[] args){
		
		int[] arr = {3,9,6,1,2,8,10,4,7,5};
		
		for(int i=0;i<arr.length;i++){
			int index=i;
			// 제일 앞의 원소가 될때까지 혹은 자신보다 작은 원소를 만날때까지 swap
			while(index>0 && arr[index]<arr[index-1]){
				int temp = arr[index];
				arr[index] = arr[index-1];
				arr[index-1] = temp;
				index--;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
		return;
	}
}
