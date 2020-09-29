package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

import java.io.IOException;
import java.util.List;

public class Zadatak3IzmenaVrednosti {
    static Dao<Avion,Integer> avionDao;
    static Dao<Roba,Integer> robaDao;

    public static void main(String[] args) {

        ConnectionSource connectionSource = null;
        try {
            // create our data-source for the database
            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);

            avionDao = DaoManager.createDao(connectionSource, Avion.class);
            robaDao = DaoManager.createDao(connectionSource, Roba.class);

            List<Roba> roba=robaDao.queryForAll();
            for(Roba r:roba)
                System.out.println("Roba = " + r);

            List<Roba>roba1=robaDao.queryForEq(Roba.POLJE_OPIS,"Plasticna stolica");
            Roba robaZaIzmenu=roba1.get(0);

            robaZaIzmenu.setOpis("Drvena stolica");

            robaDao.update(robaZaIzmenu);

            roba=robaDao.queryForAll();
            for(Roba r:roba)
                System.out.println("Roba = " + r);



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


