package bussinessmodel;

import java.util.List;

import model.ItemDTO;

public abstract class ItemService{
	public abstract List<ItemDTO> getItemsByShop(int shopid);
	public abstract ItemDTO getItem(int itemno);
	public abstract List<ItemDTO> getAll();
}
