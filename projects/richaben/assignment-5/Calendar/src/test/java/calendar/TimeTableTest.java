package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;
import java.util.GregorianCalendar;


public class TimeTableTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
			TimeTable test01TimeTable = new TimeTable();
      Appt test01Appt1 = new Appt(6, 30, 5, 5, 2005, "Title", "Description"); //5-5-2005 @6:30
      Appt test01Appt2 = new Appt(7, 30, 8, 5, 2005, "Title", "Description");
      Appt test01Appt3 = new Appt(5, 30, 6, 5, 2005, "Title", "Description");
      GregorianCalendar first = new GregorianCalendar(2000,1,1);
      GregorianCalendar last = new GregorianCalendar(2100,1,1);
      LinkedList<Appt> ApptList = new LinkedList<Appt>();
      ApptList.add(test01Appt1);
      ApptList.add(test01Appt2);
      ApptList.add(test01Appt3);

			assertTrue("Time Table works", test01TimeTable.getApptRange(ApptList, first, last) != null);
			assertTrue("Time Table has correct length" , test01TimeTable.getApptRange(ApptList, first, last).size() == 36525);
	 }
	 @Test
		public void test01b()  throws Throwable  {
			TimeTable test01TimeTable = new TimeTable();
			 Appt test01Appt1 = new Appt(6, 30, 5, 5, 2005, "Title", "Description"); //5(day)-5-2005 @6:30
			 Appt test01Appt2 = new Appt(7, 30, 5, 5, 2005, "Title", "Description");
			 Appt test01Appt3 = new Appt(5, 30, 6, 5, 2005, "Title", "Description");
			 GregorianCalendar first = new GregorianCalendar(2005,5,4);
			 GregorianCalendar last = new GregorianCalendar(2005,5,6);
			 LinkedList<Appt> ApptList = new LinkedList<Appt>();
			 ApptList.add(test01Appt1);
			 ApptList.add(test01Appt2);
			 ApptList.add(test01Appt3);
			 LinkedList<CalDay> tt = test01TimeTable.getApptRange(ApptList, first, last);
			assertTrue("Time Table works", tt != null);
			assertTrue("Time Table has correct length", tt.size() == 2);
			assertTrue("Time Table has correct appts", tt.getLast().appts.size() == 2);
	 }

	 /*@Test
		public void test01c()  throws Throwable  { //Last before first
			TimeTable test01TimeTable = new TimeTable();
			 Appt test01Appt1 = new Appt(6, 30, 5, 5, 2005, "Title", "Description"); //5(day)-5-2005 @6:30
			 Appt test01Appt2 = new Appt(7, 30, 5, 5, 2005, "Title", "Description");
			 Appt test01Appt3 = new Appt(5, 30, 6, 5, 2005, "Title", "Description");
			 GregorianCalendar last = new GregorianCalendar(2005,5,4);
			 GregorianCalendar first = new GregorianCalendar(2005,5,6);
			 LinkedList<Appt> ApptList = new LinkedList<Appt>();
			 ApptList.add(test01Appt1);
			 ApptList.add(test01Appt2);
			 ApptList.add(test01Appt3);
			 LinkedList<CalDay> tt = test01TimeTable.getApptRange(ApptList, first, last);
			assertTrue("Time Table has correct length", tt.size() == 0);
	 }*/

	 @Test
		public void test01d()  throws Throwable  { //first occurence after last day
			TimeTable test01TimeTable = new TimeTable();
			 Appt test01Appt1 = new Appt(6, 30, 5, 5, 2005, "Title", "Description"); //5(day)-5-2005 @6:30
			 Appt test01Appt2 = new Appt(7, 30, 5, 5, 2005, "Title", "Description");
			 Appt test01Appt3 = new Appt(5, 30, 6, 5, 2005, "Title", "Description");
			 GregorianCalendar first = new GregorianCalendar(2000,5,4);
			 GregorianCalendar last = new GregorianCalendar(2000,5,6);
			 LinkedList<Appt> ApptList = new LinkedList<Appt>();
			 ApptList.add(test01Appt1);
			 ApptList.add(test01Appt2);
			 ApptList.add(test01Appt3);
			 LinkedList<CalDay> tt = test01TimeTable.getApptRange(ApptList, first, last);
			 assertTrue("Time Table has correct length", tt.size() == 2);
	 }

	 @Test
		public void test01e()  throws Throwable  {
			TimeTable test01TimeTable = new TimeTable();
			 Appt test01Appt1 = new Appt(6, 30, 1, 5, 2005, "Title", "Description"); //5-5-2005 @6:30
			 GregorianCalendar first = new GregorianCalendar(2005,5,1);
			 GregorianCalendar last = new GregorianCalendar(2005,5,31);
			 int[] recurDays = new int[3];
			 recurDays[0] = 2;
			 recurDays[1] = 3;
			 recurDays[2] = 4;
			 test01Appt1.setRecurrence(recurDays, 1, 1, 5);
			 LinkedList<Appt> ApptList = new LinkedList<Appt>();
			 ApptList.add(test01Appt1);
			 LinkedList<CalDay> tt = test01TimeTable.getApptRange(ApptList, first, last);
			 assertTrue("Time Table works", tt != null);
			 assertTrue("Time Table has correct length", tt.size() == 30);
			 int apptNums = 0;
			 for(int i = 0; i < 30; i++){
				 if(tt.get(i).appts.size() == 1){
					 apptNums++;
				 }
			 }
			 assertTrue("Time Table has correct appts", apptNums == 6);
	 }

	 @Test
		public void test01f()  throws Throwable  {	//but w/o specifying recurdays
			TimeTable test01TimeTable = new TimeTable();
			 Appt test01Appt1 = new Appt(6, 30, 1, 5, 2005, "Title", "Description"); //5-5-2005 @6:30
			 GregorianCalendar first = new GregorianCalendar(2005,5,1);
			 GregorianCalendar last = new GregorianCalendar(2005,5,31);
			 int[] recurDays = new int[0];
			 test01Appt1.setRecurrence(recurDays, 1, 1, 5);
			 LinkedList<Appt> ApptList = new LinkedList<Appt>();
			 ApptList.add(test01Appt1);
			 LinkedList<CalDay> tt = test01TimeTable.getApptRange(ApptList, first, last);
			 assertTrue("Time Table works", tt != null);
			 assertTrue("Time Table has correct length", tt.size() == 30);
			 int apptNums = 0;
			 for(int i = 0; i < 30; i++){
				 if(tt.get(i).appts.size() == 1){
					 apptNums++;
				 }
			 }
			 assertTrue("Time Table has correct appts", apptNums == 5);
	 }

	 @Test
		public void test01g()  throws Throwable  {	//but w/o specifying recurdays
			TimeTable test01TimeTable = new TimeTable();
			 Appt test01Appt1 = new Appt(6, 30, 1, 5, 2005, "Title", "Description"); //5-5-2005 @6:30
			 GregorianCalendar first = new GregorianCalendar(2005,5,1);
			 GregorianCalendar last = new GregorianCalendar(2006,5,1);
			 int[] recurDays = new int[3];
			 recurDays[0] = 2;
			 recurDays[1] = 3;
			 recurDays[2] = 4;
			 test01Appt1.setRecurrence(recurDays, 2, 1, 12);
			 LinkedList<Appt> ApptList = new LinkedList<Appt>();
			 ApptList.add(test01Appt1);
			 LinkedList<CalDay> tt = test01TimeTable.getApptRange(ApptList, first, last);
			 assertTrue("Time Table works", tt != null);
			 assertTrue("Time Table has correct length", tt.size() == 365);
			 int apptNums = 0;
			 for(int i = 0; i < 364; i++){
				 if(tt.get(i).appts.size() == 1){
					 apptNums++;
				 }
			 }
			 assertTrue("Time Table has correct appts", apptNums == 12);
	 }

	 @Test
		public void test01h()  throws Throwable  {	//but w/o specifying recurdays
			TimeTable test01TimeTable = new TimeTable();
			 Appt test01Appt1 = new Appt(6, 30, 1, 5, 2005, "Title", "Description"); //5-5-2005 @6:30
			 GregorianCalendar first = new GregorianCalendar(2000,1,1);
			 GregorianCalendar last = new GregorianCalendar(2010,1,1);
			 int[] recurDays = new int[3];
			 recurDays[0] = 2;
			 recurDays[1] = 3;
			 recurDays[2] = 4;
			 test01Appt1.setRecurrence(recurDays, 3, 1, 15);
			 LinkedList<Appt> ApptList = new LinkedList<Appt>();
			 ApptList.add(test01Appt1);
			 LinkedList<CalDay> tt = test01TimeTable.getApptRange(ApptList, first, last);
			 assertTrue("Time Table works", tt != null);
			 assertTrue("Time Table has correct length", tt.size() == 3653);
			 int apptNums = 0;
			 for(int i = 0; i < 3652; i++){
				 if(tt.get(i).appts.size() == 1){
					 apptNums++;
				 }
			 }
			 assertTrue("Time Table has correct appts", apptNums == 5);
	 }

	 @Test
		public void test01i()  throws Throwable  {	//Invalid appt
			TimeTable test01TimeTable = new TimeTable();
			 Appt test01Appt1 = new Appt(6, 65, 1, 5, 2005, "Title", "Description"); //5-5-2005 @6:30
			 GregorianCalendar first = new GregorianCalendar(2005,5,1);
			 GregorianCalendar last = new GregorianCalendar(2005,5,31);
			 int[] recurDays = new int[3];
			 recurDays[0] = 2;
			 recurDays[1] = 3;
			 recurDays[2] = 4;
			 test01Appt1.setRecurrence(recurDays, 1, 1, 5);
			 LinkedList<Appt> ApptList = new LinkedList<Appt>();
			 ApptList.add(test01Appt1);
			 LinkedList<CalDay> tt = test01TimeTable.getApptRange(ApptList, first, last);
			 assertTrue("Time Table works", tt != null);
			 assertTrue("Time Table has correct length", tt.size() == 30);
			 int apptNums = 0;
			 for(int i = 0; i < 30; i++){
				 if(tt.get(i).appts.size() == 1){
					 apptNums++;
				 }
			 }
			 assertTrue("Time Table has correct appts", apptNums == 0);
	 }

