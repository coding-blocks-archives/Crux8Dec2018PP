package L6_Dec18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Dec-2018
 *
 */

public class StringBuilderDemo {

	public static void main(String[] args) {

		// string -> sb
		StringBuilder sb = new StringBuilder("hello");

		System.out.println(sb.length());
		System.out.println(sb.charAt(2));
		System.out.println(sb);

		// set/ update
		sb.setCharAt(2, 's');
		System.out.println(sb);

		// insert
		sb.insert(2, "abc");
		System.out.println(sb);
		sb.insert(sb.length(), "xyz");
		System.out.println(sb);
		sb.append("def");
		System.out.println(sb);

		// remove
		sb.delete(2, 4);
		System.out.println(sb);

		// sb to string
		System.out.println(sb.toString());
	}

}
