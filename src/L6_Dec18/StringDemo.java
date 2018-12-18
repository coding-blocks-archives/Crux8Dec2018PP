package L6_Dec18;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Dec-2018
 *
 */

public class StringDemo {

	public static void main(String[] args) {

		String str = "hello";
		// String s1 = str;
		// str = "bye";

		// System.out.println(s1);

		// String s2 = new String("hi");
		// String s3 = new String("hi");

		// Part-1 : Length of String
		System.out.println(str.length());

		// Part-2 : CharAt Limit:0->length-1
		char ch = str.charAt(0);
		System.out.println(ch);
		System.out.println(str.charAt(str.length() - 1));

		// Part-3 : Substring
		System.out.println(str.substring(0, 2)); // he
		System.out.println(str.substring(0, 5)); // hello
		// System.out.println(str.substring(0, 6)); // error
		// System.out.println(str.substring(4, 2));
		System.out.println(str.substring(2)); // llo
		System.out.println(str.substring(2, 2)); // blank

		// Part-4 : Concatenate Two Strings
		String s1 = "hi";
		String s2 = "bye";
		String s3 = s1 + s2;
		System.out.println(s1 + ", " + s2 + ", " + s3);
		String s4 = s1.concat(s2);
		System.out.println(s1 + ", " + s2 + ", " + s4);

		// Part-5 : IndexOf
		System.out.println(str.indexOf("el"));
		System.out.println(str.indexOf("eL"));

		// Part-6 : StartsWith
		System.out.println(str.startsWith("He"));
		System.out.println(str.startsWith("he"));

		// Part-7 : Equals and ==
		s1 = "Hello";
		s2 = s1;
		s3 = "Hello";
		s4 = new String("Hello");

		System.out.println((s1 == s2) + ", " + s1.equals(s2)); // true true
		System.out.println((s1 == s3) + ", " + s1.equals(s3)); // true true
		System.out.println((s1 == s4) + ", " + s1.equals(s4)); // false true

		s1 = s1.replace('l', 'w');
		System.out.println(s1);

	}

}
