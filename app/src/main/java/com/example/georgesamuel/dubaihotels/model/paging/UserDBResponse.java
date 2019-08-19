package com.example.georgesamuel.dubaihotels.model.paging;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserDBResponse implements Parcelable {

    @SerializedName("page")
    @Expose
    private int page;
    @SerializedName("per_page")
    @Expose
    private int perPage;
    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("total_pages")
    @Expose
    private int totalPages;
    @SerializedName("data")
    @Expose
    private List<User> users = null;

    public UserDBResponse(Parcel in){
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.perPage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.users, (java.lang.Object.class.getClassLoader()));
    }

    public UserDBResponse(){
    }

    public static final Creator<UserDBResponse> CREATOR = new Creator<UserDBResponse>() {
        @Override
        public UserDBResponse createFromParcel(Parcel parcel) {
            return new UserDBResponse(parcel);
        }

        @Override
        public UserDBResponse[] newArray(int i) {
            return new UserDBResponse[i];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(page);
        parcel.writeValue(perPage);
        parcel.writeValue(total);
        parcel.writeValue(totalPages);
        parcel.writeList(users);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
