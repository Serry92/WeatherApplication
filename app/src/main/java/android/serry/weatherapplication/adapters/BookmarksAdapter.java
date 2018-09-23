package android.serry.weatherapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class BookmarksAdapter extends RecyclerView.Adapter<BookmarksAdapter.BookmarkViewHolder> {

    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class BookmarkViewHolder extends RecyclerView.ViewHolder{

        public BookmarkViewHolder(View itemView) {
            super(itemView);
        }
    }
}
