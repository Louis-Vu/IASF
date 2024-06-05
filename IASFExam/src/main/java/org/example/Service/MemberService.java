package org.example.service;

import org.example.UserAlreadyExistsException;
import org.example.model.Member;
import org.example.model.Role;
import org.example.Repository.MemberRepository;
import org.example.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Member registerMember(Member member, String role) throws UserAlreadyExistsException {
        if (memberRepository.existsById(member.getUserId())) {
            try {
                throw new UserAlreadyExistsException("User already exists with userId: " + member.getUserId());
            } catch (UserAlreadyExistsException e) {
                throw new RuntimeException(e);
            }
        }
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setActive(true);
        memberRepository.save(member);
        roleRepository.save(new Role(member.getUserId(), role));
        return member;
    }

    public List<Role> getRolesByUserId(String userId) {
        return roleRepository.findByUserId(userId);
    }
}
