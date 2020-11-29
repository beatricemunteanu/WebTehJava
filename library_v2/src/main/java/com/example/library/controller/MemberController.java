package com.example.library.controller;

import com.example.library.model.Member;
import com.example.library.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/members"})
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping({"/add"})
    public ResponseEntity<List<Void>> createMember (@RequestBody Member member){
        boolean addedMember = memberService.addMember(member);
        return addedMember ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping({"/all"})
    public List<Member> getAllMembers() {
        return memberService.getAll();
    }

    @GetMapping("/borrowedByMember/{username}")
    public List<String> borrowedByMember(@PathVariable String username){
        return memberService.borrowedByMember(username);
    }

}
