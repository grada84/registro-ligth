package net.lacnic.registro.commons.utils;

import java.text.DecimalFormat;

import net.lacnic.domain.mysql.Usuario;


public class UtilsFormato {
	
	public static DecimalFormat formatDecimal = new DecimalFormat("###,###,###");
	public static DecimalFormat formatDecimalConComa = new DecimalFormat("###,###,###.##");
	
	public static String capitalizeFirstLetters(String s) {
		s = s.toLowerCase();
		
	    for (int i = 0; i < s.length(); i++) {
	        if (i == 0) {
	            // Capitalize the first letter of the string.
	            s = String.format("%s%s", Character.toUpperCase(s.charAt(0)), s.substring(1));
	        }

	        // Is this character a non-letter or non-digit? 
	        //If so then this is probably a word boundary so let's capitalize the next character in the sequence.
	        if (!Character.isLetterOrDigit(s.charAt(i))) {
	            if (i + 1 < s.length()) {
	                s = String.format("%s%s%s", s.subSequence(0, i+1), Character.toUpperCase(s.charAt(i + 1)), s.substring(i+2));
	            }
	        }
	    }

	    return s;
	}
	
	public static boolean isIntNumber(String num){
	    try{
	        Integer.parseInt(num);
	    } catch(NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean isLongNumber(String num){
	    try{
	        Long.parseLong(num);
	    } catch(NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean isDoubleNumber(String num){
	    try{
	        Double.parseDouble(num);
	    } catch(NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static String textoNulo(String text){
		if(text == null) return "";
		
		return text;
	}
	
	public static Object textoNulo(Object text){
		if(text == null) return "";
		
		return text;
	}
	
	public static String getIdUsuarioNulo(Usuario usuario){
		if(usuario == null) return "";
		
		return usuario.getId();
	}
}
