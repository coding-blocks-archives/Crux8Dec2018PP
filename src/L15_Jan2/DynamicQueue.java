package L15_Jan2;

import L13_Dec29.Queue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Jan-2019
 *
 */

public class DynamicQueue extends Queue {

	@Override
	public void enqueue(int item) throws Exception {

		if (isFull()) {

			int[] na = new int[2 * this.data.length];
			int[] oa = this.data;

			for (int i = 0; i < this.size; i++) {
				int idx = (i + this.front) % this.data.length;
				na[i] = oa[idx];
			}
			
			this.data = na ;
			this.front = 0 ;
		}

		super.enqueue(item);
	}
}
