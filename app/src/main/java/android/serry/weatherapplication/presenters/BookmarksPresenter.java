package android.serry.weatherapplication.presenters;

import android.view.View;

public interface BookmarksPresenter {

    void onCreate(View view);

    void loadBookmarks();

    void deleteBookmark(int id);
}
