package IAWithUI;

import java.util.ArrayList;
import java.util.Collections;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;

public class HomeworkApp extends JFrame {

	private JPanel contentPane;
	private JPanel panelAssignments;
	private JPanel panelNewHW;
	private JLayeredPane layeredPane;
	private JPasswordField passwordFieldLogin;
	private JTextField textUsernameLogin;
	private JPasswordField passwordFieldRegistrate;
	private JTextField textUsername;
	private JTextField textName;
	private JTextField textSubject;
	private JTextField textPriority;
	private JTextField textDueYear;
	private JTextField textDueMonth;
	private JTextField textDueDay;
	private JTextField textDeleteAssignmentNum;
	
	private String tempText = "";

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					HomeworkApp frame = new HomeworkApp();
					frame.setVisible(true);
					
				} 
				
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
			}
		});
	}
	
	
	public void switchPanels(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();

	}
	

	/**
	 * Create the frame.
	 */
	public HomeworkApp() {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1120, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(24, 66, 1068, 587);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelAssignments = new JPanel();
		layeredPane.add(panelAssignments, "name_313509302035779");
		panelAssignments.setLayout(null);
		
		JScrollPane scrollPaneAssignments = new JScrollPane();
		scrollPaneAssignments.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneAssignments.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneAssignments.setBounds(532, 63, 530, 518);
		panelAssignments.add(scrollPaneAssignments);
		
		JTextArea textAreaAssignments = new JTextArea();
		scrollPaneAssignments.setViewportView(textAreaAssignments);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(163,79,200,20);
		panelAssignments.add(dateChooser);
		
		JButton btnListHW = new JButton("View All Assignments");
		btnListHW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textAreaAssignments.setText("");
				tempText = "";

				for (int i = 1; i < Homework.getHWNum(1); i++)
				{
					try {
						
						Homework HW = (Homework) ResourceManager.load("HW" + i + ".txt");
						tempText = tempText + "\n\n" + "Assignment Number " + i + ": " +
								"\n   Assignment Name: " + HW.getAssignmentName() +
								"\n   Subject: " + HW.getSubject() +
								"\n   Due Date: " + HW.getDueMonth() + "/" + HW.getDueDay() + "/" + HW.getDueYear() +
								"\n   Priority: " + HW.getPriority();
						
						textAreaAssignments.setText(tempText);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Couldn't load assignments from " + e1.getMessage());
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				
				
				
				
			}
		});
		btnListHW.setBounds(719, 22, 177, 29);
		panelAssignments.add(btnListHW);
		
		JButton btnListHWByPriority = new JButton("By Priority");
		btnListHWByPriority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tempText = "";
				textAreaAssignments.setText("");
				
				//Gets all priorities of assignments
				
				for (int p = 3; p > 0; p--)
				{
					for (int i = 1; i < Homework.getHWNum(1); i++)
					{
						try {
							Homework HW = (Homework) ResourceManager.load("HW" + i + ".txt");
							if (HW.getPriority() == p)
							{
								tempText = tempText + "\n\n" + "Assignment Number " + i + ": " +
										"\n   Assignment Name: " + HW.getAssignmentName() +
										"\n   Subject: " + HW.getSubject() +
										"\n   Due Date: " + HW.getDueMonth() + "/" + HW.getDueDay() + "/" + HW.getDueYear() +
										"\n   Priority: " + HW.getPriority();
							}
							
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Couldn't load assignments from " + e1.getMessage());
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
				
				
				textAreaAssignments.setText(tempText);

				
			}
		});
		btnListHWByPriority.setBounds(931, 22, 96, 29);
		panelAssignments.add(btnListHWByPriority);
		
		JLabel lblNewLabel_6 = new JLabel("Assignments only on ");
		lblNewLabel_6.setBounds(21, 79, 147, 16);
		panelAssignments.add(lblNewLabel_6);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(21, 124, 499, 457);
		panelAssignments.add(scrollPane);
		
		JTextArea textAreaHWForTheDay = new JTextArea();
		scrollPane.setViewportView(textAreaHWForTheDay);
		
		JButton btnHWOnDay = new JButton("View");
		btnHWOnDay.addActionListener(new ActionListener() {
			//@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {
				
				tempText = "";
				textAreaHWForTheDay.setText("");
				
				String date = String.valueOf(dateChooser.getDate());
				
				String year = "" + date.charAt(24) + date.charAt(25) + date.charAt(26) + date.charAt(27);
				String monthInLetters = "" + date.charAt(4) + date.charAt(5) + date.charAt(6);
				String day = "" + date.charAt(8) + date.charAt(9);
				
				if (day.charAt(0) == '0')
				{
					day = "" + date.charAt(9);
				}
				
				int month = 0;
				if (monthInLetters.equals("Jan")){month = 1;}
				if (monthInLetters.equals("Feb")){month = 2;}
				if (monthInLetters.equals("Mar")){month = 3;}
				if (monthInLetters.equals("Apr")){month = 4;}
				if (monthInLetters.equals("May")){month = 5;}
				if (monthInLetters.equals("Jun")){month = 6;}
				if (monthInLetters.equals("Jul")){month = 7;}
				if (monthInLetters.equals("Aug")){month = 8;}
				if (monthInLetters.equals("Sep")){month = 9;}
				if (monthInLetters.equals("Oct")){month = 10;}
				if (monthInLetters.equals("Nov")){month = 11;}
				if (monthInLetters.equals("Dec")){month = 12;}
				
				for (int i = 1; i < Homework.getHWNum(1); i++)
				{
					try {
					Homework HW = (Homework) ResourceManager.load("HW" + i + ".txt");
					if (Integer.toString(HW.getDueYear()).equals(year))
					{
						if (HW.getDueMonth() == month)
						{
							if (Integer.toString(HW.getDueDay()).equals(day))
							{
								tempText = tempText + "\n\n" + "Assignment Number " + i + ": " +
										"\n   Assignment Name: " + HW.getAssignmentName() +
										"\n   Subject: " + HW.getSubject() +
										"\n   Due Date: " + HW.getDueMonth() + "/" + HW.getDueDay() + "/" + HW.getDueYear() +
										"\n   Priority: " + HW.getPriority();
								
								textAreaHWForTheDay.setText(tempText);
							}
						}
					}	
				}
				catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Couldn't load assignments from " + e1.getMessage());
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
	
			}
		}
		});
		
		btnHWOnDay.setBounds(375, 76, 117, 29);
		panelAssignments.add(btnHWOnDay);
		
		JLabel lblNewLabel_6_1 = new JLabel("Delete Assignment #:");
		lblNewLabel_6_1.setBounds(21, 27, 147, 16);
		panelAssignments.add(lblNewLabel_6_1);
		
		textDeleteAssignmentNum = new JTextField();
		textDeleteAssignmentNum.setBounds(163, 22, 130, 26);
		panelAssignments.add(textDeleteAssignmentNum);
		textDeleteAssignmentNum.setColumns(10);
		
		JButton btnDeleteAssignment = new JButton("Done");
		btnDeleteAssignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				File file = new File("HW" + Homework.getHWNum(1) + ".txt"); //Creates a new .txt file for later use
				int TotalHWCount = Homework.getHWNum(1); //Stores the current total count of assignments 
				
				int deleteHWNum = Integer.parseInt(textDeleteAssignmentNum.getText()); //Obtains the assignment number that will be deleted
				File fileDelete = new File("HW" + deleteHWNum + ".txt"); //Reads 
				fileDelete.delete();
				
				for (int i = deleteHWNum + 1; i <= TotalHWCount; i++)
				{
					file = new File("HW" + i + ".txt");
					int s = i - 1;
					File file2 = new File("HW" + s + ".txt");
					file.renameTo(file2);
					
				}
				
				textDeleteAssignmentNum.setText("");
			}
		});
		btnDeleteAssignment.setBounds(299, 22, 117, 29);
		panelAssignments.add(btnDeleteAssignment);
		
		JButton btnListHWByDueDate = new JButton("By Due Date");
		btnListHWByDueDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tempText = "";
				textAreaAssignments.setText("");
				
				//Gets all due dates of assignments
				String day = "0";
				String month = "0";
				
				ArrayList<Integer> dueDates = new ArrayList<Integer>();
				
				for (int i = 1; i < Homework.getHWNum(1); i++)
				{
					try {
					Homework HW = (Homework) ResourceManager.load("HW" + i + ".txt");
					if (String.valueOf(HW.getDueDay()).length() == 1)
					{
						day = "0" + HW.getDueDay();
					}
					else 
					{
						day = "" + HW.getDueDay();
					}
					
					if (String.valueOf(HW.getDueMonth()).length() == 1)
					{
						month = "0" + HW.getDueMonth();
					}
					else
					{
						month = "" + HW.getDueMonth();
					}
					
					String date = String.valueOf(HW.getDueYear()) + month + day;

					dueDates.add(Integer.valueOf(date));
					
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Couldn't load assignments from " + e1.getMessage());
						//JOptionPane.showMessageDialog(null, "False due dates");
						// TODO Auto-generated catch block
						e1.printStackTrace();
					 }
				}
				
				Collections.sort(dueDates);
				
				for (int i = 0; i < dueDates.size(); i++)
				{
					for (int j = 1; j < Homework.getHWNum(1); j++)
					{
						try {
							Homework HW = (Homework) ResourceManager.load("HW" + j + ".txt");
							String Year = "" + Integer.toString(dueDates.get(i)).charAt(0) 
									+ Integer.toString(dueDates.get(i)).charAt(1) 
									+ Integer.toString(dueDates.get(i)).charAt(2) 
									+ Integer.toString(dueDates.get(i)).charAt(3);
							String Month = "" + Integer.toString(dueDates.get(i)).charAt(4) 
									+ Integer.toString(dueDates.get(i)).charAt(5);  
							String Day = "" + Integer.toString(dueDates.get(i)).charAt(6) 
									+ Integer.toString(dueDates.get(i)).charAt(7);
							
							if (Month.charAt(0) == '0')
							{
								Month = Month.substring(1);
							}
							if (Day.charAt(0) == '0')
							{
								Day = Day.substring(1);
							}
							
						if (Year.equals(Integer.toString(HW.getDueYear())))
						{
							if (Month.equals(Integer.toString(HW.getDueMonth())))
							{
								if (Day.equals(Integer.toString(HW.getDueDay())))
								{
									int assignmentNum = j;
									tempText = tempText + "\n\n" + "Assignment Number " + assignmentNum + ": " +
											"\n   Assignment Name: " + HW.getAssignmentName() +
											"\n   Subject: " + HW.getSubject() +
											"\n   Due Date: " + HW.getDueMonth() + "/" + HW.getDueDay() + "/" + HW.getDueYear() +
											"\n   Priority: " + HW.getPriority();
						
								}
							}
						}
					} catch (Exception e1) {
						//JOptionPane.showMessageDialog(null, "Couldn't load assignments from " + e1.getMessage());
						JOptionPane.showMessageDialog(null, "Some assignments have incorrect date format");
						// TODO Auto-generated catch block
						e1.printStackTrace();
					 }
					
					}
				}
				
				textAreaAssignments.setText(tempText);
			
			}
		});
		btnListHWByDueDate.setBounds(571, 22, 117, 29);
		panelAssignments.add(btnListHWByDueDate);
		
		panelNewHW = new JPanel();
		layeredPane.add(panelNewHW, "name_313560919431185");
		panelNewHW.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Adding a New Assignment");
		lblNewLabel_1.setFont(new Font("Apple Chancery", Font.PLAIN, 48));
		lblNewLabel_1.setBounds(265, 16, 661, 106);
		panelNewHW.add(lblNewLabel_1);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(236, 155, 214, 26);
		panelNewHW.add(textName);
		
		textSubject = new JTextField();
		textSubject.setColumns(10);
		textSubject.setBounds(236, 193, 214, 26);
		panelNewHW.add(textSubject);
		
		textPriority = new JTextField();
		textPriority.setColumns(10);
		textPriority.setBounds(236, 230, 214, 26);
		panelNewHW.add(textPriority);
		
		textDueYear = new JTextField();
		textDueYear.setColumns(10);
		textDueYear.setBounds(629, 155, 214, 26);
		panelNewHW.add(textDueYear);
		
		textDueMonth = new JTextField();
		textDueMonth.setColumns(10);
		textDueMonth.setBounds(629, 193, 214, 26);
		panelNewHW.add(textDueMonth);
		
		textDueDay = new JTextField();
		textDueDay.setColumns(10);
		textDueDay.setBounds(629, 230, 214, 26);
		panelNewHW.add(textDueDay);
		
		JLabel lblNewLabel_5 = new JLabel("Assignment Name:");
		lblNewLabel_5.setBounds(105, 160, 119, 16);
		panelNewHW.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Assignment Subject:");
		lblNewLabel_5_1.setBounds(95, 198, 129, 16);
		panelNewHW.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel(" Assignment Priority:");
		lblNewLabel_5_2.setBounds(92, 235, 132, 16);
		panelNewHW.add(lblNewLabel_5_2);
		
		JTextArea txtrLow = new JTextArea();
		txtrLow.setText("     \n     1 - Low\n     2 - Medium\n     3 - High\n");
		txtrLow.setBackground(new Color(211, 211, 211));
		txtrLow.setBounds(236, 268, 214, 80);
		panelNewHW.add(txtrLow);
		
		JLabel lblNewLabel_5_2_1_1 = new JLabel("Due Year:");
		lblNewLabel_5_2_1_1.setBounds(551, 160, 66, 16);
		panelNewHW.add(lblNewLabel_5_2_1_1);
		
		JLabel lblNewLabel_5_2_1_1_1 = new JLabel("Due Month:");
		lblNewLabel_5_2_1_1_1.setBounds(538, 198, 79, 16);
		panelNewHW.add(lblNewLabel_5_2_1_1_1);
		
		JLabel lblNewLabel_5_2_1_1_2 = new JLabel("Due Day:");
		lblNewLabel_5_2_1_1_2.setBounds(551, 235, 66, 16);
		panelNewHW.add(lblNewLabel_5_2_1_1_2);
		
		JDateChooser createDueDate = new JDateChooser();
		createDueDate.setBounds(629, 388, 200, 20);
		panelNewHW.add(createDueDate);
		
		//Updated on 1/25/22 for Spring Term 2022
		//Updated on 6/22 someday I forgot for Summer Term 2022
		String[] choices = { "CMPT 105w", "CMPT 125", "MATH 150", "MATH 152", "MACM 101", "CHIN 330", "CMPT 225", "MATH 232"};
		
		@SuppressWarnings("unchecked")
		JComboBox subjectChooser = new JComboBox(choices);
		subjectChooser.setBounds(237, 388, 213, 27);
		panelNewHW.add(subjectChooser);
		

		/* final JComboBox<String> cb = new JComboBox<String>(choices);

		 cb.setMaximumSize(cb.getPreferredSize()); // added code
		 cb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
		 //cb.setVisible(true); // Not needed
		 panel.add(cb);*/
		
		
		JButton btnAddHWDone = new JButton("Done");
		btnAddHWDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String assignmentName = textName.getText();
				//String subject = textSubject.getText();
				int priority = Integer.parseInt(textPriority.getText());
				

				//JComboBox subjectChooser = (JComboBox)e.getSource();
		        String subjec = (String)subjectChooser.getSelectedItem();
				
				String date = String.valueOf(createDueDate.getDate());
				
				String year = "" + date.charAt(24) + date.charAt(25) + date.charAt(26) + date.charAt(27);
				String monthInLetters = "" + date.charAt(4) + date.charAt(5) + date.charAt(6);
				String day = "" + date.charAt(8) + date.charAt(9);
				
				if (day.charAt(0) == '0')
				{
					day = "" + date.charAt(9);
				}
				
				int month = 0;
				if (monthInLetters.equals("Jan")){month = 1;}
				if (monthInLetters.equals("Feb")){month = 2;}
				if (monthInLetters.equals("Mar")){month = 3;}
				if (monthInLetters.equals("Apr")){month = 4;}
				if (monthInLetters.equals("May")){month = 5;}
				if (monthInLetters.equals("Jun")){month = 6;}
				if (monthInLetters.equals("Jul")){month = 7;}
				if (monthInLetters.equals("Aug")){month = 8;}
				if (monthInLetters.equals("Sep")){month = 9;}
				if (monthInLetters.equals("Oct")){month = 10;}
				if (monthInLetters.equals("Nov")){month = 11;}
				if (monthInLetters.equals("Dec")){month = 12;}
				
				int dueYear = Integer.parseInt(year);
				int dueMonth = month;
				int dueDay = Integer.parseInt(day);
				
				Homework HW = new Homework(assignmentName, subjec, dueYear, dueMonth, dueDay, priority);
				
				try {
					ResourceManager.save(HW, "HW" + Homework.getHWNum(1) +".txt");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Couldn't save assignments into " + e1.getMessage());
				}
				
				textName.setText("");
				textSubject.setText("");
				textPriority.setText("");
				textDueYear.setText("");
				textDueMonth.setText("");
				textDueDay.setText("");
				
					
				textAreaAssignments.setText(tempText);

				}
				

				
			}
		);
		
		
		btnAddHWDone.setBounds(629, 277, 214, 71);
		panelNewHW.add(btnAddHWDone);
		
		JLabel lblNewLabel_5_2_1_1_3 = new JLabel("Due Date:");
		lblNewLabel_5_2_1_1_3.setBounds(551, 392, 66, 16);
		panelNewHW.add(lblNewLabel_5_2_1_1_3);

		JPanel panelLogin = new JPanel();
		layeredPane.add(panelLogin, "name_370734151275319");
		panelLogin.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome Back!");
		lblNewLabel_3.setFont(new Font("Adobe Arabic", Font.BOLD | Font.ITALIC, 61));
		lblNewLabel_3.setBounds(392, 136, 373, 67);
		panelLogin.add(lblNewLabel_3);
		
		passwordFieldLogin = new JPasswordField();
		passwordFieldLogin.setBounds(407, 298, 214, 26);
		panelLogin.add(passwordFieldLogin);
		
		JLabel lblNewLabel_4 = new JLabel("Password: ");
		lblNewLabel_4.setBounds(325, 303, 78, 16);
		panelLogin.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Username:");
		lblNewLabel_4_1.setBounds(325, 275, 78, 16);
		panelLogin.add(lblNewLabel_4_1);
		
		textUsernameLogin = new JTextField();
		textUsernameLogin.setBounds(407, 270, 214, 26);
		panelLogin.add(textUsernameLogin);
		textUsernameLogin.setColumns(10);
		
		JButton btnNewHW = new JButton("New Assignment >");
		btnNewHW.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnNewHW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelNewHW);
				btnNewHW.setEnabled(false);
			}
		});
		btnNewHW.setBounds(922, 17, 170, 29);
		contentPane.add(btnNewHW);
		
		JButton btnMainMenu = new JButton("< Back");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switchPanels(panelAssignments);
				btnNewHW.setEnabled(true);
			}
		});
		btnMainMenu.setBounds(28, 17, 117, 29);
		contentPane.add(btnMainMenu);
		
	
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = textUsernameLogin.getText();
				char[] pass = passwordFieldLogin.getPassword();
				String password = new String(pass); 
				
				try {
					User user1 = (User) ResourceManager.load("user.txt");
					
					if (username.equals(user1.getUserName()))
					{
						if (password.equals(user1.getPassword()))
						{
							JOptionPane.showMessageDialog(null, "Welcome back! " + user1.getUserName());
							switchPanels(panelAssignments);
							btnNewHW.setEnabled(true);
							btnMainMenu.setEnabled(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Wrong password/username! Please try again! ");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong password/username! Please try again! ");
					}
					
				} catch (Exception e1) {
					//JOptionPane.showMessageDialog(null, "File " + e1.getMessage() + " isn't found on this system.");
					JOptionPane.showMessageDialog(null, "Couldn't load user info from " + e1.getMessage());
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		});
		
		btnLogin.setBounds(633, 270, 117, 54);
		panelLogin.add(btnLogin);
		
		JPanel panelRegistration = new JPanel();
		layeredPane.add(panelRegistration, "name_370773592391189");
		panelRegistration.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("Please Register Below: ");
		lblNewLabel_3_1.setFont(new Font("Adobe Arabic", Font.BOLD | Font.ITALIC, 61));
		lblNewLabel_3_1.setBounds(332, 139, 456, 67);
		panelRegistration.add(lblNewLabel_3_1);
		
		passwordFieldRegistrate = new JPasswordField();
		passwordFieldRegistrate.setBounds(429, 296, 214, 26);
		panelRegistration.add(passwordFieldRegistrate);
		
		JLabel lblNewLabel_4_2 = new JLabel("New Password: ");
		lblNewLabel_4_2.setBounds(309, 301, 116, 16);
		panelRegistration.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("New Username:");
		lblNewLabel_4_1_1.setBounds(309, 273, 108, 16);
		panelRegistration.add(lblNewLabel_4_1_1);
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		textUsername.setBounds(429, 268, 214, 26);
		panelRegistration.add(textUsername);
		
		JButton btnCreateUser = new JButton("Create");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String username = textUsername.getText();
				char[] pass = passwordFieldRegistrate.getPassword();
				String password = new String(pass); 
				
				User user = new User(username, password);
				
				try {
					ResourceManager.save(user, "user.txt");
					JOptionPane.showMessageDialog(null, "Successful! Account Created!");
				} catch (Exception e1) {
					System.out.println("Couldn't save: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Couldn't save user data into " + e1.getMessage());
				}
				
				switchPanels(panelAssignments);
				btnNewHW.setEnabled(true);
				btnMainMenu.setEnabled(true);
				
			}
		});
		btnCreateUser.setBounds(655, 268, 117, 51);
		panelRegistration.add(btnCreateUser);
		
		
		
		
		
		File fileUser = new File("user.txt");
		
		if (ResourceManager.fileExists(fileUser) == false)
		{
			switchPanels(panelRegistration);
			btnNewHW.setEnabled(false);
			btnMainMenu.setEnabled(false);
		}
		
		if (ResourceManager.fileExists(fileUser) == true)
		{
			switchPanels(panelLogin);
			btnNewHW.setEnabled(false);
			btnMainMenu.setEnabled(false);
		}
		
		
		
	}
}
