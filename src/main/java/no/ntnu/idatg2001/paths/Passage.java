package no.ntnu.idatg2001.paths;
import java.util.List;
import java.util.Objects;


/**
 * The type Passage.
 */
public class Passage {
    private String title;
    private String content;
    private List<Link> link;

    /**
     * Instantiates a new Passage.
     *
     * @param title   the title
     * @param content the content
     */
    public Passage(String title, String content){
        this.title = title;
        this.content = content;

    }


    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Add link boolean.
     *
     * @param link the link
     * @return the boolean
     */
    public boolean addLink(Link link){
        return true;
    }

    /**
     * Gets link.
     *
     * @return the link
     */
    public List<Link> getLink() {
        return link;
    }

    /**
     * Has link boolean.
     *
     * @return the boolean
     */
    public boolean hasLink(){
        return true;
    }

    @Override
    public String toString() {
        return "Passage{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", link=" + link +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passage passage = (Passage) o;
        return title.equals(passage.title) && content.equals(passage.content) && link.equals(passage.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, link);
    }
}