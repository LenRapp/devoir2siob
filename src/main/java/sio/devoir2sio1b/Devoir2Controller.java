package sio.devoir2sio1b;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sio.devoir2sio1b.Model.Action;
import sio.devoir2sio1b.Model.Trader;
import sio.devoir2sio1b.Services.ServicesAction;
import sio.devoir2sio1b.Services.ServicesTrader;
import sio.devoir2sio1b.Tools.ConnexionBDD;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Devoir2Controller implements Initializable {

    private ConnexionBDD maCnx;
    Integer numTraders;
    @FXML
    private TableColumn tcMontantAchatAction;
    @FXML
    private TableColumn tcNumeroTrader;
    @FXML
    private TableView<Trader> tvTraders;
    @FXML
    private TableColumn tcNumeroAction;
    @FXML
    private TableColumn tcNomAction;
    @FXML
    private TableColumn tcQuantiteAction;
    @FXML
    private TableColumn tcNomTrader;
    @FXML
    private TableView<Action> tvActions;
    @FXML
    private TextField txtMontantTotalPortefeuille;
    @FXML
    private TextField txtNomAction;
    @FXML
    private TextField txtQuantiteAction;
    @FXML
    private Button btnVendre;
    private ServicesTrader servicesTrader;
    private ServicesAction servicesAction;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try {
            maCnx= new ConnexionBDD();
            servicesTrader = new ServicesTrader();
            servicesAction = new ServicesAction();


            tcNomTrader.setCellValueFactory(new PropertyValueFactory<>("nomTrader"));
            tcNumeroTrader.setCellValueFactory(new PropertyValueFactory<>("idTrader"));
            tvTraders.setItems(FXCollections.observableArrayList(servicesTrader.getAllTraders()));

            tcNomAction.setCellValueFactory(new PropertyValueFactory<>("nomAction"));
            tcNumeroAction.setCellValueFactory(new PropertyValueFactory<>("idAction"));

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void tvTradersClicked(Event event) throws SQLException
    {
        numTraders = tvTraders.getSelectionModel().getSelectedItem().getIdTrader();
        tvActions.setItems(FXCollections.observableArrayList(servicesAction.getAllActionsByTrader(numTraders)));
    }

    @FXML
    public void btnVendreClicked(Event event) throws SQLException
    {
        if (tvActions.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("choix de l'action");
            alert.setContentText("veuillez choisir une action");
            alert.setHeaderText("");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("choix de la quantité");
            alert.setContentText("veuillez choisir une quantité");
            alert.setHeaderText("");
            alert.showAndWait();
        }

    }

    @FXML
    public void tvActionsClicked(Event event)
    {
        // A vous de jouer
    }
}