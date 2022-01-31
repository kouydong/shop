package com.shop.controller;

import com.shop.dto.MemberFormDto;
import com.shop.entity.Member;
import com.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    //private final PasswordEncoder passwordEncoder;
    @GetMapping("/new")
    public String memberForm(Model model) {
        System.out.println("맴버 페이지 이동1");
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "members/memberForm";
    }

    @PostMapping("/new")
    public String memberForm(MemberFormDto memberFormDto) {
        System.out.println("Classname ==> MemberController.java");
        System.out.println("Name===>" + memberFormDto.getName());
        System.out.println("Email Address===>" + memberFormDto.getEmail());
        System.out.println("Password===>" + memberFormDto.getPassword());
        System.out.println("Address===>" + memberFormDto.getAddress());

        // 맴버 객체에 저장 데이터 값 설정
        Member member = Member.createMember(memberFormDto);

        // 맴버 저장
        memberService.saveMember(member);

        return "redirect:/";
    }


    public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {

        // 에러 발생시 return
        if(bindingResult.hasErrors()) {
            return "member/memberForm";
        }

        try {
            Member member = Member.createMember(memberFormDto);
            memberService.saveMember(member);
        } catch(IllegalStateException e) {
            model.addAttribute("errorMessage",e.getMessage());
            return "member/memberForm";
        }
        return "redirect:/";

    }


}
