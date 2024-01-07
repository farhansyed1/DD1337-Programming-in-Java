### Deadline
This work should be completed before the exercise on **Friday 1st October**.

### Instructions
For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-21/course-instructions#assignments).

### Preparation
You must read and answer the questions in the OLI material:

- Read [Module 4: Thinking in Objects](https://kth.oli.cmu.edu/jcourse/webui/syllabus/module.do?context=881a25ccac1f08882c13d81b79423526)
- If you have not done so, goto https://kth.oli.cmu.edu/, signup and register for the course key `dd1337-ht21`

You may wish to also read Chapter 3 from, _Objects First with Java_.

### Github Task:
Please complete the exercises listed below:

- 3.9--3.12
- 3.21
- 3.26--3.27
- 3.30
- 3.31

Please commit any written answers to the [`docs`](docs) folder, and if
indicated, commit any full Java code developed to the [`src`](src) folder of
your KTH Github repo. Remember to push to KTH Github.

#### Exercise 3.9 (docs)
Which of the following expressions return true?

```
! (4 < 5)
! false
(2 > 2) || ((4 == 4) && (1 < 0))
(2 > 2) || (4 == 4) && (1 < 0)
(34 != 33) && ! false
```

After writing your answers on paper, open the Code Pad in BlueJ or use JShell on
the terminal (if installed) and try it out. Check your answers.

> **Assistant's note:** While you can easily get the correct answers for this
> exercise by simply using the code pad, trying to work out how each expression
> is evaluated beforehand is a good mental exercise! An alternative to BlueJ is
> `jshell` and might be more useful in the long run.

#### Exercise 3.10 (docs)
Write an expression using boolean variables `a` and `b` that evaluates to true
when `a` and `b` are either both true or both false.

> **Assistant's note:** Note that if-statements are *not* expressions. Use only
> variables and operators such as `&&`, `||`, `!`, `==`, etc. when answering questions
> asking for expressions.

#### Exercise 3.11 (docs)
Write an expression using boolean variables `a` and `b` that evaluates to true
when only one of `a` and `b` is true, and that is false if `a` and `b` are both
false or both true. (This is also called an exclusive or.)

> **Assistant's requirement:** Any sane programmer would use the XOR operator
> (`^`) for this, and present the solution  `a^b`. However, this is an exercise
> in boolean logic using AND, NOT and OR, so you are not allowed to be a sane
> programmer for _this particular exercise_!

#### Exercise 3.12 (docs)
Consider the expression `(a && b)`. Write an equivalent expression (one that
evaluates to true only when `a` and `b` are both true) without using the
`&&` operator.

#### Exercise 3.21 (docs)
Rewrite the `increment` method without the modulo operator, #using an if
statement. Which solution is better? For a reminder of the `NumberDisplay` sourcecode, see
[ClockDisplay project](https://gits-15.sys.kth.se/inda-21/bluej-projects/tree/master/chapter03/clock-display).

#### Exercise 3.26 (docs)
Write the signature of a constructor that matches the following object creation
instruction:

```java
new Editor("readme.txt", –1);
```

> **Assistant's note:** Refresh your knowledge of the method signature by
> having a look at the assistant's note on exercise 1.33 from week 1!

#### Exercise 3.27 (docs)
Write Java statements that define a variable named `window` of type
`Rectangle`, and then create a rectangle object and assign it to that variable.
The rectangle constructor has two `int` parameters.

> **Assistant note:** Please note that you do not need to create the Rectangle
> class, but can assume it has already been provided to you.

#### Exercise 3.30 (docs)
Given a variable `Printer p1`; which currently holds a reference to a printer
object, and two methods inside the Printer class with the headers

```java
public void print(String filename, boolean doubleSided) { ... }
public int getStatus(int delay) { ... }
```

write two possible calls to each of these methods with appropriate arguments
that you make up. Note, you do not have to provide code for these methods, just
how they would be called, in a `main` method for example.

> **Assistant's note:** That makes _four_ method calls in total!

#### Exercise 3.31 (src)

> **Assistant's note:** When you see _src_ in the exercise title, make sure you
> add the code to the `src` folder.

Change the clock from a 24-hour clock to a 12-hour clock. Be careful: This is
not as easy as it might at first seem. In a 12-hour clock, the hours after
midnight and after noon are not shown as 00:30, but as 12:30. Thus, the minute
display shows values from 0 to 59, while the hour display shows values from 1
to 12!

You can copy the source code from the [ClockDisplay
project](https://gits-15.sys.kth.se/inda-21/bluej-projects/tree/master/chapter03/clock-display)
into your `src` folder as a starting point. Your solution must be in `src` and
compile.

### Grading Criteria
Each week we will communicate grading criteria through the [issue
tracker](../../issues/). Grading criteria set the basic standards for a pass,
komp or fail, so it is essential you review them each week. These will change
over time as your skills develop, so make sure you read the grading criteria
issue carefully and tick off all the requirements.
