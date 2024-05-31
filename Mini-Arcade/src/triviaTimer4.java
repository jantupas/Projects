
import java.util.TimerTask;


public class triviaTimer4 extends TimerTask{
    Trivia4 trivia4;
    
    public triviaTimer4(Trivia4 trivia4){
        this.trivia4=trivia4;
    }
    
    public void run(){
        if(trivia4.num == 0){
            trivia4.timer.cancel();
            trivia4.timeOver();
        }
        else{
            decrement();
            trivia4.gettimeNum().setText(Integer.toString(trivia4.num));
            
        }
    }

    public void decrement(){
            trivia4.num--;
        }
                
    
}
