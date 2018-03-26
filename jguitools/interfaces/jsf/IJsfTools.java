package jguitools.interfaces.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jguitools.interfaces.generic.IGui;


/**
 * IJsfTools.java: Extends from IGui and contains methods to manipulate JSF pages, forms and attributes. 
 * @author MichkaDaCoder
 */
public interface IJsfTools extends IGui {
     FacesContext getCurrentContext();
     boolean isValidationFailed();
     String getRequestParameter(String key);
     Object getObjectFromRequestParameter(String requestParameterName, Converter converter, UIComponent component);
     HttpServletRequest getRequest();
     HttpServletResponse getResponse();
}
