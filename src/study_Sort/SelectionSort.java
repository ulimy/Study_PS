package study_Sort;

import java.util.Arrays;

public class SelectionSort {
	
	// 가장 작은 것을 선택해서 제일 앞으로 보내기
	
	public static void main(String[] args){
		
		int[] arr = {3,9,6,1,2,8,10,4,7,5};
		
		for(int i=0;i<arr.length;i++){
			// 제일 작은 원소 찾기
			int min=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[min]) min=j;
			}
			//제일 작은 원소와 swap
			if(min!=i){
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
		return;
	}

}
