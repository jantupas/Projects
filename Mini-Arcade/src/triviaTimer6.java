
import java.util.TimerTask;


public class triviaTimer6 extends TimerTask{
    Trivia6 trivia6;
    
    public triviaTimer6(Trivia6 trivia6){
        this.trivia6=trivia6;
    }
    
    public void run(){
        if(trivia6.num == 0){
            trivia6.timer.cancel();
            trivia6.timeOver();
        }
        else{
            decrement();
            trivia6.gettimeNum().setText(Integer.toString(trivia6.num));
            
        }
    }

    public void decrement(){
            trivia6.num--;
        }
                
    
}
