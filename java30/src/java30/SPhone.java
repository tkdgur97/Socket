package java30;

public class SPhone implements Phone {

	@Override
	public void talk() {
		System.out.println("삼성폰으로 톡을 실행합니다.");

	}

	@Override
	public void internet() {
		System.out.println("삼성폰으로 인터넷을 실행합니다.");
	}

}
