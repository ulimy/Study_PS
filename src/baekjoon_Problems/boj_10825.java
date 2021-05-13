package baekjoon_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class boj_10825 {
	/*
	 도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 
	 이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.

	1. 국어 점수가 감소하는 순서로
	2. 국어 점수가 같으면 영어 점수가 증가하는 순서로	
	3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
	4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 
	(단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
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
