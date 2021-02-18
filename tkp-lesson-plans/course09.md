# Teaching TKPJava Course 09 - Final Unit 

_-Code Katas and Test-Driven Development - RectangleKata and FizzBuzzKata
-Real-world coding to complete the (anything but) "Simple Puzzle" program_
***
## Preparation to Teach this Course
| Every Course | Recipes in this Course |
|--------------------------------------------|------------------------|
| :hourglass: **Install** the [TKPJava courseware](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Java#get-started-with-tkp) | **1**. RectangleKata - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section09final/RectangleKata.java) |
| :green_book: **Read** this lesson plan page | **2**. WheelKata - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section09final/WheelKata.java) |
| :computer: **Code** the recipes yourself | **3**. FizzBuzz - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section09final/FizzBuzz.java) |
| :bulb: **Review** the [TKPJava Language pptx](http://www.slideshare.net/lynnlangit/tkpjava-teaching-kids-programming-core-java-langauge-concepts) | **4**. FizzBuzzTDD - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section09final/FizzBuzzTDD.java)|
| :fax: **Print** the main [recipe worksheet](https://www.dropbox.com/s/9qwbv48p8lmx4nj/TKP-Worksheets.zip?dl=0) | **5**. FizzBuzzGoldenMaster - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section09final/FizzBuzzGoldenMaster.java) |
| :bulb: **Review** the recipe / lesson answer files | **6**. SimplePuzzle - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section09final/SimplePuzzle.java)|
| :books: **Learn** keep learning! | **7**. DeepDive09 - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section09final/DeepDive09.java)|

***
## Part 1 - **Rectangle Kata**
A **Kata** is set of higher-level English instructions, more like actual software requirements, i.e. 'build me an application that does x,y,z', rather than create an instance of the Form class', etc...  To teach this recipe, do the following:

- Read the instructions (requirements) out loud:

  		// Draw a rectangle on the board (any size, shape and color)
		// Write EACH step to code the rectangle in English FIRST 
        			(in Eclipse using code comments)
		// Determine the ORDER to code each line 
        // Run the program to see the result 
		// Refactor to remove duplication
					
The reason for this exercise is that this type of problem deconstruction is moving closer to real-world programming, in that it mimics the process by following the real-world steps as follows:
- Get **business goal**, define it and agree on it  = _'draw a type of rectangle'_
- **Draw**or sketch business goal (most common understanding for product owners, developers and designers) = actually drawing the rectangle
- Write **discrete steps in English** FIRST - developers are MORE FLUENT in English than in any coding language = express intent clearly in native language first
- **Determine the order** to code so that developers can verify a step was coded properly = deconstruct the problem so that the logic is captured correctly
- **Code and verify** = do all preceding steps BEFORE coding for quality
- **Refactor** to remove duplicate code and to improve readability = better quality code.

***
## Part 2 - **Recipe: WheelKata**
Another **Kata**, or set of higher-level English instructions, which gets the students working more like actual software developers.  To teach this recipe, do the following:

- Read the instructions (requirements) out loud:

  		// Draw a wheel on the board (any size, shape and color)
		// Write EACH step to code the wheel in English FIRST 
        			(in Eclipse using code comments)
		// Determine the ORDER to code each line 
        // Run the program to see the result 
		// Refactor to remove duplication
					
NOTE: The students will need to implement a **main** method in their code at minimum to solve this challenge.  They will probably re-factor to have multiple methods.

***
## Part 3  - **Recipe: FizzBuzz.java**  & **Recipe: FizzBuzzTDD.java**

A **Kata** is set of higher-level English instructions, more like actual software requirements, i.e. 'build me an application that does x,y,z', rather than create an instance of the Form class', etc...  To teach this course, do the following:

- Read the instructions (requirements) out loud:
	
    	//for the whole numbers from 1 to 100, print either that number, or, 
		//if that number is evenly divisible by 3, then print the word 'Fizz', 
		//if that number is evenly divisible by 5, then print the word 'Buzz', 
		//if that number is evenly divisible by either 3 or 5, then print the word 	'FizzBuzz'_

- Lead the class in a discussion of how they will translate this Kata into lines of English (which they will then translate into code one line at a time).  Ask questions such as 'where will you start coding this and why?' Encourage students to enter ENGLISH comments BEFORE they start writing code.  Help the students to focus on USER requirements, by asking them questions such as _'when a USER inputs some number, then that USER gets a particular type of result?'_

You can teach this as a regular Kata first and then as a TDD-style, or you can teach this recipe as a TDD-style kata to start, depending on the experience of your students.

**Test-driven development** is style of coding in which the developer write the test case BEFORE writing the implementing code.  TDD uses unit tests to test each implementation of program logic.  Each TDD unit test is coded as a method with the method attribute @Test.  

As we've done in the DeepDive sections of the TKP courseware, to proceed with each test, the students should run the test and should see a failure result (or red bar).  Their job is to write the code which will implement the desired logic in the class file, in this case 'FizzBuzz.java' and method (FizzBuzz.convert) which will produce the desired user output.

