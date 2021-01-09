package lecture_StringAndArray;

import java.util.ArrayList;
import java.util.Arrays;
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
	

	public int[] solve(List<Intervals> intervals){
		return null;
	}

	public static void main(String[] args){
		MergeInterval_0109 a = new MergeInterval_0109();
		
		List<Intervals> intervals = new ArrayList<>();

		Intervals in1 = new Intervals(1,3);
		Intervals in2 = new Intervals(2,6);
		Intervals in3 = new Intervals(8,10);
		Intervals in4 = new Intervals(5,18);
		
		intervals.add(in1);
		intervals.add(in2);
		intervals.add(in3);
		intervals.add(in4);
	
		System.out.println(Arrays.toString(a.solve(intervals)));
	}
	
}
