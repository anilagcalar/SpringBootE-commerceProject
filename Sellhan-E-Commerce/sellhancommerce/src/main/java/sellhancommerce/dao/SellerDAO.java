package sellhancommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import sellhancommerce.model.Seller;

@Repository
public interface SellerDAO extends JpaRepository<Seller, Integer>
{
	public Seller findBySellerName(String sellerName);
	public Seller findBySellerId(int sellerId);
}
