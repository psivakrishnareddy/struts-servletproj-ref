package bussinessmodel;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Iterator;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import control.BillingItems;
import model.CustomerDAO;
import model.CustomerDAOImpl;
import model.CustomerDTO;
import model.InvoiceDAO;
import model.InvoiceDAOImpl;
import model.InvoiceDTO;
import model.InvoiceTransactionDAO;
import model.InvoiceTransactionDAOImpl;
import model.InvoiceTransactionDTO;
import model.ItemDTO;
import model.UserDAO;
import model.UserDAOImpl;
import model.UserDTO;

public class BillingServiceImpl extends BillingService {
	InvoiceDAO indao = new InvoiceDAOImpl();
	UserDAO userdao = new UserDAOImpl();
	InvoiceTransactionDAO itdao = new InvoiceTransactionDAOImpl();
	CustomerDAO cdao = new CustomerDAOImpl();
@Override
public void generateBill(BillingItems items , String uname) {
	float totalamt = 0;
	
	// TODO Auto-generated method stub
	Iterator<ItemDTO> iter = items.getItemslist().iterator();
	System.out.println("You bought..");
	UserDTO user=userdao.getUserByName(uname);
	int cid = user.getUid();
	int invoiceNo = indao.getNextInvno();
	invoiceNo += 1000;
	indao.addInvoice(cid , invoiceNo );
	System.out.println(invoiceNo);
	while(iter.hasNext()) {
		ItemDTO item = iter.next();
		InvoiceTransactionDTO invitem = new InvoiceTransactionDTO();
		invitem.setInvno(invoiceNo);
		invitem.setItemno(item.getItemno());
		invitem.setQty(1); // Temporary
		totalamt+= item.getPrice();
		itdao.addinvItem(invitem);
	}
	
	System.out.println("The total Amount " + totalamt);
	indao.updateInvoice(invoiceNo, totalamt);
	
	generatePDF(items,indao.getInvoiceById(invoiceNo) , cdao.getCustomerById(cid));
}


@Override
public void generatePDF(BillingItems items ,InvoiceDTO invoice , CustomerDTO customer) {
	
	try {
        Document document = new Document();
        String FILE = "E:/pdfs/" + "invoice" + LocalDate.now() + invoice.getInvno() + ".pdf";
        PdfWriter.getInstance(document, new FileOutputStream(FILE));
        document.open();
        PDFgenerator.addMetaData(document);
   
        PDFgenerator.createInvoice(document , items , invoice , customer);
        	
        document.close();
        System.out.println("BILL Generated Successfully.... " );
    } catch (Exception e) {
        e.printStackTrace();
    }
	
}
}
