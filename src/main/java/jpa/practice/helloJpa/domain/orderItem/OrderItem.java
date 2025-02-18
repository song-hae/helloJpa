package jpa.practice.helloJpa.domain.orderItem;

import jakarta.persistence.*;
import jpa.practice.helloJpa.domain.item.Item;
import jpa.practice.helloJpa.domain.order.Order;
import lombok.*;

@Builder @AllArgsConstructor //Builder 패턴을 활용해 유연한 객체 생성 보장
@Entity @Table
@Getter
@NoArgsConstructor
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @Column(nullable = false)
    @ManyToOne @JoinColumn(name = "ITEM_ID")
    private Item item;

    @Column(nullable = false)
    @ManyToOne @JoinColumn(name = "ORDER_ID")
    private Order order;

    public void assginOrder(Order order) { // 엔티티의 값 안정성을 고려한 setter 메소드
        this.order = order;
    }

    private int orderPrice;
    private int orderCount;

}
