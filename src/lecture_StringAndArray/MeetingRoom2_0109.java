package lecture_StringAndArray;

public class MeetingRoom2_0109 {
	
	/* �ּ� ȸ�ǽ��� ���� ���ϱ� 
	 
	 input : [[0,30],[5,10],[15,20]]
	 output : 2
	 
	 1) start �������� �����ϱ�
	 2) end �������� PriorityQueue MinHeap �����ϱ�
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
