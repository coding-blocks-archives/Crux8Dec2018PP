package L21_Jan20.OOPS_Story3;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Jan-2019
 *
 */

public class Student {

	String name;
	final int rollNo = 90;

	static int numOfStudents;

	Student(String name) {
		this.name = name;
		numOfStudents++;
		// this.rollNo = numOfStudents;
	}

	public void introduce() {

		System.out.println(this.name + " has roll no " + this.rollNo);
		getNumberOfStudents();
	}

	// this ?
	// static fxn we cannt access non static data members
	// static fxn cannot access this
	public static void getNumberOfStudents() {
		System.out.println(numOfStudents);
	}

}
