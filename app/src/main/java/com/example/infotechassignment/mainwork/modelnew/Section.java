
package com.example.infotechassignment.mainwork.modelnew;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Section extends Product {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
