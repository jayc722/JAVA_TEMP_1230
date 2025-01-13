package day010;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex07_ListSort2 {

	public static void main(String[] args) {
		ArrayList<Student1> list1 = new ArrayList<Student1>();
		list1.add(new Student1(1,1,3,"홍길동"));
		list1.add(new Student1(1,1,1,"고길동"));
		list1.add(new Student1(1,1,2,"길길동"));
		
		System.out.println(list1);
		
		//Collections.sort(list1)    //comparable 인터페이스 구현 필요
		
		Collections.sort(list1);  
		System.out.println(list1);
		
		
		
		ArrayList<Student2> list2 = new ArrayList<Student2>();
		list2.add(new Student2(1,1,3,"홍길동"));
		list2.add(new Student2(1,1,1,"고길동"));
		list2.add(new Student2(1,1,2,"길길동"));
		
		System.out.println("--------------");
		list2.sort(new Student2(1,1,1,"a"));			//정렬에 comparator 필요
		
		System.out.println(list2);
		
		
		ArrayList<Student3> list3 = new ArrayList<Student3>();
		list3.add(new Student3(1,1,3,"홍길동"));
		list3.add(new Student3(1,1,1,"고길동"));
		list3.add(new Student3(1,1,2,"길길동"));
		
		list3.sort(new Comparator<Student3>() {
			@Override
			public int compare(Student3 o1, Student3 o2) {					 //class에 안넣고 여기 구현해도 됨	->차후 람다식으로
																			//매개변수 private 아닌지 주의
					if(o1.grade != o2.grade) return o1.grade - o2.grade;		
					if(o1.classNum != o2.classNum) return o1.classNum - o2.classNum;
					if(o1.num != o2.num) return o1.num - o2.num;
					
				
				return 0;
			}
		});
		System.out.println("--------------");
		System.out.println(list3);
	}

}



@Data
@AllArgsConstructor
class Student1 implements Comparable<Student1>{				//정렬을 위한 기준점 필요
	private int grade, classNum, num;
	private String name;
	
	public String toString() {
		return grade + "학년 " + classNum + "반 " + num + "번 " +  name;
				}

	@Override
	public int compareTo(Student1 o) {
		if(grade != o.grade) return grade - o.grade;
		if(classNum != o.classNum) return classNum - o.classNum;
		if(num != o.num) return num - o.num;
		
		return 0;
	}
	
	
	
}



@Data
@AllArgsConstructor
class Student2 implements Comparator<Student2>{
	private int grade, classNum, num;
	private String name;
	
	public String toString() {
		return grade + "학년 " + classNum + "반 " + num + "번 " +  name;
				}

	@Override
	public int compare(Student2 o1, Student2 o2) {					 //자기자신 포함x 매개변수 2개일때
		
			if(o1.grade != o2.grade) return o1.grade - o2.grade;		//o1 생략돼도 실행은 되기때문에 주의
			if(o1.classNum != o2.classNum) return o1.classNum - o2.classNum;
			if(o1.num != o2.num) return o1.num - o2.num;
			
		
		return 0;
	}
}

@Data
@AllArgsConstructor
class Student3 {
	public int grade, classNum, num;
	public String name;
	
	public String toString() {
		return grade + "학년 " + classNum + "반 " + num + "번 " +  name;
				}
	
}