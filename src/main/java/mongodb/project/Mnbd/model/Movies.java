package mongodb.project.Mnbd.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Random;

@Data
@Document
@Setter
@Getter
public class Movies {
    @Id
    public int _id;

    @Field("gatunek")
    public String category;

    @Field("imie i nazwisko aktorow")
    public List<String> actors;

    @Field("ocena filmu")
    public int rating;

    @Field("rezyser")
    public String director;

    @Field("rok premiery")
    public Integer releaseYear;

    @Field("streszczenie fabuly")
    public String plotSynopsis;

    @Field("tytul")
    public String title;

    public Movies(final String category,
                  final int rating,
                  final String director,
                  final String plotSynopsis,
                  final String title,
                  final List<String> actors,
                  final Integer releaseYear) {
        this._id = new Random().nextInt(999999);
        this.category = category;
        this.actors = actors;
        this.rating = rating;
        this.director = director;
        this.releaseYear = releaseYear;
        this.plotSynopsis = plotSynopsis;
        this.title = title;
    }
}
