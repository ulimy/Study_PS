package baekjoon_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class boj_11650 {
	
	/*
	 2차원 평면 위의 점 N개가 주어진다. 
	 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 
	 정렬한 다음 출력하는 프로그램을 작성하시오.
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
