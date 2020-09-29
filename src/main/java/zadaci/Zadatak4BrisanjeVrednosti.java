package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

import java.io.IOException;

public class Zadatak4BrisanjeVrednosti {
    static Dao<Avion,Integer> avionDao;
    static Dao<Roba,Integer> robaDao;

    public static void main(String[] args) {

        ConnectionSource connectionSource = null;
        try {
            // create our data-source for the database
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionroba.db");


        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


