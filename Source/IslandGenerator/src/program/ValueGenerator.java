//package
package program;

//class
public final class ValueGenerator {
	
	//static attributes
	private static int GLOBAL_BASE_VALUE = 0;

	//attributes
	private int currentValue = ++GLOBAL_BASE_VALUE % 100000000;
	private int counter = 1;
	
	//method
	public int getBaseValue() {
		return GLOBAL_BASE_VALUE;
	}
	
	//method
	public boolean getTrueForPropability(int probability) {
		return (getNumberBetweenZeroAndValueIncludingBounds(99) < probability);
	}
	
	//method
	public int getNumberBetweenZeroAndValueIncludingBounds(int value) {
		updateCurrentValue();
		return currentValue % (value + 1);
	}
	
	//method
	private void updateCurrentValue() {
		if (currentValue > 1000000000) {
			currentValue = GLOBAL_BASE_VALUE % 100000000;
		}
		if (counter > 1000000) {
			counter = 1;
		}
		currentValue += (currentValue % counter) + counter++;
		if (currentValue % 2 == 0) {
			currentValue += GLOBAL_BASE_VALUE % counter;
			counter += 7;
		}
		else {
			currentValue += GLOBAL_BASE_VALUE % counter;
			counter += 3;
		}
	}
}