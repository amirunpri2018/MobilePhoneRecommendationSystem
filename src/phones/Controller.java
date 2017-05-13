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
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import knowledge.Result;
import lib.Search;
import static lib.Tools.*;

/**
 *
 * @author JA
 */
public class Controller {
    
    //LOAD FILE LOCATION
    private static final String PATH = "";
    private static final String FILE = "hehe (3).csv";
    
    //CHECKER FOR INITIALIZED
    protected static boolean INIT = false;
    
    //ARRAYLIST OF CREATED PHONES
    public static ArrayList<MobilePhone> listOfPhone = new ArrayList<>();
    
    //ARRAYLIST OF TYPES
    public static ArrayList<String> TYPE = new ArrayList<>();
    private static String[] type = {"Smartphone","Keypad"};
    public static ArrayList<String> BRANDS = new ArrayList<>();
    private static String[] brand = {"Samsung","Apple","Nokia","LG","Sony","Blackberry"};
    
    //LOAD FILE FROM CSV
    public static void readFile(){
        System.out.println("ATTEMPT TO READ FILE");
        if(!INIT){
            for(String s:type)TYPE.add("\"\"\""+s+"\"\"\"");
            for(String s:brand)BRANDS.add(s);
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
                        //READING LINES
                        /*
                        Due to BufferedReader unable to bypass "\n" thing by design
                        This part will go right through it
                        */
                        boolean toRead = true;
                        line = holder;
                        if(!holding){line = br.readLine();holding = false;}
//                        System.out.println("line: "+line); //DEBUG
                        String[] t = line.split(",");
                        if(TYPE.contains(t[0])&&t[t.length-1].equals("\"\"\"EOL\"\"\"")){toRead = false;}
                        if(toRead){
                            while((holder = br.readLine())!=null){
//                                System.out.println("holder: "+holder); //DEBUG
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
                                    holding = false;
                                    holder = "";
                                }else{
                                    holding = true;
                                }
                            }
                        }
                        if(holder==null || line ==null) break;
                        //
                        
                        ArrayList<String> temp = readLine(line);
////                        Debugging
//                        int i =0;
//                        for(String s:temp){
//                            System.out.println(wtf(i++)+" : "+s);
//                        }
//                        System.out.println("----------------------------");

                        //JUST IN CASE GOT ROGUE NULL VALUE
                        int pointer = temp.size()-2;
                        while(temp.get(pointer).equals("null")){pointer--;}
                        Float rating = Float.parseFloat(temp.get(pointer));
                        //
                        
                        MobilePhone p;
                        COMBINELIMIT = 16;
                        
                        //SEE GOT WHAT BRAND THEN ADD WHAT BRAND HERE
                        /**
                         * Phone format
                         * p = new <BRAND>(line,Float.parseFloat(temp[temp.length-1]));
                         * temp[temp.length-1] == Phone rating
                         * Auto create class dynamically
                         */
                        String className = "phones.brands."+temp.get(1);
                        if(temp.get(0).equalsIgnoreCase("smartphone")) className+="S";
                        else className+="K";
                        try {
                            Class c = Class.forName(className);
                            Constructor con = c.getConstructor(line.getClass(),rating.getClass());
                            p = (MobilePhone) con.newInstance(line,rating);
                            listOfPhone.add(p);
                        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //Outdated hardcode
//                        switch(temp.get(1)){
//                            case "Samsung":     p = new SamsungS(line,rating);break;
//                            case "Apple":       p = new AppleS(line,rating);break;
//                            case "Nokia":       p = new NokiaS(line,rating);break;
//                            case "Blackberry":  p = new BlackberryS(line,rating);break;
//                            case "Sony":        p = new SonyS(line,rating);break;
//                            case "LG":          p = new LGS(line,rating);break;
//                            case "Motorola":    p = new MotorolaK(line,rating);break;
//                            default:            p = new SamsungS("",0.0f); //SURE ERROR
//                        }
                        //
                    }
                }catch(FileNotFoundException ex) {
                    System.out.println("!!!DATABASE NOT FOUND!!!");
                    System.exit(1);
                } catch (IOException e){
                    System.out.println("ERROR FILE READER FILE");
                }catch(NullPointerException e){
                    //FILE FINISH READING'
                }
            }else{
                System.out.println("!!!DATABASE NOT FOUND!!!");
                System.exit(1);
            }
        }else{
            //FILE ALREADY LOADED
        }
        System.out.println("FILE READED SUCCESSFULLY");
        INIT = true;
        listOfPhone = merge_sort(listOfPhone);
    }
    
    //TESTING
    public static void main(String[] args) {
        readFile();
        int i =0;
        if(!listOfPhone.isEmpty()){
            for(MobilePhone p:listOfPhone){
//                System.out.println("PHONE "+(i++));
                System.out.println(p.getFullName());
//                System.out.println(p.getInfo().toString());
//                HashMap<String,ArrayList<String>> h = (p.getInfo2());
//                System.out.println(h.keySet());
//                System.out.println(h.values());
//                for(String s: p.getInfo()){
//                    System.out.println(s);
//                }
//                System.out.println("---------------------------");
            }
        }
        //<editor-fold defaultstate="collapsed" desc="TEST SEARCHING">
//        Scanner input = new Scanner(System.in);
//        while(true){
//            HashMap<String,ArrayList<String>> map = new HashMap<>();
//            ArrayList<String> in = new ArrayList<>();
//            
//            System.out.print("Brand? #");
//            in = new ArrayList<>();
//            in.add(input.nextLine());
//            map.put("brand",in);
//            
//            System.out.print("Price? #");
//            in = new ArrayList<>();
//            in.add(input.nextLine());
//            map.put("price",in);
//            
//            System.out.print("os? #");
//            in = new ArrayList<>();
//            in.add(input.nextLine());
//            map.put("os",in);
//            
//            System.out.print("Memory? #");
//            in = new ArrayList<>();
//            in.add(input.nextLine());
//            map.put("memory",in);
//            
//            System.out.print("storage? #");
//            in = new ArrayList<>();
//            in.add(input.nextLine());
//            map.put("storage",in);
//            
//            System.out.print("simslot? #");
//            in = new ArrayList<>();
//            in.add(input.nextLine());
//            map.put("numberOfSimSlots",in);
//            
//            System.out.print("front camera? #");
//            in = new ArrayList<>();
//            in.add(input.nextLine());
//            map.put("f_camera",in);
//            
//            System.out.print("back camera? #");
//            in = new ArrayList<>();
//            in.add(input.nextLine());
//            map.put("b_camera",in);
//            
//            System.out.print("What to search? #");
//            in = new ArrayList<>();
//            in.add(input.nextLine());
//            map.put("search", in);
//            
//            Search search = new Search();
//            ArrayList<Result> temp = search.search(map);
//            for(Result r:temp){
//                System.out.println(r.getMP().getFullName());
//            }
//        }
        //</editor-fold>
    }
    
}
