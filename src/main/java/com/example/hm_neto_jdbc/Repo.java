package com.example.hm_neto_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class Repo {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String fetchProductSql = read("fetch_product.sql");

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<String> getProductName(String name){
        Map<String, String> map = new HashMap<>();
        map.put("customer_name", name);
        return namedParameterJdbcTemplate.query(fetchProductSql, map, (rs, row) -> rs.getString("product_name")).stream().findAny();
    }
}