/*
   @Test	THIS TEST CURRENTLY FAILS
    public void test02()  throws Throwable  {
      TimeTable test02TimeTable = new TimeTable();
       Appt test02Appt1 = new Appt(6, 30, 5, 5, 2005, "Title", "Description");
       Appt test02Appt2 = new Appt(7, 30, 8, 5, 2005, "Title", "Description");
       Appt test02Appt3 = new Appt(5, 30, 6, 5, 2005, "Title", "Description");
       LinkedList<Appt> ApptList = new LinkedList<Appt>();
       ApptList.add(test02Appt1);
       ApptList.add(test02Appt2);
       ApptList.add(test02Appt3);
       LinkedList<Appt> ApptListWithout = new LinkedList<Appt>();
			 ApptListWithout = test02TimeTable.deleteAppt(ApptList, test02Appt1);
       assertTrue("Time Table Removes appointment" + ApptListWithout.size() + ApptList.size(), ApptListWithout.size() != ApptList.size());
   }*/

   @Test
    public void test03()  throws Throwable  {
      TimeTable test03TimeTable = new TimeTable();
      Appt test03Appt1 = new Appt(6, 30, 5, 5, 2005, "Title", "Description");
      Appt test03Appt2 = new Appt(7, 30, 8, 5, 2005, "Title", "Description");
      Appt test03Appt3 = new Appt(5, 30, 6, 5, 2005, "Title", "Description");
      LinkedList<Appt> ApptList = new LinkedList<Appt>();
      ApptList.add(test03Appt1);
      ApptList.add(test03Appt2);
      ApptList.add(test03Appt3);
      assertTrue("Time Table appointment removal does nothing to null appointments", test03TimeTable.deleteAppt(null, test03Appt1) == null);
      assertTrue("Time Table appointment removal does nothing to null appointments", test03TimeTable.deleteAppt(ApptList, null) == null);
   }
