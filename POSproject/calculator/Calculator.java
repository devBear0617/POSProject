package calculator;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Calculator extends JFrame {
	private String chkInput; // 현재 연산을 구분할 체크 값 변수 (덧셈인지, 뺄셈인지 구분 하기 위한 변수)
	private int numOne, sum, total, sosu;
	private int count = 0, inputChk = 0; // 체크값 변수(count), 연산을 구분할 변수 (덧셈인지, 뺄셈인지 구분 하기 위한 변수)
	private final String names[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "00", ".", "+", "←", "=", "C"};
	private JTextField inputText;
 
	// 계산기 레이아웃
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
 
	// 계산기 동작
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
				// 연산 입력 중 텍스트 필드에 새로운 숫자가 들어 올 경우 텍스트 필드를 비워주기 위한 카운트
				if(count == 1){
					inputText.setText("");
					count = 0;
				}
				// 사용자가 입력하는 숫자를 조합하여 텍스트 라벨에 표시한다.
				inputText.setText(inputText.getText()+event.getActionCommand()); 
			}
   
			// 사칙연산 수행
			try{
				// 숫자입력 없이 연산기호만 연속으로 누를 경우 처리
				if((total != 0) && (inputChk <= 5)){
					inputText.setText(inputText.getText()); // 텍스트 라벨에 아무것도 표시 하지 않는다.
				}
				else{
					if( inputChk == 1 ){ // 덧셈 연산일 경우
						numOne = Integer.parseInt(inputText.getText());
						total += numOne;
						numOne = 0;
						inputText.setText(String.valueOf(total));
      
						// 새로운 두번째 연산 수를 입력 하기 위해 텍스트 라벨을 초기화 한다.
						count = 1;
						// 덧셈 연산자를 구분하기 위해 체크 값을 넘겨 연산을 수행 할 수 있게 한다.
						chkInput = "+"; 
					}else if( inputChk == 2 ){ // 뺄셈 연산일 경우
						numOne = Integer.parseInt(inputText.getText());
						total += numOne;
						numOne = 0;
						inputText.setText(String.valueOf(total));
      
						count = 1;
						chkInput = "-";
					}else if( inputChk == 3 ){ // 곱셈 연산일 경우
						numOne = Integer.parseInt(inputText.getText());
						total += numOne;
						numOne = 0;
						inputText.setText(String.valueOf(total));
      
						count = 1;
						chkInput = "*";
					}else if( inputChk == 4 ){ // 나눗셈 연산일 경우
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
   
			// 아무 입력 없이( 빈 텍스트 필드 ) 연산 실행을 할 경우 처리
			if(total == 0){
				inputText.setText(inputText.getText()); // 아무런 반응을 보이지 않음.
			}else{
				// 계산 값 =
				if((inputChk == 5) && chkInput.equals("+")){
					numOne = Integer.parseInt(inputText.getText()); // 현재  텍스트 필드에 남아있는 수를 가져온다.
					sum = numOne + total; // 현재 텍스트 필드에 있는 숫자와 누적되어 있는 total 변수 값을 덧셈 한다.
     
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
 
	// 소수점 처리
	public void chkNum(String tField){
		if(tField.indexOf(".") != -1){
			sosu = 1;
		}else{
			sosu = 0;
		}
		return;
	}
 
	// C - 초기화
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
		//calStart.pack(); // 최소한의 사이즈로 자동으로 프레임 사이즈 조정
		calStart.setSize(210, 350);
		calStart.setResizable(false);
		calStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calStart.setVisible(true);
	}
}