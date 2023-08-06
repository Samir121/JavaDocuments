Java Revision Sheet

Static Keyword - To call a method directly from the class name(without creating an instance of a class), static keyword is used.
               - We cannot use non-static keyword inside a static method.

Why non-static variables doesn't work with static method?
class A{
    int num1;
    static int num2;
    public static void increment(){
        num1++;
    }
}
public class Demo{
    public static void main(){
        A.num2=5;
        A obj1 = new A();
        A obj2 = new A();
        A obj3 = new A();
        A.increment();              //Ambiguity arrires as we don't know, this will increment which object value.
    }
}

If we want to count the occurance of object of class.
class A{
    static int count;
    public A(){
        count++;
    }
    public void counter(){
        System.out.println("Total: " + count);
    }
    public static void main(){
        A obj1 = new A();
        A obj2 = new A();
        A obj3 = new A();
        obj3.counter();
    }
}

Static block will be executed when class is loaded in jvm(java virtual machine). Which will called before main method.
Use to assign any variable which is used in main function.
JVM is the one which calls the main method present in class, acts as run time engine to run Java Applications.
- static(){                                         //this will be called before main method
    System.out.println("Hello");
  }

super()  - used to call the constructor of super class. In the inherited class super() is hidden in the constructor call.
class A extends Object{
    public A(){
        System.out.ln("In const A");
    }
}  

class A{
    public void abc(){
        System.out.println("Printing parent class abc");
    }
}
class Main extends A{
    public void abc(){
        super.abc();
        System.out.println("Printing inherited class abc");
    }
    public static void main(String[] args){
        Main b = new Main();
        b.abc();
    }
}

Final - Final variable once gets assigned, it wont be changed.
      - If we dont assign it at declartion, it can be  assigned later but once assigned will not change.
      - We cant override a method which is final.
      - If you make a class as final no other class can extend that final class.

Anonymous Object - When we have to object only once then use anonymous object, otherwise always use reference object.
eg - new A().k = 29;
     new A().show();

Stack Memory - It allocates or de-allocates the memory automatically as soon as the coressponding method completes its execution.
             - Temporary memory allocation schema where the data members are accessible only if the method that contained them is currently running.
             - Data stored in this memory is accessible or visible to all the threads. So, are not thread safe.
             - Memory allocation and de-allocation is faster as compared to stack memory.
             - Stack memory has less space as compared to heap memory.
             - eg- int main(){
                       int a;
                       int b[10];
                       int n = 20;
                       int c[n];
                    }

Heap Memory - No automatic de-allocation feature is provided. We need to use a garbage collector to remove the old unused objects in
              order to use the memory efficiently. 
            - The processing time(accessing time) of this memory is quite slow as compared to the stack memory. 
            - Not thread-safe because data stored in heap memory is visible to all threads.
            - eg- int *ptr = new int[10];

Abstraction - Used to hide method implementation. 
            - If we abstract method in a class, then class should also be abstarct.
            - Abstract methods are not defined they are declared.
public class Demo{
    public static void main(String[] args){
        MaheshPhone obj = new SureshPhone();
        obj.call();
        obj.cook();
        obj.dance();
        obj.move();
    }
}
abstract class MaheshPhone{
    public void call(){
        Sout("Calling");
    }
    public abstract void move();
    public abstract void dance();
    public abstract void cook();
}
abstract class RameshPhone extends MaheshPhone{
    public void move(){
        Sout("Moving");
    }
}
class SureshPhone extends RameshPhone{                      //Concerete Class
    public void dance(){
        Sout("Dancing");
    }
}    

Interface - It is a blueprint of a class.
          - Mechanism to acheive abstraction and multiple inheritence in java.
          - Can have Abstract methods and static constants.
          - It is used to acheive loose coupling(The method and class is almost independent, and they are less depended on each other). 
          - In Java 8, interface can have default and static methods.
eg -    interface{
            void print();
        }

