package com.demo.validationgroup;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class TestValidationOperation {

  public static void main(String[] args) {
   
    Operation operation = new Operation(new Date(), new Date(), 1234l, null);

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    System.out.println("Validation sur le groupe par defaut");
    Set<ConstraintViolation<Operation>> constraintViolations = 
      validator.validate(operation);

    
    if (constraintViolations.size() > 0 ) {
      System.out.println("Impossible de valider les donnees du bean : ");
      for (ConstraintViolation<Operation> contraintes : constraintViolations) {
        System.out.println(contraintes.getRootBeanClass().getSimpleName()+ 
          "." + contraintes.getPropertyPath() + " " + contraintes.getMessage());
      }
    } else {
      System.out.println("Les donnees du groupe sont valides");
    }

    constraintViolations = validator.validate(operation, Tracabilite.class);

    System.out.println("Validation sur le groupe Tracabilite : ");

    if (constraintViolations.size() > 0 ) {
      System.out.println("Impossible de valider les donnees du bean : ");
      for (ConstraintViolation<Operation> contraintes : constraintViolations) {
        System.out.println(contraintes.getRootBeanClass().getSimpleName()+ 
          "." + contraintes.getPropertyPath() + " " + contraintes.getMessage());
      }
    } else {
      System.out.println("Les donnees du groupe sont valides");
    }
  }
}