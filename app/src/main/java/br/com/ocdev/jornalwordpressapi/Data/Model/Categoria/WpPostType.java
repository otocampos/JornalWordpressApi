
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WpPostType implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<WpPostType> CREATOR = new Creator<WpPostType>() {


        @SuppressWarnings({
            "unchecked"
        })
        public WpPostType createFromParcel(Parcel in) {
            return new WpPostType(in);
        }

        public WpPostType[] newArray(int size) {
            return (new WpPostType[size]);
        }

    }
    ;

    protected WpPostType(Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public WpPostType() {
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}
