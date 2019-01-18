package proto;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class POS_proto extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	// 더블버퍼링을 위해서 전체 화면에 대한 이미지를 담는 인스턴스

	private ImageIcon exit_B = new ImageIcon(Main.class.getResource("../image/blueButton.png"));
	private ImageIcon exit_R = new ImageIcon(Main.class.getResource("../image/redButton.png"));
	private ImageIcon login_B = new ImageIcon(Main.class.getResource("../image/login(black).png"));
	private ImageIcon login_R = new ImageIcon(Main.class.getResource("../image/login(red).png"));
	private ImageIcon m1 = new ImageIcon(Main.class.getResource("../image/m1.png"));
	private ImageIcon m2 = new ImageIcon(Main.class.getResource("../image/m2.png"));
	private ImageIcon m3 = new ImageIcon(Main.class.getResource("../image/m3.png"));
	private ImageIcon m4 = new ImageIcon(Main.class.getResource("../image/m4.png"));
	private ImageIcon m5 = new ImageIcon(Main.class.getResource("../image/m5.png"));
	private ImageIcon m6 = new ImageIcon(Main.class.getResource("../image/m6.png"));	
	private ImageIcon backbutton = new ImageIcon(Main.class.getResource("../image/back.png"));
	private ImageIcon table = new ImageIcon(Main.class.getResource("../image/m1_table.png"));
	private ImageIcon m1menubar = new ImageIcon(Main.class.getResource("../image/m1_menubar.png"));
	private ImageIcon somenu = new ImageIcon(Main.class.getResource("../image/m1_somenu.png"));
	
	private Image background = new ImageIcon(Main.class.getResource("../image/background1.png")).getImage();
	private Image space = new ImageIcon(Main.class.getResource("../image/m1_space.png")).getImage();
	private Image m1_menubar = m1menubar.getImage();
	private Image ordermain = new ImageIcon(Main.class.getResource("../image/orderMain.png")).getImage();
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar.png")));
	
	private JButton exit = new JButton(exit_B);
	private JButton login = new JButton(login_B);
	private JButton m1b = new JButton(m1);
	private JButton m2b = new JButton(m2);
	private JButton m3b = new JButton(m3);
	private JButton m4b = new JButton(m4);
	private JButton m5b = new JButton(m5);
	private JButton m6b = new JButton(m6);
	private JButton back = new JButton(backbutton);
	private JButton back_t_m1 = new JButton(backbutton);
	private JButton t1 = new JButton(table);
	private JButton t2 = new JButton(table);
	private JButton t3 = new JButton(table);
	private JButton so1 = new JButton(somenu);
	private JButton so2 = new JButton(somenu);
	private JButton so3 = new JButton(somenu);
	private JButton so4 = new JButton(somenu);
	private JButton so5 = new JButton(somenu);
	private JButton so6 = new JButton(somenu);

	private int mouseX, mouseY;
	
	private boolean spacescreen = false;
	private boolean m1_menubarscreen = false;
	private boolean orderMain = false;

	public POS_proto() {
		setUndecorated(true);
		// 원래 메뉴바 안보이게

		setTitle("POS_proto");
		// 타이틀
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 사이즈를 메인에서 설정한 값으로
		setResizable(false);
		// 사용자 맘대로 사이즈 변경 못하도록
		setLocationRelativeTo(null);
		// 실행 시 창이 화면 중앙으로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 창을 닫으면 프로그램 종료.
		setVisible(true);
		// 창이 정상적으로 화면에 출력되도록 (디폴트=false)
		setBackground(new Color(0, 0, 0, 0));
		// 원래 메뉴바 색상 없음
		setLayout(null);

		
// 종료 버튼
		exit.setBounds(1220, 0, 60, 60);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setFocusPainted(false);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setIcon(exit_R);
				// 커서 엔터시 손가락 모양으로
				exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exit.setIcon(exit_B);
				// 커서가 나갈때 다시 디폴트 커서로
				exit.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				// 1초 딜레이 주기.
				
				System.exit(0);
			}
		});
		add(exit);
		
// 메인으로 뒤로가기 버튼
		back.setVisible(false);
		back.setBounds(1220, 0, 60, 60);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
				backmain();
			}
		});
		add(back);
		
		back_t_m1.setVisible(false);
		back_t_m1.setBounds(1220, 0, 60, 60);
		back_t_m1.setBorderPainted(false);
		back_t_m1.setContentAreaFilled(false);
		back_t_m1.setFocusPainted(false);
		back_t_m1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
				back_t_m1();
			}
		});
		add(back_t_m1);

		
