package com.techprimers.elastic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Document(indexName = "users", type = "users", shards = 3)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    private String name;
    
    @Id
    @GeneratedValue
    private Long id;

    private String teamName;
    private Long salary;

}
