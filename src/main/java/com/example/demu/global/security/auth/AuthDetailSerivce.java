package com.example.demu.global.security.auth;

import com.example.demu.domain.user.domain.Usexr;
import com.example.demu.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailSerivce implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
        Usexr user = userRepository.findByAccountId(accountId)
                .orElseThrow(() -> new UsernameNotFoundException(accountId));

        return new AuthDetail(user);
    }
}
