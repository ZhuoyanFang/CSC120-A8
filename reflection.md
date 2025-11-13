Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?

I decided to overload the methods that would make the classes easier to use and a bit closer to how the campus actually works.

For the House class,  I overloaded the constructor from House(String name, String address, int nFloors, boolean hasDiningRoom, boolean elevator) (original) to House(String name, String address)
I added the shorter version so I don’t have to type all the details every time I make a house. It just builds a simple house with no dining but an elevator. I also overloaded moveOut() from moveOut(Student s) to moveOut(String studentId) I use loops through the resident list and checks their toString() to find the right student by ID. 

For the Cafe class, I overloaded the constructor that full constructor with default inventory. alsoI overloaded sellCoffee() from sellCoffee(int size, int nSugarPackets, int nCreams) into sellCoffee(int size, int nCreams). The second one is for the coffee order that do not have sugar so I don’t have to type 0 every time.

For the Library class, I overloaded addTitle() and checkout() since libraries often add/ check out multiple books at once.

- What worked, what didn't, what advice would you give someone taking this course in the future?

In my code, I can successfully reuse the original method and the overloaded one. My advice is that try to overload things that make sense in real life like adding multiple books and ordering simple coffee.