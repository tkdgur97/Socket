package java30;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		
		ArrayList doing = new ArrayList();
		doing.add("일어나기");
		doing.add("커피마시기");
		doing.add(1350);
		doing.add(5);
		
		System.out.println(doing);
		System.out.println(doing.size()+"가지 일을 함");
		System.out.println("제일 먼저 한 일은"+doing.get(0));
		System.out.println("마지막에 걸었던 시간은 " + doing.get(doing.size()-1)+"분");
		
		
	}

}
