package com.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="item")
@Setter @Getter
public class Item {

    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemNm; // 아이템이름

    private int price; // 가격

    private int stockNumber; // 재고량

    private String itemDetail; // 아이템상세

    private String itemSellStatus; // 아이템상태

    private LocalDateTime regTime;

    private LocalDateTime updateTime;

}
