package com.example.myapplication2.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import com.example.myapplication2.model.category.Category;
import com.example.myapplication2.model.productcategory.ProductCategory;

@Database(entities = {Category.class, ProductCategory.class}, version = 1, exportSchema = false)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {
    private static final String DATABASE_NAME = "Room-database";
    private static RoomDatabase instance;


    public static synchronized RoomDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), RoomDatabase.class, DATABASE_NAME)
//                    .addMigrations(MIGRATION_1_2)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract QueryDAO queryDAO();
}
