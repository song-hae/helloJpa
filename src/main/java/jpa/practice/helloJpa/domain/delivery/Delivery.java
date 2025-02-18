package jpa.practice.helloJpa.domain.delivery;

import jakarta.persistence.*;
import jpa.practice.helloJpa.domain.order.Order;
import lombok.*;

@Builder @AllArgsConstructor //Builder 패턴을 활용해 유연한 객체 생성 보장
@Entity @Table
@Getter @NoArgsConstructor
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    public void assignOrder(Order order) { // 엔티티의 값 안정성을 고려한 setter 메소드
        this.order = order;
    }

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    @Enumerated
    private DeliveryStatus deliveryStatus;
}
