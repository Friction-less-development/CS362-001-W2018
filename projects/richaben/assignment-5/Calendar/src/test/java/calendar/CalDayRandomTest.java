package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.GregorianCalendar;


/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	 @Test
	 public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				int year = ValuesGenerator.getRandomIntBetween(random, 1, 10000);
				int month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int day = ValuesGenerator.getRandomIntBetween(random, 1, 40);
				int hour = ValuesGenerator.getRandomIntBetween(random, 1, 30);
				int minute = ValuesGenerator.getRandomIntBetween(random, 1, 70);
				GregorianCalendar today = new GregorianCalendar(year,month,day);
				CalDay test03CalDay = new CalDay(today);
				Appt test03Appt1 = new Appt(hour, minute, day, month, year, "Title", "Description");
				year = ValuesGenerator.getRandomIntBetween(random, 1, 10000);
				month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				day = ValuesGenerator.getRandomIntBetween(random, 1, 40);
				hour = ValuesGenerator.getRandomIntBetween(random, 1, 30);
				minute = ValuesGenerator.getRandomIntBetween(random, 1, 70);
				Appt test03Appt2 = new Appt(hour, minute, day, month, year, "Title", "Description");
				year = ValuesGenerator.getRandomIntBetween(random, 1, 10000);
				month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				day = ValuesGenerator.getRandomIntBetween(random, 1, 40);
				hour = ValuesGenerator.getRandomIntBetween(random, 1, 30);
				minute = ValuesGenerator.getRandomIntBetween(random, 1, 70);
				Appt test03Appt3 = new Appt(hour, minute, day, month, year, "Title", "Description");
				int validAppts = 0;
				if(test03Appt1.getValid()){
					validAppts++;
				}
				if(test03Appt2.getValid()){
					validAppts++;
				}
				if(test03Appt3.getValid()){
					validAppts++;
				}
				test03CalDay.addAppt(test03Appt1);
				test03CalDay.addAppt(test03Appt2);
				test03CalDay.addAppt(test03Appt3);
				assertTrue("Valid appts added", test03CalDay.getSizeAppts() == validAppts);

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		 System.out.println("Done testing...");
	 }
}
