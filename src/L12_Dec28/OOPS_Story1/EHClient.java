package L12_Dec28.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Dec-2018
 *
 */

public class EHClient {

	public static void main(String[] args) {

		Student s = new Student();
		// System.out.println(s.getAge());
		System.out.println("hi");

		try {
			// s.age =-1 ;
			s.setAge(-1);
			System.out.println("abc");
		} catch (Exception e) {
			// System.out.println(e);
			System.out.println("in catch");
			return;
		} finally {
			System.out.println("in finally");
		}
		System.out.println("bye");
		System.out.println(s.getAge());

	}

}
