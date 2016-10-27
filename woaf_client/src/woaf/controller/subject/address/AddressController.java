package woaf.controller.subject.address;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import woaf.controller.main.WoafController;
import woaf.core.LookupManager;
import woaf.core.dao.DAOAddress;
import woaf.dto.DTOAddress;
import woaf.subject.address.AAddressController;
import woaf.subject.address.AddressTHandler;

public class AddressController extends AAddressController implements Initializable, WoafController{

	@FXML TextField stfCountry;
	@FXML TextField stfCity;
	@FXML TextField stfStreet;
	@FXML TextField stfNumber;
	@FXML TextField stfZip;
	private int addressId;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}


	@Override
	public void setDTOAddress(DTOAddress address) {
		stfCountry.setText(address.getCountry());
		stfCity.setText(address.getCity());
		stfZip.setText(address.getZipCode());
		stfStreet.setText(address.getStreet());
		stfNumber.setText(address.getNumber());
		addressId = address.getAddressId();
	}


	@Override
	public DTOAddress getDTOAddress() {
		DTOAddress address = new DTOAddress();
		address.setCountry(stfCountry.getText());
		address.setCity(stfCity.getText());
		address.setZipCode(stfZip.getText());
		address.setStreet(stfStreet.getText());
		address.setNumber(stfNumber.getText());
		address.setAddressId(addressId);
		return address;
	}

	@Override
	public void setParentStage(Stage stage) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public DAOAddress getDAOAddress() {
		return LookupManager.getInstance().getDAOAddress();
	}


	@Override
	public AddressTHandler getAddressTHandler() {
		return LookupManager.getInstance().getAddressTHandler();
	}


}