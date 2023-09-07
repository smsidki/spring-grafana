package id.spring.grafana.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Book {
    
    @Id
    @GeneratedValue
    private long id;
    
    @Column
    private String title;
    
    @Column
    private String author;
    
}
