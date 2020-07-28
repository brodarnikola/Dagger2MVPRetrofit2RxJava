package proba.vjezbanje.android.dagger2mvpretrofit2test.pojo;

import com.google.gson.annotations.SerializedName;

public class CountryData {

    @SerializedName("name")
    public String name;
    @SerializedName("alpha2Code")
    public String alpha2Code;
    @SerializedName("alpha3Code")
    public String alpha3Code;
    @SerializedName("capital")
    public String capital;
    @SerializedName("region")
    public String region;
    @SerializedName("subregion")
    public String subregion;
    @SerializedName("population")
    public int population;
}
