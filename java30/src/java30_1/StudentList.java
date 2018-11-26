package java30_1;

import java.util.HashMap;

public class StudentList {

	public static void main(String[] args) {
		HashMap students = new HashMap();
		Student s1 = new Student("123", "박아무개", 180, "011-");
		Student s2 = new Student("1234", "김아무개", 120, "012-");
		Student s3 = new Student("1235", "송아무개", 130, "013-");
		students.put("kg100", s1);
		students.put("kg200", s2);
		students.put("kg300", s3);
		System.out.println(students);
	}

}
