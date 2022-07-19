package com.wyu.pojo;

public class Zyb {

      private int  id;
      private String zym;
      private int rs;
      private String fdy;

    public Zyb() {
    }

    public Zyb(int id, String zym, int rs, String fdy) {
        this.id = id;
        this.zym = zym;
        this.rs = rs;
        this.fdy = fdy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZym() {
        return zym;
    }

    public void setZym(String zym) {
        this.zym = zym;
    }

    public int getRs() {
        return rs;
    }

    public void setRs(int rs) {
        this.rs = rs;
    }

    public String getFdy() {
        return fdy;
    }

    public void setFdy(String fdy) {
        this.fdy = fdy;
    }

    @Override
    public String toString() {
        return "zyb{" +
                "id=" + id +
                ", zym='" + zym + '\'' +
                ", rs=" + rs +
                ", fdy='" + fdy + '\'' +
                '}';
    }
}
