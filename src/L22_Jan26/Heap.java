package L22_Jan26;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jan-2019
 *
 */

public class Heap {

	ArrayList<Integer> data = new ArrayList<>();

	public int size() {
		return this.data.size();
	}

	public void add(int item) {

		this.data.add(item);
		upheapify(this.data.size() - 1);
	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (data.get(ci) < data.get(pi)) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	private void swap(int i, int j) {

		int ith = this.data.get(i);
		int jth = this.data.get(j);

		data.set(i, jth);
		data.set(j, ith);

	}

	public int remove() {

		swap(0, this.data.size() - 1);
		int rv = this.data.remove(this.data.size() - 1);
		downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if (lci < this.data.size() && data.get(lci) < data.get(mini)) {
			mini = lci;
		}

		if (rci < this.data.size() && data.get(rci) < data.get(mini)) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}

	}

	public void display() {
		System.out.println(this.data);
	}

	public int getHP() {
		return this.data.get(0);
	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}
}
