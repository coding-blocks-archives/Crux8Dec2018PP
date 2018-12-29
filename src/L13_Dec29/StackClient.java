package L13_Dec29;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class StackClient {

	public static void main(String[] args) throws Exception {

		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		// System.out.println(s.pop());
		s.display();

		s.display();
		System.out.println(s.peek());
		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.pop());
		// System.out.println(s.pop());

		s.display();
		// displayReverse(s);
		actualReverse(s, new Stack());
		s.display();

	}

	// no extra stack is allowed -> O(n)
	public static void displayReverse(Stack s) throws Exception {

		if (s.isEmpty()) {
			return;
		}

		int temp = s.pop();
		displayReverse(s);

		System.out.println(temp);
		s.push(temp);

	}

	// only one extra stack is allowed -> O(n)
	public static void actualReverse(Stack s, Stack temp) throws Exception {

		if (s.isEmpty()) {
			TempToOriginalFill(s, temp);
			return;
		}

		temp.push(s.pop());

		actualReverse(s, temp);

	}

	public static void TempToOriginalFill(Stack s, Stack temp) throws Exception {

		if (temp.isEmpty()) {
			return;
		}

		int t = temp.pop();
		TempToOriginalFill(s, temp);
		s.push(t);

	}

}
