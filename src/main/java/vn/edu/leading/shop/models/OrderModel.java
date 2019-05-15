package vn.edu.leading.shop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shop_orders")
public class OrderModel extends BaseModel<OrderModel> {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "shipper_id", nullable = false)
    @BatchSize(size = 50)
    @JsonManagedReference
    private ShipperModel shipperModel;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @BatchSize(size = 50)
    @JsonManagedReference
    private CustomerModel customerModel;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonManagedReference
    private EmployeeModel employeeModel;

    @Column(name = "order_date")
    private String orderDate;

    @OneToMany(
            mappedBy = "orderModel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 50)
    @JsonBackReference
    private Set<OrderDetailModel> orderDetailModels = new HashSet<>();
}
