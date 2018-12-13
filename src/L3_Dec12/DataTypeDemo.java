package L3_Dec12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Dec-2018
 *
 */

public class DataTypeDemo {

	public static void main(String[] args) {

		byte by = 10;
		short sh = 10;
		int in = 10;
		long lo = 10;

		// case 1
		// by = sh ;
		// by = in ;
		// by = lo;

		sh = by;
		// sh = in ;
		// sh = lo ;

		in = by;
		in = sh;
		// in = lo ;

		lo = by;
		lo = sh;
		lo = in;

		// case 2
		by = 20;
		System.out.println(by);

		by = (byte) 259;
		System.out.println(by);

		// by = 0;
		// while (by < 128) {
		// System.out.println(by);
		// by = (byte) (by + 1);
		// }

		// case 3
		in = (int) 10000000000L;
		System.out.println(in);

		// case 4
		// float fl = 5.5;
		float fl = 5.5f;
		double db = 5.5f;

		// fl =db ;
		db = fl;

		// case 5
		// in = fl;
		in = (int) fl;
		System.out.println(in);
		fl = in;
		System.out.println(fl);

		// case 6
		boolean bl = true;

		// if(in) {
		// System.out.println("hi");
		// }

		if (in > 5) {
			System.out.println("bye");
		}

		if (true) {

		}

		if (bl) {

		}

		// case 7
		// System.out.println(Math.pow(2, 16));
		char ch = 99;
		System.out.println(ch);

		in = ch;
		System.out.println(in);

		ch = (char) in;

		ch = (char) (ch + 1); // ch + int upgrades itself to int
		System.out.println(ch);

		ch = (char) (ch + 'a'); // ch + ch upgrades itself to int
		System.out.println(ch);

		// case 8
		System.out.println(10 + 20 + "Hello" + 10 + 20);
		System.out.println(2 + ' ' + 5);
		System.out.println(2 + " " + 5);
		System.out.println("Hello" + '\t' + "World");
		System.out.println("Hello" + "\t" + "World");
	}

}
