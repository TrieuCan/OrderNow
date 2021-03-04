package com.example.myapplication2.model.category;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Category",
        indices = {@Index(value = "Category_NAME", unique = true)})
public class Category implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Category_ID")
    private int CID;

    @ColumnInfo(name = "Category_NAME")
    private String nameCategory;

    @ColumnInfo(name = "Category_IMG")
    private int imageCategory;

    public Category(String nameCategory, int imageCategory) {
        this.nameCategory = nameCategory;
        this.imageCategory = imageCategory;
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getImageCategory() {
        return imageCategory;
    }

    public void setImageCategory(int imageCategory) {
        this.imageCategory = imageCategory;
    }
}
