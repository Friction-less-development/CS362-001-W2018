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
      Appt test01Appt1 = new Appt(6, 30, 5, 5, 2005, "Title", "Description");
      Appt test01Appt2 = new Appt(7, 30, 8, 5, 2005, "Title", "Description");
      Appt test01Appt3 = new Appt(5, 30, 6, 5, 2005, "Title", "Description");
      GregorianCalendar first = new GregorianCalendar(100,1,1);
      GregorianCalendar last = new GregorianCalendar(10000,1,1);
      LinkedList<Appt> ApptList = new LinkedList<Appt>();
      ApptList.add(test01Appt1);
      ApptList.add(test01Appt2);
      ApptList.add(test01Appt3);

			assertTrue("Time Table works", test01TimeTable.getApptRange(ApptList, first, last) != null);

	 }

   @Test
    public void test02()  throws Throwable  {
      TimeTable test02TimeTable = new TimeTable();
       Appt test02Appt1 = new Appt(6, 30, 5, 5, 2005, "Title", "Description");
       Appt test02Appt2 = new Appt(7, 30, 8, 5, 2005, "Title", "Description");
       Appt test02Appt3 = new Appt(5, 30, 6, 5, 2005, "Title", "Description");
       LinkedList<Appt> ApptList = new LinkedList<Appt>();
       ApptList.add(test02Appt1);
       ApptList.add(test02Appt2);
       ApptList.add(test02Appt3);
       LinkedList<Appt> ApptListWithout = test02TimeTable.deleteAppt(ApptList, test02Appt1);
       assertTrue("Time Table Removes appointment", ApptListWithout != ApptList);
   }

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

   @Test
    public void test04()  throws Throwable  {
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
			pv[1] = 1;
			pv[2] = 2;
      LinkedList<Appt> permutedApptList = test04TimeTable.permute(ApptList, pv);
      assertTrue("Permute changes Appt lists", permutedApptList != ApptList);
   }

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
