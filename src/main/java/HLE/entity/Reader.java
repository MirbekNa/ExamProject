package HLE.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
@Entity
@Table(name = "readers")
@ToString
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reader_gen")
    @SequenceGenerator(name = "reader_gen", sequenceName = "reader_seq", allocationSize = 1, initialValue = 100)
    private Long id;
    private String name;
    private int age;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinColumn(name = "book_id")
    private Book book;
    public Reader(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}