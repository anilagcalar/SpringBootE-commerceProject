package sellhancommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import sellhancommerce.model.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> 
{
	public Product findByProductId(int productId);
}