An important aspect of teaching TDD is guide the student to 'thin slice' or to write one testable scenario at a time.  After they write the test, run it and see that test fail, then student will write the implementing code to get the test pass.

Be sure to base each test cases (test method) on a single USER SCENARIO, such as '_if you send in the number one, you get back the number one'_, etc... rather than constructing scaffolding, such as '_test that we can create a class called FizzBuzz_'.  

Facilitator to guide (lead) pairs to create a JUnit test stub, with a single @Test method, to test the first case (IfOneReturnOne):

		@Test
        public static void TestOneReturnsOne()
        {
        	String result = FizzBuzz.convert(1);
            Assert.areEqual("1", result);
        }
        
 Continue with the next test case, (IfTwoReturnTwo).  Next increase the complexity to write a test case for (IfThreeReturnFizz).  Students may struggle with the Integer to String conversion in the FizzBuzz object.  There are multiple ways to perform the string conversion, we recommend the most terse case:

 				return "" + yourNumber;

Alternatively, you can use the more verbose conversion shown below:

                return String.valueOf(yourNumber);
 
 Be sure to have students create test cases that first fail (and have the students run the test to verify) and then succeed after the students complete each step of the exercise.  Again, it's critical that students re-run each test until they see it pass (or return a green bar).  When the students are stuck, have them double-click on the exception detail (bottom left pane of the editor) to open the results in the default text diff tool, so they they can see the detail of the mismatched output in order to be able to to accurately (and quickly) correct their code to produce the desired output.

#### LINE NOTES
This kata has more than one solution.  Ask students to explain why they chose to code the conditional logic in the way that they did.

***
### FizzBuzzTDD Kata Recap
Video for teacher understanding.

<a href="http://www.youtube.com/watch?feature=player_embedded&v=p5EAGD7fOHQ" target="_blank"><img src="http://img.youtube.com/vi/p5EAGD7fOHQ/0.jpg" alt=“Fizz Buzz” width=“480” height=“360” border="10" /></a>

***
## Part 4 – Variation: Refactor the conditional logic
Complete all of the requirements for FizzBuzz, now that you've written all of the Unit Tests (and also, importantly, written the code required to get those Unit Tests to pass).  To do this you'll need to do the following:

	// Copy the FizzBuzz.java file, rename it to FizzBuzz2.java
    // Create a main method (entry point)
    // Inside main create a container to hold the results / StringBuilder
    // Inside main method create list of numbers from 1-100
	// Append each converted number to the StringBuilder
	// Print the results to the console, create a new line for each number
	
A possible solution is shown below:

    package org.teachingkidsprogramming.sectionLYNNtdd;
    
    public class FizzBuzz2
    {
           public static void main(String[] args)
                {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= 100; i++)
                        {
                          sb.append(convert(i));
                        }
                System.out.print(sb);
                }
                
          public static String convert(int i)
                {
                if (0 == i % 15) { return "\n FizzBuzz"; }
                if (0 == i % 5) { return "\n Buzz"; }
                if (0 == i % 3) { return "\n Fizz"; }
                return "\n " + i;
                }
    }
***
## Part 5 – Recipe: SimplePuzzle
Concepts reviewed in this solution:
1) Use of objects, creation of new Objects
2) While Loops
3) Try..Catch Construct
4) Manipulation of Arrays

This being the last lesson in TKPJava is ironically named 'Simple Puzzle' as it is far from simple.   In this lesson we've deliberately simulated the work environment of a professional programmer.  That is, most developers are working on existing code bases, rather than coding projects entirely from scratch.  Also the task of implementing an existing API, rather than coding new functionality from scratch is also common.  In this case, we wrote an API for the puzzle (a solver) for the students to implement.
***
## Part 6 – Quiz: None
There is no quiz for this course. You may want to watch an interesting video about many different approaches to coding FizzBuzz from speaker of [Kevlin Henney "FizzBuzz Trek"](https://vimeo.com/144335290).  For your information FizzBuzz is a common interview question for professional programmers.  For more examples of code katas, see this [site](http://www.codekatas.org/).
***
## Part 7 - Deep Dive: DeepDive08
About Exceptions
***
## Part 8 – Worksheet: FizzBuzz Worksheet
Concepts reviewed in this worksheet are as follows:
1) Type conversion - number (int) to String
2) Unit testing - structure of a basic Assert statement
3) Unit testing - test set up and test execution, i.e. Assert.areEquals(expected, actual)
4) @Test syntax - method attribution for unit testing
5) Program exit points
***

Next Steps and additional resources

After students complete all of the lessons in this course, then they have completed TKPJava.  A great next set of exercises can be found at the [exercism.io](http://exercism.io/) website.  This site provides a platform to continue to learn to code by coding and by submitting code solutions for 'crowd-sourced review'.  Be sure to read the [getting started guide](http://exercism.io/getting-started) as well.


