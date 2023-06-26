package com.project.questappbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "comment")
public class Comment {

    @Id
    private Long id;

    @OnDelete(action = OnDeleteAction.CASCADE) //
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    // bir çok post bir user
    //lazy postu çektiğinde user nesnesi gelmicek. - eager yazsaydım gelecekti.
    @OnDelete(action = OnDeleteAction.CASCADE) // bir   user silinince tüm postları gitsin.
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Lob
    @Column(columnDefinition = "text")
    String text;
}
