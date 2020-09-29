package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="avion")
public class Avion {

    public static final String POLJE_OZNAKA="oznaka";
    public static final String POLJE_RASPON_KRILA="raspon_krila";

    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField(columnName = "POLJE_OZNAKA", canBeNull = false)
    public String oznaka;
    @DatabaseField(columnName = POLJE_RASPON_KRILA, canBeNull = false)
    public int rasponKrila;

    @ForeignCollectionField(foreignFieldName = "avion")
    private ForeignCollection<Roba> roba;


    public Avion() {
    }

    public Avion(String oznaka, int raspon_krila) {
        this.oznaka = oznaka;
        this.rasponKrila = raspon_krila;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public int getRaspon_krila() {
        return rasponKrila;
    }

    public void setRaspon_krila(int raspon_krila) {
        this.rasponKrila = raspon_krila;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "id=" + id +
                ", oznaka='" + oznaka + '\'' +
                ", raspon_krila=" + rasponKrila +
                '}';
    }
}
