package com.bip.interview.task.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//@Entity(tableName = "teams_table")
public class Team {
//    @PrimaryKey @ColumnInfo(name = "id")
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("area")
    @Expose
    private Area area;
    @SerializedName("activeCompetitions")
    @Expose
    private List<Competition> activeCompetitions = null;
//    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    private String name;
    //    @ColumnInfo(name = "shortName")
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("tla")
    @Expose
    private String tla;
    @SerializedName("crestUrl")
    @Expose
    private String crestUrl;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("founded")
    @Expose
    private Integer founded;
    @SerializedName("clubColors")
    @Expose
    private String clubColors;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("squad")
    @Expose
    private List<Player> squad = null;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("errorCode")
    @Expose
    private Integer errorCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Competition> getActiveCompetitions() {
        return activeCompetitions;
    }

    public void setActiveCompetitions(List<Competition> activeCompetitions) {
        this.activeCompetitions = activeCompetitions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTla() {
        return tla;
    }

    public void setTla(String tla) {
        this.tla = tla;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFounded() {
        return founded;
    }

    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    public String getClubColors() {
        return clubColors;
    }

    public void setClubColors(String clubColors) {
        this.clubColors = clubColors;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public List<Player> getSquad() {
        return squad;
    }

    public void setPlayer(List<Player> player) {
        this.squad = player;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
