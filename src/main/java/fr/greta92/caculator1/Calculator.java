package fr.greta92.caculator1;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
    int sum(int a, int b) {
        return a + b;
    }
}