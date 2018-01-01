package com.reversecoder.quote.model.database;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.orm.SugarRecord;
import com.orm.annotation.Unique;
import com.reversecoder.quote.model.Author;
import com.reversecoder.quote.model.Language;
import com.reversecoder.quote.model.Tag;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class LitePalQuote extends DataSupport implements Parcelable {

    private long id;
    @Column(unique = true)
    private String quoteDescription = "";
    private boolean isFavourite = false;
    private boolean isQuote = false;
    private LitePalLanguage language;
    private LitePalAuthor author;
//    private ArrayList<LitePalTag> tags = new ArrayList<>();

    public LitePalQuote(String quoteDescription, boolean isFavourite, boolean isQuote, LitePalLanguage language, LitePalAuthor author) {
        this.quoteDescription = quoteDescription;
        this.isFavourite = isFavourite;
        this.isQuote = isQuote;
        this.language = language;
        this.author = author;
//        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public String getQuoteDescription() {
        return quoteDescription;
    }

    public void setQuoteDescription(String quoteDescription) {
        this.quoteDescription = quoteDescription;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public boolean isQuote() {
        return isQuote;
    }

    public void setQuote(boolean quote) {
        isQuote = quote;
    }

    public LitePalLanguage getLanguage() {
        return language;
    }

    public void setLanguage(LitePalLanguage language) {
        this.language = language;
    }

    public LitePalAuthor getAuthor() {
        return author;
    }

    public void setAuthor(LitePalAuthor author) {
        this.author = author;
    }

//    public List<LitePalTag> getTags() {
////        List<LitePalTag> mTags = DataSupport.where("deletedFileInfo_id = ?", getId() + "").find(LitePalTag.class);
////        tags = new ArrayList<LitePalTag>(mTags);
//        return tags;
//    }
//
//    public void setTags(ArrayList<LitePalTag> tags) {
//        this.tags = tags;
//    }

    @Override
    public String toString() {
        return "{" +
                "id=" + getId() +
                ", quoteDescription=" + quoteDescription +
                ", isFavourite=" + isFavourite +
                ", isQuote=" + isQuote +
                ", language=" + language +
                ", author=" + author +
//                ", tags=" + tags +
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
        dest.writeString(quoteDescription);
        dest.writeInt(isFavourite ? 1 : 0);
        dest.writeInt(isQuote ? 1 : 0);
        dest.writeParcelable(language, flags);
        dest.writeParcelable(author, flags);
    }

    // Creator
    public static final Creator CREATOR
            = new Creator() {
        public LitePalQuote createFromParcel(Parcel in) {
            return new LitePalQuote(in);
        }

        public LitePalQuote[] newArray(int size) {
            return new LitePalQuote[size];
        }
    };

    // "De-parcel object
    public LitePalQuote(Parcel in) {
        id = in.readLong();
        this.quoteDescription = in.readString();
        this.isFavourite = (in.readInt() == 0) ? false : true;
        this.isQuote = (in.readInt() == 0) ? false : true;
        this.language = in.readParcelable(Language.class.getClassLoader());
        this.author = in.readParcelable(Author.class.getClassLoader());
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