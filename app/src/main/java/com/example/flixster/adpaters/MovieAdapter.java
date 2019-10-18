package com.example.flixster.adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    List<Movie> movies;

    public MovieAdapter (Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(movies.get(position));

        // to bind image after downloading
        Glide.with(context)
                .load(movies.get(position).getPoster_path())
                .into(holder.ivMovie);
    }
    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMovie;
        TextView tvTitle;
        TextView tvOverview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivMovie = itemView.findViewById(R.id.ivMovie);
            this.tvTitle = itemView.findViewById(R.id.tvTitle);
            this.tvOverview = itemView.findViewById(R.id.tvOverview);

        }

        public void bind (Movie movie) {
            this.tvTitle.setText(movie.getTitle());
            this.tvOverview.setText(movie.getOverview());
        }
    }
}
