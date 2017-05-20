/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phones;

import java.util.ArrayList;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static lib.Tools.*;

/**
 *
 * @author JA
 */
public class Controller {
    
    //LOAD FILE LOCATION
    private static final String PATH = "";
    private static final String FILE = "database.csv";
    
    //CHECKER FOR INITIALIZED
    public static boolean INIT = false;
    
    //ARRAYLIST OF CREATED PHONES
    public static ArrayList<MobilePhone> listOfPhone = new ArrayList<>();
    
    //ARRAYLIST OF TYPES
    public static ArrayList<String> TYPE = new ArrayList<String>(){{
        add("\"\"\"Smartphone\"\"\"");
        add("\"\"\"Keypad\"\"\"");
    }};
    public static ArrayList<String> BRANDS = new ArrayList<>();
    
    //<editor-fold defaultstate="collapsed" desc="Reading from database">
    public static void readFile(){
        System.out.println("READING DATABASE");
        if(!INIT){
            if(createFile(PATH,FILE)){
                try {
                    BufferedReader br = new BufferedReader(new FileReader(FILE));
                    String line;
                    String holder="";
                    boolean holding=false;
                    //DONOT REMOVE THESE
                    String ignore = br.readLine();       //GROUP
                    ignore = br.readLine();              //DETAILS
                    //
                    while(true){
                        //<editor-fold defaultstate="collapsed" desc="Reading the file">
                        //READING LINES
                        /*
                        Due to BufferedReader unable to bypass "\n" thing by design
                        This part will go right through it
                        */
                        boolean toRead = true;
                        line = holder;
                        if(!holding){line = br.readLine();}
                        if(line==null || holder==null) break;
                        String[] t = line.split(",");
                        if(TYPE.contains(t[0])&&t[t.length-1].equals("\"\"\"EOL\"\"\"")){toRead = false;}
                        if(toRead){
                            while((holder = br.readLine())!=null){
                                t = holder.split(",");
                                if(t[t.length-1].equals("\"\"\"EOL\"\"\"")){
                                    line+=combine("\n",holder);
                                    holding = false;
                                    holder = "";
                                    break;
                                }
                                if(TYPE.contains(t[0])){
                                    holding = true;
                                    break;
                                }
                                if(holder.charAt(0)=='-'){
                                    line+=combine("\n",holder); 
                                    holder = "";
                                    holding = false;
                                }else{
                                    holding = true;
                                }
                            }
                        }
                        //</editor-fold>
                        
                        ArrayList<String> temp = readLine(line);
                        MobilePhone p;
                        COMBINELIMIT = 16;
                        //JUST IN CASE GOT ROGUE NULL VALUE
                        int pointer = temp.size()-2;
                        while(temp.get(pointer).equals("null")){pointer--;}
                        Float rating = Float.parseFloat(temp.get(pointer));
                        //
                        //<editor-fold defaultstate="collapsed" desc="Creating new instances of phones">
                        //SEE GOT WHAT BRAND THEN ADD WHAT BRAND HERE
                        /**
                         * Phone format
                         * p = new <BRAND>(line,Float.parseFloat(temp[temp.length-1]));
                         * temp[temp.length-1] == Phone rating
                         * Auto create class dynamically
                         */
                        String brandName = temp.get(1);
                        BRANDS.add(brandName);
                        if(temp.get(0).equalsIgnoreCase("smartphone")) brandName+="S";
                        else brandName+="K";
                        if(!checkPhoneJAVA(brandName)){
                            createPhoneJAVA(brandName);
                        }
                        String className = "phones.brands."+brandName;
                        try {
                            Class c = Class.forName(className);
                            Constructor con = c.getConstructor(line.getClass(),rating.getClass());
                            p = (MobilePhone) con.newInstance(line,rating);
                            listOfPhone.add(p);
                        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //</editor-fold>
                    }
                }catch(IOException | NullPointerException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    System.exit(1);
                }
            }else{
                System.out.println("!!!DATABASE NOT FOUND!!!");
                System.exit(1);
            }
        }
//        displayPhone(listOfPhone);
        listOfPhone = merge_sort(listOfPhone);
        INIT = true;
        System.out.println("DATABASE READED SUCCESSFULLY");
    }
    //</editor-fold>
    
}
