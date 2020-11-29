package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Member;
import com.example.library.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAll() {
        return memberRepository.getAll();
    }
    public boolean addMember(Member member) {
        Member newMember = new Member(member.getFirstName(), member.getLastName(), member.getUsername());
        memberRepository.addMember(newMember);
        return true;
    }

    public List<String> borrowedByMember(String username)
    {
        return memberRepository.borrowedByMember(username);
    }
}