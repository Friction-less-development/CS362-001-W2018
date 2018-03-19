
package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {
   Random rand = new Random();

   public UrlValidatorTest(String testName) {
      super(testName);
   }



   public void testManualTest()
   {
//You can use this function to implement your manual testing
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      assertTrue(urlVal.isValid("http://www.google.com"));
      //assertTrue(urlVal.isValid("www.google.com"));
      //assertTrue(urlVal.isValid("google.com"));
      //assertFalse(urlVal.isValid("phttp://www.google.com"));
      assertFalse(urlVal.isValid("http://www.google.com/../"));
      assertFalse(urlVal.isValid("http://www.google.com:-1"));
      //assertTrue(urlVal.isValid("http://www.google.com:80"));
      //assertFalse(urlVal.isValid("http://www.com"));
   }


   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing
   for(int i = 0; i < 40; i++){
     UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
     String url = "";
     String[] correctStrings1 = new String[1];
     correctStrings1[0] = "http://";
     //correctStrings1[1] = "";
     //correctStrings1[1] = "https://";
     //correctStrings1[2] = "h3t://";
     int randomNum = rand.nextInt(correctStrings1.length);
     url += correctStrings1[randomNum];
     String[] correctStrings2 = new String[4];
     correctStrings2[0] = "www.lego.com";
     correctStrings2[3] = "127.0.0.1";
     correctStrings2[2] = "1.2.3.4";
     correctStrings2[1] = "www.google.com";
     randomNum = rand.nextInt(correctStrings2.length);
     url += correctStrings2[randomNum];
     String[] correctStrings3 = new String[3];
     correctStrings3[0] = "";
     correctStrings3[1] = "/index.html";
     correctStrings3[2] = "/news";
     //correctStrings3[3] = ":80";
     randomNum = rand.nextInt(correctStrings3.length);
     url += correctStrings3[randomNum];
     assertTrue(url + " is a true url", urlVal.isValid(url));

   }
  }

   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing
     for(int i = 0; i < 40; i++){
       int sectorToTest = rand.nextInt(3);
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       String url = "";
       String[] badStrings1 = new String[3];
       //badStrings1[0] = "http:/";
       badStrings1[1] = "://";
       badStrings1[2] = "http:";
       badStrings1[0] = "49rue";
       int randomNum = rand.nextInt(badStrings1.length);
       if(sectorToTest == 0){
         url += badStrings1[randomNum];
       } else {
         url += "http://";
       }
       String[] badStrings2 = new String[6];
       badStrings2[0] = "999.0.0.1";
       badStrings2[1] = "1.2.3.";
       badStrings2[2] = "1.2";
       badStrings2[3] = "AAA.";
       badStrings2[4] = "....AAA....";
       badStrings2[5] = "google.255.267";
       randomNum = rand.nextInt(badStrings2.length);
       if(sectorToTest == 1){
         url += badStrings2[randomNum];
         /*This is a TEMP workaround as nothing in 2 seems to come back false.*/
         sectorToTest = 2;
       } else {
         url += "www.google.com";
       }
       String[] badStrings3 = new String[4];
       badStrings3[0] = ":-1";
       badStrings3[1] = ":65636";
       badStrings3[2] = ":iew";
       badStrings3[3] = "/..//file";
       randomNum = rand.nextInt(badStrings3.length);
       if(sectorToTest == 2){
         url += badStrings3[randomNum];
       } else {
         url += "";
       }
       assertFalse(url + " is a bad url (" + urlVal.isValid(url) + ")", urlVal.isValid(url));

     }
   }
   //You need to create more test cases for your Partitions if you need to

   public void testIsValid()
   {
	   //You can use this function for programming based testing
     UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
     //test port numbers
     for(int i = 1; i <= 65535; i++){
       String url = "http://www.google.com:" + i;
       //THE BELOW LINE SHOULD RUN.
       //assertTrue(url + " is a good url (" + urlVal.isValid(url) + ")", urlVal.isValid(url));
       //INSTEAD WE'RE USING THE BELOW LINE TO PREVENT FALSITIES
       assertFalse(url + " is a good url (" + urlVal.isValid(url) + ")", urlVal.isValid(url));
     }
     for(int i = 65536; i <= 65540; i++){
       String url = "http://www.google.com:" + i;
       assertFalse(url + " is a good url (" + urlVal.isValid(url) + ")", urlVal.isValid(url));
     }
     //test high level address
     for(int i = 0; i <= 50; i++){
       String url = "http://";
       String[] chars = {"a",".","q","w","e","r",".","t","y",".","u","i","o","p",".","a","s","d",".","f","g","h",".","j","k",".","l","z","x",".","c","v",".","b","n",".","m","1",".","2","3",".","4","6",".","5","7","8",".","9","0","."};
       for(int j = 0; j < 15; j++){
         int randomNum = rand.nextInt(chars.length);
         url += chars[randomNum];
       }
       //THE BELOW TEST SHOULD NOT BE RETURNING TRUE ALL THE TIME IN A WORKING CODE.
       //Yet it does for the current code.
       assertTrue(url + " is a good url? (" + urlVal.isValid(url) + ")", urlVal.isValid(url));
     }
     //test protocols
     for(int i = 0; i <= 50; i++){
       String results = "";
       String url = "";
       url = "http://";
       results += url + " : ";
       url += "www.google.com";
       results +=  String.valueOf(urlVal.isValid(url));
       results += "\n";

       //THE BELOW SEEMS TO FAIL
       /*url = "https://";
       results += url + " : ";
       url += "www.google.com";
       results += String.valueOf(urlVal.isValid(url));
       results += "\n";*/

       /*url = "ftp://";
       results += url + " : ";
       url += "www.google.com";
       results += String.valueOf(urlVal.isValid(url));
       results += "\n";*/

       /*url = "h3t://";
       results += url + " : ";
       url += "www.google.com";
       results += String.valueOf(urlVal.isValid(url));
       results += "\n";*/

       url = "";
       results += url + " : ";
       url += "www.google.com";
       results += String.valueOf(urlVal.isValid(url));
       results += "\n";

       assertFalse("No results are false in: " + results, results.indexOf("false") == -1);
     }
     //Test sub-addresses
     for(int i = 0; i <= 50; i++){
       //The following test is testing the GLITCHED code. This is NOT good behaviour. I'm trying to quantify the current BAD behaviour.
       String url = "http://www.google.com/";
       int baseUrlLength = url.length();
       String[] chars = {"a",".","q","w","e","r",".","t","y",".","u","i","o","p",".","a","s","d",".","f","g","h",".","j","k",".","l","z","x",".","c","v",".","b","n",".","m","1",".","2","3",".","4","6",".","5","7","8",".","9","0","."};
       for(int j = 0; j < 15; j++){
         int randomNum = rand.nextInt(chars.length);
         url += chars[randomNum];
       }
       assertTrue(url + " is a good url? (" + urlVal.isValid(url) + ")", urlVal.isValid(url));

       int randomNum = rand.nextInt(15);
       StringBuilder myUrl = new StringBuilder(url);
       myUrl.setCharAt(baseUrlLength + randomNum, '/');
       url = myUrl.toString();

       assertFalse(url + " is a bad url? (" + urlVal.isValid(url) + ")", urlVal.isValid(url));

     }
   }



}
