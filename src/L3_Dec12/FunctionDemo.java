package L3_Dec12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2018
 *
 */

public class FunctionDemo {

	static int abc = 100;

	public static void main(String[] args) {

		System.out.println("hello");

		// Part-1
		System.out.println("----------- Part-1 -----------");
		// fxn calling
		addition();
		subtraction();

		// Part-2
		System.out.println("----------- Part-2 -----------");
		additionWithParams(2, 3);

		int sum = additionReturn(4, 6);
		System.out.println(sum);

		// Part-3
		System.out.println("----------- Part-3 -----------");
		int one = 10, two = 20;
		sum = DemoScopes(one, two);
		System.out.println(sum);

		// Part-4
		System.out.println("----------- Part-4 -----------");
		System.out.println(abc); // 100 -> global variable
		int abc = 200; // local variable
		System.out.println(abc); // 200 -> local variable
		System.out.println(FunctionDemo.abc); // 100 -> global
		DemoGlobalScopes(one);
		System.out.println(FunctionDemo.abc); // 70 -> global
		System.out.println(abc); // 200 -> local

		// Part-5 : Pass by value
		System.out.println("----------- Part-5 -----------");
		System.out.println(one + ", " + two);
		Swap(one, two);
		System.out.println(one + ", " + two);

		System.out.println("bye");

	}

	public static void Swap(int one, int two) {
		System.out.println(one + ", " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + ", " + two);
	}

	private static int DemoGlobalScopes(int one) {
		int abc = 1000;

		FunctionDemo.abc = 70;
		int sum = one + FunctionDemo.abc;
		System.out.println(sum); // 80
		return sum;
	}

	public static int DemoScopes(int one, int another) {

		int sum = one + another;
		return sum;
	}

	// fxn definition
	public static void addition() {

		int a = 2;
		int b = 4;

		int sum = a + b;

		System.out.println(sum);

	}

	public static void additionWithParams(int a, int b) {

		int sum = a + b;
		System.out.println(sum);
	}

	public static int additionReturn(int a, int b) {

		int sum = a + b;
		return sum;
	}

	public static void subtraction() {

		int a = 2;
		int b = 4;

		int sub = a - b;

		System.out.println(sub);
	}

}
