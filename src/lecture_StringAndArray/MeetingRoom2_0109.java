package lecture_StringAndArray;

public class MeetingRoom2_0109 {
	
	/* 최소 회의실의 개수 구하기 
	 
	 input : [[0,30],[5,10],[15,20]]
	 output : 2
	 
	 1) start 기준으로 정렬하기
	 2) end 기준으로 PriorityQueue MinHeap 구성하기
	 */ 
	
	public int solve(Interval[] intervals){
		return 0;
	}

	public static void main(String[] args) {
		MeetingRoom2_0109 a = new MeetingRoom2_0109();
		Interval in1 = new Interval(5,10);
		Interval in2 = new Interval(15,20);
		Interval in3 = new Interval(0,30);
		Interval[] intervals = {in1,in2,in3};
		System.out.println(a.solve(intervals));
	}

}
