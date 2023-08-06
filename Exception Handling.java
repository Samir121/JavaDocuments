Exception Handling - Exception is an unwanted or unexpected event, which occurs during the execution 
of the program that disrupts the normal flow of the programs instructions.
Error - Problem which can't be handled are errors. Can't use try and catch.
Exception - Problem which can be handled with the help of try and catch.
- All the exception and errors are subclass of Throwable class.
Exception - Checked (Compile Time Exception)
                    - IO Exception
                    - SQL Exception
                    - FileNotFound Exception
                    - ClassNotFound Exception
          - Unchecked (Run Time Exception)
                    - Arithematic Exception
                    - NullPointer Exception
                    - ArrayOutOfBound Exception

Exceptions can be handled by five keywords - try, catch, throw, throws and finally.
eg-
public class Test{
    public static void main(){
        try{
            int divideByZero = 5/0;
            System.out.println(divideByZero);
        }
        catch(ArithmaticException e){
            System.out.println("Arithmatic Exception =>" + e.getMessage());
        }
    }
}

-> ArithmeticException => / by zero

- finally block will execute independent of try-catch block.
public class Test{
    public static void main(){
        try{
            int divideByZero = 5/0;
            System.out.println(divideByZero);
        }
        catch(ArithmaticException e){
            System.out.println("Arithmatic Exception =>" + e.getMessage());
        }
        finally{
            System.out.println("Finally block");
        }
    }
}
Output ->Arithematic Exception => /by zero.
         Finally block.
Finally is a good practice for important cleanup codes and closing the file or connection.

Java Throw and throws keyword
throw keyword is used to throw a single exception.
throws keyword is used to declare the type of exceptions that might occur within the method.
eg-
public class Main { 
    static void method(int x,int y) throws ArithmeticException{
        System.out.println("Inside method");
        throws new ArithmeticException();
    } 
    public static void main(String[] args){
        try{
            method(5,0);
        }
        catch(ArithmeticException e){
            System.out.println("Cant divide by zero");
        }
    } 
}
-> output - Inside Method
            Cant divide by zero.

// Java program that demonstrates the use of throw
class ThrowExcep
{
	static void fun()
	{
		try
		{
			throw new NullPointerException("demo");
		}
		catch(NullPointerException e)
		{
			System.out.println("Caught inside fun().");
			throw e; // rethrowing the exception
		}
	}

	public static void main(String args[])
	{
		try
		{
			fun();
		}
		catch(NullPointerException e)
		{
			System.out.println("Caught in main.");
		}
	}
}
->output = Caught inside fun().
           Caught in main.
