package com.demo.validationgroup;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public interface Tracabilite {
  @NotNull
  @Past
  Date getDateCreation();

  @NotNull
  @Past
  Date getDateModif();

  @NotNull
  Long getUtilisateur();

}