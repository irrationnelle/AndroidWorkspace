package net.azurewebsites.irrationnelle.testandroidstudio.vo;

public class MainItem {
    private int bandCount;
    private String bandName;

    public MainItem(int bandCount, String bandName) {
        this.bandCount = bandCount;
        this.bandName = bandName;
    }

    public int getBandCount() {
        return bandCount;
    }

    public void setBandCount(int bandCount) {
        this.bandCount = bandCount;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }
}