Loose Coupling -
class A{
    void foo(){
        Sout("Inside the foo method of parent class");
    }
} 
class B extends A{
    void foo(){
        Sout("Inside the foo method of child class");
    }
}       
public class CouplingExample{
    public static void main(String[] args){
        B obj = new B();
        obj.foo();
    }
}

eg-
interface A
{
    public abstract void execute1();
}
interface B
{
    public abstract void execute2();
}
class C implements A,B
{
    public void execute1()
    {
        System.out.println("Haii.. I am from execute1");
    }
    public void execute2()
    {
        System.out.println("Haii.. I am from execute2");
    }
}
public class Main
{
	public static void main(String[] args) 
	{
		C obj = new C(); // creating object of class C
		obj.execute1(); //calling method execute1
		obj.execute2(); // calling method execute2
	}
}

-Lamdba Expression              (Added in Java 8)
-It is a short block of code which takes in parameter and returns a value. Can be implemented right in the body of the method.
-In Java 8, we can also remove curly braces and semicolon.
    public static void main(String args[])
    {
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);
        arrL.forEach(n -> System.out.println(n));
        // Using lambda expression to print even elements
        arrL.forEach(n -> { if (n%2 == 0) System.out.println(n); });
    }

Marker Interface - Interface which have no methods.
                 - We need marker interface because to have permission to print/execute a method of class.

- toString Method
class Student{
    int rollno;
    String name;
    String city;
    Student(int rollno,String name,String city){
        this.rollno = rollno;
        this.name = name;
        this.city = city;
    }
    public static void main(String[] args){
        Student s1 = new Student(101,"Raj","Bangalore");
        Student s2 = new Student(102,"Vijay","Ghazibad"); 
        System.out.println(s1);
        System.out.println(s2);
    }
}
This will return the hashcodes values of the object and If you want to print the values of these object then we call toString() method.
public String toString(){
    return rollno+" "+name+" "+city;
}

-Wrapper Class
Wrapper class in Java provides the mechanism to convert the primitive(int,double,char.float) into object and object into primitive.
Use of Wrapper class
- Serialization - We need to convert the objects into stream to perform the serialization.
- Synchronization - Java synchronization works with objects in multithreading.
- Java Collection framework works with objects only.
eg- int i = 10;
    Interger intObj = i;            //intObj = Object
    int intValue = intObj;          //intVal = primitives

-String is Immutable(cannot be changed)
- String is an immutable class which means we cannot change them after creating an objects.
  Whenever we change any string, a new instance is created.
String str1 = "Navin";
String str2 = "Navin";

//Stack       str1 - 101
//            str2 - 101
//Heap        101 - Navin
- This keeps the system fast.
eg - class Test{
        public static void main(String[] args){
            String s = "Samir";
            s.concat("Sujan");                      //concat() append the string at the end.
            System.out.println(s);                  //Samir because string is immutable.
        }
     }
Heap has String Constant pool which it gets stored. Cant be changed.
class Test{
    public static void main(){
        String s = "Samir";
        s = s.concat("Sujan");
        System.out.println(s);              //Sachin Tendulkar
    }
}

- StringBuffer and StringBuilder
StringBuffer is synchronized i.e thread safe. It means two threads cant call the method of StringBuffer simultaneously.
StringBuilder is non-synchronized i.e not thread safe. It means two threads can call the methods of StringBuilder simultaneously.
StringBuffer is less efficient than StringBuilder and StringBuilder is more efficient.
eg-
public class Test{
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer("Java");
        for(int i=0;i<10000;i++){
            sb.append("Samir");
        }
        System.out.println("Time taken by StringBuffer" + (System.currentTimeMillis()-startTime) + "ms");
        startTime = System.currentTimeMillis();
        StringBuilder sBuild = new StringBuilder("Again");
        for(int i=0;i<10000;i++){
            sb.append("Sujan");
        }
        System.out.println("Time taken by StringBuilder" + (System.currentTimeMillis()-startTime) + "ms"); 

    }

    //Time taken by StringBuffer 16ms
    //Time taken by StringBuilder 0ms.
}
