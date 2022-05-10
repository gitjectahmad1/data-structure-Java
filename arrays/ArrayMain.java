package arrays;

import java.util.Scanner;

public class ArrayMain {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		System.out.print("How many days temperature?");
		int numDays = console.nextInt();	
		int[] temps = new int[numDays];
		// record temperature and find average
		int sum = 0;
		for(int i=0; i<numDays; i++) {
			System.out.println("Day " + (i+1) + "'s high temp: ");
			temps[i] = console.nextInt();
			sum += temps[i];
		}
		
		double average = sum / numDays;
		// count days above average
		int above = 0;
		for (int i=0; i<temps.length; i++) {
			if(temps[i]>average) {
				above++;
			}
		}
		
		System.out.println();
		System.out.println("Average Temp = " + average);
		System.out.println(above + "days above average");
	}

}
