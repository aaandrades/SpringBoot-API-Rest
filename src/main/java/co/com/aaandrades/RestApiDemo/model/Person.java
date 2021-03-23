package co.com.aaandrades.RestApiDemo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Person {
    private String name;
    private String id;
    private String mail;
    private String phone;
}
