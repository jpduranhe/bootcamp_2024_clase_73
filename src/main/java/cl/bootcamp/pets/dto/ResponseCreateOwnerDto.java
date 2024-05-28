package cl.bootcamp.pets.dto;

public class ResponseCreateOwnerDto {

	private int id;
	
	
	public ResponseCreateOwnerDto(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
}
