package vn.edu.leading.shop.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "shop_order_details")
public class OrderDetailModel extends BaseModel<OrderDetailModel> {

    private Long quantity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id")
    @BatchSize(size = 50)
    @JsonManagedReference
    private  ProductModel productModel;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "order_id")
    @BatchSize(size = 50)
    @JsonManagedReference
    private OrderModel orderModel;
}
