package com.example.amedfareed.heattransfer.model;

import com.example.amedfareed.heattransfer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amedfareed on 04/05/18.
 */

public class Heat {
    String name;
    String desc;
    String explain;

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    int ImageId;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    List<Heat> heatList;

    public Heat() {

    }
    public Heat(String name,String desc, String explain ,int imageId) {
        this.name = name;
        this.desc = desc;
        this.explain = explain;
        ImageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }




}
