
package lib;

import java.util.ArrayList;
import java.util.HashMap;
import static classes.Controller.listOfPhone;
import static classes.Controller.BRANDS;
import classes.MobilePhone;
import knowledge.Result;
import static lib.Tools.*;

public class Search {
    
    private static ArrayList<Result> result;
    private static ArrayList<Result> finalResult;
    
    /**
     * "fuzziness" = Ration of the fuzziness. 
     * set this if want searching to show up more things
     * the higher the more accurate the results but less phone match
     * the lower the less accurate the results but more phone match
     * 
     * A value of 0.8 means: 
     * difference between the word to find and the found words is less than 20%.
    */
    private static final double fuzziness = 0.5;
    
    //Search by name or brand or both
    public static ArrayList<Result> search(HashMap<String,ArrayList<String>> map) {
        result = new ArrayList<>();
        finalResult = new ArrayList<>();
        String input = map.get("search").get(0);
        searchByName(input);
        System.out.println("");
        ArrayList<ArrayList<String>> filters = new ArrayList<>();
        filters.add(map.get("brand"));
        filters.add(map.get("price"));
        filters.add(map.get("os"));
        filters.add(map.get("memory"));
        filters.add(map.get("storage"));
        filters.add(map.get("numberOfSimSlots"));
        filters.add(map.get("f_camera"));
        filters.add(map.get("b_camera"));
        /**
         * ArrayList of filters from Mobile Phone
         * 0 = Brand        | brand
         * 1 = Price        | price
         * 2 = OS           | os
         * 3 = Memory       | memory
         * 4 = Storage      | storage
         * 5 = SIM slots    | numberOfSimSlots
         * 6 = Camera front | f_camera
         * 7 = Camera back  | b_camera
         */
        int filterMode = 0;
        while(filterMode<filters.size()){
//            for(Result r:result){
//                System.out.println(r.getMP().getFullName());
//            }
//            System.out.println("filtermode: "+filterMode);
            finalResult = new ArrayList<>();
            if(filters.get(filterMode).get(0).equals("")){
                filterMode++;
                continue;
            }
            filter(filterMode,filters.get(filterMode++));
            result = finalResult;
        }
        return result;
    }
    
    public static void searchByName(String input){
        String[] toSearch = input.split(" ");
        int mode = 0;
        for(String s:BRANDS){
            if(toSearch[0].equalsIgnoreCase(s)){
                mode = 3;
                break;
            }
        }
        if(input.length()>0 && mode!=3) mode = 2;
        if (toSearch.length>1 && mode==3) mode=1;
        fuzzySearch(input,mode);
        for(Result r:normalSearch(input)){
            boolean isNew = true;
            for(Result t:result){
                if(t.getMP().getFullName().equals(r.getMP().getFullName())){
                    isNew = false;
                    break;
                }
            }
            if(isNew) result.add(r);
        }
    }
    
    public static void filter(int filterBy,ArrayList<String> constraint){
        if(constraint.get(0).equals("")) return;
        float lower = 0f;
        float upper = Float.MAX_VALUE;
        String lowerB = "";
        String upperB = "";
        if(filterBy==1){
            if(!constraint.get(0).isEmpty()) lower = Float.parseFloat(constraint.get(0));
            if(!constraint.get(1).isEmpty()) upper = Float.parseFloat(constraint.get(1));
        }else if(filterBy==3||filterBy==4){
            lowerB = constraint.get(0);
        }else if(filterBy==6||filterBy==7){
            lowerB = constraint.get(0).split(" ")[0]+" MP";
            if(constraint.contains("No camera")) lowerB = "No";
            else upperB = constraint.get(constraint.size()-1).split(" ")[2]+" MP";
        }
        
        for(int i=0;i<result.size();i++){
            MobilePhone mp = result.get(i).getMP();
            ArrayList<String> info = mp.FILTER();
            //Condition for PRICE
            if(filterBy==1){
                float price = Float.parseFloat(info.get(1));
                if(price>=lower && price<=upper){
                    finalResult.add(result.get(i));
                }
            }else if(filterBy==0||filterBy==2||filterBy==5){
                for(String c:constraint){
                    //Condition for BRAND and OS
                    if(info.get(filterBy).toLowerCase().contains(c.toLowerCase())){
                        finalResult.add(result.get(i));
                    }
                }
            }else if(filterBy==3||filterBy==4){
                if(compareByte(info.get(filterBy),lowerB)>=0){
                    finalResult.add(result.get(i));
                }
            }else if(filterBy==6||filterBy==7){
                if(lowerB.equals("No")){
                    if(info.get(filterBy).equals("No")){
                        finalResult.add(result.get(i));
                    }
                }else if(upperB.equals("and MP")){
                    if(compareByte(info.get(filterBy),lowerB)>=0){
                        finalResult.add(result.get(i));
                    }
                }else{
                    if(compareByte(info.get(filterBy),lowerB)>=0 && compareByte(info.get(filterBy),upperB)<=0){
                        finalResult.add(result.get(i));
                    }
                }
            }
        }
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="Normal Search">
    private static ArrayList<Result> normalSearch(String str){
        ArrayList<Result> result = new ArrayList<>();
        for(MobilePhone mp:listOfPhone){
            String fullName = mp.getFullName();
            if(fullName.toLowerCase().contains(str.toLowerCase())){
                result.add(new Result(mp));
            }
        }return result;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Fuzzy Search">
    ///FUZZY SEARCH
    ///---------------------------------------------------------------------
    /// Fuzzy searches a list of Strings.
    /// Parameters
    /// "word"          = The word to find.
    /// </param>
    
    /// <returns>
    /// The list with the found words.
    /// </returns>
    private static int LevenshteinDistance(String src, String dest){
        int[][] d = new int[src.length() + 1][dest.length() + 1];
        int i, j, cost;
        char[] str1 = src.toCharArray();
        char[] str2 = dest.toCharArray();
        
        for (i = 0; i <= str1.length; i++){d[i][0] = i;}
        for (j = 0; j <= str2.length; j++){d[0][j] = j;}
        for (i = 1; i <= str1.length; i++){
            for (j = 1; j <= str2.length; j++){
                if (str1[i - 1] == str2[j - 1])
                    cost = 0;
                else
                    cost = 1;
                d[i][j] =
                    Math.min(
                        d[i - 1][j] + 1,                    // Deletion
                        Math.min(
                            d[i][j - 1] + 1,                // Insertion
                            d[i - 1][j - 1] + cost));       // Substitution

                if ((i > 1) && (j > 1) && (str1[i - 1] == str2[j - 2]) && (str1[i - 2] == str2[j - 1]))
                {
                    d[i][j] = Math.min(d[i][j], d[i - 2][j - 2] + cost);
                } 
            }
        }
        return d[str1.length][str2.length];
    }
    
    private static void fuzzySearch(String word, int mode){
        for (int i=0;i<listOfPhone.size();i++){
            String s="";
            if(mode==0){
                result.add(new Result(listOfPhone.get(i)));
                continue;
            }
            else if(mode==1)    s = listOfPhone.get(i).getFullName();
            else if(mode==2)    s = listOfPhone.get(i).getName();
            else if(mode==3)    s = listOfPhone.get(i).getBrand();
            
            // Calculate the Levenshtein-distance:
            int levenshteinDistance =
                LevenshteinDistance(word, s);

            // Length of the longer String:
            int length = Math.max(word.length(), s.length());

            // Calculate the score:
            double score = 1.0 - (double)levenshteinDistance / length;

            // Match?
            if (score >= fuzziness)
                result.add(new Result(listOfPhone.get(i)));
        }
    }
    //</editor-fold>
}
