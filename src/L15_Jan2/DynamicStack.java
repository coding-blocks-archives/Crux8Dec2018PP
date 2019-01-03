package L15_Jan2;

import L13_Dec29.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 02-Jan-2019
 *
 */

public class DynamicStack extends Stack {

	@Override
	public void push(int item) throws Exception {

		if (isFull()) {

			int[] na = new int[2 * this.data.length];
			int[] oa = this.data;

			for (int i = 0; i < oa.length; i++) {
				na[i] = oa[i];
			}

			this.data = na;
			

		}
		
		super.push(item);
	}
}
