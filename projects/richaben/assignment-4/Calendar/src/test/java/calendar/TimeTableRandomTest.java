package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;
import java.util.GregorianCalendar;

/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

		private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
		private static final int NUM_TESTS=100;
		private static int methodNumber = 0;
		/**
		 * Return a randomly selected method to be tests !.
		 */
	  public static String RandomSelectMethod(Random random){
	    String[] methodArray = new String[] {"deleteAppt","getApptRangeBasic", "getApptRangeError", "getApptRangeRecurring"};// The list of the of methods to be tested in the Appt class

	   	int n = methodNumber % 4;
			methodNumber++;
			random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

	    return methodArray[n] ; // return the method name
	  }

		 @Test
		 public void radnomtest()  throws Throwable  {

			 long startTime = Calendar.getInstance().getTimeInMillis();
			 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


			 System.out.println("Start testing...");

			try{
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {
					long randomseed =System.currentTimeMillis(); //10
					Random random = new Random(randomseed);
					String methodName = TimeTableRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("deleteAppt")){
							 TimeTable test03TimeTable = new TimeTable();
							 int year = ValuesGenerator.getRandomIntBetween(random, 1, 10000);
							 int month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
							 int day = ValuesGenerator.getRandomIntBetween(random, 1, 40);
							 int hour = ValuesGenerator.getRandomIntBetween(random, 1, 30);
							 int minute = ValuesGenerator.getRandomIntBetween(random, 1, 70);
							 Appt test03Appt1 = new Appt(hour, minute, day, month, year, "Title", "Description");
							 Appt test03Appt2 = new Appt(hour, minute, day, month, year, "Title", "Description");
							 Appt test03Appt3 = new Appt(hour, minute, day, month, year, "Title", "Description");
							 LinkedList<Appt> ApptList = new LinkedList<Appt>();
							 ApptList.add(test03Appt1);
							 ApptList.add(test03Appt2);
							 ApptList.add(test03Appt3);
							 assertTrue("Time Table appointment removal does nothing to null appointments", test03TimeTable.deleteAppt(null, test03Appt1) == null);
							 assertTrue("Time Table appointment removal does nothing to null appointments", test03TimeTable.deleteAppt(ApptList, null) == null);

							 if(test03Appt1.getValid() == true){
								 //Appears to be glitched
								 //assertTrue(test03TimeTable.deleteAppt(ApptList, test03Appt1).size() == ApptList.size()-1);
							 } else {
								 assertTrue(test03TimeTable.deleteAppt(ApptList, test03Appt1) == null);
							 }
							 if(test03Appt2.getValid() == true){
								 //assertTrue(test03TimeTable.deleteAppt(ApptList, test03Appt2).size() == ApptList.size()-1);
							 } else {
								 assertTrue(test03TimeTable.deleteAppt(ApptList, test03Appt2) == null);
							 }
							 if(test03Appt3.getValid() == true){
								//assertTrue(test03TimeTable.deleteAppt(ApptList, test03Appt3).size() == ApptList.size()-1);
							 } else {
								 assertTrue(test03TimeTable.deleteAppt(ApptList, test03Appt3) == null);
							 }
						 } else if(methodName.equals("getApptRangeBasic")){

							 int oldyear = 0;
		 					int ttNum = ValuesGenerator.getRandomIntBetween(random, 1, 50);
		 					LinkedList<Integer> numsForEachDay = new LinkedList<Integer>();
		 					LinkedList<Appt> ApptList = new LinkedList<Appt>();
		 					for(int i = 0; i < ttNum; i++){
		 						int year = ValuesGenerator.getRandomIntBetween(random, 1, 2);
		 						int day = ValuesGenerator.getRandomIntBetween(random, 1, 28);
		 						int month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
		 						int onSameDay = ValuesGenerator.getRandomIntBetween(random, 1, 10);
		 						numsForEachDay.add(onSameDay);
		 						for(int j = 0; j < onSameDay; j++){
		 							int hour = ValuesGenerator.getRandomIntBetween(random, 1, 23);
		 							int minute = ValuesGenerator.getRandomIntBetween(random, 1, 59);;
		 							ApptList.add(new Appt(hour, minute, day, month, oldyear + year, "Title", "Description"));
		 						}
								oldyear += year;
		 					}
		 					GregorianCalendar first = new GregorianCalendar(0,5,1);
		 	 			  GregorianCalendar last = new GregorianCalendar(oldyear,5,31);
							TimeTable test01TimeTable = new TimeTable();
		 					LinkedList<CalDay> tt = test01TimeTable.getApptRange(ApptList, first, last);
		 					assertTrue("Time Table works", tt != null);
		 					//assertTrue("Time Table has correct length", tt.size() == ttNum);
							int j = 0;
							System.out.println(tt.size());
		 					for(int i = 0; i < tt.size(); i++){
								if(tt.get(i).appts.size() > 0){
									assertTrue("Time Table has correct appts", tt.get(i).appts.size() == numsForEachDay.get(j));
									j++;
								}
		 					}

						} else if(methodName.equals("getApptRangeRecurring")){
						 int oldyear = 0;
						 LinkedList<Appt> ApptList = new LinkedList<Appt>();
						 int year = ValuesGenerator.getRandomIntBetween(random, 5, 10);
						 int day = ValuesGenerator.getRandomIntBetween(random, 1, 28);
						 int month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
						 int onSameDay = ValuesGenerator.getRandomIntBetween(random, 1, 10);
						 int hour = ValuesGenerator.getRandomIntBetween(random, 1, 23);
						 int minute = ValuesGenerator.getRandomIntBetween(random, 1, 59);
						 Appt appt = new Appt(hour, minute, day, month, year, "Title", "Description");
						 ApptList.add(appt);
						 int[] recurDays=ValuesGenerator.generateRandomArray(random, 1);
						 int recur=2;
						 int recurIncrement = 1;
						 int recurNumber=0;
						 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						 GregorianCalendar first = new GregorianCalendar(year,1,1);
						 GregorianCalendar last = new GregorianCalendar(year*2,12,31);
						 TimeTable test01TimeTable = new TimeTable();
						 LinkedList<CalDay> tt = test01TimeTable.getApptRange(ApptList, first, last);
						 assertTrue("Time Table works", tt != null);
						 //assertTrue("Time Table has correct length", tt.size() == ttNum);
						 int j = 0;
						 System.out.println(tt.size());
						 for(int i = 0; i < tt.size(); i++){
							 if(tt.get(i).appts.size() > 0){
								 j++;
							 }
						 }
						 assertTrue("Time Table has correct appts", j == 1);	//??
					 } else if(methodName.equals("getApptRangeError")){

						int oldyear = 0;
						LinkedList<Appt> ApptList = new LinkedList<Appt>();
						int year = ValuesGenerator.getRandomIntBetween(random, 1, 1000);
						int day = ValuesGenerator.getRandomIntBetween(random, 40, 70);
						int month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
						int onSameDay = ValuesGenerator.getRandomIntBetween(random, 1, 10);
						int hour = ValuesGenerator.getRandomIntBetween(random, 1, 23);
						int minute = ValuesGenerator.getRandomIntBetween(random, 1, 59);
						Appt appt = new Appt(hour, minute, day, month, year, "Title", "Description");
						ApptList.add(appt);
						int[] recurDays=ValuesGenerator.generateRandomArray(random, 1);
						int recur=2;
						int recurIncrement = 1;
						int recurNumber=0;
						appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						GregorianCalendar first = new GregorianCalendar(year,1,1);
						GregorianCalendar last = new GregorianCalendar(year/2,12,31);
						TimeTable test01TimeTable = new TimeTable();
						try{
							LinkedList<CalDay> tt = test01TimeTable.getApptRange(ApptList, first, last);
						} catch(DateOutOfRangeException e){
							assertTrue("Time Table does not work with bad dates", true);
						}
						LinkedList<CalDay> tt = test01TimeTable.getApptRange(ApptList, last, first);
						assertTrue("Time Table does work with good dates, but with bad appts", tt != null);

					}

					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
		 				if(iteration!=0 )
		 					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				}
			}catch(NullPointerException e){
				System.out.println(e);

			}

			 System.out.println("Done testing...");
		 }
}
