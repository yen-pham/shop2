package vn.edu.leading.shop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "shop_customers")
public class CustomerModel extends BaseModel<CustomerModel> {

    @NotEmpty
    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @NotEmpty
    @Column(name = "contact_name", nullable = false)
    private String contactName;

    private String address;

    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    private String country;

    @OneToMany(
            mappedBy = "customerModel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 50)
    @JsonBackReference
    private Set<OrderModel> orderModels = new HashSet<>();
}
