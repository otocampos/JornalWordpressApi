
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links implements Parcelable
{

    @SerializedName("self")
    @Expose
    private List<Self> self = null;
    @SerializedName("collection")
    @Expose
    private List<Collection> collection = null;
    @SerializedName("about")
    @Expose
    private List<About> about = null;
    @SerializedName("up")
    @Expose
    private List<Up> up = null;
    @SerializedName("wp:post_type")
    @Expose
    private List<WpPostType> wpPostType = null;
    @SerializedName("curies")
    @Expose
    private List<Cury> curies = null;
    public final static Parcelable.Creator<Links> CREATOR = new Creator<Links>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        public Links[] newArray(int size) {
            return (new Links[size]);
        }

    }
    ;

    protected Links(Parcel in) {
        in.readList(this.self, (Self.class.getClassLoader()));
        in.readList(this.collection, (Collection.class.getClassLoader()));
        in.readList(this.about, (About.class.getClassLoader()));
        in.readList(this.up, (Up.class.getClassLoader()));
        in.readList(this.wpPostType, (WpPostType.class.getClassLoader()));
        in.readList(this.curies, (Cury.class.getClassLoader()));
    }

    public Links() {
    }

    public List<Self> getSelf() {
        return self;
    }

    public void setSelf(List<Self> self) {
        this.self = self;
    }

    public List<Collection> getCollection() {
        return collection;
    }

    public void setCollection(List<Collection> collection) {
        this.collection = collection;
    }

    public List<About> getAbout() {
        return about;
    }

    public void setAbout(List<About> about) {
        this.about = about;
    }

    public List<Up> getUp() {
        return up;
    }

    public void setUp(List<Up> up) {
        this.up = up;
    }

    public List<WpPostType> getWpPostType() {
        return wpPostType;
    }

    public void setWpPostType(List<WpPostType> wpPostType) {
        this.wpPostType = wpPostType;
    }

    public List<Cury> getCuries() {
        return curies;
    }

    public void setCuries(List<Cury> curies) {
        this.curies = curies;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(self);
        dest.writeList(collection);
        dest.writeList(about);
        dest.writeList(up);
        dest.writeList(wpPostType);
        dest.writeList(curies);
    }

    public int describeContents() {
        return  0;
    }

}
