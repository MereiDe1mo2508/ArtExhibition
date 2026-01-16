package controllers;
import entities.artwork;
import repositories.interfaces.IartworkRepository;

import java.sql.SQLException;
import java.util.List;
public class artworkController {
    private final IartworkRepository repository;

    public artworkController(IartworkRepository repository) {
        this.repository = repository;
    }
    public String createArtwork(String title, String artist, int date_of_creating, String copyrighted) {
        boolean yes = (copyrighted.toLowerCase().equals("yes"));
        artwork artwork = new artwork(title, artist, date_of_creating, yes);
        boolean created = repository.CreatedArtwork(artwork);
        return created ? "Artwork Created" : "Artwork Not Created";
    }
    public String getArtwork(int id) {
        artwork artwork = repository.getArtwork(id);
        return (artwork == null) ? "Artwork Not Found" : artwork.toString();
    }
    public String getAllArtworks() {
        List<artwork> artworks = repository.getAllArtworks();
        return artworks.toString();
    }
}