// 메뉴바
		menuBar.setBounds(0, 0, 1280, 60);
		// 메뉴바 잡고 창을 이동가능하게
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}

		});
		add(menuBar);
		// JFrame에 메뉴바 설정

		
// 로그인 버튼
		login.setBounds(950, 350, 200, 100);
		login.setBorderPainted(false);
		login.setContentAreaFilled(false);
		login.setFocusPainted(false);
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				login.setIcon(login_R);
				// 커서 엔터시 손가락 모양으로
				login.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				login.setIcon(login_B);
				// 커서가 나갈때 다시 디폴트 커서로
				login.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override	// 로그인버튼 이벤트
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
				
				login.setVisible(false);
				background = new ImageIcon(Main.class.getResource("../image/background.png")).getImage();
				m1b.setVisible(true);
				m2b.setVisible(true);
				m3b.setVisible(true);
				m4b.setVisible(true);
				m5b.setVisible(true);
				m6b.setVisible(true);
			
			}
		});

		add(login);
		

// 주메뉴 버튼들
		m1b.setBounds(210, 180, 150, 100);
		m1b.setBorderPainted(false);
		m1b.setContentAreaFilled(false);
		m1b.setFocusPainted(false);
		m1b.setVisible(false);
		m1b.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
				m1b.setVisible(false);
				m2b.setVisible(false);
				m3b.setVisible(false);
				m4b.setVisible(false);
				m5b.setVisible(false);
				m6b.setVisible(false);
				exit.setVisible(false);
				back.setVisible(true);
				
				so1.setVisible(true);
				so2.setVisible(true);
				so3.setVisible(true);
				so4.setVisible(true);
				so5.setVisible(true);
				so6.setVisible(true);
				
				t1.setVisible(true);
				t2.setVisible(true);
				t3.setVisible(true);
				
				spacescreen = true;
				m1_menubarscreen = true;
			
			}
		});
		add(m1b);
		
		m2b.setBounds(420, 180, 150, 100);
		m2b.setBorderPainted(false);
		m2b.setContentAreaFilled(false);
		m2b.setFocusPainted(false);
		m2b.setVisible(false);
		m2b.addMouseListener(new MouseAdapter() {
			@Override	// 로그인버튼 이벤트
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
				m1b.setVisible(false);
				m2b.setVisible(false);
				m3b.setVisible(false);
				m4b.setVisible(false);
				m5b.setVisible(false);
				m6b.setVisible(false);
				exit.setVisible(false);
				back.setVisible(true);
			}
		});
		add(m2b);
		
		m3b.setBounds(630, 180, 150, 100);
		m3b.setBorderPainted(false);
		m3b.setContentAreaFilled(false);
		m3b.setFocusPainted(false);
		m3b.setVisible(false);
		m3b.addMouseListener(new MouseAdapter() {
			@Override	// 로그인버튼 이벤트
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
				m1b.setVisible(false);
				m2b.setVisible(false);
				m3b.setVisible(false);
				m4b.setVisible(false);
				m5b.setVisible(false);
				m6b.setVisible(false);
				exit.setVisible(false);
				back.setVisible(true);
			}
		});
		add(m3b);
		
		m4b.setBounds(210, 360, 150, 100);
		m4b.setBorderPainted(false);
		m4b.setContentAreaFilled(false);
		m4b.setFocusPainted(false);
		m4b.setVisible(false);
		m4b.addMouseListener(new MouseAdapter() {
			@Override	// 로그인버튼 이벤트
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
				m1b.setVisible(false);
				m2b.setVisible(false);
				m3b.setVisible(false);
				m4b.setVisible(false);
				m5b.setVisible(false);
				m6b.setVisible(false);
				exit.setVisible(false);
				back.setVisible(true);
			}
		});
		add(m4b);
		
		m5b.setBounds(420, 360, 150, 100);
		m5b.setBorderPainted(false);
		m5b.setContentAreaFilled(false);
		m5b.setFocusPainted(false);
		m5b.setVisible(false);
		m5b.addMouseListener(new MouseAdapter() {
			@Override	// 로그인버튼 이벤트
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
				m1b.setVisible(false);
				m2b.setVisible(false);
				m3b.setVisible(false);
				m4b.setVisible(false);
				m5b.setVisible(false);
				m6b.setVisible(false);
				exit.setVisible(false);
				back.setVisible(true);
			}
		});
		add(m5b);
		
		m6b.setBounds(630, 360, 150, 100);
		m6b.setBorderPainted(false);
		m6b.setContentAreaFilled(false);
		m6b.setFocusPainted(false);
		m6b.setVisible(false);
		m6b.addMouseListener(new MouseAdapter() {
			@Override	// 로그인버튼 이벤트
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				// 1초 딜레이 주기.
				
				System.exit(0);
			}
		});
		add(m6b);

