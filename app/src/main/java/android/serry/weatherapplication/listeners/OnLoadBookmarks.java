package android.serry.weatherapplication.listeners;

import android.serry.weatherapplication.models.Bookmark;

import java.util.List;

public interface OnLoadBookmarks {
    void onLoad(List<Bookmark> bookmarks);
}
