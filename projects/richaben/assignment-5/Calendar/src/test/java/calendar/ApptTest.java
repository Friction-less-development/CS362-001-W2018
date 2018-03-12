package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
			Appt test01Appt = new Appt(6, 30, 5, 5, 2025, "Title", "Description");
			assertTrue("Title is set", test01Appt.getTitle() == "Title");
			assertTrue("Description is set", test01Appt.getDescription() == "Description");
			assertTrue("Is valid", test01Appt.getValid() == true);
			assertTrue("Year is set", test01Appt.getStartYear() == 2025);
			assertTrue("Month is set", test01Appt.getStartMonth() == 5);
			assertTrue("Day is set", test01Appt.getStartDay() == 5);
			assertTrue("Minute is set", test01Appt.getStartMinute() == 30);
			assertTrue("Hour is set", test01Appt.getStartHour() == 6);
			assertTrue("Default recurrence is set", test01Appt.getRecurBy() == 2 && !test01Appt.isRecurring());
	 }

	 @Test
		public void test01b()  throws Throwable  {
			Appt test01Appt = new Appt(25, 30, 5, 5, 2025, "Title", "Description");
			assertTrue("Testing invalid setups", test01Appt.getValid() == false);
			test01Appt = new Appt(22, -30, 5, 5, 2025, "Title", "Description");
			assertTrue("Testing invalid setups", test01Appt.getValid() == false);
			test01Appt = new Appt(22, 70, 5, 5, 2025, "Title", "Description");
			assertTrue("Testing invalid setups", test01Appt.getValid() == false);
	 }

	 @Test
	  public void test02()  throws Throwable  {
			Appt test02Appt = new Appt(6, 30, 5, 5, 2025, "Title", "Description");
			assertTrue("Is valid", test02Appt.getValid() == true);
			test02Appt.setStartHour(50);
			assertTrue("Is not valid after setting bad hour", test02Appt.getValid() == false);
			test02Appt.setStartHour(-5);
			assertTrue("Is not valid after setting bad hour", test02Appt.getValid() == false);
	 }

	 @Test
		public void test03()  throws Throwable  {
			Appt test03Appt = new Appt(6, 30, 5, 5, 2025, "Title", "Description");
			assertTrue("Is valid", test03Appt.getValid() == true);
			test03Appt.setStartMinute(-5);
			assertTrue("Is not valid after setting bad minute", test03Appt.getValid() == false);
			test03Appt.setStartMinute(100);
			assertTrue("Is not valid after setting bad minute", test03Appt.getValid() == false);
	 }

	 @Test
		public void test04()  throws Throwable  {
			Appt test04Appt = new Appt(6, 30, 5, 5, 2025, "Title", "Description");
			assertTrue("Is valid", test04Appt.getValid() == true);
			test04Appt.setStartDay(50);
			assertTrue("Is not valid after setting bad day", test04Appt.getValid() == false);
			test04Appt.setStartDay(-50);
			assertTrue("Is not valid after setting bad day", test04Appt.getValid() == false);
	 }

	 @Test
		public void test05()  throws Throwable  {
			Appt test05Appt = new Appt(6, 30, 5, 5, 2025, "Title", "Description");
			assertTrue("Is valid", test05Appt.getValid() == true);
			test05Appt.setStartMonth(1);
			assertTrue("Month has been changed", test05Appt.getStartMonth() == 1);
			assertTrue("Is valid", test05Appt.getValid() == true);
	 }

	 @Test
		public void test06()  throws Throwable  {
			Appt test06Appt = new Appt(6, 30, 5, 5, 2025, "Title", "Description");
			assertTrue("Is valid", test06Appt.getValid() == true);
			test06Appt.setStartYear(1950);
			assertTrue("Year has been changed", test06Appt.getStartYear() == 1950);
			assertTrue("Is valid", test06Appt.getValid() == true);
	 }

	 @Test
		public void test07()  throws Throwable  {
			Appt test07Appt = new Appt(6, 30, 5, 5, 2025, "Title", "Description");
			assertTrue("Is valid", test07Appt.getValid() == true);
			test07Appt.setTitle("New Title");
			assertTrue("Title has been changed", test07Appt.getTitle() == "New Title");
	 }

	 @Test
		public void test08()  throws Throwable  {
			Appt test08Appt = new Appt(6, 30, 5, 5, 2025, "Title", "Description");
			assertTrue("Is valid", test08Appt.getValid() == true);
			test08Appt.setDescription("New Description");
			assertTrue("Description has been changed", test08Appt.getDescription() == "New Description");
	 }

	 @Test
		public void test09()  throws Throwable  {
			Appt test09Appt = new Appt(6, 30, 31, 5, 2025, "Title", "Description");
			assertTrue("Is not null", test09Appt.toString() != null);
			test09Appt.setStartDay(50);
			assertTrue("Is null", test09Appt.toString() == null);
			test09Appt.setStartDay(5);
			test09Appt.setStartHour(18);
			assertTrue("Is not null", test09Appt.toString() != null);
	 }

	 @Test
		public void test10()  throws Throwable  {
			Appt test10Appt = new Appt(6, 30, 5, 5, 2025, "Title", "Description");
			Appt test10Appt2 = new Appt(6, 30, 5, 5, 2025, "Title", "Description");
			assertTrue("2 Appts have the same compareTo", test10Appt.compareTo(test10Appt2) == 0);
			Appt test10Appt3 = new Appt(6, 35, 5, 5, 2025, "Title", "Description");
			Appt test10Appt4 = new Appt(6, 30, 5, 5, 2025, "Title", "Description");
			assertTrue("2 different Appts have different compareTo", test10Appt3.compareTo(test10Appt4) > 0);
	 }

	 @Test
		public void test11()  throws Throwable  {
			Appt test11Appt = new Appt(6, 30, 5, 5, 2025, "Title", "Description");
			int[] recurDays = new int[3];
			recurDays[0] = 2;
			recurDays[1] = 3;
			recurDays[2] = 4;
			test11Appt.setRecurrence(recurDays, 5, 2, 1);
			assertTrue("Checking recurrence is set up", test11Appt.getRecurNumber() == 1);
			assertTrue("Checking recurrence is set up", test11Appt.getRecurBy() == 5);
			assertTrue("Checking recurrence is set up", test11Appt.getRecurDays() == recurDays);
			assertTrue("Checking recurrence is set up", test11Appt.getRecurIncrement() == 2);
			assertTrue("Checking recurrence is set up", test11Appt.isRecurring() == true);
	 }
	 @Test
		public void test12()  throws Throwable  {
			Appt test12Appt = new Appt(6, 30, 5, 5, 2025, "Title", "Description");
			int[] recurDays = null;
			test12Appt.setRecurrence(recurDays, 5, 2, 1);
			assertTrue("Checking recurrence is set up", test12Appt.getRecurNumber() == 1);
			assertTrue("Checking recurrence is set up", test12Appt.getRecurBy() == 5);
			assertTrue("Checking recurrence is set up", test12Appt.getRecurDays() != null);
			assertTrue("Checking recurrence is set up", test12Appt.getRecurIncrement() == 2);
			assertTrue("Checking recurrence is set up", test12Appt.isRecurring() == true);
	 }
}
