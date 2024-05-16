package com.sabirov.springeshop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    private static final String SEQ_NAME = "order_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME,allocationSize = 1)
    private long id;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private BigDecimal sum;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
