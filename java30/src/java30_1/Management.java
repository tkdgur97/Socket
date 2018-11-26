package java30_1;

import java.util.HashMap;

public class Management {

	public static void main(String[] args) {
		HashMap cus = new HashMap();
		
		cus.put(100, "김데이");
		cus.put(200, "김사전");
		cus.put(300, "김구조");
		cus.put(400, "김자료");
		
		cus.remove(200);
		cus.put(300, "김충성");
		System.out.println(cus);
	}

}
