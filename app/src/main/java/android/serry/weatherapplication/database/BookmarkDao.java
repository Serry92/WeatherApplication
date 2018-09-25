package android.serry.weatherapplication.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.serry.weatherapplication.models.Bookmark;

import java.util.List;

@Dao
public interface BookmarkDao {
    @Query("SELECT * FROM Bookmark")
    List<Bookmark> getAll();

    @Query("SELECT * From BOOKMARK WHERE id= :id")
    List<Bookmark> getBookmark(int id);

    @Query("SELECT COUNT(*) from Bookmark")
    int countBookmark();

    @Insert
    void insert(Bookmark... bookmarks);

    @Query("DELETE FROM BOOKMARK WHERE id= :id")
    void delete(int id);

    @Query("DELETE FROM Bookmark")
    void deleteAll();
}
