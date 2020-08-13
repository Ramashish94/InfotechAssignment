
package com.example.infotechassignment.mainwork.modelnew;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category extends Addition {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("template")
    @Expose
    private String template;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

}
