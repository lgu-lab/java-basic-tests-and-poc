package org.demo.java7.closeable.usage;

import java.io.IOException;

import org.demo.java7.closeable.resources.MyResource1;
import org.demo.java7.closeable.resources.MyResource2;
import org.demo.java7.closeable.resources.MyResource3;

public class Example1 {

	public static void main(String[] args) {


		//----------------------------------------------------------------
		// Closable resource : catch Exception or IOException
		//----------------------------------------------------------------
		try ( MyResource1 res = new MyResource1() ) { // try-with-resources
			
		}         
		catch(Exception e) {
            System.out.println("From Exception Block");
        } 
		
		try ( MyResource1 res = new MyResource1() ) { // try-with-resources
			
		}         
		catch(IOException e) {
            System.out.println("From Exception Block");
        } 
		
		//----------------------------------------------------------------
		// AutoClosable resource : catch Exception (only) 
		//----------------------------------------------------------------
		try ( MyResource2 res = new MyResource2() ) { // try-with-resources
			
		}         
		catch(Exception e) {
            System.out.println("Exception catched");
        } 
		
		//----------------------------------------------------------------
		// MyClosable resource : no Exception
		//----------------------------------------------------------------
		try ( MyResource3 x = new MyResource3() ) { // try-with-resources
			
		}         
		
		try ( MyResource3 x = new MyResource3() ) {  // try-with-resources
			  
		}         

	}

}
