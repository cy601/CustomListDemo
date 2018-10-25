package com.example.cy601.customlistdemo;
//列表显示类
public class Item {
    public int itemImage;//图像资源ID
    public String itemCountry;//标题
    public Item(String itemCountry,int itemImage){
        this.itemCountry=itemCountry;
        this.itemImage=itemImage;
    }
}