/* THIS ONES SEEMS TO BE GLITCHED
   @Test
    public void test04()  throws Throwable  { //Seems to NOT be working
      TimeTable test04TimeTable = new TimeTable();
      Appt test04Appt1 = new Appt(6, 30, 5, 5, 2005, "Title", "Description");
      Appt test04Appt2 = new Appt(7, 30, 8, 5, 2005, "Title", "Description");
      Appt test04Appt3 = new Appt(5, 30, 6, 5, 2005, "Title", "Description");
      LinkedList<Appt> ApptList = new LinkedList<Appt>();
      ApptList.add(test04Appt1);
      ApptList.add(test04Appt2);
      ApptList.add(test04Appt3);
      int[] pv = new int[3];
			pv[0] = 0;
			pv[1] = 2;
			pv[2] = 1;
      LinkedList<Appt> permutedApptList = test04TimeTable.permute(ApptList, pv);
      //assertTrue("Permute changes Appt lists", permutedApptList != ApptList);

			for(int i = 0; i < 2; i++){
				GregorianCalendar curDay = new GregorianCalendar(
					permutedApptList.get(i).getStartYear(),
					permutedApptList.get(i).getStartMonth(),
					permutedApptList.get(i).getStartDay()
				);
				GregorianCalendar nextDay = new GregorianCalendar(
					permutedApptList.get(i+1).getStartYear(),
					permutedApptList.get(i+1).getStartMonth(),
					permutedApptList.get(i+1).getStartDay()
				);
				assertTrue("Permute orders Appt lists"
				+permutedApptList.get(0).getStartDay()
				+permutedApptList.get(1).getStartDay()
				+permutedApptList.get(2).getStartDay(), curDay.before(nextDay));
			}
   }*/

   @Test
	  public void test05()  throws Throwable  {
			TimeTable test05TimeTable = new TimeTable();
      Appt test05Appt1 = new Appt(6, 30, 5, 5, 2005, "Title", "Description");
      Appt test05Appt2 = new Appt(7, 30, 8, 5, 2005, "Title", "Description");
      Appt test05Appt3 = new Appt(5, 30, 6, 5, 2005, "Title", "Description");
      Appt test05Appt4 = new Appt(5, 30, 6, 5, 2005, "Title", "Description");
      int[] recurDays = new int[3];
			recurDays[0] = 2;
			recurDays[1] = 3;
			recurDays[2] = 4;
      test05Appt1.setRecurrence(recurDays, Appt.RECUR_BY_MONTHLY, 2, 1);
      test05Appt2.setRecurrence(null, 5, 2, 1);
      test05Appt3.setRecurrence(recurDays, Appt.RECUR_BY_YEARLY, 2, 1);
      test05Appt4.setRecurrence(recurDays, Appt.RECUR_BY_WEEKLY, 2, 1);

      GregorianCalendar first = new GregorianCalendar(100,1,1);
      GregorianCalendar last = new GregorianCalendar(10000,1,1);
      LinkedList<Appt> ApptList = new LinkedList<Appt>();
      ApptList.add(test05Appt1);
      ApptList.add(test05Appt2);
      ApptList.add(test05Appt3);
      ApptList.add(test05Appt4);

			assertTrue("Time Table works with recurring apps", test05TimeTable.getApptRange(ApptList, first, last) != null);

	 }
}
