package com.rest.demo.model;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class DemoModel {
    private int id;
    private String name;
}
