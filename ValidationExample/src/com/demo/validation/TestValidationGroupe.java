package com.demo.validation;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class TestValidationGroupe {

	public static void main(String[] args) {


	    Groupe groupe = new Groupe("Mon groupe");
	    
	    PersonneBean personne1 = new PersonneBean(null, null, new GregorianCalendar(
	        2065, Calendar.JANUARY, 18).getTime());
	    DeveloppeurSeniorBean personne2 = new DeveloppeurSeniorBean(null, "", new GregorianCalendar(
		        1965, Calendar.JANUARY, 18).getTime(), 3);

	    groupe.ajouter(personne1);
	    groupe.ajouter(personne2);
	    
	    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    Validator validator = factory.getValidator();

	    Set<ConstraintViolation<Groupe>> constraintViolations = 
	      validator.validate(groupe);

	    if (constraintViolations.size() > 0 ) {
	      System.out.println("Impossible de valider les donnees du bean : ");
	      for (ConstraintViolation<Groupe> contraintes : constraintViolations) {
	        System.out.println(contraintes.getRootBeanClass().getSimpleName()+ 
	          "." + contraintes.getPropertyPath() + " " + contraintes.getMessage());
	      }
	    } else {
	      System.out.println("Les donnees du groupe sont valides");
	    }

	  }
}
