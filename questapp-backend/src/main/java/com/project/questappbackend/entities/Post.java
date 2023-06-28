package com.project.questappbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "post")
public class Post {

    @Id
    private Long id;


    //lazy postu çektiğinde user nesnesi gelmicek. - eager yazsaydım gelecekti.
    @OnDelete(action = OnDeleteAction.CASCADE) // bir user silinince tüm postları gitsin.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    private String title;

//    @Lob // large object görüntü ses video vs. bu sayede veri tabanına ekstra yük binmez.
    @Column(columnDefinition = "text")
    private String text;


}
