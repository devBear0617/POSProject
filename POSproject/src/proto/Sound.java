package proto;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Sound extends Thread {
	
	private Player player; 	// ���� ���
	private boolean isloop;	// 1�� ������� ���ѹݺ�����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Sound(String name, boolean isloop) {
		try {
			this.isloop = isloop;
			file = new File(Main.class.getResource("../sound/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void close() {
		isloop = false;
		player.close();
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isloop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
