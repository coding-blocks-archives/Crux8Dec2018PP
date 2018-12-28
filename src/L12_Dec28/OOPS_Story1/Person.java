package L12_Dec28.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 28-Dec-2018
 *
 */

// class
public class Person {

	// data members
	String name;
	int age;

	// fxn
	public void introduceYourself() {
		System.out.println(this.name + " is " + this.age + " years old.");
	}

	public void sayHi(String name) {
		System.out.println(this.name + " says hi to " + name);

	}

}
