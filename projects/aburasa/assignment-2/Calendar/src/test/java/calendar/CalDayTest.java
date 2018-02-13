package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.GregorianCalendar;

public class CalDayTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
			int year = 1994;
			int month = 1;
			int day = 12;
			GregorianCalendar today = new GregorianCalendar(year,month,day);
			CalDay test01CalDay = new CalDay(today);
			assertTrue("Cal Day is valid", test01CalDay.isValid() == true);
			assertTrue("Cal Day has correct day", test01CalDay.getDay() == day);
			assertTrue("Cal Day has correct month", test01CalDay.getMonth() == month);
			assertTrue("Cal Day has correct year", test01CalDay.getYear() == year);
			assertTrue("Running String Builder", test01CalDay.toString() != null);

	 }

   @Test
	 public void test02()  throws Throwable  {
		 CalDay test02CalDay = new CalDay();

		 int year = 1994;
		 int month = 1;
		 int day = 12;
		 GregorianCalendar today = new GregorianCalendar(year,month,day);
		 CalDay test02CalDay2 = new CalDay(today);

		 assertTrue("Empty Cal Day is not valid", test02CalDay.isValid() == false);
		 assertTrue("Empty Cal Day has no appts", test02CalDay.iterator() == null);
		 assertTrue("Empty Cal Day toString has empty string", test02CalDay.toString() != test02CalDay2.toString());
	 }

	@Test
	 public void test03()  throws Throwable  {
		 int year = 1994;
		 int month = 1;
		 int day = 12;
		 GregorianCalendar today = new GregorianCalendar(year,month,day);
		 CalDay test03CalDay = new CalDay(today);
		 Appt test03Appt1 = new Appt(6, 30, day, month, year, "Title", "Description");
		 Appt test03Appt2 = new Appt(7, 30, day, month, year, "Title", "Description");
		 Appt test03Appt3 = new Appt(5, 30, day, month, year, "Title", "Description");
		 test03CalDay.addAppt(test03Appt1);
		 test03CalDay.addAppt(test03Appt2);
		 test03CalDay.addAppt(test03Appt3);
		 assertTrue("Appts added", test03CalDay.getAppts().get(0).getStartDay() == day);
		 assertTrue("Appts added", test03CalDay.iterator() != null);
		 assertTrue("Appts added", test03CalDay.toString() != null);
		 assertTrue("Appts added", test03CalDay.getSizeAppts() == 3);
		 Appt test03Appt4 = new Appt(5, 30, 50, month, year, "Title", "Description");
		 test03CalDay.addAppt(test03Appt4);
		 assertTrue("Invalid Appt not added", test03CalDay.getSizeAppts() == 3);

	 }

}
