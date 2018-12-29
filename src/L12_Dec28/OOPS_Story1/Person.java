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
	String name = "D";
	int age = 90;

	// constructor
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// default constructor
	public Person() {
		this.name = "p";
		this.age = 900;
	}

	// fxn
	public void introduceYourself() {
		System.out.println(this.name + " is " + this.age + " years old.");

	}

	public void sayHi(String name) {
		System.out.println(this.name + " says hi to " + name);

	}

}
