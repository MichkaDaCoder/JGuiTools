/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jguitools.interfaces.generic;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

/**
 * IGui.java: Generic interface that contains all methods for JFrame and JSF including displaying messages, validations...
 * @author MichkaDaCoder
 */
public interface IGui {
    void showInfoMessage(String title, String text);
    void showErrorMessage(String title, String text);
    void showWarningMessage(String title, String text);
    int parseInteger(String text);
    double parseDouble(String text);
    float parseFloat(String text);
    boolean isEmptyField(String text);
    boolean areEmptyFields(String[] fields);
    boolean dateSuperior(Date d1,Date d2);
    String formatDate(Date d, String pattern) throws ParseException;
    boolean isValidEmail(String email);
    Properties loadPropertiesFile(String path) throws IOException;
    String loadProperty(String property) throws IOException, InvalidParameterException;
}
