package com.micropsilocol.psilouser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PsiloUserRepository extends JpaRepository<PsiloUser, Integer> {
    Optional<PsiloUser> findByUsername(String username);
}
