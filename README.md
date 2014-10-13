##Set up TKPJava courseware and customized Eclipse##

1a) **Create** a new folder named **TKPSource** (no spaces in the folder name) at C:\ -> C:\TKPSource.

1b) **Download** the TKP zip file from this site. Download this zip file by clicking the 'Download ZIP' button on the middle right side of this page (or use the link directly below this line). Wait for the download to complete.

[![download zip button][2]][1]
 
1c) **Move** the zip file from your **\Downloads** folder to the **C:\TKPSource** folder.  The name of the downloaded file is 'TeachingkidsProgramming.Java-master.zip'.

1d) **Unzip** the downloaded file (by right clicking it) and then click on 'extract all'(Win) or 'unzip'(Mac) to unzip it.  

1e) **Open** the upzipped TKP folders and find the **'TKP_Launcher.jar'** file.  

1f) **Run** the 'TKP_Launcher.jar file by double-clicking it. Wait for it to run.  

    If the jar file runs ok, then Eclipse will launch with the TKP workspace open. 
    
    If an error MessageBox pops up, read the message and go to the **Fixing Installation Errors** 
    section at the bottom of this document.

A successful install should look like the screenshot below: (you can test with two lines of code below)

    Tortoise.show();

![screenshot of Eclipse](http://teachingkidsprogramming.org/blog/wp-content/uploads/2012/04/Screen-shot-TKP-Java1.png)
=============================
## Lesson Plans ##

#####You can download [Printable Lesson Plans] (https://www.penflip.com/lynnlangit/tkp-lesson-plans) to aid in teaching. We suggest the PDF format (Indexed and formatted better).  These lesson plans include links to our [YouTube channel](https://www.youtube.com/user/tkpjava) which has screencast videos us coding the TKP lessons as well.#####
=============================
### Fixing Installation Errors ###

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
   
   d) Failure due to **Unable to write to file system location(s)** -> some school districts apply various 'locking' permissions to student computer lab laptops.  Try to 'run as administrator' (for Windows) or 'run as root' (for Mac) so that the downloaded TKP files can be unzipped.  Another variation of this locked down state is that some schools create a virtual (and sometimes shared C:\ drive).  If this is the case, unzip Eclipse to the C:\ drive and then unzip the TKP.zip to each student's C:\temp directory.  

  [1]: https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Java/archive/master.zip
  [2]: https://dl.dropboxusercontent.com/u/41301272/downloadZip.png


