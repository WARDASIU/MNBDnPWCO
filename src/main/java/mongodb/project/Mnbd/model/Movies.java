package mongodb.project.Mnbd.model;

import jakarta.annotation.Nullable;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@AllArgsConstructor
@Data
@Document
@Setter
@Getter
public class Movies {
    @Id
    public long id;

    @Field("gatunek")
    public String category;

    @Field("imie i nazwisko aktorow")
    public List<String> actors;

    @Field("ocena filmu")
    public String rating;

    @Field("rezyser")
    public String director;

    @Field("rok premiery")
    public Integer releaseYear;

    @Field("streszczenie fabuly")
    public String plotSynopsis;

    @Field("tytul")
    public String title;
}
