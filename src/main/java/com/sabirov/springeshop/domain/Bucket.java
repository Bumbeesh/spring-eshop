package com.sabirov.springeshop.domain;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "buckets")
public class Bucket {
    private static final String SEQ_NAME = "bucket_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME,allocationSize = 1)
    private long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany //В корзине может быть много товаров, товар может быть в нескольких корзинах
    @JoinTable(name = "buckets_products",
                joinColumns = @JoinColumn(name = "bucket_id"),
                inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
}
