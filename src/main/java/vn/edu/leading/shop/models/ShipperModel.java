package vn.edu.leading.shop.models;

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
@Table(name = "shop_shippers")
public class ShipperModel extends BassModel<ShipperModel> {

    @NotEmpty
    @Column(name = "shipper_name", nullable = false)
    private String shipperName;

    @Column(nullable = false)
    private String phone;

    @OneToMany(
            mappedBy = "shipperModel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 50)
    private Set<OrderModel> orderModels = new HashSet<>();
}
