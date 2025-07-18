@Entity
@Data
public class Content {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String body;

    @ManyToOne
    private User author;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
