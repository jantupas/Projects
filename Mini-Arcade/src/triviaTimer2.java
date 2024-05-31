
import java.util.TimerTask;


public class triviaTimer2 extends TimerTask{
    Trivia2 trivia2;
    
    public triviaTimer2(Trivia2 trivia2){
        this.trivia2=trivia2;
    }
    
    public void run(){
        if(trivia2.num == 0){
            trivia2.timer.cancel();
            trivia2.timeOver();
        }
        else{
            decrement();
            trivia2.gettimeNum().setText(Integer.toString(trivia2.num));
            
        }
    }

    public void decrement(){
            trivia2.num--;
        }
                
    
}
