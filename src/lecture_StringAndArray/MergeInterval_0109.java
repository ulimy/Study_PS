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
	 ��ġ�� interval ���� ��ġ��
	 input : [[1,3],[2,6],[8,10],[15,18]]
	 output: [[1,6],[8,10],[15,18]]
	 */
	

	public List<Intervals> solve(List<Intervals> intervals){
		
		// ����ִ��� Ȯ��
		if(intervals.isEmpty()) return intervals;
		
		// ��� ������� ����
		List<Intervals> result = new ArrayList<>();
		
		// 1. start�� �������� �������� ����
		Collections.sort(intervals,(a,b) -> a.start-b.start);
		
		// 2. ù��° interval �ϴ� ����
		Intervals before = intervals.get(0);
		
		// 3. �ι�° ���Һ���
		for (int i=1;i<intervals.size();i++){
			
			Intervals current = intervals.get(i);
			
			// before�� end�� current�� start���� ũ�ٸ� before�� current�� before�� ��ġ��
			if (before.end>=current.start){ // before�� end�� current�� start���� ũ�ٸ� before�� current�� before�� ��ġ��
				// �ΰ��� end �� �� ū ������ end ����
				before.end = Math.max(before.end, current.end);
			}else{ // �׷��� �ʴٸ� ��ĥ �� ���� ��. ���������� ��� �����ϰ� ���� �ݺ����� ���� before �ٲ��ֱ�
				result.add(before);
				before = current;
			}
		}
		
		// !!!! ���� ������ ���Ұ� �߰����� �ʰԵǱ� ������ �������� �ѹ� �� �߰������ �� 
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
