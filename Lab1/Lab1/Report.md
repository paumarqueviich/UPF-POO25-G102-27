# **Lab 1 – Object-Oriented Programming**

## **1. Introduction**

In this first lab, the goal was to develop a Java program applying the main principles of object-oriented programming. The task focused on designing and implementing classes that could represent mathematical vectors and perform different operations with them.  

For this, I created two main classes:

- **Vector**: represents a mathematical vector and includes methods for basic operations such as addition, subtraction, multiplication, division, scalar operations, square root, dot product, and norm calculation.  
- **Record**: represents a simple data record containing a Vector (as input) and a numeric output value.  
- **TestRecord**: is a test class that creates instances of these objects and checks that all methods behave as expected.

The objective was to make the program modular, easy to understand, and based on well-structured object-oriented design.


## **2. Design Decisions and Object-Oriented Concepts**

At the beginning, I considered using only arrays to handle the numerical data, but I quickly realized that defining a dedicated Vector class would make the program clearer, more reusable, and easier to extend. Using Java’s ArrayList was another option, but it would have added unnecessary complexity for simple numerical operations.

The chosen solution was to:
- Define a **Vector class** that stores its elements in a double[] array and provides methods for mathematical operations. Each operation returns a **new object**, keeping the class immutable.
- Use a **Record class** that combines a vector and its corresponding output value, showing how **composition** works in object-oriented design.

Some of the main OOP concepts applied in this solution are:
- **Encapsulation**: class attributes are private, and access is provided through getters.  
- **Abstraction**: the internal implementation of operations is hidden from the user.  
- **Composition**: a Record object is built from a Vector object.  
- **Reusability**: the Vector class could be reused in other programs that need similar mathematical functionality.

This structure made the code more organized and helped maintain a clear separation of responsibilities between the classes.


## **3. Conclusion**

The final implementation worked correctly and met the objectives of the lab. All classes behaved as expected during testing, and the operations produced consistent results.  

Throughout the implementation, some general challenges appeared, such as keeping the code clean, ensuring that the methods returned new objects instead of modifying existing ones, and maintaining consistency in the class design. These aspects required careful thinking about how data should flow between objects.  

Additionally, since I worked on this lab individually (most people did it in pairs), I had to manage all parts of the development process on my own. This made the work a bit more demanding but also helped me understand each part of the code more deeply and reinforce the concepts of object-oriented programming.  

In general, the lab was a good exercise to strengthen the understanding of object-oriented programming principles. It helped me practice concepts like encapsulation, abstraction, and composition in a practical way, and I am satisfied with the final result.
