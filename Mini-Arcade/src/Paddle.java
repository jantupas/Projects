
import java.awt.*;
import java.awt.event.*;


public class Paddle extends Rectangle{

	int id;
	int yVelocity;
	int speed = 10;
	
	Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		this.id=id;
	}
	
	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(speed);
			}
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		switch(id) {
		case 2:
			if(e.getKeyCode()== KeyEvent.VK_W) {
				setYDirection(0);
			}
			if(e.getKeyCode()== KeyEvent.VK_S) {
				setYDirection(0);
			}
			break;
		}
	}
        

        
        public void mouseMoved(MouseEvent e){
            y = e.getY();
        }
        
        public void mouseDragged(MouseEvent e){
            switch (id){
                case 1:
                    if(e.getY() == MouseEvent.MOUSE_DRAGGED)
                        setYDirection(0);
            }
        }
        

        
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	public void move() {
		y= y + yVelocity;
	}
	public void draw(Graphics g) {
		if(id==1)
			g.setColor(Color.green);
		else
			g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}