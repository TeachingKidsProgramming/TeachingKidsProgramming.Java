# Teaching TKPJava Course 03 - Conditional Logic


_More about Methods, and introducing Simple & Complex If-statements_

***
## Preparing to Teach this Course
| Every Course | Recipes in this Course |
|--------------------------------------------------------------|---------------------------------|
| :hourglass: **Install** the [TKPJava courseware](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Java#get-started-with-tkp) | **1**. HiLow - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section03ifs/HiLow.java) |
| :green_book: **Read** this lesson plan page | **2**. HiLowVariation - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section03ifs/HiLowVariation.java) |
| :computer: **Code** the recipes yourself | **3**. HiLowQuiz -[answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section03ifs/HiLowQuiz.java) |
| :bulb: **Review** the [TKPJava Language pptx](http://www.slideshare.net/lynnlangit/tkpjava-teaching-kids-programming-core-java-langauge-concepts) | **4**. ConcentricLoop - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section03ifs/ConcentricLoop.java) |
|:fax: **Print** the [worksheet / also keyboard shortcuts cheat sheet](https://www.dropbox.com/s/9qwbv48p8lmx4nj/TKP-Worksheets.zip?dl=0) | **5**. ChooseYourOwnAdventure - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section03ifs/ChooseYourOwnAdventure.java) |
|:bulb: **Review** the recipe / lesson answer files | **6**. DeepDive03 - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section03ifs/DeepDive03Ifs.java) |

***
## Part 1 - **Recipe: HiLow Game**
This course introduces conditional logic with increasingly complex Java if..., if...else If...., etc...control flow structures.  We also introduce the idea of 'exit' points, or end of program code.

Additionally, in this course, we use a random number generator that we wrote for TKPJava.
The line referring to using a random number can be translated in two ways.  We make use of a utility library (NumberUtils) that we wrote to simplify the creation of a random number (as shown below).

    //    Choose a random number between 1 and 100 --#4.1 (fake!) & --#13   
    int answer = NumberUtils.getRandomInt(1, 100);
    
Alternatively you could use the "classic" Java pattern as shown below:
    
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(100);
    
There are also two ways to translate the 'and exit --#10' line, this depends on how many if statements are used.  When using a single If statement (with two included 'else if' conditions), then you can translate 'and exit' as shown below:
    
    	//     and exit --#10
        System.exit(0);
        
Alternatively, if you choose to use two if statements, then you can use a Java 'break' statement rather than 'System.exit(0)' to exit the program on the winning condition.
***
### Viedo Recap: HiLow
Teacher preparation video HiLow recipe recap linked below.
<a href="http://www.youtube.com/watch?feature=player_embedded&v=KU3kU326fqQ" target="_blank"><img src="http://img.youtube.com/vi/KU3kU326fqQ/0.jpg" alt=“HiLow” width=“480” height=“360” border="10" /></a>

Also, new teacher tip video 'How to use the Eclipse Debugger' (shown with the HiLow Variation) linked below.
https://www.youtube.com/watch?v=M8F6ziuccmw
***
## Part 2 – Variation: HiLow
To kick off this section, you may choose to use the TKP Kata Question:

_"How would you make sure that the guess is a positive number?"_

See the TKP Instructional Design (Teaching Variation) section for more information.

Elicit from kids – _what features are there?_
Example (with all later steps completed):

Feature - Value
Text of questions - i.e. "What is your guess?"
Answer - Integer (40)
Number of Times Guess - 8
Range of possible guesses - any integer

### Variation Preparation
1. Prepare and then update the text of questions
Easy to change right now
Change to update the game - can make it funny
Run, see that it’s the same. [THIS IS IMPORTANT.]
Put X in “prepare” for 'text of questions'.
Can change text of input questions and messages out (including adding error messages - i.e. 'you can't guess more than 100 silly...', etc)

2. Prepare and then update answer
Simple refactoring. Go to where it says 40, highlight, right click, refactor, extract local
variable.
Name it “answer”
Run – show that it does exactly the same thing.
[Don’t explain everything here – just show that it runs.]
X it off in the graph.

3. Prepare and update the number of attempts to guess
_Which line determines this? the for loop stop value_
You are just checking for understanding
Go back to grid, X it off

4. Range of possible guesses
Can verify that currently the guess can be ANY integer, or within a range of integers (using additional conditional logic, i.e. additional and/or nested 'if' blocks)
Can change number of guesses allows and wrap in an if-block to select easy, medium or hard game (with progressively fewer guesses possible)


### Sample Variation Grid

| Feature | Value | Refactor  |
| ------ | ------ | -----: |
|  Number of Guesses  |  8 |   no  |
|  Guess Value  |  number  |   no  |
|  Answer Value  |  number  |   no  |
|  Guess Value Range  |  integers  |   positive integers only  |
|  Guess Values  |  as above  |   reduce range of possible inputs  |
|  Guess Value Message  |  none  |   custom |
|  Program Exit Point  |  simple  |   with message  |

***
## Part 3 – Quiz: HiLowQuiz.java

Working with Tortoise methods, such as getX( ), getY( ), and detail -- includes 'turn to the left' and more to verify that kids are actually reading the English comments before they translate into Java
***
## Part 4 – **Recipe: ConcentricLoop**
Combines nested for loops with if statement and introduces scope of variables in loops, i.e. 'i' in first for loop and 'j' in nested for loop.
***
## Part 5 – Recipe: ChooseYourOwnAdventure.java

Open “ChooseYourOwnAdventure”
Each kid is on a single computer or this can be done in pairs if you prefer.

This recipe uses a new type of comparision in the if clauses - specifically it uses the syntax:
	"string1".equalsIgnoreCase(string2).  

This recipe teaches 'control of (program) flow' via complex conditional logic.  Concepts included are these:
- Conditionals (if...elseif...else)
- Nested Conditionals (if....if...)
- Redirect to main method

Also using methods to encapsulate reused code is demonstrated by both having kids write code and then extract it as a method (and then reuse that method elsewhere in the code) and also by introducing the idea of convenience methods for repeated code.  Convenience methods represent code libraries that are used in production code to produce more human-readable code, particularly in cases of long methods/classes.

The convenience methods used are as follows:
	MessageBox.showMessage(message); --> tellMoreStory("blah...");
	MessageBox.askForInput(question); --> askAQuestion("blah...");
      
Other teaching tips: if the students are having difficulty, be sure to have them 'match' the braces for their 'if' statements.  If you feel comfortable, you may want to add a breakpoint (click in the left margin on the code editor window on a line to 'break' [or stop] during execution of code on and then run the code in debug mode to open the debugger.  Here's a link to a short tutorial on how to use the debugger - http://www.vogella.com/tutorials/EclipseDebugging/article.html    

***
##Part 6 – Deep Dive: DeepDive03Ifs.java
Covers conditional logic, various implementations of 'if...' clauses

### SETUP
Chairs at front, circle/oval/whatever – computer at desk to the side.

Give kids post-its. 
Each kid writes an observation and the last thing they just did. No talking – they just write. Then collect, and read them to the class.
PROCESS
When going through Deep Dive, one student will sit @ computer, another will be standing and will tell them what to type.
After each test, standing student gives observation (/explains why they entered what they did), then they rotate.
If they ask “Does it work if…” then try it and see!
SHOW THEM THE PROCESS
***
## Part 7 – Worksheet: 
Print '3_HiLowWorksheet.docx' and have the kids complete it.
***

