package android.serry.weatherapplication.presenters;

import android.content.Context;
import android.serry.weatherapplication.listeners.OnLoadBookmarks;
import android.serry.weatherapplication.listeners.OnSuccessDeletedListener;
import android.serry.weatherapplication.models.Bookmark;
import android.serry.weatherapplication.viewsFragments.BookmarksView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class BookmarksPresenterImp implements BookmarksPresenter, OnLoadBookmarks, OnSuccessDeletedListener {
    private BookmarksView bookmarksView;
    private Context context;
    private Bookmark bookmark;

    public BookmarksPresenterImp(BookmarksView bookmarksView, Context context) {
        this.bookmarksView = bookmarksView;
        this.context = context;
    }

    @Override
    public void onCreate(View view) {
        bookmarksView.initViews(view);
    }

    @Override
    public void loadBookmarks() {
        bookmark = new Bookmark();
        bookmark.loadBookmarksFromDB(context, this);
    }

    @Override
    public void deleteBookmark(int id) {
        if (bookmark == null)
            bookmark = new Bookmark();
        bookmark.deleteBookmarkFromDB(context, id, this);
    }

    @Override
    public void onLoad(List<Bookmark> bookmarks) {
        bookmarksView.setViews(bookmarks);
    }

    @Override
    public void onSuccessDeleted() {
        bookmarksView.showDeletedMessage();
    }
}
