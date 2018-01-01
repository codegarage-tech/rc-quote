package com.reversecoder.quote.model.database;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

public class LitePalTag extends DataSupport implements Parcelable {

    private long id;
    @Column(unique = true)
    private String tagName = "";

    public LitePalTag() {
    }

    public LitePalTag(String tagName) {
        this.tagName = tagName;
    }

    public long getId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + getId() +
                ", tagName='" + tagName + '\'' +
                '}';
    }

    /**************************
     * Methods for parcelable *
     **************************/
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(getId());
        dest.writeString(tagName);
    }

    // Creator
    public static final Creator CREATOR
            = new Creator() {
        public LitePalTag createFromParcel(Parcel in) {
            return new LitePalTag(in);
        }

        public LitePalTag[] newArray(int size) {
            return new LitePalTag[size];
        }
    };

    // "De-parcel object
    public LitePalTag(Parcel in) {
        id = in.readLong();
        tagName = in.readString();
    }

    /**************************
     * Methods for convertion *
     **************************/
    public static <T> T convertFromStringToObject(String jsonString, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, clazz);
    }

    public static <T> String convertFromObjectToString(T object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}