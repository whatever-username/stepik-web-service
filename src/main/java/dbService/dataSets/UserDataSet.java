package dbService.dataSets;

/**
 * Created by Innokentiy on 25.08.2017.
 */
@SuppressWarnings("UnusedDeclaration")
public class UserDataSet {
    private long id;
    private String name;

    public UserDataSet(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UsersDataSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}