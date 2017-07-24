/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

/**
 *
 * @author Shawn
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("nameValidator")
public class NameValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
//        "[a-zA-Z]+" "a-zA-Z" means capitalize up and down, "+" means unlimited words
      Pattern  pattern = Pattern.compile("[a-zA-Z]+");
      Matcher  matcher = pattern.matcher((CharSequence) value);
      HtmlInputText  htmlInputText = (HtmlInputText) component;
        
        String label;
        
         if (htmlInputText.getLabel() == null || htmlInputText.getLabel().trim().equals(" ")) {
            label = htmlInputText.getId();
        } else {
            label = htmlInputText.getLabel();
        }

        if (!matcher.matches()) {
            FacesMessage facesMessage
                    = new FacesMessage(label
                            + ": not a valid name inputed");
            throw new ValidatorException(facesMessage);
        }
        
        
        
    }
    
}
