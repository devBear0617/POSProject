package calculator;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Calculator extends JFrame {
	private String chkInput; // ���� ������ ������ üũ �� ���� (��������, �������� ���� �ϱ� ���� ����)
	private int numOne, sum, total, sosu;
	private int count = 0, inputChk = 0; // üũ�� ����(count), ������ ������ ���� (��������, �������� ���� �ϱ� ���� ����)
	private final String names[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "00", ".", "+", "��", "=", "C"};
	private JTextField inputText;
 
	// ���� ���̾ƿ�
	public Calculator(){
		BorderLayout layout = new BorderLayout(2, 2);
		setLayout(layout);
		
		//textInput
		JPanel groupPanel = new JPanel(new BorderLayout(5, 2));
		inputText = new JTextField("", SwingConstants.CENTER);
		inputText.setHorizontalAlignment(JTextField.RIGHT);
		groupPanel.add(inputText, BorderLayout.CENTER);
  
		//padPanel
		JPanel padPanel = new JPanel(new GridLayout(5, 5));
		JButton buttons[] = new JButton[names.length];
  
		for(int count = 0; count < names.length; count++){
			buttons[count] = new JButton(names[count]);
			padPanel.add(buttons[count]);
			if(count==names.length-1) {
				ClearButton handler = new ClearButton();
				buttons[count].addActionListener(handler);
			}else {
				PadInput handler = new PadInput();
				buttons[count].addActionListener(handler);
			}
		}
		add(groupPanel, BorderLayout.NORTH);
		add(padPanel, BorderLayout.CENTER);
	}
 
	// ���� ����
	private class PadInput implements ActionListener {
		
		public void actionPerformed(ActionEvent event){
			String eventText = event.getActionCommand();

			if(eventText.equals("+")){
				inputChk = 1;
			}else if(eventText.equals("-")){
				inputChk = 2;
			}else if(eventText.equals("*")){
				inputChk = 3;
			}else if(eventText.equals("/")){
				inputChk = 4;
			}else if(eventText.equals("=")){
				inputChk = 5;
			}else{
				// ���� �Է� �� �ؽ�Ʈ �ʵ忡 ���ο� ���ڰ� ��� �� ��� �ؽ�Ʈ �ʵ带 ����ֱ� ���� ī��Ʈ
				if(count == 1){
					inputText.setText("");
					count = 0;
				}
				// ����ڰ� �Է��ϴ� ���ڸ� �����Ͽ� �ؽ�Ʈ �󺧿� ǥ���Ѵ�.
				inputText.setText(inputText.getText()+event.getActionCommand()); 
			}
   
			// ��Ģ���� ����
			try{
				// �����Է� ���� �����ȣ�� �������� ���� ��� ó��
				if((total != 0) && (inputChk <= 5)){
					inputText.setText(inputText.getText()); // �ؽ�Ʈ �󺧿� �ƹ��͵� ǥ�� ���� �ʴ´�.
				}
				else{
					if( inputChk == 1 ){ // ���� ������ ���
						numOne = Integer.parseInt(inputText.getText());
						total += numOne;
						numOne = 0;
						inputText.setText(String.valueOf(total));
      
						// ���ο� �ι�° ���� ���� �Է� �ϱ� ���� �ؽ�Ʈ ���� �ʱ�ȭ �Ѵ�.
						count = 1;
						// ���� �����ڸ� �����ϱ� ���� üũ ���� �Ѱ� ������ ���� �� �� �ְ� �Ѵ�.
						chkInput = "+"; 
					}else if( inputChk == 2 ){ // ���� ������ ���
						numOne = Integer.parseInt(inputText.getText());
						total += numOne;
						numOne = 0;
						inputText.setText(String.valueOf(total));
      
						count = 1;
						chkInput = "-";
					}else if( inputChk == 3 ){ // ���� ������ ���
						numOne = Integer.parseInt(inputText.getText());
						total += numOne;
						numOne = 0;
						inputText.setText(String.valueOf(total));
      
						count = 1;
						chkInput = "*";
					}else if( inputChk == 4 ){ // ������ ������ ���
						numOne = Integer.parseInt(inputText.getText());
						total += numOne;
						numOne = 0;
						inputText.setText(String.valueOf(total));
      
						count = 1;
						chkInput = "/";
					}
				}
			}catch(Exception e){
				System.out.println(" Error ==> " + e);
			}
   
			// �ƹ� �Է� ����( �� �ؽ�Ʈ �ʵ� ) ���� ������ �� ��� ó��
			if(total == 0){
				inputText.setText(inputText.getText()); // �ƹ��� ������ ������ ����.
			}else{
				// ��� �� =
				if((inputChk == 5) && chkInput.equals("+")){
					numOne = Integer.parseInt(inputText.getText()); // ����  �ؽ�Ʈ �ʵ忡 �����ִ� ���� �����´�.
					sum = numOne + total; // ���� �ؽ�Ʈ �ʵ忡 �ִ� ���ڿ� �����Ǿ� �ִ� total ���� ���� ���� �Ѵ�.
     
					count = 1;
					numOne = 0;
					total = 0;
					inputText.setText(String.valueOf(sum));
				}else if((inputChk == 5) && chkInput.equals("-")){
					numOne = Integer.parseInt(inputText.getText());
					sum = total - numOne;
     
					count = 1;
					numOne = 0;
					total = 0;
					inputText.setText(String.valueOf(sum));
				}else if((inputChk == 5) && chkInput.equals("*")){
					numOne = Integer.parseInt(inputText.getText());
					sum = numOne * total;
     
					count = 1;
					numOne = 0;
					total = 0;
					inputText.setText(String.valueOf(sum));
				}else if((inputChk == 5) && chkInput.equals("/")){
					numOne = Integer.parseInt(inputText.getText());
					sum = total / numOne;
     
					count = 1;
					numOne = 0;
					total = 0;
					inputText.setText(String.valueOf(sum));
				}
			}
		}
	}
 
	// �Ҽ��� ó��
	public void chkNum(String tField){
		if(tField.indexOf(".") != -1){
			sosu = 1;
		}else{
			sosu = 0;
		}
		return;
	}
 
	// C - �ʱ�ȭ
	private class ClearButton implements ActionListener{
		public void actionPerformed(ActionEvent event){
			inputText.setText("");
			numOne = 0;
			total = 0;
			sum = 0;
			count = 0;
			inputChk = 0;
		}
	}
 
	
	//Main
	public static void main(String args[]){
		Calculator calStart = new Calculator();
		//calStart.pack(); // �ּ����� ������� �ڵ����� ������ ������ ����
		calStart.setSize(210, 350);
		calStart.setResizable(false);
		calStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calStart.setVisible(true);
	}
}