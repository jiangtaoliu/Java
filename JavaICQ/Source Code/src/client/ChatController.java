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

public class ChatController implements Initializable {
	
	String loginuser;
	String peeruser;
	
	@FXML
	Button btnSend;
	
	@FXML
	Button btnSendBroadcast;

	@FXML
	Button btnExit;
	
	@FXML
	Button btnSendFile;

	@FXML
	Label txtName;

	@FXML
	TextFlow txtConsoleClient;
	
	@FXML
	ScrollPane txtScrollPaneClient;

	@FXML
	TextField txtSend;

	public ObservableList<Member> listObvMember = FXCollections.observableArrayList ();
	public ObservableList<String> listObvMemberName = FXCollections.observableArrayList ();
	private ClientSocketConnection csc;

	@Override // This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert btnSend != null;

		txtSend.requestFocus();
		txtSend.setOnAction(event -> {
			try {
				performSend(txtSend.getText(), ServerConstants.PRIVATE_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

	@FXML
	private void handleButtonActionSendBroadcast (ActionEvent event) throws Exception{
		performSend(txtSend.getText(), ServerConstants.BROADCAST_MESSAGE);
	}
	@FXML
	private void handleButtonActionSend (ActionEvent event) throws Exception{
		performSend(txtSend.getText(), ServerConstants.PRIVATE_MESSAGE);
	}

	public void performSend(String message, int type) throws IOException {
		if (!message.trim().equals("")) {
			if(type == ServerConstants.BROADCAST_MESSAGE) {
				// Send broadcast message
				this.csc.sendMessage(message);
			} else {
				// Send private message
				String receiver = txtName.getText();
				System.out.println(receiver +"|"+message);
				this.csc.sendMessage(ServerConstants.PRIVATE_MESSAGE, receiver +"|"+message);
				Text name = new Text(loginuser+":");
				Text mess = new Text(message);

				this.txtConsoleClient.getChildren().addAll(name, mess);
				txtConsoleClient.getChildren().add(new Text("\n"));
				this.txtScrollPaneClient.setVvalue(1.0); 
				//if (!sender.equals(receiver)) {
				//	addStringConsole("From " + sender + " to "+receiver + "> " + message, ServerConstants.PRIVATE_MESSAGE);
				//}
			}
		}
		txtSend.clear();
		txtSend.requestFocus();
	}

	@FXML
	private void handleButtonActionExit (ActionEvent event) throws Exception{
		//this.csc.stopClient();

		Stage stage = (Stage) btnExit.getScene().getWindow();
	    stage.close();
		//Platform.exit();
	}

	public void addStringConsole(String str, int id){
		
		Text name;
		Text message;
		
		if (id == ServerConstants.BROADCAST_MESSAGE) {
			name = new Text(str.substring(0, str.indexOf(">")+1));
			message = new Text(str.substring(str.indexOf(">")+1, str.length())+"\n");
			
			name.setFill(Color.BLUE);
	
		} else if (id == ServerConstants.SYSTEM_MESSAGE) {
			name = new Text("");
			message = new Text(str+"\n");
			
		} else if (id == ServerConstants.PRIVATE_MESSAGE) {
			name = new Text(str.substring(0, str.indexOf(">")+1));
			//skip the receiver name
			message = new Text(str.substring(str.indexOf(">", 2)+1, str.length())+"\n");
			
			name.setFill(Color.RED);
			
		} else if (id == ServerConstants.ERROR_MESSAGE) {
			name = new Text("");
			message = new Text(str+"\n");
			
			name.setFill(Color.RED);
			message.setFill(Color.RED);
			
		} else if (id == ServerConstants.SEND_ACK_FILE_TO_CLIENT) {
			name = new Text(str.substring(0, str.indexOf(">")+1));
			message = new Text(str.substring(str.indexOf(">")+1, str.length())+"\n");
			
			name.setFill(Color.BLUE);
			
		} else {
			name = new Text("");
			message = new Text(str+"\n");
		}
		
		Platform.runLater(new Runnable() {
			public void run() {
				txtConsoleClient.getChildren().addAll(name, message);
				txtScrollPaneClient.setVvalue(1.0); 
			}
		});
		
		System.out.println(str);

	}
	
	public void addLinkLoadFile(String fileName) {
		Hyperlink clickHere = new Hyperlink("Click here");
		Text toDownload = new Text(" to download ..\n");
		
		Platform.runLater(new Runnable() {
			public void run() {
				txtConsoleClient.getChildren().addAll(clickHere, toDownload);
				txtScrollPaneClient.setVvalue(1.0); 
			}
		});
		
		clickHere.setOnAction(event -> {
			try {
				csc.getFileFromServer(fileName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}
	
	public void addLinkOpenFile(String fileName) {
		Text toOpen = new Text("Click to open the file: ");
		Hyperlink linkFileName = new Hyperlink(fileName);
		
		Platform.runLater(new Runnable() {
			public void run() {
				txtConsoleClient.getChildren().addAll(toOpen, linkFileName);
				txtConsoleClient.getChildren().add(new Text("\n"));
				txtScrollPaneClient.setVvalue(1.0); 
			}
		});
		
		linkFileName.setOnAction(event -> {
			try {
				Desktop.getDesktop().open(new File(txtName.getText()+File.separator+fileName));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}
	
	@FXML
	private void handleButtonActionSendFile (ActionEvent event) throws Exception{
		FXMLLoader fxmlLoaderSendFile = new FXMLLoader(getClass().getResource("SendFile.fxml"));
		Pane rootSendFile = (Pane)fxmlLoaderSendFile.load();
		SendFileController sfc = fxmlLoaderSendFile.<SendFileController>getController();
		
		sfc.setChatController(this);
		sfc.setClientSocketConnection(this.csc);
		sfc.setpeeruser(this.peeruser);

		Scene sceneSendFile = new Scene(rootSendFile);
		sceneSendFile.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Stage stage = new Stage();
		stage.setScene(sceneSendFile);
		stage.setTitle ("Send a File ..");
		stage.show();
	}

	public void setClientSocketConnection (ClientSocketConnection csc) {
		this.csc = csc;
	}
	public void setpeeruser(String peeruser, String loginuser)
	{
		this.peeruser = peeruser;
		this.txtName.setText(peeruser); 
		this.loginuser = loginuser;
	}

}