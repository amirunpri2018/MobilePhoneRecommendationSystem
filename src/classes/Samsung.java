/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;
import static lib.Tools.*;
/**
 *
 * @author JA
 */
public class Samsung extends SmartPhone{
    
    public Samsung(String information){
        String[] info = information.split(" ");
        int i =0;
        brand = loadInfo(info[i++]);
        name = loadInfo(info[i++]);
        price = loadInfo(info[i++]);
        image = loadInfo(info[i++]);
        c_network = loadInfo(info[i++]);
        c_launch = loadInfo(info[i++]);
        c_body = loadInfo(info[i++]);
        c_display = loadInfo(info[i++]);
        
    }
    
}
