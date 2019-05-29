
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WpAttachment implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<WpAttachment> CREATOR = new Creator<WpAttachment>() {


        @SuppressWarnings({
            "unchecked"
        })
        public WpAttachment createFromParcel(Parcel in) {
            return new WpAttachment(in);
        }

        public WpAttachment[] newArray(int size) {
            return (new WpAttachment[size]);
        }

    }
    ;

    protected WpAttachment(Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public WpAttachment() {
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
