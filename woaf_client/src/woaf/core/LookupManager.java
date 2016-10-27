package woaf.core;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import woaf.core.authentication.UserSession;
import woaf.core.dao.DAOAddress;
import woaf.core.functions.AvaiableFunctionsHandler;
import woaf.core.functions.AvaiableTransitionsHandler;
import woaf.core.functions.DTOCollectorForChoose;
import woaf.subject.address.AddressTHandler;
import woaf.subject.contract.ContractTHandler;
import woaf.subject.customer.CustomerTHandler;

public class LookupManager {
	private static LookupManager instance;
	public static LookupManager getInstance(){
		return instance = instance == null ? 
				new LookupManager() : instance;
	}
	
	private LookupManager(){}

	private Object woafLookup(String string){
		try {
			return new InitialContext().lookup(string);
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public UserSession getUserSession(){
		return (UserSession) woafLookup("java:global/woaf_ee/woaf_ejb/UserSessionBean!woaf.core.authentication.UserSession");
	}
	
	public AvaiableFunctionsHandler getAvaiableFunctionsHandler(){ 
		return (AvaiableFunctionsHandler) woafLookup("java:global/woaf_ee/woaf_ejb/AvaiableFunctionsHandlerBean!woaf.core.functions.AvaiableFunctionsHandler");
	}
	
	public AvaiableTransitionsHandler getAvaiableTransitionsHandler(){ 
		return (AvaiableTransitionsHandler) woafLookup("java:global/woaf_ee/woaf_ejb/AvaiableTransitionsHandlerBean!woaf.core.functions.AvaiableTransitionsHandler");
	}
	
	public ContractTHandler getContractTHandler(){
		return (ContractTHandler) woafLookup("java:global/woaf_ee/woaf_ejb/ContractTHandlerBean!woaf.subject.contract.ContractTHandler");
	}

	public DTOCollectorForChoose getDTOCollectorForChoose(){
		return (DTOCollectorForChoose) woafLookup("java:global/woaf_ee/woaf_ejb/DTOCollectorForChooseBean!woaf.core.functions.DTOCollectorForChoose");
	}

	public CustomerTHandler getCustomerTHandler() {
		return (CustomerTHandler) woafLookup("java:global/woaf_ee/woaf_ejb/CustomerTHandlerBean!woaf.subject.customer.CustomerTHandler");
	}
	
	public DAOAddress getDAOAddress() {
		return (DAOAddress) woafLookup("java:global/woaf_ee/woaf_ejb/AddressTHandlerBean!woaf.core.dao.DAOAddress");
	}

	public AddressTHandler getAddressTHandler() {
		return (AddressTHandler) woafLookup("java:global/woaf_ee/woaf_ejb/AddressTHandlerBean!woaf.subject.address.AddressTHandler");
	}
	
}