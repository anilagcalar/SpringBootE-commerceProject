package sellhancommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import sellhancommerce.model.Orders;

@Repository
public interface OrderDAO extends JpaRepository<Orders, Integer>
{

}
