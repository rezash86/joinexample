package johnabbott.session7.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import johnabbott.session7.model.Cart;

@Repository
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addCart(Cart c) {
		getSession().save(c);
		c.getItems().forEach(item ->{
			item.setCart(c);
			getSession().save(item);
		});
	}
	
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
}
