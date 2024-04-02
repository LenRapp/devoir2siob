package sio.devoir2sio1b.Services;

import sio.devoir2sio1b.Model.Action;
import sio.devoir2sio1b.Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicesAction
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ServicesAction()
    {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Action> getAllActionsByTrader(int idTrader) throws SQLException {
        ArrayList<Action> lesActions = new ArrayList<>();
        ps = cnx.prepareStatement("SELECT action.idAction, action.nomAction, acheter.montantAchat, acheter.quantite FROM action " +
                "INNER JOIN acheter on action.idAction = acheter.numAction WHERE action.idAction =  ?");
        ps.setInt(1,idTrader);
        rs= ps.executeQuery();
        while (rs.next()){
            Action action = new Action(rs.getInt(1), rs.getString(2));
            lesActions.add(action);
        }
        ps.close();
        rs.close();
        return lesActions;
    }
    public void updateQuantite(int idTrader, int idAction, int quantite) throws SQLException {

    }
    public void deleteAction(int idTrader, int idAction) throws SQLException {
        ps = cnx.prepareStatement(" DELETE FROM action WHERE action.idAction = ?");
        ps.setInt(1,idTrader);
        ps.setInt(1,idAction);
        ps.executeUpdate();
        ps.close();
    }
}
