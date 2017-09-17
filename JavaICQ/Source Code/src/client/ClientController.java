package client;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.*;
import javafx.util.Callback;
import server.ServerConstants;

import java.net.*;
import java.util.*;
import java.awt.Desktop;
import java.io.*;

public class ClientController implements Initializable {
	
	static String loginuser;
	String peeruser;
	
	@FXML
	Button btnSend;

	@FXML
	Button btnExit;

	@FXML
	TableView<Member> tblMemberList;

	@FXML
    TableColumn<Member, String> tblColName;

	@FXML
    TableColumn<Member, String> tblColIP;

    @FXML
    TableColumn<Member, Integer> tblColPort;

    @FXML
    TableColumn<Member, Boolean> tblColBlock;

	public ObservableList<Member> listObvMember = FXCollections.observableArrayList ();
	public ObservableList<String> listObvMemberName = FXCollections.observableArrayList ();
	private ClientSocketConnection csc;

	@Override // This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert btnSend != null;
		
		tblMemberList.requestFocus();

		// Set the member list
		tblColName.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));
		tblColIP.setCellValueFactory(new PropertyValueFactory<Member, String>("IPAddress"));
		tblColPort.setCellValueFactory(new PropertyValueFactory<Member, Integer>("port"));
		
		// Set the block's check box
		// Value of isBlocked is automatically updated based on check box value 
		tblColBlock.setCellValueFactory(new PropertyValueFactory<Member, Boolean>("isBlocked"));
		tblColBlock.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Member, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<Member, Boolean> param) {
            	//System.out.println("Value is : "+param.getValue().isBlockedProperty());
                return param.getValue().isBlockedProperty();
            }
        });
		tblColBlock.setCellFactory( CheckBoxTableCell.forTableColumn(tblColBlock) );
		tblColBlock.setEditable( true );
		tblMemberList.setItems(listObvMember);
		tblMemberList.setRowFactory(tv -> new TableRow<Member>() {
		    @Override
		    public void updateItem(Member item, boolean empty) {
		        super.updateItem(item, empty) ;
		        if (item == null) {
		            setStyle("");
		        } else if (item.getName().equals(ClientController.getloginuser())) {
		        	setStyle("-fx-background-color: tomato;");
		        } else {
		        	setStyle("");
		        }
		    }
		});
		
		tblMemberList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        this.peeruser = newSelection.getName();
		    }
		});
	}

	@FXML
	private void handleButtonActionSend (ActionEvent event) throws Exception{
		//performSend(txtSend.getText());
		createChat(this.peeruser, ClientController.loginuser);
		
	}

	@FXML
	private void handleButtonActionExit (ActionEvent event) throws Exception{
		csc.stopClient();

		Stage stage = (Stage) btnExit.getScene().getWindow();
	    stage.close();
		//Platform.exit();
	}
	
	public static void setloginuser(String loginuser) 
	{
		ClientController.loginuser = loginuser;
	}
	public static String getloginuser()
	{
		return ClientController.loginuser;
	}
	
	public void setClientSocketConnection (ClientSocketConnection csc) {
		this.csc = csc;
	}
	/*
	public void setChatController (ChatController cc) {
		this.cc = cc;
	}
	*/

	public void createChat(String peeruser, String loginuser) throws IOException
	{
		FXMLLoader fxmlLoaderClientChat = new FXMLLoader(getClass().getResource("ClientChat.fxml"));
		Parent ClientChat = (Parent)fxmlLoaderClientChat.load();
		ChatController cc = fxmlLoaderClientChat.<ChatController>getController();
		this.csc.setChatController(cc, this.peeruser);
		//notice this csc
		cc.setClientSocketConnection(this.csc);
		
		Scene sceneClientChat = new Scene(ClientChat);
		sceneClientChat.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Stage stage = new Stage();
		stage.setScene(sceneClientChat);
		stage.setTitle (this.peeruser);
		stage.show();
		
		cc.setpeeruser(peeruser, loginuser);
	}
	/*
	public void setSceneChat(Scene scene) {
		this.sceneChat = scene;
	}
	*/

}