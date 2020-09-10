package org.teachingextensions.logo;

import java.awt.Toolkit;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * <img src="http://www.spellzone.com/images/sound-icon.gif" style="text-align: left" alt="A speaker with sound waves" >
 * Sound allows you to play a sound, like a 'beep' or the sound from a file
 */
public class Sound
{
  private URL soundUrl = null;
  public Sound()
  {
    this(TKPSound.Yay);
  }
  public Sound(TKPSound sound)
  {
    this.setSound(sound);
  }
  /**
   * Plays a beep through your speakers. BEEP!<br>
   * <b>Example:</b> {@code  Sound.playBeep()}
   */
  public static void playBeep()
  {
    Toolkit.getDefaultToolkit().beep();
  }
  /**
   * Sets a sound that you can play through your speakers.
   * Use a TKPSound (there is a list)<br>
   * <b>Example:</b> {@code  Sound.setSound(TKPSound.Ahem)}
   */
  public synchronized void setSound(TKPSound mySound)
  {
    String sound = "soundFiles/" + mySound + ".wav";
    URL resource = this.getClass().getResource(sound);
    if (resource == null)
    {
      resource = this.getClass().getClassLoader().getResource(sound);
    }
    if (resource == null) { throw new IllegalStateException("Could not get TKPSound: " + sound); }
    this.soundUrl = resource;
  }
  /**
   * Plays a TKPSound through your speakers.
   * You must first set the TKPSound <br>
   * <b>Example:</b> {@code  Sound.playSound()}
   */
  public synchronized void playSound()
  {
    final URL sound = this.soundUrl;
    new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        try
        {
          Clip clip = AudioSystem.getClip();
          AudioInputStream inputStream = AudioSystem.getAudioInputStream(sound);
          clip.open(inputStream);
          clip.start();
        }
        catch (Exception e)
        {
          System.out.println("play sound error: " + e.getMessage() + " for " + sound);
        }
      }
    }).start();
  }
  /**
   * Check out our cool sounds - thanks to http://www.wavsource.com/
   */
  public enum TKPSound {
                        Ahem, Applause, BrainIsGone, CatMeow, Cheering, Crickets, DoctorMccoy, Fanfare, FargoYah,
                        Gong, LLCoolJYaKnow, LosingPower, LoveBeingATurtle, Malfunction, Pizza, RunAway,
                        SheerIgnorance, SoBeIt, StrangePerson, Stubborn, Yahoo, Yay
  }
}
