package model;

import java.sql.Date;
import java.util.List;

public abstract class InvoiceDAO {
public abstract void addInvoice(int cid , int invno);
public abstract void updateInvoice(int invno ,float amt);
public abstract int getNextInvno();
public abstract InvoiceDTO getInvoiceById(int id);
public abstract List<ReportInvoice> getReportInvoices();
public abstract List<ReportInvoice> getReportInvoicesByDates(Date d1 ,Date d2);
public abstract List<ReportInvoice> getCReportsInvoicesByDates(Date d1 ,Date d2);
}
