package baekjoon_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj_2751 {
	
	// N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<count;i++){
			list.add(sc.nextInt());
		}
		
		sc.close();
		
		Collections.sort(list);
		
		StringBuilder result = new StringBuilder();
		
		for(Integer i : list){
			result.append(i).append('\n');
		}
		
		System.out.println(result);
	}
}