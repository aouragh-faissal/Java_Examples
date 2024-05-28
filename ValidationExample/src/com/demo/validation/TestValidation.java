package com.demo.validation;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class TestValidation {

	  public static void main(String[] args) {
		    DeveloppeurSeniorBean personne = new DeveloppeurSeniorBean(null, "", new GregorianCalendar(
		        1965, Calendar.JANUARY, 18).getTime(), 3);
		    
		    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		    Validator validator = factory.getValidator();

		    Set<ConstraintViolation<DeveloppeurSeniorBean>> constraintViolations = 
		      validator.validate(personne);

		    if (constraintViolations.size() > 0 ) {
		      System.out.println("Impossible de valider les donnees du bean : ");
		      for (ConstraintViolation<DeveloppeurSeniorBean> contraintes : constraintViolations) {
		        System.out.println(contraintes.getRootBeanClass().getSimpleName()+ 
		          "." + contraintes.getPropertyPath() + " " + contraintes.getMessage());
		      }
		    } else {
		      System.out.println("Les donnees du bean sont valides");
		    }
		  }
}
