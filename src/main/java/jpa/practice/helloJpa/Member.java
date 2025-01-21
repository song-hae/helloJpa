package jpa.practice.helloJpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter @NoArgsConstructor
@Entity //JPA 매핑, 엔티티 클래스 선언
@Table(name = "MEMBER") //MEMBER 테이블과 매핑
public class Member {

    @Id //PK 설정
    @Column(name = "ID") //필드와 컬럼 매핑
    private String id;

    @Column(name = "NAME")
    private String userName;

    //매핑 정보 없음 -> 같은 이름의 테이블 컬럼과 자동 매핑
    private Integer age;

    @Builder
    public Member(String id, String userName, Integer age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

}
