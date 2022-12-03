package IAWithUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Homework implements Serializable{
	
	private String assignmentName;
	private String subject;
	private int dueYear;
	private int dueMonth;
	private int dueDay;
	private int priority;
	
	
	static int HWNum = 0;
	
	public Homework(String assignmentName, String subject, int dueYear, int dueMonth, int dueDay, int priority)
	{
		this.assignmentName = assignmentName;
		this.subject = subject;
		this.dueYear = dueYear;
		this.dueMonth = dueMonth;
		this.dueDay = dueDay;
		this.priority = priority;
	}
	
	public String getAssignmentName()
	{
		return assignmentName;
	}
	
	public String getSubject()
	{
		return subject;
	}
	
	public int getDueYear()
	{
		return dueYear;
	}
	
	public int getDueMonth()
	{
		return dueMonth;
	}
	
	public int getDueDay()
	{
		return dueDay;
	}
	
	public int getPriority()
	{
		return priority;
	}
	
	
	
	public void setAssignmentName(String assignmentName)
	{
		this.assignmentName = assignmentName;
	}
	
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	
	public void setDueYear(int dueYear)
	{
		this.dueYear = dueYear;
	}
	
	public void setDueMonth(int dueMonth)
	{
		this.dueMonth = dueMonth;
	}
	
	public void setDueDay(int dueDay)
	{
		this.dueDay = dueDay;
	}
	
	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	
	public static int getHWNum(int HWNum)
	{
		
		File file = new File("HW" + HWNum + ".txt");
		
		if (ResourceManager.fileExists(file) == true)
		{
			HWNum++;
			return (getHWNum(HWNum));
		}
		else
		{
			return HWNum--;

		}
		
	}


	/*HWNum = 1;
	
	File file = new File("HW" + HWNum + ".txt");
	
	while (ResourceManager.fileExists(file) == true)
	{
		HWNum++;
		file = new File("HW" + HWNum + ".txt");
	}
	
	return HWNum;*/
	
	
	
	
}
