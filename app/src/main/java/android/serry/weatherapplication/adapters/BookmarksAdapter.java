package android.serry.weatherapplication.adapters;

import android.content.Context;
import android.serry.weatherapplication.R;
import android.serry.weatherapplication.listeners.OnBookmarkClickListener;
import android.serry.weatherapplication.listeners.OnDeleteBookmarkClickListener;
import android.serry.weatherapplication.models.Bookmark;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class BookmarksAdapter extends RecyclerView.Adapter<BookmarksAdapter.BookmarkViewHolder> {
    private List<Bookmark> bookmarks;
    private Context context;
    private OnBookmarkClickListener onBookmarkClickListener;
    private OnDeleteBookmarkClickListener onDeleteBookmarkClickListener;

    public BookmarksAdapter(Context context, List<Bookmark> bookmarks, OnBookmarkClickListener onBookmarkClickListener
            , OnDeleteBookmarkClickListener onDeleteBookmarkClickListener) {
        this.context = context;
        this.bookmarks = bookmarks;
        this.onBookmarkClickListener = onBookmarkClickListener;
        this.onDeleteBookmarkClickListener = onDeleteBookmarkClickListener;
    }

    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bookmark, parent, false);
        final BookmarkViewHolder myViewHolder = new BookmarkViewHolder(view);
        myViewHolder.cvBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBookmarkClickListener.onBookmarkClick(bookmarks.get(myViewHolder.getAdapterPosition()));
            }
        });
        myViewHolder.ibDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDeleteBookmarkClickListener.OnDeleteBookmark(bookmarks.get(myViewHolder.getAdapterPosition()).getId());
                bookmarks.remove(myViewHolder.getAdapterPosition());
                notifyItemRemoved(myViewHolder.getAdapterPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {
        holder.tvLocation.setText(bookmarks.get(position).getCountry());
        holder.tvLat.setText(bookmarks.get(position).getLat());
        holder.tvLng.setText(bookmarks.get(position).getLng());
    }

    @Override
    public int getItemCount() {
        return bookmarks.size();
    }

    class BookmarkViewHolder extends RecyclerView.ViewHolder {
        CardView cvBookmark;
        TextView tvLocation, tvLat, tvLng;
        ImageButton ibDelete;

        BookmarkViewHolder(View itemView) {
            super(itemView);
            cvBookmark = itemView.findViewById(R.id.cv_bookmark);
            tvLocation = itemView.findViewById(R.id.tv_location_name);
            tvLat = itemView.findViewById(R.id.tv_lat);
            tvLng = itemView.findViewById(R.id.tv_lng);
            ibDelete = itemView.findViewById(R.id.ib_delete);
        }
    }
}
