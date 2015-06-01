#Get Started With TKP And Customized Eclipse#

####Need help?  Click "Join Chat" below:

[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/TeachingKidsProgramming/TeachingKidsProgramming.Java?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)


##Setup Your Computer

### Windows

1. **Create** a new folder named `TKPSource` (no spaces in the folder name) at the top level of your `C:` drive.  Example: `C:\TKPSource`.

    ![Create C:\TKPSource](/images/01CreateFolder.png?raw=true)

1. **Download** the TKP zip file from this site by clicking the `Download ZIP` button on the middle right side of this page (or use the link directly below this line). Wait for the download to complete.

    [![download zip button][2]][1]
 
1. **Move** the zip file from your **Downloads** folder to the **C:\TKPSource** folder.  The name of the downloaded file is `TeachingkidsProgramming.Java-master.zip`

    ![Move zip to C:\TKPSource](/images/02MoveZip.png?raw=true)

1. **Unzip** the downloaded file.  Right click on the zip file, and choose `Extract All...`.  Next click `Extract` to create the TKP folder.

    ![Extract Zip](/images/03ExtractAll.png?raw=true)

1. **Open** the unzipped TKP folders and find the **'TKP_Launcher.jar'** file.  

    ![TKP Launcher](/images/04TKPLauncher.png?raw=true)

1. **Run** the `TKP_Launcher.jar` file by double-clicking it. Wait for it to run.  

    If the jar file runs ok, then Eclipse will launch with the TKP workspace open. A successful install should look like the screenshot below: (you can test with two lines of code below)

    ```java
    Tortoise.show();
    Tortoise.move(50);
    ```

    ![screenshot of Eclipse](http://teachingkidsprogramming.org/blog/wp-content/uploads/2012/04/Screen-shot-TKP-Java1.png)

     If an error MessageBox pops up, you probably just need a little more setup, keep reading.
    

    ![Java Missing](/images/05NoJava.png?raw=true)
        
1. **Run** the "Ninite" installer for Java.  There are two, but only one is appropriate for your computer.  Look in the `C:\` folder.  Do you have a folder called `Program Files (x86)`?  

    ![64-bit](/images/06_64bit.png?raw=true)
    
    If so, then double-click `Ninite JDK x64 8 Installer.exe`.  Otherwise, double-click `Ninite JDK 8 Installer.exe`.  (If you see a `Security Warning` click `Run`. If you see a `User Account Control` prompt click `Yes`).  When the Ninite Java install finishes, try double-clicking the `TKP_Launcher.jar` again.  
    
    If it works, great!  Otherwise, you might see a message like the one below.  Keep reading for more setup.

    ![Eclipse Missing](/images/07NoEclipse.png?raw=true)
    
1. **Run** the "Ninite" installer for Eclipse.  There is only one installer for eclipse, called `Ninite Eclipse Installer.exe`.  Double-click the eclipse installer (If you see a `Security Warning` click `Run`. If you see a `User Account Control` prompt click `Yes`). When the Ninite Java install finishes, try double-clicking the `TKP_Launcher.jar` again.  
    
    If it works, great!  Otherwise, visit the `Fixing Installation Errors` section below for more tips.
   


=============================
## Lesson Plans ##

#####You can download [Printable Lesson Plans] (https://www.penflip.com/lynnlangit/tkp-lesson-plans) to aid in teaching. We suggest the PDF format (Indexed and formatted better).  These lesson plans include links to our [YouTube channel](https://www.youtube.com/user/tkpjava) which has screencast videos us coding the TKP lessons as well.#####
=============================
### Fixing Installation Errors ###

If the standard install doesn't work, then there are a couple of possible reasons: 
   
a) **Java (7 or higher) not installed** -> 



(for Mac) download the JDK and install it.  To validate the version of Java that is installed, go to [this website](http://java.com/en/download/installed8.jsp) and click the 'validate' button - 

   
   b2) **Eclipse Luna not installed** -> (for Mac) install Eclipse manually.  Be sure to unzip Eclipse into your applications folder. After you are done installing Eclipse, then double-click on the 'TKP_Launcher.jar' file to re-run it.  You may need to 'point to' the TKP workspace manually, see instruction c1b) (below)

   c1a) Some **old version of Eclipse installed** -> (Win/Mac) Delete the version of Eclipse you have on your system by finding the folder named Eclipse and deleting it.  Then install Eclipse Luna.  You can find Eclipse Luna here

[Eclipse Luna](https://projects.eclipse.org/releases/luna)  

   c1b) Customized **TKP workspace not open** in Eclipse.  Open Eclipse and change the default workspace directory, 
   by clicking on 'File>Switch Workspace>Open...' and navigating to the **\TeachingKidsProgramming.Java** folder.

  After you do this, then your working directory should include the following folders:
   `  
    \.metadata & \TeachingKidsProgramming` 
     
   
   d) General Installation Failure due to **Unable to write to file system location(s)** -> some school districts apply various 'locking' permissions to student computer lab laptops.  Try to 'run as administrator' (for Windows) or 'run as root' (for Mac) so that the downloaded TKP files can be unzipped.  Another variation of this locked down state is that some schools create a virtual (and sometimes shared C:\ drive).  If this is the case, unzip Eclipse to the C:\ drive and then unzip the TKP.zip to each student's **C:\temp** directory.  

  [1]: https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Java/archive/master.zip
  [2]: https://dl.dropboxusercontent.com/u/41301272/downloadZip.png


