package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="carts")
@Getter
@Setter
public class Cart {

    public enum StatusType{
        pending,
        ordered,
        canceled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private Long id;

    @Column(name="order_tracking_number")
    private String orderTrackingNumber;

    @Column(name="package_price")
    private BigDecimal package_price;

    @Column(name="party_size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private StatusType status;

    @Column(name="create_date")
    private Date create_date;

    @Column(name="last_update")
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItem;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;
}
