package L21_Jan20.GenericFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Jan-2019
 *
 */

public class CarSpeedComparator implements Comparator<Car> {

	@Override
	public int compare(Car t, Car o) {
		return t.speed - o.speed;
	}

}
