package L21_Jan20.GenericClass;

import java.util.ArrayList;
import L21_Jan20.GenericFxn.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Jan-2019
 *
 */

public class GenericClassDemo {

	public static void main(String[] args) {
		Pair<Pair<Integer, String>, Pair<Double, Character>> pair = new Pair<>();

		pair.a = new Pair<>();
		pair.b = new Pair<>();
		System.out.println(pair.a.a);
		System.out.println(pair.a.b);
		System.out.println(pair.b.a);
		System.out.println(pair.b.b);

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		System.out.println(list.get(0).add(10));
		System.out.println(list.get(0).add(20));
		System.out.println(list);

		LinkedListGeneric<Car> ll = new LinkedListGeneric<>();

		Car[] cars = new Car[5];
		cars[0] = new Car(100, 45, "Black");
		cars[1] = new Car(20, 20, "White");
		cars[2] = new Car(10, 30, "Red");
		cars[3] = new Car(90, 12, "Yellow");
		cars[4] = new Car(56, 67, "Grey");

		ll.addLast(cars[0]);
		ll.addLast(cars[1]);
		ll.addLast(cars[2]);
		ll.addLast(cars[3]);
		ll.addLast(cars[4]);

		ll.display();

	}

}
