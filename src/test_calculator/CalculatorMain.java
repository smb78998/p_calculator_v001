package test_calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//maybe add error when divide by zero 

public class CalculatorMain implements ActionListener {

	JFrame frame;
	JLabel label;
	
	//Buttons, Lots of Buttons 
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addBut, mulBut, divBut, subBut;
	JButton decBut, enterBut, clearBut, delBut;
	JTextField text;
	JPanel panel;
	ImageIcon Image;
	
	Font myFont = new Font("Ink Free",Font.BOLD,30);
	
	double num1 = 0 , num2= 0, result = 0;
	char operator;
	
	CalculatorMain(){
		//CREATING FRAME -----------------------------------------------------------------------------
		frame = new JFrame("Cool Calculator");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(420,600);
		frame.setLayout(null);
		
		
		//IMAGE, and resize 
		ImageIcon imageIcon = new ImageIcon("cool.png");
		Image image = imageIcon.getImage();
		Image newing = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newing);
		
		//LABEL------------------------------------------------------------------------------
		JLabel label = new JLabel("Cool Calculator");
		label.setBounds(50, 15, 300, 40); //ADD Icon?!?
		label.setBackground(Color.GRAY);
		label.setIcon(imageIcon);
		label.setFont(myFont);
		label.setOpaque(true);
		
		//TEXTFIELD------------------------------------------------------------------------------
		text = new JTextField("");
		text.setBounds(50, 60, 300, 50);
		text.setFont(myFont);
		
		//BUTTONS------------------------------------------------------------------------------
		 addBut = new JButton("+");
		 mulBut = new JButton("*");
		 divBut = new JButton("/");
		 subBut = new JButton("-");
		 decBut = new JButton(".");
		 enterBut = new JButton("=");
		 clearBut = new JButton("Clear");
		 delBut = new JButton("Delete ");
		 
		 functionButtons[0] = addBut;
		 functionButtons[1] = mulBut;
		 functionButtons[2] = divBut;
		 functionButtons[3] = subBut;
		 functionButtons[4] = decBut;
		 functionButtons[5] = enterBut;
		 functionButtons[6] = clearBut;
		 functionButtons[7] = delBut;
		
		 
		 for(int i = 0 ; i < 8 ; i++) { //Use for loop so that we can add things/ edit all buttons easier 
			functionButtons[i].addActionListener(this); //HAVE TO ADD ACTIONLISTENER FOR BUTTON TO BE BUTTON 
			 functionButtons[i].setFont(myFont);
		 }
		 
		 for(int i = 0 ; i<10; i++) {
			 numberButtons[i] = new JButton(String.valueOf(i));
			 numberButtons[i].addActionListener(this);
			 numberButtons[i].setFont(myFont);
		 }
		 
		 delBut.setBounds(50,420,140,50);
		 clearBut.setBounds(200,420,140,50);
		 
		 //PANEL------------------------------------------------------------------------------
		panel = new JPanel()	;
		panel.setBounds(50, 110, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.DARK_GRAY);
		
		
		//1st Row
		panel.add(numberButtons[0]);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(addBut);
		
		//2nd Row
		panel.add(numberButtons[3]);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(subBut);
		
		//3rd Row
		panel.add(numberButtons[6]);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(mulBut);
		
		//4th Row
		panel.add(decBut);
		panel.add(numberButtons[9]);
		panel.add(enterBut);
		panel.add(divBut);
		
		//ADD TO FRAME --------------------------------------------------------------------
		frame.add(delBut);
		frame.add(clearBut);
		frame.add(panel);
		frame.add(text);
		frame.add(label);
		frame.setResizable(false);
		frame.setIconImage(newing);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorMain calculator = new CalculatorMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			/**
			 * We use for loop so that when action performed is equal to out number buttons
			 * 0-9 we will place this on the text area
			 * 
			 * loop is so that we don't have to right actions performed methods for each button
			 */
			
			if(e.getSource() == numberButtons[i]) {
				text.setText(text.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decBut) {
			text.setText(text.getText().concat("."));
		}
		
		if(e.getSource() == addBut) {
			num1 =  Double.parseDouble(text.getText()); //go from String to Double 
			text.setText("");
			operator = '+';
		}
		if(e.getSource() == subBut) {
			num1 =  Double.parseDouble(text.getText()); 
			text.setText("");
			operator = '-';
		}
		if(e.getSource() == mulBut) {
			num1 =  Double.parseDouble(text.getText()); 
			text.setText("");
			operator = '*';
		}
		if(e.getSource() == divBut) {
			num1 =  Double.parseDouble(text.getText()); 
			text.setText("");
			operator = '/';
		}
		if(e.getSource()== clearBut) {
			text.setText("");
		}
		
		//Delete Function, I used StringBuffer to delete the last char
		
		if(e.getSource()==delBut) {
			
			String string = text.getText();
			StringBuffer sb = new StringBuffer(string);
			sb.deleteCharAt(sb.length()-1);
			string = sb.toString();
			text.setText(string);
			
		}
		
		if( e.getSource() == enterBut) {
			num2 = Double.parseDouble(text.getText());
			
			
			switch(operator) {
			case'+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
				
			}
		
			text.setText(String.valueOf(result));
			
			}
		}
		
		
	
	}


