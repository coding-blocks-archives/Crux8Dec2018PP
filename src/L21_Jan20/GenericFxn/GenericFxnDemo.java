package L21_Jan20.GenericFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Jan-2019
 *
 */

public class GenericFxnDemo {

	public static void main(String[] args) {

		// Integer[] arr = { 10, 20, 39, 40 };
		// display(arr);
		//
		// String[] sarr = { "abc", "hi", "bye" };
		// display(sarr);

		Car[] cars = new Car[5];
		cars[0] = new Car(100, 45, "Black");
		cars[1] = new Car(20, 20, "White");
		cars[2] = new Car(10, 30, "Red");
		cars[3] = new Car(90, 12, "Yellow");
		cars[4] = new Car(56, 67, "Grey");

		display(cars);
		// bubbleSort(cars);
		display(cars);

		bubbleSort(cars, new CarSpeedComparator());
		display(cars);
		bubbleSort(cars, new CarPriceComparator());
		display(cars);
		bubbleSort(cars, new CarColorComparator());
		display(cars);

	}

	public static <T> void display(T[] arr) {

		System.out.println("-------------");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("-------------");
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		int n = arr.length;

		for (int counter = 0; counter < n - 1; counter++) {

			for (int j = 0; j < n - counter - 1; j++) {

				if (arr[j].compareTo(arr[j + 1]) > 0) {

					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}
	}

	public static <T> void bubbleSort(T[] arr, Comparator<T> obj) {

		int n = arr.length;

		for (int counter = 0; counter < n - 1; counter++) {

			for (int j = 0; j < n - counter - 1; j++) {

				if (obj.compare(arr[j], arr[j + 1]) > 0) {

					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}

	}

}
