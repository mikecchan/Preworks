package part_1;

public class part1 {
	
	public static void check_sum(int n1, int n2) {
		System.out.println("Calculating...");
		
		//I need to split my passed in Integer values into character array so that I can easily pick off each digit.
		char ch1[] = Integer.toString(n1).toCharArray();
		char ch2[] = Integer.toString(n2).toCharArray();
		int[] sum_array = new int[ch1.length];

		//I am looping through each array of both passed in numeric values, finding the sum of each, then putting them into a new array.
		for (int i=0; i < ch1.length; i++) {
			int char_num1 = Character.getNumericValue(ch1[i]);
			int char_num2 = Character.getNumericValue(ch2[i]);
			System.out.println(i + " in first number is " + char_num1);
			System.out.println(i + " in second number is " + char_num2);
			sum_array[i] = char_num1 + char_num2;
			System.out.println("Sum of both values is " + sum_array[i]);
		}
		
		//Finally, I am comparing each numeric value in the array and making sure the values are the same all across.
		for (int n=1; n < sum_array.length; n++) {
			System.out.println("Comparing each value in sum_array.");
			if (sum_array[n-1] != sum_array[n]) {
				System.out.println("False! One value is " + sum_array[n-1] + " and the other value is " + sum_array[n] );
				System.exit(1);
			}
			System.out.println("So far so good...");
		}
		System.out.println("True! All values matches!");
	}
		
	public static void main(String[] args) {
		//To user: please enter two numeric values with both having the same number of digits.
		int num1 = 544;
		int num2 = 456;

		System.out.println("First number is: " + num1);
		System.out.println("Second number is: " + num2);
		
		//This Try/Catch block makes sure both inputted numeric values are good.
		try {
			System.out.println("Checking if both values are only 3 digits long...");
			String num1_str = Integer.toString(num1);
			String num2_str = Integer.toString(num2);
			if (num1_str.length() != num2_str.length()) {
				throw new Exception("Both numbers need to be exactly 3 digits.");
			}
			else {
				System.out.println("It's good!");
			}
		}
		catch(Exception excpt) {
			System.out.println(excpt.getMessage());
			System.exit(1);
		}
		
		//Perform method to check the sum of each ordered digit in both values equal to the same total.
		part1.check_sum(num1,num2);
		
	} // End of 'main' method
} // End of Class
