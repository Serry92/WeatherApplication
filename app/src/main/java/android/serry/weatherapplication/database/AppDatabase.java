package android.serry.weatherapplication.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.serry.weatherapplication.models.Bookmark;

@Database(entities = {Bookmark.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BookmarkDao bookmarkDao();
}
