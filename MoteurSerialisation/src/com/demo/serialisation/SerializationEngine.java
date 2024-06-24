package com.demo.serialisation;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SerializationEngine {
    
	public static void writeObject( Object object, PrintWriter writer ) throws Exception {
	    Class<?> metadata = object.getClass();
	    if ( metadata == Byte.class ||
	         metadata == Short.class ||
	         metadata == Integer.class ||
	         metadata == Long.class ||
	         metadata == Float.class ||
	         metadata == Double.class ||
	         metadata == Boolean.class ) {
	        // --- On gère les types de bases ---
	        writer.print( "" + object );
	    } else if ( metadata == String.class || metadata == Character.class ) {
	        // --- On gère les chaînes de caractères ---
	        writer.print( "\"" + object + "\"" );
	    } else if ( metadata.isArray() || object instanceof List ) {
	        // --- On gère les tableaux et les collections ---
	        @SuppressWarnings("rawtypes") 
	        List collection = object instanceof List 
	                ? (List) object : ArrayUtils.toObjectList( object ) ;
	        int size = collection.size();
	        int i = 0;

	        writer.print( "[" );
	        for( Object value : collection ) {
	            writeObject( value, writer );
	            if ( i++ < size - 1 ) writer.print( "," );
	        }
	        writer.print( "]" );
	    } else {
	        // --- On gère les objets Java ---
	        writer.write( "{" );
	        Field [] fields = metadata.getDeclaredFields();
	        for ( int i=0; i<fields.length; i++ ) {
	            Field field = fields[i];
	            field.setAccessible( true );
	            writer.write( String.format( "\"%s\": ", field.getName() ) );
	            writeObject( field.get( object ), writer );
	            if ( i < fields.length-1 ) writer.write( ", " );
	        }
	        writer.write( "}" );
	    }
	}
    
    
	private static Object readObject( Class<?> metadata, Scanner scanner ) throws Exception {
	    if ( metadata == Byte.class || metadata == byte.class ) {
	        return Byte.parseByte( scanner.findInLine( "[0-9]+" ) );
	    } else if ( metadata == Short.class || metadata == short.class  ) {
	        return Short.parseShort( scanner.findInLine( "[0-9]+" ) );
	    } else if ( metadata == Integer.class || metadata == int.class ) {
	        return Integer.parseInt( scanner.findInLine( "[0-9]+" ) );
	    } else if ( metadata == Long.class || metadata == long.class  ) {
	        return Long.parseLong( scanner.findInLine( "[0-9]+" ) );
	    } else if ( metadata == Float.class || metadata == float.class  ) {
	        return Float.parseFloat( scanner.findInLine( "[0-9]+(\\.[0-9]+)?" ) );
	    } else if ( metadata == Double.class || metadata == double.class ) {
	        return Double.parseDouble( scanner.findInLine( "[0-9]+(\\.[0-9]+)?" ) );
	    } else if ( metadata == Boolean.class || metadata == boolean.class  ) {
	        return Boolean.parseBoolean( scanner.findInLine( "true|false" ) );
	    } else if ( metadata == String.class || metadata == Character.class || metadata == char.class ) {
	        String value = scanner.findInLine( "\".*?\"" );
	        return value.substring( 1, value.length()-1 );
	    } else if ( metadata.isArray() || List.class.isAssignableFrom( metadata ) ) {            
	        // --- Désérialisation de tableaux ou de collections ---
	        throw new Exception( "Not actually implemented" );
	    } else {
	        // --- Désérialisation d'un objet ---
	        Object object = metadata.getDeclaredConstructor().newInstance();
	        scanner.findInLine( "\\{\\s*" );
	        while( ! scanner.hasNext( "\\s*\\}" ) ) {
	            String attributeName = (String) readObject( String.class, scanner );
	            scanner.findInLine( ":\\s*" );                
	            Field field = metadata.getDeclaredField( attributeName );
	            field.setAccessible( true );
	            Object value = readObject( field.getType(), scanner );
	            field.set( object, value );
	        }
	        scanner.findInLine( "\\s*\\}" );
	        return object;
	    }
	}

    // J'introduis ici la généricité pour plus de confort.
    @SuppressWarnings( "unchecked" )
    public static <T> T readObject( Class<T> metadata, Reader reader ) throws Exception {
        try ( Scanner scanner = new Scanner( reader ) ) {
            scanner.useLocale(Locale.US);    // double stocké avec le caractère . (et non la virgule)
            return (T) readObject( metadata, scanner );    
        }
    }
    
    
    public static void main( String[] args ) throws Exception {
        
        String file = "./file.json";
        
        try ( PrintWriter writer = new PrintWriter( file ) ) {
            //SerializationEngine.writeObject( 3, writer );
            //SerializationEngine.writeObject( 3.1415, writer );
            //SerializationEngine.writeObject( "Hello Faissal", writer );
        	
        	//String [] languages = { "Java", "Python", "C#", "C++" };
            //SerializationEngine.writeObject( languages, writer );
        	
        	Article article = new Article();
            SerializationEngine.writeObject( article, writer ); 
        	//CommandLine commandLine = new CommandLine();
            //SerializationEngine.writeObject( commandLine, writer );
        }
        
        try ( FileReader reader = new FileReader( new File( file ) ) ) {
            //double data = SerializationEngine.readObject( Double.class, reader );
            //String data = SerializationEngine.readObject( String.class, reader );
            //System.out.println( data );
        	
        	Article article = SerializationEngine.readObject( Article.class, reader );
            System.out.println( article );
        }
    
    }
    
}
