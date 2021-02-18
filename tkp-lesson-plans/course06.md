# Teaching TKPJava Course 06 - MVC (Model-View-Controller)


_More on String Concatenation, Message Box - Using MVC (as a variation)_
***
##Preparing to Teach this Course
| Every Course | Recipes in this Course |
|--------------------------------------------|--------------------------|
| :hourglass: **Install** the  [TKPJava courseware](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Java#get-started-with-tkp) | **1**. AdLibs - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section06modelviewcontroller/AdLibs.java) |
| :green_book: **Read** this lesson plan page | **2**. ExceptionalAdLibsVariation - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section06modelviewcontroller/ExceptionalAdLibsVariation.java) |
| :computer: **Code** the recipes yourself | **3**. AdLibsRtf - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section06modelviewcontroller/AdLibsRtf.java) |
| :bulb: **Review** the [TKPJava Language pptx](http://www.slideshare.net/lynnlangit/tkpjava-teaching-kids-programming-core-java-langauge-concepts) | **4**. AdLibsQuiz- [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section06modelviewcontroller/AdLibsQuiz.java) |
| :fax: **Print** the main [recipe worksheet](https://www.dropbox.com/s/9qwbv48p8lmx4nj/TKP-Worksheets.zip?dl=0) | **5**. DeepDive06 - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section06modelviewcontroller/DeepDive06ModelViewController.java) |
| :bulb: **Review** the recipe / lesson answer files |  **6**. OneFishTwoFish - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section06modelviewcontroller/OneFishTwoFish.java) |


***    
## Part 1 - **Recipe: Ad Libs**

Pretty basic recipe, but fun!  String concatenation requires careful reading of the English and using quotes and concatenation characters ('+') correctly.

We are also reinforcing the creation and use of variables with the use of 'current{word}' repeatedly in this recipe.

    //Ask the user to enter an adverb, save it as currentAdverb --#2
    String currentAdverb = MessageBox.askForTextInput("What is the adverb?");
    
We layer the string concatenation practice on top of the use of mutiple variables, for example:

    //Add the words "I woke " + currentAdverb + ". " to the currentStory --#3
    currentStory = currentStory + "I woke " + currentAdverb + ". ";

### Video Recap: AdLibs Recap
Video recap for teacher preparation.

<a href="http://www.youtube.com/watch?feature=player_embedded&v=1HSWdT4-czc" target="_blank"><img src="http://img.youtube.com/vi/1HSWdT4-czc/0.jpg" alt=“Ad Libs” width=“480” height=“360” border="10" /></a>

***

## Part 2 - Variation: ExceptionalAdLibsVariation
To kick off this section, you may choose to use the TKP Kata Question:

_"How would you make sure that the person telling your story did NOT enter in a number?"_

In this variation, we've added conditional logic to test for valid input values.  Keeping this simple, we raise 'psuedo' exception messages in Message Boxes, rather than the more formal method of using try...catch  w/Java exception handers.

Also we introduce the first RegEx expression in the '_adverb.matches("[\\d]*")) argument.

Be sure to point out the the use of 'If' statements and you may want to draw out the program control of flow mapping.

We also refactored to include convenience methods, i.e. 'askForValueAgain( )....'

## Part 3 – Variation: AdLibs with .rtf file

A simple analogy to explain MVC is this:
_The Model is the food, the View is the plate and the Controller is the chef._

This is lead as a ‘follow the leader’ style exercise. Open Word or something to scribble in. Make a grid, add columns for feature, value; ask the kids:

_which line(s) of code in the original AdLibs recipe create the model, which create the view and which create the controller?_

Answers: 

1. The Model or Data model is the concatenated string ("currentStory")
2. The View is the MessageBox in the recipe
3. The Controller is the .showMessage ( ) method in the recipe 

In the Variation, several new concepts are introduced:

 - to update the Model, create the **Words class** which holds the data Model - you will have to add a new class for this data
 - to update the Parser object, which acts as a controller - use the .parseRtfFile (templateFilename, data); method
 - to update the View object, which is the viewer - use the .displayRtfFile (model); method  
 These objects re-purpose the basic Model which the kids already created in the core recipe.
    
The View object uses uses a the template file 'view.rtf' and which contains string   replacement parameters, designated by the syntax {parameterName} as shown below. This template file (view.rtf) is compiled as a resource in the TKP.jar file.
    
    Today I woke {adverb}. Then I {edVerb} my {bodyPart}.
    
Variation results: 

1. The Model (originally the concatenated string) -> becomes the Words class 
2. The View (MessageBox) -> becomes an RTF file via the Viewer class, using the display RTF file method (using the template file and passing the parameter values [strings] via the template placeholders
3. The Controller (.showMessage ( ) ) -> becomes a Parser, using the parse RTF method

### Alternate Variations

For classes that would be better served by simpler variations than the MVC version listed above, teachers may wish to use the guidance provided below.

New column: “Simple changes”
Add one more column: “Cool changes”
Can change anything, but needed to prepare before we mess around.

Could add one or more Integers, i.e. number + 'number of bodyParts' to explore concatenation with variables of Integer type being converted and concatenated to variables of String type such as below:
    
    String myString = " body parts";
    Integer myNumber = 5;
    result = myNumber + myString;
    System.out.println(result);
***

## Part 4 – Quiz: AdLibsQuiz
concepts tested include the following:
Question 1 & 2) String concatenation (variations of such)
Question 3) MVC - implementing a custom parser - 
    hint: use Parser.parse(<template>,<model>)
Question 4) MVC - implementing a custom template
 	hint: set the template variable = "<letter>{templateName}<otherLetter>"
***
## Part 5 - Deep Dive: DeepDive06ModelViewController
concepts reinforced include the following:
1) string concatenation - simple as well as multi-line concatenation
2) type conversion - specifically numbers (int, etc...) to string for concatenation
3) HashMap - using simple types, Strings and integers
***
## Part 6 – Recipe: OneFishTwoFish
New recipe still in development.  Uses the Java string manipulation Scanner class.  
Uses many methods of the Scanner object - see HINTS in the main recipe English comments.
It also uses an Iterator object in the foreach loop.
***
## Part 7 – Worksheet: 
-Print the worksheet '6_AdLibsWorksheet.docx'
***

