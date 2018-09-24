package android.serry.weatherapplication.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.serry.weatherapplication.models.Bookmark;

import java.util.List;

@Dao
public interface BookmarkDao {
    @Query("SELECT * FROM Bookmark")
    List<Bookmark> getAll();

    @Query("SELECT COUNT(*) from Bookmark")
    int countBookmark();

    @Insert
    void insert(Bookmark... bookmarks);

    @Delete
    void delete(Bookmark bookmark);

    @Query("DELETE FROM Bookmark")
    void deleteAll();
}
