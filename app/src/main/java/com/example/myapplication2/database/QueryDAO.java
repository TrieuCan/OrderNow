package com.example.myapplication2.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.myapplication2.model.category.Category;
import com.example.myapplication2.model.productcategory.ProductCategory;

import java.util.List;

@Dao
public interface QueryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertCategory(Category category);

    @Query("SELECT * FROM Category")
    List<Category> getListCategory();

    @Transaction
    @Query("SELECT *FROM Category Where Category_NAME like :nameCategory")
    List<Category> checkCategory(String nameCategory);

    @Update
    void updateCategory(Category category);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertProductCategory(ProductCategory productCategory);

    @Query("SELECT * FROM PCategory")
    List<ProductCategory> getListProductCatagory();

    @Transaction
    @Query("SELECT *FROM PCategory Where Category_ID = :id")
    List<ProductCategory> checkProductCategory(int id);

    @Update
    void updateProductCategory(ProductCategory pCategory);
}
