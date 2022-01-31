package com.shop.entity;

import com.shop.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {

    @Id
    @Column(name="order_id")
    @GeneratedValue
    private Long id;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate; // 주문일

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // 주문상태

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItem = new ArrayList<>();

    private LocalDateTime regTime; // 등록일자

    private LocalDateTime updateTime; // 갱신일자


    //public static Member createMember(MemberFormDto memberFormDto, PasswordE
    /* 소스코드 변경 필요 */
    // 맴버객체 설정



}
