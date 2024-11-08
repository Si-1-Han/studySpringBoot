package com.test.usingDB.entity;

import com.test.usingDB.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Setter
@Getter
@Table(name = "member_table") //database에 해당 이름의 테이블 생성
public class MemberEntity { //table 역할
    //jpa ==> database를 객체처럼 사용 가능

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true)
    private String memberEmail;

    @Column
    private String memberID;

    @Column
    private String memberPassword;

    @Column
    private String memberName;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberID(memberDTO.getMemberID());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        return memberEntity;
    }

}