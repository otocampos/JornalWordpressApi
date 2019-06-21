
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.PostLite;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Media implements Parcelable
{

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("medium_large")
    @Expose
    private String mediumLarge;
    @SerializedName("large")
    @Expose
    private String large;
    public final static Parcelable.Creator<Media> CREATOR = new Creator<Media>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Media createFromParcel(Parcel in) {
            return new Media(in);
        }

        public Media[] newArray(int size) {
            return (new Media[size]);
        }

    }
    ;

    protected Media(Parcel in) {
        this.thumbnail = ((String) in.readValue((String.class.getClassLoader())));
        this.medium = ((String) in.readValue((String.class.getClassLoader())));
        this.mediumLarge = ((String) in.readValue((String.class.getClassLoader())));
        this.large = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Media() {
    }

    /**
     * 
     * @param mediumLarge
     * @param thumbnail
     * @param large
     * @param medium
     */
    public Media(String thumbnail, String medium, String mediumLarge, String large) {
        super();
        this.thumbnail = thumbnail;
        this.medium = medium;
        this.mediumLarge = mediumLarge;
        this.large = large;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getMediumLarge() {
        return mediumLarge;
    }

    public void setMediumLarge(String mediumLarge) {
        this.mediumLarge = mediumLarge;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(thumbnail);
        dest.writeValue(medium);
        dest.writeValue(mediumLarge);
        dest.writeValue(large);
    }

    public int describeContents() {
        return  0;
    }

}
