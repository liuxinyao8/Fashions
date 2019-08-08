package com.example.fashions.model.bean;

public class My_Rv_Bean {
    private int image;
    private String tv1;

    public My_Rv_Bean(int image, String tv1) {
        this.image = image;
        this.tv1 = tv1;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }

    @Override
    public String toString() {
        return "My_Rv_Bean{" +
                "image=" + image +
                ", tv1='" + tv1 + '\'' +
                '}';
    }
}
