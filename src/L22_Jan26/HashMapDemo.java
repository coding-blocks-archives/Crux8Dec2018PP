package L22_Jan26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jan-2019
 *
 */

public class HashMapDemo {

	public static void main(String[] args) {
	
		HashMap<String, Integer> map = new HashMap<>();

		// put : O(1)
		map.put("India", 10);
		map.put("US", 60);

		System.out.println(map);
		map.put("India", 50);

		System.out.println(map);

		// get : O(1)
		System.out.println(map.get("India"));
		System.out.println(map.get("Aus"));

		// containsKey : O(1)
		System.out.println(map.containsKey("India"));
		System.out.println(map.containsKey("Aus"));

		// remove : O(1)
		// System.out.println(map.remove("India"));
		System.out.println(map);
		System.out.println(map.remove("Aus"));

		// keySet : O(n)
		ArrayList<String> keys = new ArrayList<>(map.keySet());

		System.out.println(keys);

		for (String val : keys) {
			System.out.println(val);
		}

		Set<String> keysss = map.keySet();

		System.out.println(keysss);

		for (String val : keysss) {
			System.out.println(val);
		}

	}

}
