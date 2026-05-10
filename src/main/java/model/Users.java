package model;

public class Users {
	
	
	    private int id;
	    private String name;
	    private String email;
	    private byte[] image;
	    
	    
	    public Users() {

	    }
	    
	    
	    public Users(int id, String name, String email, byte[] image) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.image = image;
	    }
	    
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public byte[] getImage() {
	        return image;
	    }

	    public void setImage(byte[] image) {
	        this.image = image;
	    }
	


	}

	


