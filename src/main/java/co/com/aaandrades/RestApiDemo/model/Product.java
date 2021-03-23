package co.com.aaandrades.RestApiDemo.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

// Here we create the model of the DB, or the ORM
@Data
@Entity
@Table(name = "product")
public class Product  implements Serializable {

    // private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproduct;

    private String name;
    private String price;
}
