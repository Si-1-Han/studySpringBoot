package com.test.usingDB.entity;

import com.test.usingDB.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Data
@NoArgsConstructor
@Table(name = "member_table") //database에 해당 이름의 테이블 생성
public class MemberEntity { //table 역할
    //jpa ==> database를 객체처럼 사용 가능

    @jakarta.persistence.Id
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

    @Builder
    public MemberEntity(String memberEmail, String memberID, String memberPassword, String memberName) {
        this.memberEmail = memberEmail;
        this.memberID = memberID;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
    }


    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        return MemberEntity.builder()
                .memberEmail(memberDTO.getMemberEmail())
                .memberID(memberDTO.getMemberID())
                .memberPassword(memberDTO.getMemberPassword())
                .memberName(memberDTO.getMemberName())
                .build();
    }

}

