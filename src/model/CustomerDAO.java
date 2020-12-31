package model;

import java.util.List;

public abstract class CustomerDAO {
public abstract void addCustomer(CustomerDTO customer);
public abstract void updateCustomer(CustomerDTO customer);
public abstract void deleteCustomer(CustomerDTO customer);
public abstract CustomerDTO getCustomerById(int cid);
public abstract List<CustomerDTO> getAllCustomers();
}
