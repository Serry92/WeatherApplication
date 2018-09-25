package android.serry.weatherapplication;

import android.content.Context;
import android.serry.weatherapplication.models.WeatherResponse;
import android.serry.weatherapplication.presenters.BookmarkWeatherPresenterImp;
import android.serry.weatherapplication.viewsActivities.BookmarkWeatherView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

public class BookmarkWeatherPresenterTest {
    private BookmarkWeatherPresenterImp presenter;
    @Mock
    private Context context;
    @Mock
    private BookmarkWeatherView bookmarkWeatherView;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private WeatherResponse weatherResponse;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new BookmarkWeatherPresenterImp(bookmarkWeatherView, context);
    }

    @Test
    public void testLoadWeatherInfo() {
        presenter.onLoadWeatherInfo(weatherResponse);
        verify(bookmarkWeatherView).setViews(weatherResponse);
    }
}
