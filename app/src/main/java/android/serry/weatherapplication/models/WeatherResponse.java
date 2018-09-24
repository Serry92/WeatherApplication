package android.serry.weatherapplication.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

public class WeatherResponse {
    @PrimaryKey(autoGenerate = true)
    private String id;
    private String name;
    private String cod;
    private BookmarkCoOrd coord;
    private BookmarkMain main;
    private BookmarkWeather weather;
    private BookmarkWind wind;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public BookmarkCoOrd getCoord() {
        return coord;
    }

    public void setCoord(BookmarkCoOrd coord) {
        this.coord = coord;
    }

    public BookmarkMain getMain() {
        return main;
    }

    public void setMain(BookmarkMain main) {
        this.main = main;
    }

    public BookmarkWeather getWeather() {
        return weather;
    }

    public void setWeather(BookmarkWeather weather) {
        this.weather = weather;
    }

    public BookmarkWind getWind() {
        return wind;
    }

    public void setWind(BookmarkWind wind) {
        this.wind = wind;
    }
}
