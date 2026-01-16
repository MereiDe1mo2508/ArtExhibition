package repositories.interfaces;
import entities.artwork;
import java.util.List;
public interface IartworkRepository {
    boolean CreatedArtwork(artwork artwork);
    artwork getArtwork(int id);
    List<artwork> getAllArtworks();
}
