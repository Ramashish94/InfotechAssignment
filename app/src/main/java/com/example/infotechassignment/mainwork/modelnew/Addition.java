
package com.example.infotechassignment.mainwork.modelnew;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Addition {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
