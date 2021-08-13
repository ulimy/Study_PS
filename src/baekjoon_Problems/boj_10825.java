package baekjoon_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class boj_10825 {
	/*
	 �����̳� �� �л� N���� �̸��� ����, ����, ���� ������ �־�����. 
	 �̶�, ������ ���� �������� �л��� ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.

	1. ���� ������ �����ϴ� ������
	2. ���� ������ ������ ���� ������ �����ϴ� ������	
	3. ���� ������ ���� ������ ������ ���� ������ �����ϴ� ������
	4. ��� ������ ������ �̸��� ���� ������ �����ϴ� ������ 
	(��, �ƽ�Ű �ڵ忡�� �빮�ڴ� �ҹ��ں��� �����Ƿ� ���������� �տ� �´�.)
	 */

	public static void main(String[] args) {
		class Score{
			int korean,english,math;
			String name;
			
			Score(String name, int korean, int english, int math) {
				this.name = name;
				this.korean = korean;
				this.english = english;
				this.math = math;
				
			}

			@Override
			public String toString() {
				return "Score [korean=" + korean + ", english=" + english + ", math=" + math + ", name=" + name + "]";
			}
			
			
		}
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		List<Score> list = new ArrayList<>();
		
		for(int i=0;i<count;i++){
			list.add(new Score(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
		}
		
		sc.close();
		
		Collections.sort(list, new Comparator<Score>(){
			@Override
			public int compare(Score s1, Score s2){
				if(s1.korean!=s2.korean) return s2.korean-s1.korean;
				if(s1.english!=s2.english) return s1.english-s2.english;
				if(s1.math!=s2.math) return s2.math-s1.math;
				return s1.name.compareTo(s2.name);
 			}
		});
		
		for(Score s : list){
			System.out.println(s.name);
		}

	}

}
