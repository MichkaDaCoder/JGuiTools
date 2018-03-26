package jguitools.classes.jsf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jguitools.interfaces.jsf.IJsfTools;

/**
 * JsfUtils.java: Implements <b>IJsfTools</b> interface and contains useful methods for manipulating JSF pages, datas and much more.
 * @author MichkaDaCoder
 */
public class JsfUtils implements IJsfTools{

    /**
     * Default contructor
     */
    public JsfUtils() {
        
    }
    /**
     * Shows an info message.
     * @param title
     * @param text 
     */
    @Override
    public void showInfoMessage(String title, String text) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, text, title);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    /**
     * Shows an error message
     * @param title
     * @param text 
     */
    @Override
    public void showErrorMessage(String title, String text) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, text);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * Shows a warning message.
     * @param title
     * @param text 
     */
    @Override
    public void showWarningMessage(String title, String text) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, title, text);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * Gets current JSF context.
     * @return <b>FacesContext</b>
     */
    @Override
    public FacesContext getCurrentContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Parses a String to an integer value.
     * @param text
     * @return <b>Int</b>
     */
    @Override
    public int parseInteger(String text) {
        return Integer.parseInt(text);
    }

    /**
     * Parses a String to a double value.
     * @param text
     * @return <b>Double</b>
     */
    @Override
    public double parseDouble(String text) {
        return Double.parseDouble(text);
    }

    /**
     * Parses a String to a float value.
     * @param text
     * @return <b>Float</b>
     */
    @Override
    public float parseFloat(String text) {
        return Float.parseFloat(text);
    }

    /**
     * Checks if a text field is empty.
     * @param text
     * @return <b>Boolean</b>
     */
    @Override
    public  boolean isEmptyField(String text) {
        return text.length()==0;
    }

    /**
     * Check if a multiple text fields are empty.
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
     * Checks if a date is superior to another
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
     * Validate an email address using a Regex.
     * @param email
     * @return <b>Boolean</b>
     */
    @Override
    public boolean isValidEmail(String email) {
        final String EMAIL_PATTERN="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(EMAIL_PATTERN);
    }

    @Override
    public Properties loadPropertiesFile(String path) throws IOException {
        Properties prop=new Properties();
        InputStream input=new FileInputStream(path);
        prop.load(input);
        return prop;
    }

    @Override
    public String loadProperty(String property) throws IOException, InvalidParameterException {
        loadPropertiesFile("YourPropertiesfile.properties");
        return loadPropertiesFile("YourPropertiesFile.properties").getProperty(property);
    }

    /**
     * Checks if the current JSF Form is valid.
     * @return <b>Boolean</b>
     */
    @Override
    public boolean isValidationFailed() {
       return FacesContext.getCurrentInstance().isValidationFailed();
    }

    @Override
    public String getRequestParameter(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }

    /**
     * Returns an Object from a Request parameter name.
     * @param requestParameterName
     * @param converter
     * @param component
     * @return <b>Object</b>
     */
    @Override
    public Object getObjectFromRequestParameter(String requestParameterName, Converter converter, UIComponent component) {
       String theId = getRequestParameter(requestParameterName);
       return converter.getAsObject(FacesContext.getCurrentInstance(), component, theId);
    }

    /**
     * Returns a Http request from a current context.
     * @return <b>HttpServletRequest</b>
     */
    @Override
    public HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    /**
     * Returns a Http response from a current context.
     * @return <b>HttpServletResponse</b>
     */
    @Override
    public HttpServletResponse getResponse() {
        return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }
}
