package com.test.usingDB.repository;

import com.test.usingDB.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long>//어떤 Entity인지, pk 어떤 타입인지
{
    // 아이디로 회원 정보 조회( select * from member_table where member_id=?)
    Optional<MemberEntity> findByMemberID(String memberID);
}