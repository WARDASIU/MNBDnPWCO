package mongodb.project.Mnbd.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document
@Setter
@Getter
public class MovieRental {
    @Id
    public ObjectId _id;
    public Client client;
    public String movieTitle;
    public Date dateOfRental;
    public Date plannedDateOfReturn;

    @SneakyThrows
    public MovieRental(final Client client, final String movieTitle, final String dateOfRental, final String plannedDateOfReturn) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.client = client;
        this.movieTitle = movieTitle;
        this.dateOfRental = inputFormat.parse(dateOfRental);
        this.plannedDateOfReturn = inputFormat.parse(plannedDateOfReturn);
    }
}
