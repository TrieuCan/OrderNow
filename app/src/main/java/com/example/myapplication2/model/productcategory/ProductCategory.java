package com.example.myapplication2.model.productcategory;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.myapplication2.model.category.Category;

import java.io.Serializable;

@Entity(tableName = "PCategory",
        foreignKeys = {
                @ForeignKey(entity = Category.class,
                        parentColumns = "Category_ID",
                        childColumns = "Category_ID")
        },
        indices = {@Index(value = "PCategory_Name", unique = true)})
public class ProductCategory implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "PCategory_ID")
    public int PID;

    @ColumnInfo(name = "Category_ID")
    public int cID;

    @ColumnInfo(name = "PCategory_Name")
    private String productCgrName;

    @ColumnInfo(name = "PCategory_IMG")
    private int productCgrImage;

    @ColumnInfo(name = "Price")
    private float price;

    @ColumnInfo(name = "TyPe")
    private String typeProduct;

    @ColumnInfo(name = "Detail")
    private String detail;

    @ColumnInfo(name = "Sale")
    private String sale;

    @ColumnInfo(name = "Favorite")
    private int productFavorite;


    public ProductCategory(int cID, String productCgrName, int productCgrImage, float price, String typeProduct, String detail, String sale, int productFavorite) {
        this.cID = cID;
        this.productCgrName = productCgrName;
        this.productCgrImage = productCgrImage;
        this.price = price;
        this.typeProduct = typeProduct;
        this.detail = detail;
        this.sale = sale;
        this.productFavorite = productFavorite;
    }

    public int getPID() {
        return PID;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getProductCgrName() {
        return productCgrName;
    }

    public int getProductCgrImage() {
        return productCgrImage;
    }

    public void setProductCgrName(String productCgrName) {
        this.productCgrName = productCgrName;
    }

    public void setProductCgrImage(int productCgrImage) {
        this.productCgrImage = productCgrImage;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getProductFavorite() {
        return productFavorite;
    }

    public void setProductFavorite(int productFavorite) {
        this.productFavorite = productFavorite;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
