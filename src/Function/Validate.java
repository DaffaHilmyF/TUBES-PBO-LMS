/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

/**
 *
 * @author daffa
 */
public class Validate {
    
    
    
    public static void sanitizeInputStringNotNull(String ...givenInput) {
        for(String data: givenInput){
            if(data == null) throw new NullPointerException();
        }
    }
    
    public static void sanitizeInputIntegerNotOverflow(int ...givenInput) {
        for(int data: givenInput){
            if(data >= Integer.MAX_VALUE) throw new ArithmeticException();
        }
    }
    
    
    
}
