package com.example.library.repository;

import com.example.library.model.Book;
import com.example.library.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository {
    private final List<Member> members = new ArrayList<>();
    public MemberRepository() {
    }

    public void addMember(Member member)
    {
        members.add(member);
    }

    public List<Member> getAll(){
        return members;
    }
    public Optional<Member> findByUsername(String username) {
        return members.stream().filter(member -> member.getUsername().equals(username)).findFirst();
    }

    public List<String> borrowedByMember(String username){
        return members.stream()
                .filter(member -> member.getUsername().equals(username))
                .findFirst().map(Member::getBorrowedBooks)
                .orElse(Collections.emptyList());
    }


}
