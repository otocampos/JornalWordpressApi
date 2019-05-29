
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Up implements Parcelable
{

    @SerializedName("embeddable")
    @Expose
    private Boolean embeddable;
    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Up> CREATOR = new Creator<Up>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Up createFromParcel(Parcel in) {
            return new Up(in);
        }

        public Up[] newArray(int size) {
            return (new Up[size]);
        }

    }
    ;

    protected Up(Parcel in) {
        this.embeddable = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Up() {
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
