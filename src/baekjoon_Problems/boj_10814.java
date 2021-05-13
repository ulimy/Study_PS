package baekjoon_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class boj_10814 {
	/*
	 �¶��� ������ ������ ������� ���̿� �̸��� ������ ������� �־�����. 
	 �̶�, ȸ������ ���̰� �����ϴ� ������, ���̰� ������ ���� ������ ����� �տ� ���� ������ 
	 �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 */

	public static void main(String[] args) {
		class Member{
			int age;
			String name;
			int count;
			
			Member(int age, String name, int count){
				this.age = age;
				this.name = name;
				this.count = count;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		List<Member> list = new ArrayList<>();
		
		for(int i=0;i<count;i++){
			list.add(new Member(sc.nextInt(),sc.nextLine(),i));
		}
		
		sc.close();
		
		Collections.sort(list,new Comparator<Member>(){
			@Override
			public int compare(Member m1, Member m2){
				return (m1.age!=m2.age)?m1.age-m2.age:m1.count-m2.count;
			}
		});
		
		for(Member m : list){
			System.out.println(m.age+m.name);
		}

	}

}
