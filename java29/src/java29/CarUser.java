package java29;

public class CarUser {

	public static void main(String[] args) {
		Car car = new GreenCar();
		
		car.start();
		car.soundUp();
		car.soundDown();
		car.stop();
	}

}
