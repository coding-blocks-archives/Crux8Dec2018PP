package L22_Jan26;

import java.util.ArrayList;

import L21_Jan20.GenericFxn.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jan-2019
 *
 */

public class HeapGenericClient {

	public static void main(String[] args) {

		Car[] cars = new Car[5];
		cars[0] = new Car(100, 45, "Black");
		cars[1] = new Car(20, 20, "White");
		cars[2] = new Car(10, 30, "Red");
		cars[3] = new Car(90, 12, "Yellow");
		cars[4] = new Car(56, 67, "Grey");

		HeapGeneric<Car> heapg = new HeapGeneric<>();

		for (int i = 0; i < cars.length; i++) {
			heapg.add(cars[i]);
		}

		while (!heapg.isEmpty()) {
			System.out.println(heapg.remove());
		}

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.get(0).add(10);
		list.get(0).add(20);
		list.get(0).add(30);
		list.get(0).add(40);
		list.get(1).add(2);
		list.get(1).add(3);
		list.get(1).add(5);
		list.get(1).add(7);
		list.get(2).add(6);
		list.get(2).add(15);
		list.get(2).add(23);
		list.get(2).add(50);

		System.out.println(mergeKSortedLists(list));
	}

	public static class Pair implements Comparable<Pair> {

		int data;
		int listNo;
		int idxNo;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}
	}

	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

		ArrayList<Integer> ans = new ArrayList<>();

		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < lists.size(); i++) {
			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.idxNo = 0;
			np.listNo = i;

			heap.add(np);
		}

		while (!heap.isEmpty()) {

			Pair rp = heap.remove();
			ans.add(rp.data);

			rp.idxNo++;

			if (rp.idxNo < lists.get(rp.listNo).size()) {
				rp.data = lists.get(rp.listNo).get(rp.idxNo);
				heap.add(rp);
			}

		}
		return ans;
	}

	public static ArrayList<Integer> kLargestElements(ArrayList<Integer> lists) {

		ArrayList<Integer> ans = new ArrayList<>();

		return ans;
	}

}
