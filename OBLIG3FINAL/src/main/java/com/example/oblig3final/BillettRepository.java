package com.example.oblig3final;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillettRepository {
    @Autowired
    private JdbcTemplate db;
    //Save billettene
    public void lagreBillett(BillettLager innBillett){
        String sql = "INSERT INTO BillettLager (film, antall, fnavn, enavn, telefon, email) VALUES(?,?,?,?,?,?)";
        db.update(sql, innBillett.getFilm(), innBillett.getAntall(), innBillett.getFnavn(), innBillett.getEnavn(), innBillett.getTelefon(), innBillett.getEmail());
    }
    //Get all billettene
    public List<BillettLager> hentAlleBilletter(){
        String sql = "SELECT * FROM BillettLager order by enavn";
        List<BillettLager> alleBilletter = db.query(sql, new BeanPropertyRowMapper<>(BillettLager.class));
        return alleBilletter;
    }
    //Delete all billettene
    public void slettAlleBilletter(){
        String sql = "DELETE FROM BillettLager";
        db.update(sql);
    }
}