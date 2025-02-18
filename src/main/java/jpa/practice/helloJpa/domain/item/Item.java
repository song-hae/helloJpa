package jpa.practice.helloJpa.domain.item;

import jakarta.persistence.*;
import lombok.*;

@Builder @AllArgsConstructor //Builder 패턴을 활용해 유연한 객체 생성 보장
@Entity @Table @Getter
@NoArgsConstructor
public class Item {
    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
}
