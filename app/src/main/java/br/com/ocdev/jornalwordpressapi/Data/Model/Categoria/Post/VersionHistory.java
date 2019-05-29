
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionHistory implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<VersionHistory> CREATOR = new Creator<VersionHistory>() {


        @SuppressWarnings({
            "unchecked"
        })
        public VersionHistory createFromParcel(Parcel in) {
            return new VersionHistory(in);
        }

        public VersionHistory[] newArray(int size) {
            return (new VersionHistory[size]);
        }

    }
    ;

    protected VersionHistory(Parcel in) {
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public VersionHistory() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}
