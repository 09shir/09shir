package IAWithUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable{
	
	private String username;
	private String password;
	

	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public void setUserName(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	
	public String getUserName()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
		
	}
	


}
