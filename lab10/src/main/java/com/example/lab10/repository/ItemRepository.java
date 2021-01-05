package com.example.lab10.repository;

import com.example.lab10.exception.NoProductFoundException;
import com.example.lab10.model.OrderItem;
import com.example.lab10.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ItemRepository {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    private ProductRepository productRepository;
    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(OrderItem item, int orderId) {
        String sql = "INSERT INTO order_items VALUES(NULL, ?, ?, ?)";

        jdbcTemplate.update(sql,
                item.getProduct().getId(),
                orderId,
                item.getQuantity());
    }

    public List<OrderItem> getOrderItemsByOrderId(Integer orderId) {
        String sql = "SELECT * FROM order_items WHERE orderid = ?";
        try {
            RowMapper<OrderItem> rowMapper = (resultSet,rowNum) -> {
                        OrderItem item = new OrderItem();
                        item.setId(resultSet.getInt("id"));
                        Optional<Product> product = productRepository.getProductById(resultSet.getInt("productid"));
                        if (product.isPresent()) {
                            item.setProduct(product.get());
                        } else {
                            throw new NoProductFoundException();
                        }
                        item.setQuantity(resultSet.getInt("quantity"));
                        return item;
                    };
            List<OrderItem> orderItemList = jdbcTemplate.query(sql, new Integer[]{orderId},rowMapper);

            return orderItemList;

        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }
}
