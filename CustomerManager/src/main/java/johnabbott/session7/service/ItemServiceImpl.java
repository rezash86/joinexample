package johnabbott.session7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import johnabbott.session7.dao.ItemDAO;
import johnabbott.session7.model.Cart;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDAO itemDAO;

	@Override
	@Transactional
	public void saveCart(Cart cart) {
		itemDAO.addCart(cart);
	}
	


}
