package org.teachingkidsprogramming.section03ifs;

public class ChooseYourOwnAdventure
{
  public static void main(String[] args)
  {
    //   startStory (recipe below) --#2.1
    //
    //   ------------- Recipe for startStory --#2.2
    //      Tell the user "One morning the Tortoise woke up in a dream." --#1
    //
    //      animateStartStory (recipe below) --#38.1
    //
    //      ------------- Recipe for animateStartStory --#38.2
    //         Show the Tortoise --#37
    //         The current pen color is black --#39.2
    //         Do the following 25 times --#41.1
    //              Turn the background to the current pen color --#39.1
    //              Lighten the current pen color --#42
    //              Wait for 100 milliseconds --#40  
    //         Repeat --#41.2
    //      ------------- End of animateStartStory recipe --#38.3
    //
    //      Ask the user "Do you want to 'wake up' or 'explore' the dream?" --#3
    //      If they answer "wake up" --#6
    //          wakeUp (recipe below) --#5.1
    //
    //          ------------- Recipe for wakeUp --#5.2
    //              Tell the user "You Wake up and have a boring day.  The End." --#4
    //          ------------- End of wakeUp recipe --#5.3
    //      Otherwise, if they answer "explore" --#9
    //          approachOoze (recipe below) --#8.1
    //
    //      ------------- Recipe for approachOoze --#8.2
    //         Tell the user "You approach a glowing, green bucket of ooze, worried that you will get in trouble, you pick up the bucket." --#7
    //         Ask the user "Do you want to pour the ooze into the 'backyard' or 'toilet'?" --#13
    //         If they answer "toilet" --#16
    //              pourIntoToilet (recipe below) --#15.1
    //
    //         ------------- Recipe for pourIntoToilet --#15.2
    //            Tell the user "As you pour the ooze into the toilet it backs up, gurgles and explodes covering you in radio-active waste." --#14
    //            Ask the user "Do you want to train to be a NINJA?  'Yes' or 'HECK YES'?" --#29
    //            If they answer "yes" --#32
    //                  ninjaTortoise (recipe below) --#31.1
    //
    //            ------------- Recipe for ninjaTortoise --#31.2
    //               Tell the user "Awesome Dude!  You live out the rest of your life fighting crimes and eating pizza!" --#30
    //            ------------- End of ninjaTortoise recipe --#31.3
    //
    //            Otherwise, if they answer "heck yes" --#34
    //            ninjaTortoise (recipe below) --#33
    //
    //            Otherwise, if they answer anything else --#36
    //            badAnswer (recipe below) --#35
    //
    //         ------------- End of pourIntoToilet recipe --#15.3
    //
    //         Otherwise, if they answer "backyard" --#19
    //         pourIntoBackyard (recipe below) --#18.1
    //
    //         ------------- Recipe for pourIntoBackyard --#18.2
    //            Tell the user "As you walk into the backyard a net scoops you up and a giant takes you to a boiling pot of water." --#17
    //            Ask the user "As the man starts to prepare you as soup, do you...  'Scream' or 'Faint'?" --#21
    //            If they answer "faint" --#24
    //
    //                  tortoiseSoup (recipe below) --#23.1
    //
    //            ------------- Recipe for tortoiseSoup --#23.2
    //               Tell the user "You made a delicious soup!  Yum!  The End." --#22
    //            ------------- End of tortoiseSoup recipe --#23.3
    //
    //            Otherwise, if they answer "scream" --#26
    //                  startStory (recipe below) --#25.1
    //
    //            Otherwise, if they answer anything else --#28
    //                  badAnswer (recipe below) --#27
    //
    //         ------------- End of pourIntoBackyard recipe --#18.3
    //         Otherwise, if they answer anything else --#20
    //            badAnswer (recipe below) --#19
    //      ------------- End of approachOoze recipe --#8.3
    //
    //      Otherwise, if they answer anything else --#12
    //            badAnswer (recipe below) --#11.1
    //
    //      ------------- Recipe for badAnswer --#11.2
    //         Tell the user "You don't know how to read directions.  You can't play this game.  The End." --#10
    //      ------------- End of badAnswer recipe --#11.3
    //
    //   ------------- End of startStory recipe --#2.3
  }
}
