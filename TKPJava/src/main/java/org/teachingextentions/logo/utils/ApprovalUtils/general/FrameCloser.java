package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

public class FrameCloser extends java.awt.event.WindowAdapter {
    /**
     * *******************************************************************
     */
    public void windowClosing(java.awt.event.WindowEvent e) {
        e.getWindow().dispose();
    }

    /**
     * *******************************************************************
     */
    public void windowClosed(java.awt.event.WindowEvent e) {
        System.exit(0);
    }
    /***********************************************************************/
}