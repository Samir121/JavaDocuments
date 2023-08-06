class Human{
    int age;
    char gender;
}
// Object Creation - Static 
// Human - Class, obj - Object
Human obj;

// Object Creation - Dynamic
Human *obj = new Human();

// Constructor
// Default Constructor
Human(){
    age = 25;
    gender = 'M';
}

// Parametrized Constructor
Human(int age,char gender){
    this.age = age;
    this.gender = gender;
}

// Copy Constructor
class Human{
    public:
    int age;
    char gender;
    Human(){}                                   // Default Constructor

    Human(int age,char gender){                 // Parametrized Constructor
        this.age = age;
        this.gender = gender;
    }
    Human(Human &temp){                         // Pass by reference
        age = temp.age;
        gender = temp.gender;
    }
}
int main(){
    Human obj1(15,'M');
    Human obj2(obj1);                           // Copy Constructor Called
}

// Destructor - call to deallocate memory.n,m.

// Encapsulation - Binding of data members and function in a single unit (class).
// Used in data hiding, security.
// Clean Code - Readility
//              Reusability
//              Extensibility

// Inheritence - Capability of a class to derive property and behaviour of another class. 
class Parent {
    public:
    int id_p;
};
class Child : public Parent {
    public:
    int id_c;
};
int main(){
    Child obj1;
    obj1.id_c = 5;
    obj1.id_p = 10;

}

//  Polymorphism - Existing in many forms/ Ability of msg to be displayed in more than one form.
// Two types - Compile Time Polymorphism(Early Binding) - Method/Function Overloading
//                                                        Operator Overloading
//             Run Time Polymorphism(Late Binding) - Method Overriding

// Method/Function Overloading
class Human {
    public:
    void func(int x){
        cout << "first" << x;
    }
    void func(double x){
        cout << "double" << x;
    }
    void func(int x,int y){
        cout << "sum is "<< x+y;
    }
};
int main()
    Human obj1;
    obj1.func(5);
    obj1.func(5.5);
    obj1.func(5,5);
}

// Operator Overloading
class Demo{
    public:
    int first;
    int second;
    Demo operator+(Demo &temp){
        Demo result;
        result.first = this.first + temp.first;
        result.second = this.second + temp.second;
    }
};
int main(){
    Demo a;
    Demo b;
    Demo c = a + b;
    cout << "Sum is " << c.first << c.second;
}

// Method Overriding - When we change the implementation of an inherited function is called method overriding.

class Animal{
    public:
    void eat(){
        cout << "Eating";
    }
};
class Dog : public Animal{
    public:
    void eat(){
        cout << "Eating bread";
    }
};
int main(){
    Dog d = Dog();
    d.eat();    // Eating bread
    Animal a = Dog();
    a.eat();    // Eating 
}

// Example 2
class Shape{
    public:
    // Virtual Keyword will make sure that child class gets only single instance of the common base. 
    // Such that amibiguity will not be there.
    virtual void draw(){                         
        cout << "Drawing";
    }
};
class Rectangle : public Shape{
    public:
    void draw(){
        cout << "Drawing Rectangle";
    }
};
class Circle : public Shape{
    public:
    void draw(){
        cout << "Drawing Circle";
    }
};
int main(){
    Shape *s;
    Shape sh;
    Rectangle r;
    Circle c;
    s = &sh;
    s->draw();               // Drawing       
    s = &r;
    s->draw();               // Drawing Rectangle 
    s = &c;
    s->draw();               // Drawing Circle
}

// Virtual function ensures that the correct function is called for an object,
// regardless of the type of reference(or pointer) used for function call.
// Execute the derived class version of the function.

// Friend Class - It can access private and protected members of other classes in which it is declared as a friend.
// Note: We can declare friend class or function anywhere in the base class body whether its private, protected or public block. It works all the same.
class A{
    private:
    int a;
    friend class B;
};
class B{
    void show(A &temp){
        cout << temp.a;
    }
};

