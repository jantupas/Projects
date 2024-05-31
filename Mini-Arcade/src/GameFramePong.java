
import java.awt.*;
import javax.swing.*;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameFramePong extends JFrame{
    GamePanelPong panel;
    
	GameFramePong(){
		panel = new GamePanelPong();
		this.add(panel);
		this.setTitle("Pong");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);    
	}
}