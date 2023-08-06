-Generics - Generic means parameterized types. Idea is to allow type(Integer,String,or user-defined data type) to be a parameter to create classes that work with different data types.
Advantages
- We can hold only single type of Objects in generics. It doesnt allow to store other objects.
- It is checked at compile time so no problem occur at runtime.
eg - 
List<Integer> l1 = new ArrayList<Integer>();
l1.add(10);
l1.add("Samir");            //Compile time error

class Test{
    public static void main(String[] args){
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        l1.add(2);
        Iterator<Integer> i = l1.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}

import java.util.*;
class Main{
    public static<E> void printArray(E[] elements){
        for(E element:elements){
            System.out.println(element);
        }
        System.out.println("");
    }
    public static void main(String[] args){
        Integer[] intArray = {1,2,3,54,56,64};
        Character[] charArray = {'A','B','C','D','E'};
        System.out.println("Integer Array ");
        printArray(intArray);
        System.out.println("Character Array ");
        printArray(charArray);
    }
}

import java.util.*;
abstract class Shape{
    abstract void draw();
}
class Rectangle extends Shape{
    void draw(){
        System.out.println("Rectangle");
    }
}
class Circle extends Shape{
    void draw(){
        System.out.println("Circle");
    }
}
class Main{
    public static void drawShapes(List<? extends Shape> lists){         //When we want to use only child class
        for(Shape s:lists){
            s.draw();
        }
    }
    public static void main(String[] args){
        List<Rectangle> list1 = new ArrayList<Rectangle>();
        list1.add(new Rectangle());
        List<Circle> list2 = new ArrayList<Circle>();
        list2.add(new Circle());
        list2.add(new Circle());
        drawShapes(list1);
        drawShapes(list2);
    }
}

import java.util.*;
class Main{

    public static Double add(ArrayList<? extends Number> num){
        Double sum = 0.0;
        for(Number d:num){
            sum = sum + d.doubleValue();
        }
        return sum;
    }
    public static void main(String[] args){
        ArrayList<Double> list1 = new ArrayList<Double>();
        list1.add(1.0);
        list1.add(2.0);
        System.out.println("Sum is"+ add(list1));
        ArrayList<Double> list2 = new ArrayList<Double>();
        list2.add(2.0);
        list2.add(5.0);
        System.out.println("Sum is"+ add(list2));
    }
}

Collections - Collections in java is a framework that provides an architecture to store and manipulate 
the group of objects.
Java Collections means a single unit of objects.
Collection framework provides interfaces(set,List,Queue,Deque) and classes(ArrayList,Vector,LinkedList,
Priority Queue, Hashset,LinkedHashSet, TreeSet).

- List Interface
List interface is the child interface of Collection interface. It inhibits a list of data structure in
which we can store the ordered collection of objects. It can be duplicate values.
List is implemented by class ArrayList, LinkedList, Vector and Stack.
List<data-type> list1 = new ArrayList<>();
List<data-type> list2 = new LinkedList<>();
List<data-type> list3 = new Vector<>();
List<data-type> list4 = new Stack<>();
eg- (ArrayList)
import java.util.*;
class Test{
    public static void main(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        Iterartor it = list1.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
eg - (LinkedList)
import java.util.*;
class Main{
    public static void main(String[] args){
        List<String> list1 = new LinkedList<>();
        list1.add("Samir");
        list1.add("Sujan");
        list1.add("Suvir");
        list1.add("Sujan");
        Iterator<String> it = list1.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
eg - (Vector)
import java.util.*;
class Main{
    public static void main(String[] args){
        List<String> list1 = new Vector<>();
        list1.add("Samir");
        list1.add("Sujan");
        list1.add("Suvir");
        list1.add("Sujan");
        Iterator<String> it = list1.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
eg - (Stack)
peak() is used for getting peak value in a Stack(Last in first Out).
pop() is used to remove from top.
import java.util.*;
class Main{
    public static void main(String[] args){
        List<String> list1 = new Stack<>();
        list1.push("Samir");
        list1.push("Sujan");
        list1.push("Suvir");
        list1.push("Sujan");
        Iterator<String> it = list1.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}

- Queue 
First in first out
Various classes like PriorityQueue, Deque and ArrayQueue implements the Queue interface.

Queue<String> q1 = new PriorityQueue();
Queue<String> q2 = new ArrayDeque();

PriorityQueue - It holds the elements or objects which are to be processed by their priorities.
It doesnt allow null values to be stored. 
The element with highest ASCII value will have highest priority.

class Test{
    public static void main(){
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Samir");
        pq.add("Sujan");
        pq.add("Suvir");
        Iterator it = queue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        pq.poll();                                  //to remove the elements
        pq.remove();                                //to remove the elements

    }
}

Deque - Deque interface extends the Queue interface. In Dequeue, we can remove and add the elements from
both the sides. It is a double ended queue and enable us to perform the operations from both sides.

ArrayDeque - ArrayDeque class implements the Deque ineteface.
It facilitates us to use the deque. Unlike queue we can add and delete from both the ends.
ArrayDeque is faster  than ArrayList and Stack and has no capacity restrictions.

eg - 
class Test{
    public static void main(String[] args){
            Deque<String> d = new ArrayQueue<String>();
            d.add("Gautam");
            d.add("Samir");
            d.add("Sujan");
            for(String str:d){
                System.out.println(str);
            }
    }
}

Set Interface - Extends the collection class. Represents the unordered set of elements which doesnt
alllow us to store the duplicate items.
We can store most one null value in a set.
Set in implemented by HashSet, LinkedHashSet and TreeSet.
HashSet - eg
class Test{
    public static void main(){
        HashSet<String> hs = new HashSet<String>();
        hs.add("Ravi");
        hs.add("Vijay");
        hs.add("Ravi");
        hs.add("Ajay");
        Iterator<String> it = hs.iterator();
        while(hs.hasNext()){
            System.out.println(itr.next());
        }
    }
}  
Output - Vijay 
         Ravi   
         Ajay

LinkedHashSet eg -
It maintains the insertion order and permits the null value.
class Test{
    public static void main(String[] args){
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        set.add("Ravi");
        set.add("Vijay");
        set.add("Ravi");
        set.add("Ajay");
        Iterator<String> itr = set.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
Output - Ravi
         Vijay  
         Ajay

TreeSet eg -
The elements in TreeSet stored in ascending order. The access and retrivel time of treeset is quite fast.
eg -
class Test{
    public static void main(String[] args){
        TreeSet<String> set = new TreeSet<String>();
        set.add("Ravi");
        set.add("Vijay");
        set.add("Ravi");
        set.add("Ajay");
        Iterator<String> itr = set.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        set.forEach(e->{
            System.out.println(e);
        });
    }
}
Output - Ajay
         Ravi
         Vijay
