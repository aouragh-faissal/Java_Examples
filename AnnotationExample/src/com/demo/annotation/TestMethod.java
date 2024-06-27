package com.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.METHOD )
public @interface TestMethod {

    /** Permet de spécifier un éventuel type d'exception attendue */ 
    Class<? extends Throwable> expected() default NoExceptionExpected.class;
    
    /** Un temps maximal d'exécution de notre scénario de test */
    long timeout() default -1;
    
    /** Un type que nous associerons à une situation ou aucune exception n'est attendue. */
    public static class NoExceptionExpected extends Throwable {
        private static final long serialVersionUID = -8242156681893882520L;     
    }
        
}