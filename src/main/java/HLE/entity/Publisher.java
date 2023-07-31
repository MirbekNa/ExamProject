package HLE.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_gen")
    @SequenceGenerator(name = "publisher_gen", sequenceName = "publisher_seq", allocationSize = 1, initialValue = 100)
    private Long id;
    private String name;
    private String address;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "author_publisher",
            joinColumns = @JoinColumn(name = "publisher_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
