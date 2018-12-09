
/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 08-Dec-2018
 *
 */

public class Conditions {

	public static void main(String[] args) {

		int marks = 60;
		int pack = 10;

		if(marks == 60) {
			System.out.println("marks is 60");
		}
		if (marks > 50 || pack > 15) {
			System.out.println("good");
		} 
		
		if (marks > 40 && pack > 2) {
			System.out.println("avg");
		} else {
			System.out.println("in else");
		}

	}

}
