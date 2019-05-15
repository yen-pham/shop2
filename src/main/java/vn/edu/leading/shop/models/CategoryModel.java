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
@Table(name = "shop_categories")
public class CategoryModel extends BaseModel<CategoryModel> {
    @NotEmpty
    @Column(name = "category_name")
    String categoryName;

    String description;

    @OneToMany(
            mappedBy = "categoryModel",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 50)
    @JsonBackReference
    private Set<ProductModel> productModels = new HashSet<>();
}
