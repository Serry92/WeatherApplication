package android.serry.weatherapplication.viewsFragments;

import android.serry.weatherapplication.models.Bookmark;
import android.view.View;

import java.util.List;

public interface BookmarksView {
    void initViews(View view);

    void setViews(List<Bookmark> bookmarks);

    void refreshView();
}
