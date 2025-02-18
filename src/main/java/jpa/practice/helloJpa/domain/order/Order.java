package jpa.practice.helloJpa.domain.order;

import jakarta.persistence.*;
import jpa.practice.helloJpa.domain.BaseTimeEntity;
import jpa.practice.helloJpa.domain.delivery.Delivery;
import jpa.practice.helloJpa.domain.member.Member;
import jpa.practice.helloJpa.domain.orderItem.OrderItem;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder @AllArgsConstructor //Builder 패턴을 활용해 유연한 객체 생성 보장
@Entity @Table @Getter
@NoArgsConstructor
public class Order extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID", nullable = false)
    @ManyToOne @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(name = "ORDER_ITEM_ID")
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    // 연관 관계 메소드
    public void setMember(Member member){
        //기존 관계 제거
        if (this.member != null) this.member.getOrders().remove(this);
        this.member = member;
        this.member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.assginOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.assignOrder(this);
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}

