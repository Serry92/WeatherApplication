package android.serry.weatherapplication.presenters;

import android.content.Context;
import android.serry.weatherapplication.listeners.OnLoadBookmarks;
import android.serry.weatherapplication.models.Bookmark;
import android.serry.weatherapplication.viewsFragments.BookmarksView;
import android.view.View;

import java.util.List;

public class BookmarksPresenterImp implements BookmarksPresenter,OnLoadBookmarks {
    private BookmarksView bookmarksView;
    private Context context;

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
        Bookmark bookmark=new Bookmark();
        bookmark.loadBookmarksFromDB(context,this);
    }

    @Override
    public void onLoad(List<Bookmark> bookmarks) {
        bookmarksView.setViews(bookmarks);
    }
}
