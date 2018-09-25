package android.serry.weatherapplication.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.serry.weatherapplication.database.AppDatabase;
import android.serry.weatherapplication.listeners.OnLoadBookmarks;
import android.serry.weatherapplication.listeners.OnSuccessDeletedListener;
import android.serry.weatherapplication.listeners.OnUpdateDatabaseListener;
import android.serry.weatherapplication.utilities.Constants;

import java.util.List;

@Entity(tableName = "bookmark")
public class Bookmark implements Parcelable {
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

    /*for test*/
    public Bookmark(int id) {
        this.id = id;
    }

    protected Bookmark(Parcel in) {
        id = in.readInt();
        country = in.readString();
        lat = in.readString();
        lng = in.readString();
    }

    public static final Creator<Bookmark> CREATOR = new Creator<Bookmark>() {
        @Override
        public Bookmark createFromParcel(Parcel in) {
            return new Bookmark(in);
        }

        @Override
        public Bookmark[] newArray(int size) {
            return new Bookmark[size];
        }
    };

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

    private AppDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, Constants.DATABASE).allowMainThreadQueries()
                .addMigrations(Constants.addMigration(0, 1)).build();
    }

    public void insertBookmarkToDB(Bookmark bookmark, Context context, OnUpdateDatabaseListener onUpdateDatabaseListener) {
        getInstance(context).bookmarkDao().insert(bookmark);
        int count = getInstance(context).bookmarkDao().countBookmark();
        onUpdateDatabaseListener.onSuccess(count);
    }

    public void loadBookmarksFromDB(Context context, OnLoadBookmarks onLoadBookmarks) {
        List<Bookmark> bookmarkList = getInstance(context).bookmarkDao().getAll();
        onLoadBookmarks.onLoad(bookmarkList);
    }

    public void deleteBookmarkFromDB(Context context, int id, OnSuccessDeletedListener onSuccessDeletedListener) {
        getInstance(context).bookmarkDao().delete(id);
        onSuccessDeletedListener.onSuccessDeleted();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(lat);
        parcel.writeString(lng);
    }
}
