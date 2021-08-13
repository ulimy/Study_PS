package baekjoon_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class boj_11651 {
	
	/*
	 2차원 평면 위의 점 N개가 주어진다. 
	 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 
	 정렬한 다음 출력하는 프로그램을 작성하시오.
	 */

	public static void main(String[] args) {
		
		class Point{
			int x,y;
			
			Point(int x, int y){
				this.x = x;
				this.y = y;
			}

			@Override
			public String toString() {
				return x + " " + y;
			}
			
		}
		
		List<Point> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		for(int i=0;i<count;i++){
			list.add(new Point(sc.nextInt(),sc.nextInt()));
		}
		
		sc.close();
		
		Collections.sort(list,new Comparator<Point>(){
			@Override
			public int compare(Point p1, Point p2){
				return (p1.y!=p2.y)?p1.y-p2.y:p1.x-p2.x;
			}
		});
		
		StringBuffer result = new StringBuffer();
		for(Point p : list){
			result.append(p.toString());
			result.append('\n');
		}
		
		System.out.println(result.toString());

		
	}

}
