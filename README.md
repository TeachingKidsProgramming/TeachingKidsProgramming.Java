#Get Started With TKP

Setup your computer

* [Windows](#windows) 
* [Mac](#mac)

### <a name="windows"></a>Windows

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

1. **Run** the `TKP_Launcher.jar` file by double-clicking it. Wait for it to run.  *Tip* if the jar wont run, double check that you are double-clicking it from the extracted **folder** and not inside the **zip**. 

    If the jar file runs ok, then Eclipse will launch with the TKP workspace open. A successful install should look like the screenshot below: (you can test with two lines of code below)

    ```java
    Tortoise.show();
    Tortoise.move(50);
    ```

    ![screenshot of Eclipse](/images/20Success.png?raw=true)

     If an error MessageBox pops up, you probably just need a little more setup, keep reading.
    

    ![Java Missing](/images/05NoJava.png?raw=true)
        
1. **Run** the "Ninite" installer for Java.  There are two, but only one is appropriate for your computer.  Look in the `C:\` folder.  Do you have a folder called `Program Files (x86)`?  

    ![64-bit](/images/06_64bit.png?raw=true)
    
    If so, then double-click `Ninite JDK x64 8 Installer.exe`.  Otherwise, double-click `Ninite JDK 8 Installer.exe`.  (If you see a `Security Warning` click `Run`. If you see a `User Account Control` prompt click `Yes`).  When the Ninite Java install finishes, try double-clicking the `TKP_Launcher.jar` again.  
    
    If it works, great!  Otherwise, you might see a message like the one below.  Keep reading for more setup.

    ![Eclipse Missing](/images/07NoEclipse.png?raw=true)
    
1. <a name="wineclipse"></a>**Run** the "Ninite" installer for Eclipse.  There is only one installer for eclipse, called `Ninite Eclipse Installer.exe`.  Double-click the eclipse installer (If you see a `Security Warning` click `Run`. If you see a `User Account Control` prompt click `Yes`). When the Ninite Java install finishes, try double-clicking the `TKP_Launcher.jar` again.  
    
    If it works, great!  Otherwise, visit the [Fixing Installation Errors](#troubleshooting) section below for more tips.
   
### <a name="mac"></a>Mac

1. **Create** a new folder named `TKPSource` (no spaces in the folder name) in your `Documents` folder.  Example: `/Users/james/Documents/TKPSource`.

    ![Create ~/TKPSource](/images/08CreateFolder.png?raw=true)

1. **Download** the TKP zip file from this site by clicking the `Download ZIP` button on the middle right side of this page (or use the link directly below this line). Wait for the download to complete.

    [![download zip button][2]][1]
 
1. **Move** the zip file from your **Downloads** folder to the **TKPSource** folder.  The name of the downloaded file is `TeachingkidsProgramming.Java-master.zip`

    ![Move zip to TKPSource](/images/09MoveZip.png?raw=true)

1. **Unzip** the downloaded file.  Right click on the zip file, and choose `Open` to create the TKP folder.

    ![Extract Zip](/images/10Open.png?raw=true)

1. **Open** the unzipped TKP folders and find the **TKP_Launcher.jar** file.  

    ![TKP Launcher](/images/11TKPLauncher.png?raw=true)

1. **Run** the `TKP_Launcher.jar` file by double-clicking it. Wait for it to run.  *Tip* if the jar wont run, double check that you are double-clicking it from the extracted **folder** and not inside the **zip**.

    If the jar file runs ok, then Eclipse will launch with the TKP workspace open. A successful install should look like the screenshot below: (you can test with two lines of code below)

    ```java
    Tortoise.show();
    Tortoise.move(50);
    ```

    ![screenshot of Eclipse](/images/20Success.png?raw=true)

     If an error MessageBox pops up, you probably just need a little more setup, keep reading.

    ![Not Trusted](/images/12Untrusted.png?raw=true)
        
1. **Open** the Mac `System Preferences` and choose `Security & Privacy`.

    ![Settings](/images/13Settings.png?raw=true)
    
    Click `Open Anyway`, then `Open`.  This will allow the TKP launcher to run in the future, and Mac will immediately try to run the launcher again.  

    ![Open Anyway](/images/14OpenAnyway.png?raw=true)
        
    If it works, great!  Otherwise, you might see a message like the one below.  Keep reading for more setup.

    ![Java Missing](/images/15NoJava.png?raw=true)
    
1. **Download** Java 8.  Click the `More Info...` button (shown above) to go to Oracle's download page.  There are several download options, choose `JDK` (indicated below).

    ![Choose JDK](/images/16JDK.png?raw=true)
    
    On the next page there is a table of files you can download.  First, accept the Java license by choosing `Accept License Agreement`.  Now, find `Mac OS X x64` in the table and download the `dmg` file from the same row.

    ![Choose Mac DMG](/images/17JDK2.png?raw=true)
    
	Wait for it to download, then double-click the dmg to open it.  Double click the `pkg` file inside the `dmg`, then click `Continue` then `Install` in the wizard that appears.  Enter your password if prompted, and wait for the installation to complete.
	
	Next, try launching the `TKP_Launcher.jar` by double-clicking it.  If it works, great!  Otherwise, you might see a message like the one below.  Keep reading for more setup.
    
    ![Eclipse Missing](/images/18NoEclipse.png?raw=true)
    
1. <a name="maceclipse"></a>**Download** [Eclipse Luna][3]. To extract the eclipse files, right-click on the `eclipse-java-luna-SR2-macosx-cocoa-x86_64.tar.gz` file and choose `Open`. Next, drag the `eclipse` folder to `Applications`.
    
    ![Move Eclipse](/images/19Eclipse.png?raw=true)
     
    When you have put `eclipse` into `Applications` try launching TKP again by double-clicking `TKP_Launcher.jar`.  If it works, great!  Otherwise, visit the [Fixing Installation Errors](#troubleshooting) section below for more tips.

## <a name="troubleshooting"></a>Fixing Installation Errors

We're sorry that you are having trouble getting started with TKP.  Below you will find a few more troubleshooting tips that we have used to resolve issues in the past.  
   
###Correct version of Java (7 or higher) not installed

We test the standard installation steps using "clean" computers with no software installed except what comes with Windows or OSX.  However, your computer might have an older version of Java on it that we don't support.

To validate the version of Java that is installed, go to [this website](http://java.com/en/download/installed8.jsp) and click the 'validate' button. **Note** this website will not work in Google's Chrome browser, so you may need to visit it in another browser (Safari/Firefox/Internet Explorer/etc).

If the reported version of your Java installation is less than 7, then update Java to the version that Oracle recommends.

###Correct version of Eclipse (Luna) not installed

We test the standard installation steps using "clean" computers with no software installed except what comes with Windows or OSX.  However, your computer might have an older version of eclipse on it that we don't support.

Eclipse installations have friendly names (examples: Indigo, Kepler, Luna) that indicate their version.  You can see this name when eclipse starts.
    
![Eclipse Luna](/images/21Luna.png?raw=true)
     
We test TKP with `Luna`.  The friendly names are in alphabetical order, so if your version starts with a letter that comes before `L`, then you are using an older version of eclipse and should update to Luna.  If you are using a version of eclipse that comes after `L`, then it _should_ work, but we haven't yet tested that version, you may want to try Luna.  

We recommend that you delete your current version of eclipse.  (Advanced users can rename it, but we won't cover that here).   On **Windows**, delete `C:\eclipse`.  On **Mac** delete `eclipse` from `Applications`.  Next, go back to the installation instructions for [Windows](#wineclipse) or [Mac](#maceclipse) to setup Luna. 

###Customized TKP workspace did not open in Eclipse.

Open Eclipse and change the default workspace directory, by clicking on `File` then choosing `Switch Workspace` and then `Open...`.  Navigate to the `\TeachingKidsProgramming.Java` folder (under `C:\TKPSource` on **Windows**, or `Documents\TKPSource` on **Mac**).  After you do this, then your `TeachingKidsProgramming.Java` should include the following folders:

* `\.metadata`
* `\TeachingKidsProgramming` 
     
###Unable to write to file system location(s)
This general installation failure can occur if your school has "locked down" permissions to student lab computers.  

Try to `run as administrator` for **Windows**, or `run as root` for **Mac** and this may allow the downloaded TKP files to unzip.

Some schools create a virtual (sometimes shared) `C:\` drive.  If the drive is shared, eclipse should still be installed to `C:\`, but `TKPSource` should be created in each student's `C:\temp` directory.

###Still Stuck?

Please consider writing a description of the errors/problems you are seeing and sharing it with us by opening a GitHub issue.  You can be a detailed as you like, and your story will help us make TKP better.

You can create a issue by following this link (GitHub account required): [Create An Issue][4]

Or you can [email us from this page](http://teachingkidsprogramming.org/contact/) and we will create the issue for you (no account required).

  [1]: https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Java/archive/master.zip
  [2]: https://dl.dropboxusercontent.com/u/41301272/downloadZip.png
  [3]: https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/luna/SR2/eclipse-java-luna-SR2-macosx-cocoa-x86_64.tar.gz
  [4]: https://github.com/TeachingKidsProgramming/TeachingKidsProgramming.Java/issues/new


