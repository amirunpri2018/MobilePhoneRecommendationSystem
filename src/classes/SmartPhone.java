/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

/**
 *
 * @author JA
 */
public class SmartPhone extends MobilePhone{
    
    
    public SmartPhone(String information){
        super(information);
        keypad = false;
        touchscreen = true;
    }
    
}
