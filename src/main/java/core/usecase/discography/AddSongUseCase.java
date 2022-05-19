package core.usecase.discography;

import core.domain.Album;
import core.domain.Discography;
import core.domain.Song;
import core.usecase.UseCase;

import java.util.Date;

public class AddSongUseCase extends UseCase<AddSongUseCase.InputValues, AddSongUseCase.OutputValues> {

    private final DiscographyRepository repository;

    public AddSongUseCase(DiscographyRepository repository) {
        this.repository = repository;
    }


    @Override
    public OutputValues execute(InputValues input) throws Exception {
        Song song=new Song(input.getName(),input.getDate(),input.getArtist(), input.getSongId());


        Discography discography= repository.getDiscographyById(input.getDiscographyId());
        Album result=null;
        for(Album a: discography.getAlbumList()){
            if(a.getId().equals(input.getAlbumId())){
                result=a;
            }
        }

        discography.getAlbumList().remove(result);
        assert result != null;
        result.getSongs().add(song);
        discography.getAlbumList().add(result);

        repository.save(discography);


        return new AddSongUseCase.OutputValues(song);

    }

    public static class InputValues implements UseCase.InputValues {
        private final String name;
        private final Date date;
        private final String artist;
        private final Long songId;
        private final Long discographyId;
        private final Long albumId;

        public InputValues(String name, Date date, String artist, Long albumId, Long discographyId, Long songId, Long discographyId1, Long albumId1) {
            this.name = name;
            this.date = date;
            this.artist = artist;
            this.songId = songId;


            this.discographyId = discographyId1;
            this.albumId = albumId1;
        }

        public Long getSongId() {
            return songId;
        }

        public Long getDiscographyId() {
            return discographyId;
        }

        public Long getAlbumId() {
            return albumId;
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


    }

    public static class OutputValues implements UseCase.OutputValues {
        private final Song song;

        public OutputValues(Song song) {
            this.song = song;
        }
    }
}
