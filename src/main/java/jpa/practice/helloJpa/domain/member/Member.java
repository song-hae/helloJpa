package jpa.practice.helloJpa.domain.member;

import jakarta.persistence.*;
import jpa.practice.helloJpa.domain.BaseTimeEntity;
import jpa.practice.helloJpa.domain.order.Order;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder @AllArgsConstructor //Builder 패턴을 활용해 유연한 객체 생성 보장
@Getter // Entity는 DB에 밀접해 있기 때문에 Setter를 통한 값 변환 막기 위해 만들지 않음
@NoArgsConstructor // JPA가 기본 생성자를 통해 만들기 때문에 필요
@Entity //JPA 매핑, 엔티티 클래스 선언
@Table // 테이블 매핑
public class Member extends BaseTimeEntity {

    @Id //PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    // Entity가 영속 상태가 되려면 식별자가 반드시 필요한데, IDENTITY 전략은 Entity가 DB에 저장되어야 식별자를 구할 수 있다.
    // 따라서 영속 상태가 되는 즉시 insert가 SQL로 전달되기에 쓰기 지연이 동작하지 않는다.
    private Long id;

    @Column(nullable = false, length = 10) // 필수 입력, 최대 길이 10자 제한 사항
    private String name;

    //매핑 정보 없음 -> 같은 이름의 테이블 컬럼과 자동 매핑
    @Column(nullable = false)
    private Integer age;
    /*
     요구 사항 추가
     1. 회원 등급 구분 (회원, 관리자) -> Enum 사용
     2. 회원 가입일과 수정일 -> BaseTImeEntity 사용
     3. 회원 설명 필드(필드 길이 제한 x) -> Lob 사용
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Lob
    private String description;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

//    @Builder //Builder 패턴을 활용해 유연한 객체 생성 보장
//    public Member(String name, Integer age, Role role, String description) {
//        this.name = name;
//        this.age = age;
//        this.role = role;
//        this.description = description;
//    }

}
