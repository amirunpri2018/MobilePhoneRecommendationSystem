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
public class KeypadPhone extends MobilePhone{
    
    
    public KeypadPhone(String information){
        super(information);
        keypad = true;
        touchscreen = false;
    }
    
    public void loadAdditionalInfo(String information){
        String[] info = information.split("\t");
        try{
            c_feature.Games = info[loadDao++];
            c_memory.oldSchool(info[loadDao++],info[loadDao++]);
        }catch(ArrayIndexOutOfBoundsException e){
            loaded = false;
        }
    }
    
}
