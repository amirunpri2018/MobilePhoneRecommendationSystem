/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phones.phonecomponent;

import static lib.Tools.*;
import java.util.ArrayList;

/**
 *
 * @author JA
 */
public class Camera {
    
//    private boolean hasP = false;
//    private boolean hasS = false;
    
    //Primary (Back) Camera
    public String pPhoto_Quality = " ";
    private String pFeature = " ";
    
    //Feature
    private String cFeature = " ";
    
    //Video
//    private final String vVideo_Quality;
    private String vFeature = " ";
    
    //Secondary (Front) Camera
    public String sPhoto_Quality = " ";
    private String sFeature = " ";
    
    public Camera(String pInfo,String cInfo,String vInfo,String sInfo){
        if(pInfo!=null && pInfo.length()!=0 && !pInfo.equals(" ")){
            if(pInfo.equals("No")){
                pPhoto_Quality = "No";
            }else{
                pPhoto_Quality = pInfo.split(",")[0];
            }
            pFeature = pInfo;
            cFeature = cInfo;
            vFeature = vInfo;
        }
        if(sInfo!=null && sInfo.length()!=0 && !sInfo.equals(" ")){
            if(sInfo.equals("No")){
                sPhoto_Quality = "No";
            }else{
                sPhoto_Quality = sInfo.split(",")[0];
            }
            sFeature = sInfo;
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
            combine("Primary", pFeature ),
            combine("Feature",cFeature),
            combine("Video",vFeature),
            combine("Secondary", sFeature )
        });
        return info;
    }
    
}
