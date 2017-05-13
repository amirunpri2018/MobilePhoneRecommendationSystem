/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phones;

import java.util.ArrayList;
import static lib.Tools.readLine;

/**
 *
 * @author JA
 */
public class KeypadPhone extends MobilePhone{
    
    
    public KeypadPhone(String information){
        super(information);
        keypad = true;
        touchscreen = false;
        loadAdditionalInfo(information);
    }
    
    private void loadAdditionalInfo(String information){
        ArrayList<String> info = readLine(information);
        try{
            c_feature.Games = info.get(loadDao++);
            c_memory.oldSchool(info.get(loadDao++),info.get(loadDao++));
            c_body.keyboard = info.get(loadDao++);
            loaded = true;
        }catch(ArrayIndexOutOfBoundsException e){
            loaded = false;
        }
    }
    
}
