package com.example.book_social_network.history;

import com.example.book_social_network.book.Book;
import com.example.book_social_network.common.BaseEntity;
import com.example.book_social_network.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookTransactionHistory extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // user relationship

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;// book relationship

    private boolean returned ;

    private boolean returnApproved;
}
