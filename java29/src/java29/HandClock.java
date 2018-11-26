package java29;

public abstract class HandClock implements Clock {
	int price;

	@Override
	public void watch() {
		System.out.println("손목시계로 시각을 보다.");
	
	}
	
	public abstract void timeStop();
}
