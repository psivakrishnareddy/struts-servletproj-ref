package bussinessmodel;

import java.util.ArrayList;
import java.util.List;

import model.ItemDAO;
import model.ItemDAOImpl;
import model.ItemDTO;


public class ItemServiceImpl extends ItemService {
	
@Override
public List<ItemDTO> getItemsByShop(int shopid) {
	ItemDAO idao = new ItemDAOImpl();
	List<ItemDTO> itemslist = new ArrayList<ItemDTO>();
	itemslist  = idao.getItemByShop(shopid);
	return itemslist;
}
@Override
	public ItemDTO getItem(int itemno) {
		ItemDAO idao = new ItemDAOImpl();
		ItemDTO item = idao.getItem(itemno);
		return item;
	}

@Override
	public List<ItemDTO> getAll() {
	ItemDAO idao = new ItemDAOImpl();
	return idao.getAllItems();
	}
}
