package control;

import java.util.ArrayList;
import java.util.List;

import model.ItemDTO;

public class BillingItems {
List<ItemDTO> itemslist = new ArrayList<ItemDTO>();

public List<ItemDTO> getItemslist() {
	return itemslist;
}

public void setItemslist(ItemDTO item) {
	itemslist.add(item);
}

}
