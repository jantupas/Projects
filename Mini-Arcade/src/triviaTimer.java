
import java.util.TimerTask;


public class triviaTimer extends TimerTask{
    Trivia trivia;
    
    public triviaTimer(Trivia trivia){
        this.trivia=trivia;
    }
    
    public void run(){
        if(trivia.num == 0){
            trivia.timer.cancel();
            trivia.timeOver();
        }
        else{
            decrement();
            trivia.gettimeNum().setText(Integer.toString(trivia.num));
            
        }
    }

    public void decrement(){
            trivia.num--;
        }
                
    
}
