package com.broa.phonbookapp.models;

import com.broa.phonbookapp.R;

import java.util.ArrayList;
import java.util.List;

public class MyContacts {
    private  String name ;
    private  String tel;
    private  int    img;

    public MyContacts() {
    }

    public MyContacts(String name, String tel, int img) {
        this.name = name;
        this.tel = tel;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public  static List<MyContacts> getAllContacts() {
        List <MyContacts> contactsList = new ArrayList <>();
        String[] arrayName = {"Eisa", "Mosa", "Asad", "Salam", "Broa", "Heaman", "Ali", "Mohammad", "Mardin", "Ramsin"};
        int[] picarray = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p6, R.drawable.p5
                , R.drawable.p7, R.drawable.p8, R.drawable.p9, R.drawable.p10, R.drawable.p11};
        for (int i = 0; i < 3; i++) {
            MyContacts contacts = new MyContacts(arrayName[i] + "  yousefi  " + i, "09192562910", picarray[i]);
            contactsList.add(contacts);


        }
        return contactsList;
    }

}
