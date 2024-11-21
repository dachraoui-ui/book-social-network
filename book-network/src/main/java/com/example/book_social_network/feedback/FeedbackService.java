package com.example.book_social_network.feedback;


import com.example.book_social_network.book.Book;
import com.example.book_social_network.book.BookRepository;
import com.example.book_social_network.exception.OperationNotPermittedException;
import com.example.book_social_network.history.BookTransactionHistory;
import com.example.book_social_network.user.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor

public class FeedbackService {

    private final BookRepository bookRepository;
    public Integer save(FeedbackRequest request, Authentication connectedUser) {
        Book book = bookRepository.findById(request.bookId())
                .orElseThrow(() -> new EntityNotFoundException("No book  found with the ID::" + request.bookId()));
        if (book.isArchived() || !book.isShareable()){
            throw new OperationNotPermittedException("You cannot give a feedback for an archived or non shareable book ");
        }
        User user = ((User) connectedUser.getPrincipal());
        if (Objects.equals(book.getOwner().getId(),user.getId())){
            throw new OperationNotPermittedException("You cannot give a feedback for your own book ");
        }
        Feedback feedback = feedbackMapper.toFeedback(request);
    }
}
