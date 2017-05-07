/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes.phonecomponent;

import static lib.Tools.*;
import java.util.ArrayList;

/**
 *
 * @author JA
 */
public class Memory {
    
    //private final boolean SD_SIM;   //if the slot is share with sd card
    
    //SD CARD
    private final String SD_type;
    public String SD_size = "";
    
    //OLD SCHOOL
    private final String Phonebook;
    private final String Call_records;
    
    //INTERNAL
    public String Internal;
    public final String RAM;
    
    /**
     * Constructor
    // * @param slot  Is the SIM card slot sharing with SD card
     * @param SDt   Type of SD card
     * @param SDs   Size of SD card
     * @param Int   Size of internal memory
     * @param R     Size of RAM
     */
    public Memory(String SDt,String SDs,String Int,String R){
        //SD_SIM = slot;
        SD_type = SDt;
        SD_size = SDs;
        Internal = Int;
        RAM = R;
        Phonebook = "";
        Call_records = "";
    }
    
    /**
     * Constructor
    // * @param slot  Is the SIM card slot sharing with SD card
     * @param SDt   Type of SD card
     * @param SDs   Size of SD card
     * @param p     Phonebook size
     * @param c     If retains call records
     * @param Int   Size of internal memory
     * @param R     Size of RAM
     */
    public Memory(String SDt,String SDs,String p,String c,String Int,String R){
        //SD_SIM = slot;
        SD_type = SDt;
        SD_size = SDs;
        Phonebook = p;
        Call_records = c;
        Internal = Int;
        RAM = R;
    }
    
    /**
     * Return all information
     * 0 - SD card info
     * 1 - Phone book *
     * 2 - Call records *
     * 1 / 3 * - Internal memory info
     * \* if is keypad phone
     * @return all information
    */
    public ArrayList<String> getInfo(){
        ArrayList<String> info = new ArrayList<>();
        info = addInfos(info,new String[]{
            combine("Card slot",SD_type+" up to "+SD_size),
            combine("Phonebook",Phonebook),
            combine("Call Records",Call_records),
            combine("Internal",Internal+", "+RAM+" RAM")
        });
        return info;
    }
    
    
    
}
