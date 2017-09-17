package client;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import server.ServerConstants;

public class SendFileController implements Initializable {
	
	String loginuser;
	String peeruser;
	
	@FXML
	Button btnBrowse;
	
	@FXML
	Button btnSend;
	
	@FXML
	Button btnExit;

	@FXML
	TextField txtFileName;

	private ClientController clc;
	private ClientSocketConnection csc;
	private ChatController cc;
	
	public ObservableList<String> listObvMemberName = FXCollections.observableArrayList ();

	@Override // This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		
	}

	@FXML
	private void handleButtonActionBrowse(ActionEvent event) {
		Stage stage = (Stage) btnBrowse.getScene().getWindow();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File selectedFile = fileChooser.showOpenDialog(stage);
		if (selectedFile != null) {
			txtFileName.setText(selectedFile.getAbsolutePath());
		}
	}
	
	@FXML
	private void handleButtonActionSend(ActionEvent event) {
		String fileName = txtFileName.getText();
		
		if(!fileName.equals("") && (new File(fileName).isFile())) {
			cc.addStringConsole("Sending a file .. "+fileName, ServerConstants.SYSTEM_MESSAGE);
			cc.txtSend.clear();
			cc.txtSend.requestFocus();
			
			csc.performSendFile(this.peeruser +"|"+fileName);
		}
		
		Stage stage = (Stage) btnExit.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	private void handleButtonActionExit(ActionEvent event) {
		Stage stage = (Stage) btnExit.getScene().getWindow();
	    stage.close();
	}
	
	public void setClientController(ClientController clc) {
		this.clc = clc;
	}
	
	public void setClientSocketConnection(ClientSocketConnection csc) {
		this.csc = csc;
	}
	public void setChatController(ChatController cc) {
		this.cc = cc;
	}
	public void setpeeruser(String peeruser)
	{
		this.peeruser = peeruser;
	}

}