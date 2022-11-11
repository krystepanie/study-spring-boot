package com.tutorial.music.model;

import com.tutorial.music.common.validation.ValidYear;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "album")
@Getter
@NoArgsConstructor
@SuperBuilder
public class Album {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @ValidYear
    @Column(name = "publish_year")
    private int publishYear;

    @Column(name = "genre")
    private String genre;

    @Column(name = "discs_amount")
    private int discsAmount;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
