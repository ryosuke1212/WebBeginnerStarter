package com.example.demo.dao;

import com.example.demo.entity.Inquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class InquiryDaoImpl implements InquiryDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertInquiry(Inquiry inquiry) {
        jdbcTemplate.update("INSERT INTO inquiry(name, email, contents, created VALUES(?, ?, ?, ?)",
                inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getCreated());
    }

    @Override
    public List<Inquiry> getAll() {
        String sql = "SELECT id, name, email, contents, created FROM inquiry";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        List<Inquiry> list = new ArrayList<Inquiry>();
        for(Map<String, Object> result : resultList) {
            Inquiry inquiry= new Inquiry();
            Inquiry.setId((int)result.get("id"));
            Inquiry.setName((String)result.get("name"));
            Inquiry.setEmail((String)result.get("email"));
            Inquiry.setContents((String)result.get("contents"));
            Inquiry.setCreated(((Timestamp)result.get("created")));
            list.add(inquiry);
        }
        return list;
    }
}
