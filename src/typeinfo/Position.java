package typeinfo;

/**
 * Created by nanca on 8/21/2017.
 */
public class Position {
    private String title;
    private Person person;

    public Position(String jobTitle, Person employee) {
        title = jobTitle;
        person = employee;
        if (person == null) {
            person = Person.NULL;
        }
    }

    public Position(String jobTitle) {
        title = jobTitle;
        person = Person.NULL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person newPerson) {
        this.person = newPerson;
        if (person == null) {
            person = Person.NULL;
        }
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", person=" + person +
                '}';
    }
}
