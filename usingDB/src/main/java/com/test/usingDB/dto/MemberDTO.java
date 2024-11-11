package com.test.usingDB.dto;

import com.test.usingDB.entity.MemberEntity;
import lombok.*;

//lombok dependency추가
@Getter
@NoArgsConstructor
@ToString
@Data
public class MemberDTO { //회원 정보를 필드로 정의
    private Long id;
    private String memberID;
    private String memberPassword;
    private String memberName;
    private String memberEmail;

    @Builder
    public MemberDTO(Long id, String memberID, String memberPassword, String memberName, String memberEmail) {
        this.id = id;
        this.memberID = memberID;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
    }

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        return MemberDTO.builder()
                .id(memberEntity.getId())
                .memberID(memberEntity.getMemberID())
                .memberPassword(memberEntity.getMemberPassword())
                .memberName(memberEntity.getMemberName())
                .memberEmail(memberEntity.getMemberEmail())
                .build();
    }
}