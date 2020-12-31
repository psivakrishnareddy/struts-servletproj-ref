package model;

import java.io.Serializable;
import java.sql.Date;

public class InvoiceDTO implements Serializable {
private int invno;
public int getInvno() {
	return invno;
}
public void setInvno(int invno) {
	this.invno = invno;
}
public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
}
public Date getInv_date() {
	return inv_date;
}
public void setInv_date(Date inv_date) {
	this.inv_date = inv_date;
}
private int customerid;
private Date inv_date;
private float ammount;
public float getAmmount() {
	return ammount;
}
public void setAmmount(float ammount) {
	this.ammount = ammount;
}

}
