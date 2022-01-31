package com.shop.service;

import com.shop.dto.MemberFormDto;
import com.shop.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    public Member createMember() {

        MemberFormDto memberFormDto = new MemberFormDto();

        memberFormDto.setEmail("kouydong22@gmail.com");

        memberFormDto.setName("고의동");

        memberFormDto.setAddress("강북구 미아동");

        memberFormDto.setPassword("1234");

        return Member.createMember(memberFormDto);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest() {

        Member member = createMember();
        Member saveMember = memberService.saveMember(member);

        assertEquals(member.getEmail(), saveMember.getEmail());
        assertEquals(member.getName(), saveMember.getName());
        assertEquals(member.getAddress(), saveMember.getAddress());
        assertEquals(member.getPassword(), saveMember.getPassword());
        assertEquals(member.getRole(), saveMember.getRole());
    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateMemberTest() {
        /*
        Member member1 = createMember();
        Member member2 = createMember();

        memberService.saveMember(member1);
        */

    }
}