package bussinessmodel;

import control.BillingItems;
import model.CustomerDTO;
import model.InvoiceDTO;

public abstract class BillingService {
public abstract void generateBill(BillingItems items , String uname);
public abstract void generatePDF(BillingItems items , InvoiceDTO invoice , CustomerDTO customer);
}
