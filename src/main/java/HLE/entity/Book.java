package HLE.entity;
import HLE.enums.Genre;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_gen")
    @SequenceGenerator(name = "book_gen", sequenceName = "book_seq", allocationSize = 1, initialValue = 100)
    private Long id;
    private String name;
    private String address;
    private LocalDate publishedYear;
    private BigDecimal price;
    private Genre genre;
   @ToString.Exclude
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Publisher> publishers;
@ToString.Exclude
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Author> authors;

    public Book(String name, String address, LocalDate publishedYear, BigDecimal price, Genre genre) {
        this.name = name;
        this.address = address;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
    }

}