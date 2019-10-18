package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String title;
    String overview;
    String poster_path;

    public Movie (JSONObject jObject) throws JSONException {
        this.title = jObject.getString("title");
        this.overview = jObject.getString("overview");
        this.poster_path = jObject.getString("poster_path");
    }

    public static List<Movie> extractMovies (JSONArray jArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < jArray.length(); i ++) {
            movies.add(new Movie (jArray.getJSONObject(i)));
        }

        return movies;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", poster_path);
    }
}
