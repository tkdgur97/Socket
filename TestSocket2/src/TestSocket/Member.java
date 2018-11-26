package TestSocket;

import java.io.Serializable;
//serializble 직렬화하게만드는거
public class Member implements Serializable{
	String name;
	String tel;
	int age;
	public Member(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}

}
