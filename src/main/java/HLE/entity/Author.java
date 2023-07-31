package HLE.entity;

import java.time.LocalDate;
import java.util.List;

import HLE.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
// Author entity
@Entity
@Table(name = "authors")

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_gen")
    @SequenceGenerator(name = "author_gen", sequenceName = "author_seq")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String country;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "author_publisher",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id")
    )
    private List<Publisher> publishers;
@ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    public Author(String firstName, String lastName, String email, LocalDate dateOfBirth, String country, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.gender = gender;
    }
}
