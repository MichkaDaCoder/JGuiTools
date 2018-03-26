package jguitools.interfaces.jframe;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import jguitools.interfaces.generic.IGui;

/**
 * IJFrameTools.java: Interface that inherits from <b>IGui</b> and contains specific methods for JFrame such as displaying input message, components look-and-feel...
 * @author MichkaDaCoder
 */
public interface IJFrameTools extends IGui{
    void showInputDialog(String title, String text);
    void showConfirmDialog(String title,String text);
    void setLabelStyle(JLabel jlabel, Color foreground, String fontName,int size);
    void setLabelIcon(JLabel label,String path) throws IOException;
    void setButtonPressedIcon(JButton button, String path) throws IOException;
}
