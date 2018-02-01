package dbService.executor;

/**
 * Created by Innokentiy on 25.08.2017.
 */
import java.sql.ResultSet;
import java.sql.SQLException;


public interface ResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
