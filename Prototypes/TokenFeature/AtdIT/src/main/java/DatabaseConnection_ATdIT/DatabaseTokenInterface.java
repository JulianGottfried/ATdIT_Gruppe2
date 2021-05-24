package DatabaseConnection_ATdIT;

public interface DatabaseTokenInterface {
	
	void insertNewData();
	
	void updateStatus(String tokenId);
	
	void searchToken(String tokenId);

}
