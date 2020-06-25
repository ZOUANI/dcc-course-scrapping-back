package sd.jfr.web_scraping.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String entitled;
    private String description;
    private int hourlyVolume;
    private String difficulty;
    private int rating;
    private String language;
    private String courseLink;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Chapter> chapters = new ArrayList<>();

}
