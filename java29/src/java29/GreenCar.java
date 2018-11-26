package java29;

public class GreenCar implements Car {

	@Override
	public void start() {
		System.out.println("녹색차가 출발합니다.");

	}

	@Override
	public void stop() {
		System.out.println("녹색차가 정지합니다.");
	}

	@Override
	public void soundUp() {
		System.out.println("녹색차가 소리를 키웁니다.");
	}

	@Override
	public void soundDown() {
		System.out.println("녹색차가 소리를 줄입니다.");
	}

}
