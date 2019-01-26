package L22_Jan26;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jan-2019
 *
 */

public class HeapGeneric<T extends Comparable<T>> {

	ArrayList<T> data = new ArrayList<>();

	public int size() {
		return this.data.size();
	}

	public void add(T item) {

		this.data.add(item);
		upheapify(this.data.size() - 1);
	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (isLarger(data.get(ci), data.get(pi)) > 0) {
			swap(pi, ci);
			upheapify(pi);
		}

	}

	private void swap(int i, int j) {

		T ith = this.data.get(i);
		T jth = this.data.get(j);

		data.set(i, jth);
		data.set(j, ith);

	}

	public T remove() {

		swap(0, this.data.size() - 1);
		T rv = this.data.remove(this.data.size() - 1);
		downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if (lci < this.data.size() && isLarger(data.get(lci), data.get(mini)) > 0) {
			mini = lci;
		}

		if (rci < this.data.size() && isLarger(data.get(rci), data.get(mini)) > 0) {
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

	public T getHP() {
		return this.data.get(0);
	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}

	// o1 priority > o2 : +ve
	// o2 priority > o1 : -ve
	public int isLarger(T o1, T o2) {
		return o1.compareTo(o2);
	}

}
