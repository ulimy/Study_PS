package baekjoon_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class boj_11650 {
	
	/*
	 2���� ��� ���� �� N���� �־�����. 
	 ��ǥ�� x��ǥ�� �����ϴ� ������, x��ǥ�� ������ y��ǥ�� �����ϴ� ������ 
	 ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 */

	public static void main(String[] args) {
		
		class Point{
			int x,y;
			
			Point(int x,int y){
				this.x = x;
				this.y = y;
			}

			@Override
			public String toString() {
				return x + " " + y;
			}
			
			
		}
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		List<Point> list = new ArrayList<>();
		
		for(int i=0;i<count;i++){
			list.add(new Point(sc.nextInt(),sc.nextInt()));
		}
		
		sc.close();
		
		Collections.sort(list,new Comparator<Point>(){
			@Override
			public int compare(Point p1,Point p2){
				return (p1.x!=p2.x)?p1.x-p2.x:p1.y-p2.y;
			}
		});
		
		for(Point p : list){
			System.out.println(p.toString());
		}
		
	}

}
