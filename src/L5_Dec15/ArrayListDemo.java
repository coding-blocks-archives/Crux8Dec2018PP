package L5_Dec15;

import java.util.ArrayList;

import javax.sound.midi.Synthesizer;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Dec-2018
 *
 */

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(list);

		// add at last
		list.add(10);
		list.add(20);
		list.add(30);
		System.out.println(list);

		// size
		System.out.println(list.size());

		// add at index
		// range : 0 -> size
		list.add(0, 50);
		System.out.println(list);

		// get : arr[2]
		// range : 0 -> size-1
		System.out.println(list.get(2));

		// update : arr[1] = 60 ;
		// range : 0 -> size-1
		list.set(1, 60);
		System.out.println(list);

		// remove
		// range : 0 -> size-1
		list.remove(1);
		System.out.println(list);

		// display
		System.out.println(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
