package lecture_StringAndArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Intervals {
	int start;
	int end;
	Intervals(){
		this.start = 0;
		this.end =0;
	}
	Intervals(int s, int e){
		this.start = s;
		this.end = e;
	}
}

public class MergeInterval_0109 {
	
	/*
	 겹치는 interval 전부 합치기
	 input : [[1,3],[2,6],[8,10],[15,18]]
	 output: [[1,6],[8,10],[15,18]]
	 */
	

	public List<Intervals> solve(List<Intervals> intervals){
		
		// 비어있는지 확인
		if(intervals.isEmpty()) return intervals;
		
		// 결과 담기위해 생성
		List<Intervals> result = new ArrayList<>();
		
		// 1. start를 기준으로 오름차순 정렬
		Collections.sort(intervals,(a,b) -> a.start-b.start);
		
		// 2. 첫번째 interval 일단 담음
		Intervals before = intervals.get(0);
		
		// 3. 두번째 원소부터
		for (int i=1;i<intervals.size();i++){
			
			Intervals current = intervals.get(i);
			
			// before의 end가 current의 start보다 크다면 before과 current를 before로 합치기
			if (before.end>=current.start){ // before의 end가 current의 start보다 크다면 before과 current를 before로 합치기
				// 두개의 end 중 더 큰 값으로 end 저장
				before.end = Math.max(before.end, current.end);
			}else{ // 그렇지 않다면 합칠 수 없는 것. 이전까지의 결과 저장하고 다음 반복문을 위해 before 바꿔주기
				result.add(before);
				before = current;
			}
		}
		
		// !!!! 제일 마지막 원소가 추가되지 않게되기 때문에 마지막에 한번 더 추가해줘야 함 
		if(!result.contains(before)) result.add(before);
		
		return result;
	}

	public static void main(String[] args){
		MergeInterval_0109 a = new MergeInterval_0109();
		
		List<Intervals> intervals = new ArrayList<>();

		Intervals in1 = new Intervals(1,3);
		Intervals in2 = new Intervals(2,6);
		Intervals in3 = new Intervals(8,10);
		Intervals in4 = new Intervals(15,18);
		
		intervals.add(in1);
		intervals.add(in2);
		intervals.add(in3);
		intervals.add(in4);
		
		List<Intervals> results = a.solve(intervals);
		
		for (int i=0;i<results.size();i++){
			Intervals result = results.get(i);
			System.out.println("start : "+result.start+" end : "+result.end);
		}
	}
	
}
