package java29;

public class AppleSpeaker implements Speaker {

	@Override
	public void soundUp() {
		System.out.println("애플스피커 소리 업");
	}

	@Override
	public void soundDown() {
		System.out.println("애플스피커 소리 다운");
	}

}
