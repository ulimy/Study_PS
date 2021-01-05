package lecture_StringAndArray;

import java.util.Arrays;
import java.util.Comparator;

class Interval{
	int start;
	int end;
	Interval(){
		this.start = 0;
		this.end =0;
	}
	Interval(int s, int e){
		this.start = s;
		this.end = e;
	}
}

public class MeetingRoom_0105 {
	/*
	 회의실 겹치지 않게 빌리기
	
	input : [[0,30],[5,10],[15,20]]
	output : false
	
	input : [[7,10],[2,4]]
	output : true
	
	*/
	
	public boolean solve(Interval[] intervals){
		//1. 입력값이 null인지 확인하기
		if(intervals==null) return false;
		
		//2. start를 기춘으로 intervals 정렬하기
		Arrays.sort(intervals,Comp);
		
		//3. start기준으로 정렬되었으니 앞의 end와 뒤의 start만 비교하면 됨
		for (int i=1;i<intervals.length;i++){
			if(intervals[i-1].end>intervals[i].start) return false;
		}
		
		//4. 반복문이 return 없이 끝났다면 조건 충족.
		return true;
	}
	
	
	public void print(Interval[] intervals) {
		for(int i=0; i<intervals.length; i++) {
			Interval in = intervals[i];
			System.out.println(in.start+" "+in.end);
			
		}
	}
	
	Comparator<Interval> Comp = new Comparator<Interval>() {

		@Override
		public int compare(Interval a, Interval b) {
			// start를 기준으로 오름차순이 될 수 있도록 a에서 b빼기
			return a.start - b.start;
		}
		
	};
	
	public static void main(String[] args) {
		MeetingRoom_0105 a = new MeetingRoom_0105();
		
	
		Interval in1 = new Interval(15,20);
		Interval in2 = new Interval(5,10);
		Interval in3 = new Interval(0,30);
		
		Interval[] intervals = {in1, in2,in3};
		System.out.println(a.solve(intervals));
	}
}
