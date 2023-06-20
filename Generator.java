package igrica;

import java.util.Random;

public class Generator {
	
	int low, high;
	int result;
	
	public Generator(int low, int high) {
		this.low = low;
		this.high = high;
		
		Random random = new Random();
		result = random.nextInt(high-low) + low;
	}
	
	public int getRandom() {
		return result;
	}

}
