
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
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
    @SerializedName("author")
    @Expose
    private List<Author> author = null;
    @SerializedName("replies")
    @Expose
    private List<Reply> replies = null;
    @SerializedName("version-history")
    @Expose
    private List<VersionHistory> versionHistory = null;
    @SerializedName("predecessor-version")
    @Expose
    private List<PredecessorVersion> predecessorVersion = null;
    @SerializedName("wp:featuredmedia")
    @Expose
    private List<WpFeaturedmedium> wpFeaturedmedia = null;
    @SerializedName("wp:attachment")
    @Expose
    private List<WpAttachment> wpAttachment = null;
    @SerializedName("wp:term")
    @Expose
    private List<WpTerm> wpTerm = null;
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
        in.readList(this.self, (br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.Self.class.getClassLoader()));
        in.readList(this.collection, (br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.Collection.class.getClassLoader()));
        in.readList(this.about, (br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.About.class.getClassLoader()));
        in.readList(this.author, (br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.Author.class.getClassLoader()));
        in.readList(this.replies, (br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.Reply.class.getClassLoader()));
        in.readList(this.versionHistory, (br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.VersionHistory.class.getClassLoader()));
        in.readList(this.predecessorVersion, (br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.PredecessorVersion.class.getClassLoader()));
        in.readList(this.wpFeaturedmedia, (br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.WpFeaturedmedium.class.getClassLoader()));
        in.readList(this.wpAttachment, (br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.WpAttachment.class.getClassLoader()));
        in.readList(this.wpTerm, (br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.WpTerm.class.getClassLoader()));
        in.readList(this.curies, (br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post.Cury.class.getClassLoader()));
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

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public List<VersionHistory> getVersionHistory() {
        return versionHistory;
    }

    public void setVersionHistory(List<VersionHistory> versionHistory) {
        this.versionHistory = versionHistory;
    }

    public List<PredecessorVersion> getPredecessorVersion() {
        return predecessorVersion;
    }

    public void setPredecessorVersion(List<PredecessorVersion> predecessorVersion) {
        this.predecessorVersion = predecessorVersion;
    }

    public List<WpFeaturedmedium> getWpFeaturedmedia() {
        return wpFeaturedmedia;
    }

    public void setWpFeaturedmedia(List<WpFeaturedmedium> wpFeaturedmedia) {
        this.wpFeaturedmedia = wpFeaturedmedia;
    }

    public List<WpAttachment> getWpAttachment() {
        return wpAttachment;
    }

    public void setWpAttachment(List<WpAttachment> wpAttachment) {
        this.wpAttachment = wpAttachment;
    }

    public List<WpTerm> getWpTerm() {
        return wpTerm;
    }

    public void setWpTerm(List<WpTerm> wpTerm) {
        this.wpTerm = wpTerm;
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
        dest.writeList(author);
        dest.writeList(replies);
        dest.writeList(versionHistory);
        dest.writeList(predecessorVersion);
        dest.writeList(wpFeaturedmedia);
        dest.writeList(wpAttachment);
        dest.writeList(wpTerm);
        dest.writeList(curies);
    }

    public int describeContents() {
        return  0;
    }

}
