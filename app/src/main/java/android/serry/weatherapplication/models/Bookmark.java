package android.serry.weatherapplication.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.serry.weatherapplication.database.AppDatabase;
import android.serry.weatherapplication.listeners.OnLoadBookmarks;
import android.serry.weatherapplication.listeners.OnUpdateDatabaseListener;
import android.serry.weatherapplication.utilities.Constants;

import java.util.List;

@Entity(tableName = "bookmark")
public class Bookmark {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String country;
    private String lat;
    private String lng;


    public Bookmark(String country, String lat, String lng) {
        this.country = country;
        this.lat = lat;
        this.lng = lng;
    }

    public Bookmark() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void addBookmarkToDatabase(Bookmark bookmark, Context context, OnUpdateDatabaseListener onUpdateDatabaseListener) {
        AppDatabase appDatabase = Room.databaseBuilder(context, AppDatabase.class, Constants.DATABASE).allowMainThreadQueries()
                .addMigrations(Constants.addMigration(0, 1)).build();
        appDatabase.bookmarkDao().insert(bookmark);
        onUpdateDatabaseListener.onSuccess();
    }

    public void loadBookmarksFromDB(Context context, OnLoadBookmarks onLoadBookmarks) {
        AppDatabase appDatabase = Room.databaseBuilder(context, AppDatabase.class, Constants.DATABASE).allowMainThreadQueries()
                .addMigrations(Constants.addMigration(0, 1)).build();
        List<Bookmark> bookmarkList = appDatabase.bookmarkDao().getAll();
        onLoadBookmarks.onLoad(bookmarkList);
    }
}
