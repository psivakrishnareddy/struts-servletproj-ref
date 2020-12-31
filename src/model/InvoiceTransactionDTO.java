package model;

import java.io.Serializable;

public class InvoiceTransactionDTO  implements Serializable{
   private int invno;
   private int itemno;
   private int qty;
public int getInvno() {
	return invno;
}
public void setInvno(int invno) {
	this.invno = invno;
}
public int getItemno() {
	return itemno;
}
public void setItemno(int itemno) {
	this.itemno = itemno;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
}