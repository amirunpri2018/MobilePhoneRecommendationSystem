/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.ArrayList;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import knowledge.Result;
import static lib.Tools.*;
import static lib.Search.*;

/**
 *
 * @author JA
 */
public class Controller {
    
    //LOAD FILE LOCATION
    private static final String PATH = "";
    private static final String FILE = "hehe (2).csv";
    
    //CHECKER FOR INITIALIZED
    protected static boolean INIT = false;
    
    //ARRAYLIST OF CREATED PHONES
    public static ArrayList<MobilePhone> listOfPhone = new ArrayList<>();
    
    //ARRAYLIST OF TYPES
    public static ArrayList<String> TYPE = new ArrayList<>();
    private static String[] type = {"Smartphone","Keypad phone"};
    public static ArrayList<String> BRANDS = new ArrayList<>();
    private static String[] brand = {"Samsung","Apple","Nokia","LG","Sony","Blackberry"};
    
    //LOAD FILE FROM CSV
    public static void readFile(){
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
                    ignore = br.readLine();       //DETAILS
                    //
                    while(true){
                        //READING LINES
                        /*
                        Due to BufferedReader unable to bypass "\n" thing by design
                        This part will go right through it
                        */
                        boolean toRead = true;
                        line = holder;
                        if(!holding){
                            line += br.readLine();
                            String[] t = line.split(",");
                            if(TYPE.contains(t[0])&&t[t.length-1].equals("\"\"\"EOL\"\"\"")) toRead = false;
                        }
                        if(toRead){
                            while((holder = br.readLine())!=null){
                                String[] t = holder.split(",");
                                if(t[t.length-1].equals("\"\"\"EOL\"\"\"")){
                                    line+=combine("\n",holder);
                                    holding = false;
                                    holder = "";
                                    break;
                                }
                                if(TYPE.contains(t[0])) break;
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
//                        int i =0;
//                        for(String s:temp){
//                            System.out.println(wtf(i++)+" : "+s);
//                        }
//                        System.out.println("----------------------------");

                        //JUST IN CASE GOT ROGUE NULL VALUE
                        int pointer = temp.size()-2;
                        while(temp.get(pointer).equals("null")){pointer--;}
                        float rating = Float.parseFloat(temp.get(pointer));
                        //
                        
                        MobilePhone p;
                        COMBINELIMIT = 16;
                        
                        //SEE GOT WHAT BRAND THEN ADD WHAT BRAND HERE
                        /*
                        Phone format
                        p = new <BRAND>(line,Float.parseFloat(temp[temp.length-1]));
                        temp[temp.length-1] == Phone rating
                        */
                        switch(temp.get(1)){
                            case "Samsung":
                                p = new Samsung(line,rating);
                                break;
                            case "Apple":
                                p = new Apple(line,rating);
                                break;
                            case "Nokia":
                                p = new Nokia(line,rating);
                                break;
                            case "Blackberry":
                                p = new Blackberry(line,rating);
                                break;
                            case "Sony":
                                p = new Sony(line,rating);
                                break;
                            case "LG":
                                p = new LG(line,rating);
                                break;
                            default:
                                p = new Samsung("",0.0f);
                        }
                        //
                        listOfPhone.add(p);
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
        INIT = true;
    }
    
    public static void main(String[] args) {
        readFile();
//        int i =0;
//        if(!listOfPhone.isEmpty()){
//            for(MobilePhone p:listOfPhone){
////                System.out.println("PHONE "+(i++));
//                System.out.println(p.getFullName());
////                for(String s: p.getInfo()){
////                    System.out.println(s);
////                }
////                System.out.println("---------------------------");
//            }
//        }
        Scanner input = new Scanner(System.in);
        while(true){
            HashMap<String,ArrayList<String>> map = new HashMap<>();
            ArrayList<String> in = new ArrayList<>();
            
            System.out.print("Brand? #");
            in = new ArrayList<>();
            in.add(input.nextLine());
            map.put("brand",in);
            
            System.out.print("Price? #");
            in = new ArrayList<>();
            in.add(input.nextLine());
            map.put("price",in);
            
            System.out.print("os? #");
            in = new ArrayList<>();
            in.add(input.nextLine());
            map.put("os",in);
            
            System.out.print("Memory? #");
            in = new ArrayList<>();
            in.add(input.nextLine());
            map.put("memory",in);
            
            System.out.print("storage? #");
            in = new ArrayList<>();
            in.add(input.nextLine());
            map.put("storage",in);
            
            System.out.print("simslot? #");
            in = new ArrayList<>();
            in.add(input.nextLine());
            map.put("numberOfSimSlots",in);
            
            System.out.print("front camera? #");
            in = new ArrayList<>();
            in.add(input.nextLine());
            map.put("f_camera",in);
            
            System.out.print("back camera? #");
            in = new ArrayList<>();
            in.add(input.nextLine());
            map.put("b_camera",in);
            
            System.out.print("What to search? #");
            in = new ArrayList<>();
            in.add(input.nextLine());
            map.put("search", in);
            
            ArrayList<Result> temp = search(map);
            for(Result r:temp){
                System.out.println(r.getMP().getFullName());
            }
        }
    }
    
}
