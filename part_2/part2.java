package part_2;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class part2 {

	public static void main(String[] args) {
		System.out.println("Please enter two valid dates");
		
		//To user: please enter two valid dates in the string format of 'YYYY-MM-DD'
		//"date1_input" should be the start date.
		//"date2_input should be the last date.
		String date1_input = "2014-01-01";
		String date2_input = "2017-10-23";
		String[] string_array = {date1_input,date2_input};
		LocalDate[] date_array = new LocalDate[2];
		
		System.out.println("First date is " + date1_input + " and second date is " + date2_input);
		
		//I am checking to make sure both dates inputted by user is valid...
		for (int i=0; i < string_array.length; i++) {
			try {
			  System.out.println("Checking to see if " + string_array[i] + " is valid...");
		      date_array[i] = LocalDate.parse(string_array[i]);
		    	} 
			catch (DateTimeParseException e) {
		      e.printStackTrace();
		      System.out.println("Invalid Date input, please input dates as string in format: MM-DD-YYYY");
		      System.exit(0);
			}
		}
		
		//Here I am calculating the duration difference between the two inputted dates.
		System.out.println("Looks Good!  Now let's calculate the period duration between the two dates...");
		Period p = Period.between(date_array[0], date_array[1]);
		//I need to make sure the user didn't put the last date as the 'date1_input' variable and the start date as the 'date2_input variable'
		if (p.getDays() < 0) {
			System.out.println("You cannot subtract the first day from the last day");
			System.exit(0);
		}
		//Finally to display the results...
		System.out.println("There are " + p.getYears() + " years, " + p.getMonths() + " months, " + p.getDays() + " days in between.");
	}
}
