package model;



import java.io.Serializable;
import java.sql.Blob;

public class ItemDTO implements Serializable {
   private int itemno;
   private String itemdesc;
   private String unit;
   private float price;
   private int shopid;
//   private Blob image;
//public Blob getImage() {
//	return image;
//}
//public void setImage(Blob image) {
//	this.image = image;
//}
public int getShopid() {
	return shopid;
}
public void setShopid(int shopid) {
	this.shopid = shopid;
}
public int getItemno() {
	return itemno;
}
public void setItemno(int itemno) {
	this.itemno = itemno;
}
public String getItemdesc() {
	return itemdesc;
}
public void setItemdesc(String itemdesc) {
	this.itemdesc = itemdesc;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
}

