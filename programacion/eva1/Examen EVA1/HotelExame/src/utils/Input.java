
package utils;

import java.util.Scanner;


public class Input {

    private static Scanner scn=new Scanner(System.in);
    private static final String CANCELSTR="*";

    public static String getStr(String msg) throws CancelException {
        System.out.print(msg+" ("+CANCELSTR+" para cancelar): ");
        String input=scn.nextLine();
        if (input.equals(CANCELSTR)) throw new CancelException();
        return input;
    }
    
      
    public static String validString(String msg,Validator validator) throws CancelException {
        boolean ok=false;
        String str;
        
        do {
            str=getStr(msg);
            if (!validator.isValid(str)) System.out.println("\t"+validator.message());
            else                         ok=true;
        } while(!ok);
        return str;
    }
    
    public static String getDni(String msg) throws CancelException {
        return validString(msg,new DniValidator());
    }

}