
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WpFeaturedmedium implements Parcelable
{

    @SerializedName("embeddable")
    @Expose
    private Boolean embeddable;
    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<WpFeaturedmedium> CREATOR = new Creator<WpFeaturedmedium>() {


        @SuppressWarnings({
            "unchecked"
        })
        public WpFeaturedmedium createFromParcel(Parcel in) {
            return new WpFeaturedmedium(in);
        }

        public WpFeaturedmedium[] newArray(int size) {
            return (new WpFeaturedmedium[size]);
        }

    }
    ;

    protected WpFeaturedmedium(Parcel in) {
        this.embeddable = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public WpFeaturedmedium() {
    }

    public Boolean getEmbeddable() {
        return embeddable;
    }

    public void setEmbeddable(Boolean embeddable) {
        this.embeddable = embeddable;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(embeddable);
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}
