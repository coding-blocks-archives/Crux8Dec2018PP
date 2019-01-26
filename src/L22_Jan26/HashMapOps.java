package L22_Jan26;

import java.util.HashMap;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jan-2019
 *
 */

public class HashMapOps {

	public static void main(String[] args) {

		System.out.println(maxFreq("aaaaabbccddeeeeeeeeeee"));

		consecutiveSeq(new int[] { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 , 4});
	}

	public static char maxFreq(String str) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (map.containsKey(ch)) {
				int of = map.get(ch);
				int nf = of + 1;
				map.put(ch, nf);
			} else {
				map.put(ch, 1);
			}

		}

		int maxFreq = 0;
		char maxFreqChar = ' ';

		for (Character key : map.keySet()) {

			int val = map.get(key);
			if (val > maxFreq) {
				maxFreq = val;
				maxFreqChar = key;
			}
		}

		return maxFreqChar;

	}

	public static void consecutiveSeq(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			int val = arr[i];

			if (map.containsKey(val - 1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}

			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}

		}

		int maxCount = 0;
		int starting = 0;

		for (Integer key : map.keySet()) {

			if (map.get(key)) {

				int count = 0;

				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > maxCount) {
					maxCount = count;
					starting = key;
				}

			}
		}

		for (int i = starting; i < starting + maxCount; i++) {
			System.out.println(i);
		}

	}

}
