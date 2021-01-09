package lecture_StringAndArray;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2_0109 {
	
	/* 최소 회의실의 개수 구하기 
	 
	 input : [[0,30],[5,10],[15,20]]
	 output : 2
	 
	 1) start 기준으로 정렬하기
	 2) end 기준으로 PriorityQueue MinHeap 구성하기
	 */ 
	
	public int solve(Interval[] intervals){
		
		//비어있는지 확인
		if(intervals==null || intervals.length==0) return 0;
		
		//1) start 기준으로 오름차순 정렬하기
		Arrays.sort(intervals,(a,b)->(a.start-b.start));
		
		//2)MinHeap 구성하기
		Queue<Interval> minHeap = new PriorityQueue<>(intervals.length, (a,b)->(a.end-b.end));
		int max=0;
		
		for(int i=0;i<intervals.length;i++){
			
			//힙이 비어있지 않고 힙에 peek해서 end보다 현재의 start가 더 크면 새로운 회의실 필요없음 -> poll
			while(!minHeap.isEmpty() && minHeap.peek().end <= intervals[i].start){
				minHeap.poll();
			}
			
			// 새로운 회의실이 필요하므로 heap에 넣기
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
