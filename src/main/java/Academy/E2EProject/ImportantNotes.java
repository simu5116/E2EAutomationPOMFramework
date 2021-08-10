package Academy.E2EProject;

public class ImportantNotes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * How we had achieved encapsulation in our project
		 * 
		 * If u make any variable private,then only that class can use that variable/method
		 * another class even though it extends it cannot use it
		 * Encapsulation
		 * 
		 *basically by declaring variables private and methods public we are hiding the implementation
		// and showing only the functionality
		 * 
		 * we can convert POM objects to private and  POM methods to public
		 */
		
		//==================================================
		/*
		 * How inheritance is achieved in our framework
		 * 1.HomePage class is extending base class as it contains the driver initialization part and properties
		 * file from where url is fetched.
		 */

		/*
		 * How we are using interface in our framework
		 * 
		 * 1. WebDriver is an interface,so that we are using.
		 * 2.In Listeners.java we are implementing ITListeners
		 *
		 */
		
		/*
		 * Can driver be static or non static 
		 * 
		 * Yes driver can be static 
		 * advantages of static driver
		 * --->Suppose we have 100 testcases all will call initialize driver ,means 100 times 
		 * driver object will be created in heap memeory
		 * so if we use static then only one time the driver object is created ,it saves a lot a lot 
		 * of memory. That driver object will run all the test cases
		 * 
		 * Disadvantages
		 * 
		 * If driver is static then parallel execution is not possible
		 * because one testcase initialize driver will override another testcase initialize driver
		 * 
		 * 
		 * But in our framework even if its static ,parallel execution is possible as we have created 
		 * a local webdriver variable in our java files ,so it will not fail 
		 * 
		 * 
		 * Answer
		 * If u are running your tests sequentially then you can use static keyword is advantageous 
		 * to have less memeory in your heapspace
		 * 
		 * But if you are running in parallel,you will run into null pointer exception
		 */
	}

}
