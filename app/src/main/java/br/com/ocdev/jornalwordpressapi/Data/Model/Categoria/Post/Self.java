
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Self implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Self> CREATOR = new Creator<Self>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Self createFromParcel(Parcel in) {
            return new Self(in);
        }

        public Self[] newArray(int size) {
            return (new Self[size]);
        }

    }
    ;

    protected Self(Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Self() {
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
