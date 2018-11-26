package java30_1;

import java.util.ArrayList;

public class Run {
	public static void main(String[] args) {
		ArrayList rank = new ArrayList();
		rank.add("박소정");
		rank.add("김정민");
		rank.add("소지현");
		rank.add("김개념");
		rank.remove(1);
		for (int i = 0; i < rank.size(); i++) {
			System.out.println((i+1)+"등 "+rank.get(i));
		}
		
	}
}
