
package lib;

import java.util.ArrayList;
import static classes.Controller.listOfPhone;
import static classes.Controller.BRANDS;
import classes.MobilePhone;
import knowledge.Result;

public class Search {
    
    private static ArrayList<Result> result;
    
    /**
     * "fuzziness" = Ration of the fuzziness. 
     * set this if want searching to show up more things
     * the higher the more accurate the results but less phone match
     * the lower the less accurate the results but more phone match
     * 
     * A value of 0.8 means: 
     * difference between the word to find and the found words is less than 20%.
    **/
    private static final double fuzziness = 0.5;
    
    //Search by name or brand or both
    public static ArrayList<Result> search(String input) {
        result = new ArrayList<>();
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
        return result;
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
