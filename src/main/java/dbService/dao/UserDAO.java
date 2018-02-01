package dbService.dao;

import dbService.dataSets.UserDataSet;
import dbService.executor.Executor;
import dbService.executor.ResultHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private Executor executor;

    public UserDAO(Connection connection) {
        this.executor = new Executor(connection);
    }

    public UserDataSet get(long id) throws SQLException {

        return executor.execQuery("select * from users where id=" + id,
                new ResultHandler<UserDataSet>() {
                    public UserDataSet handle(ResultSet resultSet) throws SQLException {
                    resultSet.next();
                    return new UserDataSet(resultSet.getLong(1),resultSet.getString(2) );
                    }
                });
    }

    public long getUserId(String name) throws SQLException {
        return executor.execQuery("select * from users where user_name='" + name + "'",
                new ResultHandler<Long>() {
                    public Long handle(ResultSet resultSet) throws SQLException {
                    resultSet.next();
                    return resultSet.getLong(1);
                    }
                });
    }

    public void insertUser(String name) throws SQLException {
        executor.execUpdate("insert into users (user_name) values ('" + name + "')");
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment, user_name varchar(256), primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }
}