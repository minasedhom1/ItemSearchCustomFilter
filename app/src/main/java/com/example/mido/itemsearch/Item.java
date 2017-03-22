package com.example.mido.itemsearch;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lenovo on 02/01/2017.
 */

public class Item implements Serializable {

   private String id,name,description ,photo1,phone1,phone2,phone3,phone4,phone5,categoryName,subcategoryName,city,region
           ,site,categoryID,menu_url,promoText,promoButton,promo_pdf,url_btn_text,numOfPersonsRate;
   private float rate;
    private boolean isPromo,isRaty;
    double lon,lat;

    public String getNumOfPersonsRate() {
        return numOfPersonsRate;
    }

    public void setNumOfPersonsRate(String numOfPersonsRate) {
        this.numOfPersonsRate = numOfPersonsRate;
    }

    public String getUrl_btn_text() {
        return url_btn_text;
    }

    public void setUrl_btn_text(String url_btn_text) {
        this.url_btn_text = url_btn_text;
    }

    public boolean isRaty() {
        return isRaty;
    }

    public void setRaty(boolean raty) {
        isRaty = raty;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public String getPromoText() {
        return promoText;
    }

    public void setPromoText(String promoText) {
        this.promoText = promoText;
    }

    public String getPromoButton() {
        return promoButton;
    }

    public void setPromoButton(String promoButton) {
        this.promoButton = promoButton;
    }

    public String getPromo_pdf() {
        return promo_pdf;
    }

    public void setPromo_pdf(String promo_pdf) {
        this.promo_pdf = promo_pdf;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    ArrayList<String> phones=new ArrayList<>();

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }


    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
        if(!phone1.matches("null"))
            phones.add(phone1);
    }


    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
         this.phone2 = phone2;
        if(!phone2.matches("null"))
            phones.add(phone2);
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
        if(!phone3.matches("null"))
          phones.add(phone3);

    }

    public String getPhone4() {
        return phone4;
    }

    public void setPhone4(String phone4) {
        this.phone4 = phone4;
        if(!phone4.matches("null"))
          phones.add(phone4);

    }

    public String getPhone5() {
        return phone5;
    }

    public void setPhone5(String phone5) {

        this.phone5 = phone5;
        if(!phone5.matches("null"))
            phones.add(phone5);

    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {

        this.rate = (float) (Math.round(rate*10.0)/10.0);
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    private boolean like;

    public Item() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        photo1=photo1.replaceAll(" ","%20");
        this.photo1 = photo1;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
