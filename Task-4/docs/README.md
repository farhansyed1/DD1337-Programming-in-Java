# Task 4

**Exercise 3.9 - Which of the following expressions return true?**

ANSWER:    `!false` and `(34 != 33) && !false`

**Exercise 3.10 - Write an expression using boolean variables a and b that evaluates to true when a and b are either both true or both false.**

ANSWER:     `(a && b) || (!a && !b)`

**Exercise 3.11 - Write an expression using boolean variables a and b that evaluates to true when only one of a and b is true, and that is false if a and b are both false or both true.** 

ANSWER:     `(a && !b) || (!a && b)`

**Exercise 3.12 - Consider the expression (a && b). Write an equivalent expression (one that evaluates to true only when a and b are both true) without using the && operator.**

ANSWER:     `!(!a || !b);`

**Exercise 3.21 - Rewrite the increment method without the modulo operator, #using an if statement. Which solution is better?**

ANSWER: The original method is better because the new method only works if the value is 0.  
     
    public void increment() {
        if(value + 1 ==  limit)  {
            value = 0;
        }
        else{
            value++;
        }
    }     
       
**Exercise 3.26 - Write the signature of a constructor that matches the following object creation instruction**

ANSWER: `Editor(String, int)`

**Exercise 3.27 - Write Java statements that define a variable named window of type Rectangle, and then create a rectangle object and assign it to that variable. The rectangle constructor has two int parameters.** 

ANSWER:

    private Rectangle window; 
    window = new Rectangle(1,2);

**Exercise 3.30 - Given a variable Printer p1; which currently holds a reference to a printer object, and two methods inside the Printer class with the headers, write two possible calls to each of these methods with appropriate arguments that you make up.**

ANSWER:    
    
    p1.print(“file.txt”, true);
    p1.print(“file2.txt”,false);
    p1.getStatus(2);
    p1.getStatus(3);

