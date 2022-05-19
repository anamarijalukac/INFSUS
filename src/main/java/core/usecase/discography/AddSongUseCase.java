package core.usecase.discography;

import core.domain.Album;
import core.domain.Discography;
import core.domain.Song;
import core.usecase.UseCase;

import java.time.Year;
import java.util.Date;

public class AddSongUseCase extends UseCase<AddSongUseCase.InputValues, AddSongUseCase.OutputValues> {

    private final DiscographyRepository repository;

    public AddSongUseCase(DiscographyRepository repository) {
        this.repository = repository;
    }


    @Override
    public OutputValues execute(InputValues input) throws Exception {
        Song song=new Song(input.getName(),input.getDate(),input.getArtist());
        Album album=input.getAlbum();
        repository.addSong(album,song);
        return new AddSongUseCase.OutputValues(song);

    }

    public static class InputValues implements UseCase.InputValues {
        private final String name;
        private final Date date;
        private final String artist;
        private final Album album;

        public InputValues(String name, Date date, String artist, Album album) {
            this.name = name;
            this.date = date;
            this.artist = artist;
            this.album = album;
        }

        public String getName() {
            return name;
        }

        public Date getDate() {
            return date;
        }

        public String getArtist() {
            return artist;
        }

        public Album getAlbum() {
            return album;
        }
    }

    public static class OutputValues implements UseCase.OutputValues {
        private final Song song;

        public OutputValues(Song song) {
            this.song = song;
        }
    }
}
