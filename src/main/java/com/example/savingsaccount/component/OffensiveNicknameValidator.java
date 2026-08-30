package com.example.savingsaccount.component;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class OffensiveNicknameValidator {

    private static final Set<String> OFFENSIVE_WORDS = Set.of(
            "idiot", "stupid", "dumb", "moron"
    );

    public boolean isOffensive(String nickname) {
        if (nickname == null || nickname.isBlank()) {
            return false;
        }

        String[] words = nickname.toLowerCase().split("[^a-z0-9]+");
        for (String word : words) {
            if (OFFENSIVE_WORDS.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
