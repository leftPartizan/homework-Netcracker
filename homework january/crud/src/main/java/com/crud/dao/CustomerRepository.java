package com.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.crud.model.Customer;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> getAll(){
        String sql = "SELECT * FROM CUSTOMER";
        List<Customer> result = jdbcTemplate.query(sql, (rs, rowNum) -> new Customer(rs.getInt("id"),
                rs.getString("lastName"),rs.getString("district"),rs.getInt("discount")));
        return result;
    }

    public Customer getById(int id){
        String SQL = "SELECT * FROM CUSTOMER WHERE id = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, (rs, rowNum) -> new Customer(rs.getInt("id"),
                rs.getString("lastName"),rs.getString("district"),rs.getInt("discount")));
    }

    public String create(Customer customer){
        String SQL = "insert into CUSTOMER VALUES (?,?,?,?)";
        jdbcTemplate.update(SQL, customer.getId(), customer.getLastName(), customer.getDistrict(), customer.getDiscount());
        return "Customer was successfully created";
    }

    public String deleteAll (){
        String sql = "delete * from CUSTOMER";
        jdbcTemplate.update(sql);
        return "Customers was successfully deleted";
    }

    public String deleteById(int id){
        String sql = "delete * from buyer where id = ?";
        jdbcTemplate.update(sql, id);
        return "Customer was successfully deleted";
    }

}
