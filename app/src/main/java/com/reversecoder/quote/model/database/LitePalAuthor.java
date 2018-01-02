package com.reversecoder.quote.model.database;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

public class LitePalAuthor extends DataSupport implements Parcelable {

    private long id;
    @Column(unique = true)
    private String authorName = "";
    private String birthDate = "";
    private String deathDate = "";
    private String occupation = "";
    private String nationality = "";
    private int profileImage = -1;
    private boolean isAuthor = true;

    public LitePalAuthor() {
    }

    public LitePalAuthor(String authorName, String birthDate, String deathDate, String occupation, String nationality, int profileImage, boolean isAuthor) {
        this.authorName = authorName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.occupation = occupation;
        this.nationality = nationality;
        this.profileImage = profileImage;
        this.isAuthor = isAuthor;
    }

    public long getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public boolean isAuthor() {
        return isAuthor;
    }

    public void setAuthor(boolean author) {
        isAuthor = author;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + getId() +
                ", authorName='" + authorName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", deathDate='" + deathDate + '\'' +
                ", occupation='" + occupation + '\'' +
                ", nationality='" + nationality + '\'' +
                ", profileImage=" + profileImage +
                ", isAuthor=" + isAuthor +
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
        dest.writeString(authorName);
        dest.writeString(birthDate);
        dest.writeString(deathDate);
        dest.writeString(occupation);
        dest.writeString(nationality);
        dest.writeInt(profileImage);
        dest.writeInt(isAuthor ? 1 : 0);
    }

    // Creator
    public static final Creator CREATOR
            = new Creator() {
        public LitePalAuthor createFromParcel(Parcel in) {
            return new LitePalAuthor(in);
        }

        public LitePalAuthor[] newArray(int size) {
            return new LitePalAuthor[size];
        }
    };

    // "De-parcel object
    public LitePalAuthor(Parcel in) {
        id = in.readLong();
        authorName = in.readString();
        birthDate = in.readString();
        deathDate = in.readString();
        occupation = in.readString();
        nationality = in.readString();
        profileImage = in.readInt();
        isAuthor = (in.readInt() == 0) ? false : true;
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