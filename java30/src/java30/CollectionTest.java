package java30;

import java.util.Vector;

public class CollectionTest {

	public static void main(String[] args) {

		Vector data = new Vector();
		
		data.add("감사합니다.");
		data.add(100);
		data.add(11.22);
		data.add(true);
		data.add(new KiwiSpeaker());
		
		System.out.println(data);
		System.out.println(data.get(0));
		System.out.println(data.get(data.size()-1));
		
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}
		
		String hi = (String) data.get(0);
		Integer num = (Integer)data.get(1);
	}

}
