package com.example.book_social_network.feedback;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class FeedbackService {

    public Integer save(FeedbackRequest request, Authentication connectedUser) {
    }
}
