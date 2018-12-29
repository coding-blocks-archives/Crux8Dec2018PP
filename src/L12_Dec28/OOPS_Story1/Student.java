package L12_Dec28.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class Student {

	private String name;
	private int age;

	// getter
	public int getAge() {
		return age;
	}

	// setter
	public void setAge(int age) throws Exception {

		if (age <= 0) {
			throw new ArithmeticException("Invalid Age.");
		}

		this.age = age;
	}
}
