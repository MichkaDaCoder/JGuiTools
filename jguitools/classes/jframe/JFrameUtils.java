package jguitools.classes.jframe;

import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import jguitools.interfaces.jframe.IJFrameTools;
/**
 * JFrameUtils.java: class that contains useful methods for JFrame components and attributes including modal messages, conve
 * @author MichkaDaCoder
 */
public class JFrameUtils implements IJFrameTools{

    public JFrameUtils() {
        
    }
    
    /**
     * Shows an info message.
     * @param title
     * @param text 
     */
    @Override
    public void showInfoMessage(String title, String text) {
        JOptionPane.showMessageDialog(null, text,title,JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Shows an error message.
     * @param title
     * @param text 
     */
    @Override
    public void showErrorMessage(String title, String text) {
        JOptionPane.showMessageDialog(null, text,title,JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Shows a warning message.
     * @param title
     * @param text 
     */
    @Override
    public void showWarningMessage(String title, String text) {
        JOptionPane.showMessageDialog(null, text,title,JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Shows an input dialog message.
     * @param title
     * @param text 
     */
    @Override
    public void showInputDialog(String title, String text) {
        JOptionPane.showInputDialog(null, text,title, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showConfirmDialog(String title, String text) {
        
    }

    /**
     * Parses a given text to an Integer.
     * @param text
     * @return <b>Integer</b>
     */
    @Override
    public int parseInteger(String text) {
        return Integer.parseInt(text);
    }

    /**
     * Parses a given text to a double
     * @param text
     * @return <b>Double</b>
     */
    @Override
    public double parseDouble(String text) {
        return Double.parseDouble(text);
    }

    /**
     * Parses a given text to a float.
     * @param text
     * @return <b>Float</b>
     */
    @Override
    public float parseFloat(String text) {
        return Float.parseFloat(text);
    }

    /**
     * Checks if a fields is empty.
     * @param text
     * @return <b>Boolean</b>
     */
    @Override
    public  boolean isEmptyField(String text) {
        return text.length()==0;
    }

    /**
     * Checks if a multiple fields are empty.
     * @param fields
     * @return <b>Boolean</b>
     */
    @Override
    public boolean areEmptyFields(String[] fields) {
        for(int i=0;i<fields.length;i++) {
            if(fields[i].length()==0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compares 2 given dates and return the superior one.
     * @param d1
     * @param d2
     * @return <b>Boolean</b>
     */
    @Override
    public boolean dateSuperior(Date d1, Date d2) {
        return d2.after(d1);
    }
    
    /**
     * Format your date to the pattern you want. Eg: ddMMyyyy, MMddyyyy
     * @param d
     * @param pattern
     * @return <b>String</b>
     * @throws ParseException 
     */
    @Override
    public String formatDate(Date d, String pattern) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(d);
    }

    /**
     * Set a style for your JLabel component.
     * @param jlabel
     * @param foreground
     * @param font
     * @param size 
     */
    @Override
    public void setLabelStyle(JLabel jlabel, Color foreground, String font,int size) {
        jlabel.setFont(new Font(font,Font.PLAIN,size));
        jlabel.setForeground(foreground);
    }

    /**
     * Set an Icon for your JLabel.
     * @param label
     * @param path
     * @throws IOException 
     */
    @Override
    public void setLabelIcon(JLabel label,String path) throws IOException {
        Icon iccon=new ImageIcon(path);
        label.setIcon(iccon);
    }

    /**
     * Set an Icon for a pressed JButton.
     * @param button
     * @param path
     * @throws IOException 
     */
    @Override
    public void setButtonPressedIcon(JButton button, String path) throws IOException {
        Icon icon=new ImageIcon(path);
        button.setPressedIcon(icon);
    }

    /**
     * Checks if a given email is valid using a Regex.
     * @param email
     * @return <b>Boolean</b>
     */
    @Override
    public boolean isValidEmail(String email) {
        final String EMAIL_PATTERN="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(EMAIL_PATTERN);
    }

    /**
     * Loads a properties file.
     * @param path
     * @return <b>Properties</b>
     * @throws IOException 
     */
    @Override
    public Properties loadPropertiesFile(String path) throws IOException {
        Properties prop=new Properties();
        InputStream input=new FileInputStream(path);
        prop.load(input);
        return prop;
    }

    /**
     * Read a property of a key from a given Properties file.
     * @param property
     * @return <b>String</b>
     * @throws IOException
     * @throws InvalidParameterException 
     */
    @Override
    public String loadProperty(String property) throws IOException, InvalidParameterException {
        loadPropertiesFile("YourPropertiesfile.properties");
        return loadPropertiesFile("YourPropertiesFile.properties").getProperty(property);
    }

    
}
