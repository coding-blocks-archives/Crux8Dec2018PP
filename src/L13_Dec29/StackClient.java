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

		int[] arr = { 50, 30, 20, 40, 25, 45, 60, 70 };

		int[] ans = nextGreaterElement2(arr);

		for (int val : ans) {
			System.out.print(val + " ");
		}
		System.out.println();

		int[] prices = { 100, 20, 30, 90, 60, 50, 80, 120, 110, 150 };
		int[] span = stockSpan(prices);

		for (int val : span) {
			System.out.print(val + " ");
		}
		System.out.println();

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

	public static void nextGreaterElement(int[] arr) throws Exception {

		Stack stack = new Stack(100);

		for (int i = 0; i < arr.length; i++) {

			while (!stack.isEmpty() && stack.peek() < arr[i]) {
				System.out.println(stack.pop() + " -> " + arr[i]);
			}

			stack.push(arr[i]);

		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " -> -1");
		}

	}

	public static int[] nextGreaterElement2(int[] arr) throws Exception {

		int[] ans = new int[arr.length];

		Stack stack = new Stack(100);

		for (int i = 0; i < arr.length; i++) {

			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				ans[stack.pop()] = arr[i];
			}

			stack.push(i);

		}

		while (!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}

		return ans;
	}

	public static int[] stockSpan(int[] arr) throws Exception {

		Stack stack = new Stack(100);

		int[] ans = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {

			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				ans[i] = i + 1;
			} else {
				ans[i] = i - stack.peek();
			}

			stack.push(i);
		}

		return ans;
	}

}
