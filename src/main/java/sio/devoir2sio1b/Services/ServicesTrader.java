package sio.devoir2sio1b.Services;

import sio.devoir2sio1b.Model.Action;
import sio.devoir2sio1b.Model.Trader;
import sio.devoir2sio1b.Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicesTrader
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServicesTrader()
    {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Trader> getAllTraders() throws SQLException {
        ArrayList<Trader> lesTraders = new ArrayList<>();
        ps = cnx.prepareStatement("SELECT idTrader, nomTrader FROM trader");
        rs = ps.executeQuery();
        while (rs.next()){
            Trader trader = new Trader(rs.getInt(1), rs.getString(2));
            lesTraders.add(trader);
        }
        ps.close();
        rs.close();
        return lesTraders;
    }

    public double getMontantTotalPortefeuille(int idTrader) throws SQLException {

        return 0;
    }
}
