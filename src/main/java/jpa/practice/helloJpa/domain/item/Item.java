package jpa.practice.helloJpa.domain.item;

import jakarta.persistence.*;
import jpa.practice.helloJpa.domain.category.Category;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder @AllArgsConstructor //Builder 패턴을 활용해 유연한 객체 생성 보장
@Entity @Table @Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //상속 관계 매핑, 단일 테이블 전략 활용
@DiscriminatorColumn(name = "DTYPE") //단일 테이블 전략이기에 구분 컬럼 필요
public abstract class Item {
    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @OneToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
