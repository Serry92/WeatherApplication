package android.serry.weatherapplication.viewsFragments;

import android.content.Intent;
import android.os.Bundle;
import android.serry.weatherapplication.R;
import android.serry.weatherapplication.adapters.BookmarksAdapter;
import android.serry.weatherapplication.listeners.OnBookmarkClickListener;
import android.serry.weatherapplication.listeners.OnDeleteBookmarkClickListener;
import android.serry.weatherapplication.models.Bookmark;
import android.serry.weatherapplication.presenters.BookmarksPresenterImp;
import android.serry.weatherapplication.utilities.Constants;
import android.serry.weatherapplication.viewsActivities.BookmarkWeatherActivity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

public class BookmarksFragment extends Fragment implements BookmarksView, OnBookmarkClickListener, OnDeleteBookmarkClickListener {
    private static BookmarksFragment instanceMapFragment;
    private RecyclerView rvBookmarks;
    private BookmarksPresenterImp bookmarksPresenterImp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookmarksPresenterImp = new BookmarksPresenterImp(this, getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookmarks, container, false);
        bookmarksPresenterImp.onCreate(view);
        return view;

    }

    public static synchronized BookmarksFragment getInstance() {
        if (instanceMapFragment == null) {
            instanceMapFragment = new BookmarksFragment();
        }
        return new BookmarksFragment();
    }

    @Override
    public void initViews(View view) {
        rvBookmarks = view.findViewById(R.id.rv_bookmarks);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvBookmarks.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void setViews(List<Bookmark> bookmarks) {
        BookmarksAdapter bookmarksAdapter = new BookmarksAdapter(getActivity(), bookmarks, this, this);
        rvBookmarks.setAdapter(bookmarksAdapter);
        bookmarksAdapter.notifyDataSetChanged();

    }

    @Override
    public void showDeletedMessage() {
        Toast.makeText(getActivity(), Objects.requireNonNull(getActivity()).getResources().getString(R.string.successfully_deleted), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBookmarkClick(Bookmark bookmark) {
        Intent intent = new Intent(getActivity(), BookmarkWeatherActivity.class);
        intent.putExtra(Constants.KEY_BOOKMARK, bookmark);
        startActivity(intent);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser)
            bookmarksPresenterImp.loadBookmarks();
    }

    @Override
    public void OnDeleteBookmark(int id) {
        bookmarksPresenterImp.deleteBookmark(id);
    }
}
