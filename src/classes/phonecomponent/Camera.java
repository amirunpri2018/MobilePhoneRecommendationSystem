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
public class Camera {
    
    private boolean hasP = false;
    private boolean hasS = false;
    
    //Primary (Back) Camera
    public String pPhoto_Quality = "-";
    private String pFeature = "";
    
    //Feature
    private String cFeature = "-";
    
    //Video
//    private final String vVideo_Quality;
    private String vFeature = "-";
    
    //Secondary (Front) Camera
    public String sPhoto_Quality = "-";
    private String sFeature = "";
    
    public Camera(boolean p,boolean s,String pInfo,String cInfo,String vInfo,String sInfo){
        if(p){
            pPhoto_Quality = pInfo.split(",")[0];
            pFeature = pInfo.substring(pPhoto_Quality.length()+2);
            cFeature = cInfo;
            vFeature = vInfo;
            hasP = p;
        }
        if(s){
            hasS = s;
            sPhoto_Quality = sInfo.split(",")[0];
            sFeature = sInfo.substring(sPhoto_Quality.length()+2);
        }
    }
    
    
    /**
     * Returns all information
     *  0 - Primary
     *  1 - Feature
     *  2 - Video
     *  3 - Secondary
     * @return all information
    */
    public ArrayList<String> getInfo(){
        ArrayList<String> info = new ArrayList<>();
        info = addInfos(info,new String[]{
            combine("Primary", pPhoto_Quality+", "+pFeature ),
            combine("Feature",cFeature),
            combine("Video",vFeature),
            combine("Secondary",sPhoto_Quality+", "+sFeature)
        });
        return info;
    }
    
}
