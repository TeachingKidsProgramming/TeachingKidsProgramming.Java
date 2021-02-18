## Teaching TKPJava Course 08 - Events & Event Listeners

_Events, Event Listeners and more about Object Instances_
***
## Preparation to Teach this Course
| Every Course | Recipes in this Course |
|--------------------------------------------|--------------------------------|
|:hourglass: **Install** the [TKPJava courseware](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Java#get-started-with-tkp) | **1**. SimpleBubble - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section08events/SimpleBubble.java) |
| :green_book: **Read** this lesson plan page | **2**. SimpleBubbleVariation - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section08events/SimpleBubbleVariation.java) |
| :computer: **Code** the recipes yourself | **3**. SimpleBubbleQuiz - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section08events/SimpleBubbleQuiz.java) |
| :bulb: **Review** the [TKPJava Language pptx](http://www.slideshare.net/lynnlangit/tkpjava-teaching-kids-programming-core-java-langauge-concepts) | **4**. ConnectTheDots - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section08events/ConnectTheDots.java) |
| :fax: **Print** the main [recipe worksheet](https://www.dropbox.com/s/9qwbv48p8lmx4nj/TKP-Worksheets.zip?dl=0) | **5**. :future: DeepDive08 |
| :bulb: **Review** the recipe / lesson answer files | **6**. TortoiseMaze - [answer](https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Source.Java/blob/master/src/main/java/org/teachingkidsprogramming/recipes/completed/section08events/TortoiseMaze.java) |

***    
## Part 1 - **Recipe: Simple Bubble** 

This lesson introduces the idea of object instances and also includes some coding around variable scope.  Specifically the first line to be translated says in English:

	//Create a ProgramWindow titled My Bubble --#1
    
To do this you'll have to guide the students through several steps (if you have time watch the video shown below).  These steps are as follows (code is shown below):
1) create a new object called ProgramWindow with the value Bubbles 
2) save that object as a local variable called programWindow
3) declare a field (before the class) of type ProgramWindow

 	private ProgramWindow programWindow;
  	public SimpleBubble()
  	{
    	//Create a ProgramWindow titled Bubbles --#1
   		 programWindow = new ProgramWindow("Bubbles");
         
Using similar logic, guide the students to translate the English comment

	// Create a circle with the radius and the next color from the color wheel --#2.1
    
By first creating a new Circle object and then including required parameters.  You may want to fake the radius as an intermediate step.    Next save the new circle as a local variable called circle.  Code will look like this:

 	// Set the radius for the circle to a random number between 10 and 50 --#2.5
    int radius = NumberUtils.getRandomInt(10, 50);
    // Create a circle with the radius and the next color from the color wheel --#2.1
    Circle circle = new Circle(radius, ColorWheel.getNextColor());

Next you'll guide the kids to the next new concept -- coding events via a MouseClickListener.  We wrote a customized Listerner object, derived from the more generic MouseClick event object which is standard in Java, to simplify the onramping to events.  You will note we also limited the listener to the left mouse button.  The solution to the section of the lesson that uses this object is shown below.

    @Override
     public void onLeftMouseClick(int x, int y)
    {
    // createBubble (recipe below) --#8
    createBubble(x, y);
    }

The concept of calling a listener using the "this" keyword is also new in this lesson:

    //Have SimpleBubble listen for when the left mouse button is clicked in your program window --#2.2
    programWindow.addMouseLeftClickListener(this);

Additionally we created a Circle object to make the creation of a Bubble most straight-forward.  The Circle object is a higher level abstraction to the more general Paintable library.  This is why the students need to call 'removePainable' on the Program Window to remove the Circles they create.

In the createBubble method in addition to the use of the Circle object, there are several new intermediate programming concepts.  They include the use of our NumberUtils library to create a random number and also the use of an instance of the Circle object.  

The idea of instance creation (as a field or a local variable) vs. global object initialization should be reinforced (Circle circle = new Circle...).  Also, the idea of 'use your editor to explore' is built-in as we created custom methods on the Circle object, such as Circle.setCenter... and Circle.addTo to make the translation process closer to the original English.

***
### Recap: Bubble
This is just a video for teacher preparation - found [here](https://www.youtube.com/watch?v=3aihvg44gNs).  Concepts to emphasize are scope of variables, i.e. field vs. local variable, and  fake it 'till you make it, i.e. using fakes (constants, such as a a number - in our case 9 for the radius, etc...) so that you can run and test your code in intermediate steps.  

Also you may want to re-inforce NOT deleting the lines of English until after each line is FULLY translated.

Ask the students a question: 'Why did we extract two methods?'

You also may want to ask about the main method - in past recipes we always put it as one of the first lines  - in this one we did not.  The reason is that we wanted to have the kids use a constructor method, i.e. SimpleBubble( ), which is then called by the main method atypically at the END of this recipe.  We also reinforce this idea of a constructor method in the extra recipe, 'Connect the Dots'.

<a href="http://www.youtube.com/watch?feature=player_embedded&v=3aihvg44gNs" target="_blank"><img src="http://img.youtube.com/vi/3aihvg44gNs/0.jpg" alt=“Bubble” width=“480” height=“360” border="10" /></a>

***
## Part 2 – Variation: SimpleBubbleVariation (aka 'BubbleSplat')
To kick off this section, you may choose to use the TKP Kata Question:

_"How would you add the ability to change your bubble into a unicorn?"_

Example (with all later steps completed):
Variation 1: create a 'splat' of bubbles by doing the following:
--adding another override to the onLeftMouseClick which includes a for loop of size 7.  Inside of the method (and for loop) create a new method called createBubbles by copying the original createBubbles method and removing the programWindow.removePaintable line - potential solution is shown below:

		public class SimpleBubble implements MouseLeftClickListener
		{
 			 private ProgramWindow programWindow;
  			
            public SimpleBubble()
  			{
    				programWindow = new ProgramWindow("Bubbles");
    				programWindow.addMouseLeftClickListener(this);
    				prepareColorPalette();
  			}
            
  			private void prepareColorPalette()
  			{
                    ColorWheel.addColor(Colors.Blues.AliceBlue);
                    ColorWheel.addColor(Colors.Blues.Blue);
                    ColorWheel.addColor(Colors.Blues.DarkBlue);
                    ColorWheel.addColor(Colors.Purples.Purple);
 			 }
    //  @Override
    //  public void onLeftMouseClick(int x, int y)
    //  {
    //    createBubble(x, y);
    //  }
    
    @Override
    public void onLeftMouseClick(int x, int y)
    {
    int size = 7;
    for (int i = 1; i <= size; i++)
            {
              createBubbles(x + i * 15, y + i * 15);
            }
    }
    private void createBubble(int x, int y)
    {
      programWindow.removePaintable();
      int radius = NumberUtils.getRandomInt(10, 50);
      Circle circle = new Circle(radius, ColorWheel.getNextColor());
      circle.setCenter(x, y);
      circle.addTo(programWindow);
    }
    private void createBubbles(int x1, int y1)
      {
        //programWindow.removePaintable();
        int radius = NumberUtils.getRandomInt(10, 50);
        Circle circle = new Circle(radius, ColorWheel.getNextColor());
        circle.setCenter(x1, y1);
        circle.addTo(programWindow);
      }
    public static void main(String[] args)
    	{
     	 new SimpleBubble();
    	}
 	 }

Variation 2: refactor to create an array of bubbles

***

## Part 3 – Quiz: SimpleBubbleQuiz 
Complete the quiz - IMPORTANT: students must interact (click) with the screen, in addition to completing the coding in order to pass this quiz.  They have to click on either the left or the right mouse button to complete the step (after they have coded it) in order to pass the quiz.
***
## Part 4 – Connect the Dots 
This recipe reinforced the idea of a constructor in the first comment line:
    //Create a new 'Connect The Dots' window. --#1.1

Which, similar to the translation process of SimpleBubble recipe earlier, is translated using the same process - that is:
1) create a new ConnectTheDots object
2) create a local variable called dots of type ConnectTheDots (object) and is translated into this:

	ConnectTheDots dots = new ConnectTheDots();
 
 We again use method chaining, as we did in the Turtle Tree recipe, but now combined with the event listeners in the line of English:
 
 	// Listen for left clicks on the window for the tortoise 
    
Which is translated into this code:

	Tortoise.getBackgroundWindow().addMouseLeftClickListener(this);
 
This lesson reinforces the newly-introduced events concept with the use of the onLeftMouseClick and the onRightMouseClick event listeners.

    @Override
     public void onRightMouseClick(int x, int y)
    {
    clearTheScreen();
    }
    @Override
    public void onLeftMouseClick(int x, int y)
    {
    addDot(x, y);
    }

 Also use of the Tortoise object to clear the Program Window, rather than the Program Window itself may be confusing to students.  The use of the Text object as a translation of 'Write '{these words}' on the screen is a subtle shift which is important to highlight, i.e. from English verb to Java noun.

    private static void clearTheScreen()
     {
    //  ------------- Recipe for clearTheScreen
    //   Clear the Program Window
    Tortoise.clear();
    //   Write "Right click to clear" on the screen at position 100, 100
    new Text("Right click to clear").setTopLeft(100, 100).addTo(Tortoise.getBackgroundWindow());
    }
***
## Part 5 - Deep Dive08: TBD
Concepts will include events and more on object instances
***
## Part 6 - Tortoise Maze
Button click events
## Part 7 – Worksheet
-Print the worksheet '7_SimpleBubbleWorksheet.docx'
