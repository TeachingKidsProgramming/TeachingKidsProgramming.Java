TeachingKidsProgramming.Java
============================

## To Install ##

1a) Open your C: drive, Create a new folder called **TKPSource** (Do NOT put any blank spaces in the folder name).

1b) Download the TKP ZIP file from this site. Download this zip file by clicking the 'Download ZIP' button on the middle right side of this page (for your convenience we also copied that same link directly below this line)

[![download zip button][2]][1]
 
1c) After the download completes, drag the zip from your **Downloads** folder to the **TKPSource** folder then right click the downloaded file and then click on 'extract all'(Win) or 'unzip'(Mac) to unzip it.  

      For Windows -- Next open the upzipped folders and find the 'TKP_Launcher.jar' file.  Double-click the 'TKP_Launcher.jar file to run it.

      For Mac -- download Eclipse and also download the Java SDK, then follow the instructions below.

2) After the 'TKP_Launcher.jar' runs successfully, then Eclipse should open with the TKP courseware loaded. The courseware is a series of *.java files.  If the 'TKP_Launcher.jar' file displays an error, read the error and see the section at the bottom of this page to complete the steps needed.

A successful install should look like this (our sample has two lines of code completed 'Tortoise.show();' which can you run to test to make sure everything is working if you like: ![screenshot of Eclipse](http://teachingkidsprogramming.org/blog/wp-content/uploads/2012/04/Screen-shot-TKP-Java1.png)

## To Run and Use the Courseware ##

Double click the 'TKP_Launcher.jar' file.  This will open Eclipse and load the TKP workspace (courseware) into the customized IDE (Eclipse editor) using the latest version of the TKP courseware.

## Lesson Plans ##

You can download [Printable Lesson Plans] (https://www.penflip.com/lynnlangit/tkp-lesson-plans) to aid in teaching. We suggest the PDF format (Indexed and formatted better).

=============================
### If Standard Install Doesn't Work ###

If the standard install doesn't work, then there are a couple of possible reasons: 
   
   a) **Java (6 or higher) not installed** -> (for Windows) run the 'Ninite JDK Installer'.  After the installer finishes, then double-click on the 'TKP_Launcher.jar' file to re-run it. (for Mac) download the JDK and install it.
   
   b1) **Eclipse Luna not installed** -> (for Windows) run the 'Ninite Eclipse Installer'. After the installer finishes, then double-click on the 'TKP_Launcher.jar' file to re-run it. 
   
   b2) **Eclipse Luna not installed** -> (for Mac) install Eclipse manually.  Be sure to unzip Eclipse into your applications folder. After you are done installing Eclipse, then double-click on the 'TKP_Launcher.jar' file to re-run it.  You may need to 'point to' the TKP workspace manually, see instruction c1b) (below)

   c1a) Some **old version of Eclipse installed** -> (Win/Mac) Delete the version of Eclipse you have on your system by finding the folder named Eclipse and deleting it.  Then install Eclipse Luna.  You can find Eclipse Luna here

[Eclipse Luna](https://projects.eclipse.org/releases/luna)  

   c1b) Open Eclipse and point it at the this directory, by going to File>Switch Workspace>Open 

\TeachingKidsProgramming.Java

When done your dir should include

   `  
   .metadata  
   TeachingKidsProgramming` 
   
   d) Failure due to **Unable to write to filesystem location(s)** -> some school districts apply various 'locking' permissions to student computer lab laptops.  Try to 'run as administrator' (for Windows) or 'run as root' (for Mac) so that the downloaded TKP files can be unzipped.  Another variation of this locked down state is that some schools create a virtual (and sometimes shared C:\ drive).  If this is the case, unzip Eclipse to the C:\ drive and then unzip the TKP.zip to each student's C:\temp directory.  

  [1]: https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Java/archive/master.zip
  [2]: https://dl.dropboxusercontent.com/u/41301272/downloadZip.png


