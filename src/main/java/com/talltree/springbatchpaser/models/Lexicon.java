@Entity(name = "lexicon")
public class Lexicon {

    @Id
    private Integer id;
    private String strongNumnber;
    private String greekDefinition;

    public Lexicon() {

    }

    public Lexicon(Integer id, String strongNumnber, String greekDefinition) {
        this.id = id;
        this.strongNumnber = strongNumnber;
        this.greekDefinition = greekDefinition;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrongNumnber() {
        return this.strongNumnber;
    }

    public void setStrongNumnber(String strongNumnber) {
        this.strongNumnber = strongNumnber;
    }

    public String getGreekDefinition() {
        return this.greekDefinition;
    }

    public void setGreekDefinition(String greekDefinition) {
        this.greekDefinition = greekDefinition;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", strongNumnber='" + getStrongNumnber() + "'" +
            ", greekDefinition='" + getGreekDefinition() + "'" +
            "}";
    }

}