// => m1
// 소메뉴들
		so1.setVisible(false);
		so1.setBounds(255, 625, 90, 90);
		so1.setBorderPainted(false);
		so1.setContentAreaFilled(false);
		so1.setFocusPainted(false);
		so1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
			}
		});
		add(so1);
		
		so2.setVisible(false);
		so2.setBounds(420, 625, 90, 90);
		so2.setBorderPainted(false);
		so2.setContentAreaFilled(false);
		so2.setFocusPainted(false);
		so2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
			}
		});
		add(so2);
		
		so3.setVisible(false);
		so3.setBounds(585, 625, 90, 90);
		so3.setBorderPainted(false);
		so3.setContentAreaFilled(false);
		so3.setFocusPainted(false);
		so3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
			}
		});
		add(so3);
		
		so4.setVisible(false);
		so4.setBounds(750, 625, 90, 90);
		so4.setBorderPainted(false);
		so4.setContentAreaFilled(false);
		so4.setFocusPainted(false);
		so4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
			}
		});
		add(so4);
		
		so5.setVisible(false);
		so5.setBounds(915, 625, 90, 90);
		so5.setBorderPainted(false);
		so5.setContentAreaFilled(false);
		so5.setFocusPainted(false);
		so5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
			}
		});
		add(so5);
		
		so6.setVisible(false);
		so6.setBounds(1080, 625, 90, 90);
		so6.setBorderPainted(false);
		so6.setContentAreaFilled(false);
		so6.setFocusPainted(false);
		so6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
			}
		});
		add(so6);
		
//테이블들
		t1.setVisible(false);
		t1.setBounds(50, 90, 100, 100);
		t1.setBorderPainted(false);
		t1.setContentAreaFilled(false);
		t1.setFocusPainted(false);
		t1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
				
				t1.setVisible(false);
				t2.setVisible(false);
				t3.setVisible(false);
				so1.setVisible(false);
				so2.setVisible(false);
				so3.setVisible(false);
				so4.setVisible(false);
				so5.setVisible(false);
				so6.setVisible(false);
				back.setVisible(false);
				spacescreen = false;
				m1_menubarscreen = false;
				
				back_t_m1.setVisible(true);
				orderMain = true;
				
				
				
			}
		});
		add(t1);
		
		t2.setVisible(false);
		t2.setBounds(50, 200, 100, 100);
		t2.setBorderPainted(false);
		t2.setContentAreaFilled(false);
		t2.setFocusPainted(false);
		t2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
				
			}
		});
		add(t2);
		
		t3.setVisible(false);
		t3.setBounds(160, 90, 100, 100);
		t3.setBorderPainted(false);
		t3.setContentAreaFilled(false);
		t3.setFocusPainted(false);
		t3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Sound pressbutton = new Sound("buttonSound1.mp3", false);
				pressbutton.start();
				
			}
		});
		add(t3);
		
		
	}

	// 프로그램 시작부터 끝나는 순간까지 계속 이미지를 출력
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); // 단순 이미지 추가
		
		if (spacescreen) {
			g.drawImage(space, 40, 80, null);
		}
		if (m1_menubarscreen) {
			g.drawImage(m1_menubar, 90, 620, null);
		}
		if (orderMain) {
			g.drawImage(ordermain, 0, 0, null);
		}
		
		paintComponents(g); // 메뉴바 그리기 add로 추가되는 애들을 그려줌
		this.repaint();
	}
	
// 뒤로가기 버튼's
	// 주메뉴 선택화면으로 돌아가기
	public void backmain() {
		m1b.setVisible(true);
		m2b.setVisible(true);
		m3b.setVisible(true);
		m4b.setVisible(true);
		m5b.setVisible(true);
		m6b.setVisible(true);
		exit.setVisible(true);
		
		back.setVisible(false);
		so1.setVisible(false);
		so2.setVisible(false);
		so3.setVisible(false);
		so4.setVisible(false);
		so5.setVisible(false);
		so6.setVisible(false);	
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);	
		spacescreen = false;
		m1_menubarscreen = false;
	}
	// 테이블에서 메뉴1로 돌아가기
	public void back_t_m1() {
		back_t_m1.setVisible(false);
		back.setVisible(true);
		
		so1.setVisible(true);
		so2.setVisible(true);
		so3.setVisible(true);
		so4.setVisible(true);
		so5.setVisible(true);
		so6.setVisible(true);
		
		t1.setVisible(true);
		t2.setVisible(true);
		t3.setVisible(true);
		
		spacescreen = true;
		m1_menubarscreen = true;
		orderMain = false;
	}

}
