package com.spring.blogspot.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertUser(User u) {
        String sql = "INSERT INTO users (u_id, name, password, age, gender, specialization) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                u.getU_id(),
                u.getName(),
                u.getPassword(),
                u.getAge(),
                u.getGender(),
                u.getSpecialization()
        );
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setU_id(rs.getString("u_id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
                user.setSpecialization(rs.getString("specialization"));
                return user;
            }
        });
    }
    public User findByNameAndPassword(String name, String password) {
    String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
    List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setU_id(rs.getString("u_id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setAge(rs.getInt("age"));
            user.setGender(rs.getString("gender"));
            user.setSpecialization(rs.getString("specialization"));
            return user;
        }
    }, name, password);
    return users.isEmpty() ? null : users.get(0);
}
// ...existing code...

public User findByName(String name) {
    String sql = "SELECT * FROM users WHERE name = ?";
    List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setU_id(rs.getString("u_id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setAge(rs.getInt("age"));
            user.setGender(rs.getString("gender"));
            user.setSpecialization(rs.getString("specialization"));
            return user;
        }
    }, name);
    return users.isEmpty() ? null : users.get(0);
    }
}