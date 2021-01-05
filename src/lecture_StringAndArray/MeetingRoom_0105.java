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
	 ȸ�ǽ� ��ġ�� �ʰ� ������
	
	input : [[0,30],[5,10],[15,20]]
	output : false
	
	input : [[7,10],[2,4]]
	output : true
	
	*/
	
	public boolean solve(Interval[] intervals){
		//1. �Է°��� null���� Ȯ���ϱ�
		if(intervals==null) return false;
		
		//2. start�� �������� intervals �����ϱ�
		Arrays.sort(intervals,Comp);
		
		//3. start�������� ���ĵǾ����� ���� end�� ���� start�� ���ϸ� ��
		for (int i=1;i<intervals.length;i++){
			if(intervals[i-1].end>intervals[i].start) return false;
		}
		
		//4. �ݺ����� return ���� �����ٸ� ���� ����.
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
			// start�� �������� ���������� �� �� �ֵ��� a���� b����
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
