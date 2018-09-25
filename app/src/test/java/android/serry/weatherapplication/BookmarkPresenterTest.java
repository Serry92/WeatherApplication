package android.serry.weatherapplication;

import android.content.Context;
import android.location.Geocoder;
import android.serry.weatherapplication.models.Bookmark;
import android.serry.weatherapplication.presenters.BookmarksPresenterImp;
import android.serry.weatherapplication.viewsFragments.BookmarksView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.mockito.Mockito.verify;

public class BookmarkPresenterTest {

    private BookmarksPresenterImp presenter;
    @Mock
    private Context context;
    @Mock
    private BookmarksView bookmarksView;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private List<Bookmark> bookmarkList;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new BookmarksPresenterImp(bookmarksView, context);
    }

    @Test
    public void testShowDeletedMessage() {
        presenter.onSuccessDeleted();
        verify(bookmarksView).showDeletedMessage();
    }

    @Test
    public void testSetViewsAfterLoadBookmarks() {
        presenter.onLoad(bookmarkList);
        verify(bookmarksView).setViews(bookmarkList);
    }
}
