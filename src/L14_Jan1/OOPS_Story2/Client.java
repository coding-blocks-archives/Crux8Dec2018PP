package L14_Jan1.OOPS_Story2;

import java.util.Stack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Jan-2019
 *
 */

public class Client {

	public static void main(String[] args) {

		// case 1
		P obj1 = new P();
		System.out.println(obj1.d);
		System.out.println(obj1.d1);
		obj1.fun();
		obj1.fun1();
		// System.out.println(obj1.d2);

		// case 2
		P obj2 = new C();
		System.out.println(obj2.d); // 10
		System.out.println(((C) obj2).d); // 100
		System.out.println(obj2.d1); // 20
		System.out.println(((C) obj2).d2); // 200
		obj2.fun(); // C fun
		((P) obj2).fun(); // C fun
		obj2.fun1(); // P fun
		((C) obj2).fun2(); // C fun2

		// case 3
		// C obj3 = new P() ;
		// System.out.println(obj3.d);
		// System.out.println(obj3.d2);

		// case 4
		C obj4 = new C();
		System.out.println(obj4.d); // 100
		System.out.println(((P) obj4).d); // 10
		System.out.println(obj4.d1); // 20
		System.out.println(obj4.d2); // 200
		obj4.fun();
		obj4.fun1();
		obj4.fun2();

		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);

		System.out.println(stack.pop());
		System.out.println(stack.size());

		System.out.println(stack);

	}

}
