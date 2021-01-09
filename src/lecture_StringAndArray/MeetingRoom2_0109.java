package lecture_StringAndArray;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2_0109 {
	
	/* �ּ� ȸ�ǽ��� ���� ���ϱ� 
	 
	 input : [[0,30],[5,10],[15,20]]
	 output : 2
	 
	 1) start �������� �����ϱ�
	 2) end �������� PriorityQueue MinHeap �����ϱ�
	 */ 
	
	public int solve(Interval[] intervals){
		
		//����ִ��� Ȯ��
		if(intervals==null || intervals.length==0) return 0;
		
		//1) start �������� �������� �����ϱ�
		Arrays.sort(intervals,(a,b)->(a.start-b.start));
		
		//2)MinHeap �����ϱ�
		Queue<Interval> minHeap = new PriorityQueue<>(intervals.length, (a,b)->(a.end-b.end));
		int max=0;
		
		for(int i=0;i<intervals.length;i++){
			
			//���� ������� �ʰ� ���� peek�ؼ� end���� ������ start�� �� ũ�� ���ο� ȸ�ǽ� �ʿ���� -> poll
			while(!minHeap.isEmpty() && minHeap.peek().end <= intervals[i].start){
				minHeap.poll();
			}
			
			// ���ο� ȸ�ǽ��� �ʿ��ϹǷ� heap�� �ֱ�
			minHeap.offer(intervals[i]);
			max=Math.max(max,minHeap.size());
		}
		
		return max;
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
