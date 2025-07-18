@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository repo;
    private final UserRepository userRepo;

    public ContentDTO createContent(ContentDTO dto) {
        Content content = new Content();
        content.setTitle(dto.getTitle());
        content.setBody(dto.getBody());
        content.setCreatedAt(LocalDateTime.now());
        content.setAuthor(getCurrentUser());
        return mapToDTO(repo.save(content));
    }

    // getAll, updateContent, deleteContent...

    private User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByUsername(username).orElseThrow();
    }

    private ContentDTO mapToDTO(Content content) {
        return new ContentDTO(content.getId(), content.getTitle(), content.getBody(), content.getAuthor().getUsername());
    }
}
