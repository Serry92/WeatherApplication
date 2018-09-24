package android.serry.weatherapplication.adapters;

import android.content.Context;
import android.serry.weatherapplication.R;
import android.serry.weatherapplication.viewsFragments.BookmarksFragment;
import android.serry.weatherapplication.viewsFragments.MapFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public MyFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return MapFragment.getInstance();
        else
            return BookmarksFragment.getInstance();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.map);
            case 1:
                return mContext.getString(R.string.bookmarks);
            default:
                return null;
        }
    }
}
