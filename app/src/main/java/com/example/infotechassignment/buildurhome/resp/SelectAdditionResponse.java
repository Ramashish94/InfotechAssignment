
package com.example.infotechassignment.buildurhome.resp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SelectAdditionResponse {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private String status;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Category {

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

    public static class Product {

        @SerializedName("product_id")
        @Expose
        private Integer productId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("sku")
        @Expose
        private String sku;
        @SerializedName("href")
        @Expose
        private String href;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("category_id")
        @Expose
        private Integer categoryId;
        @SerializedName("option")
        @Expose
        private Object option;

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public Object getOption() {
            return option;
        }

        public void setOption(Object option) {
            this.option = option;
        }

    }
}
