package java30;

import java.util.ArrayList;

public class Ski {
	public static void main(String[] args) {
		ArrayList rank = new ArrayList();

		rank.add("박스키");
		rank.add("송스키");
		rank.add("김스키");
		rank.add("정스키");
		System.out.println(rank);
		rank.remove(1);
		System.out.println(rank);
	}
}