// Friend function - Friend function can be granted special access to private and protected members of a class in C++.
// Non-member function
class base{
    private:
    int private_var;
    protected:
    int protected_var;
    public:
    base(){
        private_var = 10;
        protected_var = 40;
    }
    friend void friendFunction(base& obj);
}
void friendFunction(base& obj){
    cout << "Private " << private_var;
    cout << "Protected " << protected_var;
}
int main(){
    base b;
    friendFunction(b);
}


//Abstract Class
// - class is abstract if it has atleast one pure virtual function. eg- virtual void sum() = 0;
// - If we dont override the pure virtual function in derived class, then derived class also becomes abstract class.
// - An abstract class can have constructors.
// - the purpose of abstract class is to provide an appropriate base class from which other classes can inherit.



/**************Practice************/

//class creation
class Human{
    int age;
    char gender;
}

Human h;         //static object
Human h = new Human();         //Dynamic object

Human(){                                //Default Constructor

}

Human(int age,char gender){              //Parameterized Constructor
    this.age = age;
    this.gender = gender;
}

Human(Human& temp){
    this.age = temp.age;
    this.gender = temp.gender;
}

int main(){
    Human h1 = Human(16,"M");
    Human h2(h1);                        //Copy Constructor
}

//Copy Constructor - Used to create copy of an object i.e a new object same as the old object;

//Inheritence - Child class can inherit data members and functions from the parent class.

class Human {
    int age;
    char gender;
}
class Male : public Human{
    int weight;
    string firstname;
}
class Female: public Male{
    string lastname;
}

int main(){
    Male m = new Male();
    m.age=14; 
    Female f = new Female();
    f.gender = 'f';
}

//Polymorphism - Existing in many forms
//Compile Time Polymorphism
//Method Overloading - There can be different methods with same name with different no. of arguement 
class Human(){                       
    void print(){
        cout << "normal";
    }
    void print(int age,char gender){
        cout << " ineron";
    }
    void print(char gender){
        cout << "Only gender";
    }
}

int main(){
    Human h;
    h.print();
    h.print(12,'F');
    h.print('M');
}

//Operator Overloading - By this we can give different meaning to the operators.
class Sum{
    int x;
    int y;
    Sum(){
        this.x = x;
        this.y = y;
    }
    Sum operator+(Sum& temp){
        Sum result;
        result.x = this.x + temp.x;
        result.y = this.y + temp.y;
    }
}
int main(){
    Sum s1(12,4);
    Sum s2(20,10);
    Sum s3 = s1 + s2;
    cout << s3.x << s3.y;
}

//Method Overridding - We can have different implementation of same function in different inherited class.
class Human{
    void print(){
        cout << "Parent class";
    }
}
class Male: public Human{
    void print(){
        cout << "Child Class";
    }
}
class Female:public Human{
    void print(){
        cout << "another child class";
    }
}

int main(){
    Male m = new Male();
    m.print();
    Human h = new Male();
    h.print();
}

//Virtual - virtual keyword makes sure inherited class will get only single instance of common base
//virtual function - ensures that methods will get called depending on the objects and regardless of the
// type of reference.

class Human{
    virtual void print(){
        cout << "Parent class";
    }
}
class Male: public Human{
    void print(){
        cout << "Child Class";
    }
}
class Female:public Human{
    void print(){
        cout << "Another child class";
    }
}

int main(){
    Human *x;
    Human h;
    Male m;
    Female f;
    x=&h;
    x->print();         //Parent class
    x=&m;
    x->print();         //Child Class
    x=&f;
    x->print();         //Another child class
}

//Friend Function - By which we can accesss private and protected members of a class. 
class A{
    private:
        int x;
    friend class B;    
}
class B{
    void print(A& temp){
        cout << temp.x;
    }
}

class A{
    private:
        int private_val;
    protected:
        int protected_val;
    A(){
        private_value = 10;
        protected_value = 20;
    }      
    friend void demo(A& temp);
}

void demo(A& temp){
    cout << private_val;
    cout << protected_val;
}
int main(){
    A first;
    demo(first);
}

Abstract class - Methods which have one pure virtual method;