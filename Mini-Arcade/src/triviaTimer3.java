
import java.util.TimerTask;


public class triviaTimer3 extends TimerTask{
    Trivia3 trivia3;
    
    public triviaTimer3(Trivia3 trivia3){
        this.trivia3=trivia3;
    }
    
    public void run(){
        if(trivia3.num == 0){
            trivia3.timer.cancel();
            trivia3.timeOver();
        }
        else{
            decrement();
            trivia3.gettimeNum().setText(Integer.toString(trivia3.num));
            
        }
    }

    public void decrement(){
            trivia3.num--;
        }
                
    
}
