package iaulife.handler;

import iaulife.entity.Person;
import iaulife.entity.User;


import javax.jws.soap.SOAPBinding;
import java.sql.*;


public class DataBaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() {

        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName
                    + "?autoReconnect=true&useSSL=false";
            Class.forName("com.mysql.jdbc.Driver");

            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dbConnection;

    }
    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Constants.USERS_TABLE + "(" +
                Constants.USER_ROLE_ID + "," + Constants.USER_EMAIL+ "," + Constants.USER_PASSWORD + ")" +
                "VALUE(?,?,?)";
        try {
            if (user.getRoleId() != 0 && !user.getMail().equals("") && !user.getPassword().equals("")) {

                PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                prSt.setInt(1, user.getRoleId());
                prSt.setString(2, user.getMail());
                prSt.setString(3, user.getPassword());

                prSt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void signUpPerson(Person person) {
        String insert = "INSERT INTO " + Constants.PERSONS_TABLE + "(" +
                Constants.PERSONS_NAME + "," + Constants.PERSONS_SURNAME+ "," + Constants.PERSONS_BIRTHDAY  +")" +
                "VALUE(?,?,?)";
        try {
            if (!person.getName().equals("") && !person.getSurname().equals("") && !person.getBirthday().equals("") ) {

                PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                prSt.setString(1, person.getName());
                prSt.setString(2, person.getSurname());
                prSt.setString(3, person.getBirthday());


                prSt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet getUser(User user) {
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Constants.USERS_TABLE + " WHERE " + Constants.USER_EMAIL + "=? AND "
                + Constants.USER_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getMail());
            prSt.setString(2, user.getPassword());


            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public ResultSet getEmail(User user) {
        ResultSet resultSet = null;

        String select = "SELECT * FROM " + Constants.USERS_TABLE + " WHERE " + Constants.USER_EMAIL + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getMail());

            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public void getPassword(){};
    public void getStatus(){};


    public void getNews(){};
    public void getSchedule(){};
    public void getEvents(){};
    public void getAnnouncements(){};
    public void getLog(){};

    public void addEvents(){};
    public void addNews(){};
    public void addLog(){};

}
