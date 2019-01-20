package L21_Jan20.GenericFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Jan-2019
 *
 */

public class CarPriceComparator implements Comparator<Car> {

	@Override
	public int compare(Car t, Car o) {
		return o.price - t.price;
	}

}
