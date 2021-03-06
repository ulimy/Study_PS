package baekjoon_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj_2751 {
	
	// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<count;i++){
			list.add(sc.nextInt());
		}
		
		sc.close();
		
		// Arrays.sort는 최악의 경우 O(n^2)가 나올 수 있음
		// Collections.sort의 경우는 최악의 경우에도 O(nlogn)을 보장함
		Collections.sort(list);
		
		StringBuilder result = new StringBuilder();
		
		for(Integer i : list){
			result.append(i).append('\n');
		}
		
		System.out.println(result);
	}
}