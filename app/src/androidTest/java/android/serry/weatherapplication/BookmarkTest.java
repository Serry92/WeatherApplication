package android.serry.weatherapplication;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.serry.weatherapplication.database.AppDatabase;
import android.serry.weatherapplication.database.BookmarkDao;
import android.serry.weatherapplication.models.Bookmark;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)

public class BookmarkTest {
    private BookmarkDao bookmarkDao;
    private AppDatabase appDatabase;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        bookmarkDao = appDatabase.bookmarkDao();
    }

    @After
    public void closeDb() {
        appDatabase.close();
    }

    @Test
    public void tesFetchBookmarksShouldGetEmptyListIfTableIsEmpty() {
        List<Bookmark> bookmarkList = bookmarkDao.getAll();
        assertTrue(bookmarkList.isEmpty());
    }

    @Test
    public void testClearBookmarksTable() {
        Bookmark bookmark = new Bookmark();
        bookmarkDao.insert(bookmark);

        bookmarkDao.deleteAll();
        assert (bookmarkDao.getAll().isEmpty());
    }

    @Test
    public void testInsertBookmark() {
        Bookmark bookmark = new Bookmark();
        bookmarkDao.insert(bookmark);

        List<Bookmark> bookmarkList = appDatabase.bookmarkDao().getAll();
        assertEquals(1, bookmarkList.size());
    }
}
