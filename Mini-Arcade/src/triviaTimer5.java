
import java.util.TimerTask;


public class triviaTimer5 extends TimerTask{
    Trivia5 trivia5;
    
    public triviaTimer5(Trivia5 trivia5){
        this.trivia5=trivia5;
    }
    
    public void run(){
        if(trivia5.num == 0){
            trivia5.timer.cancel();
            trivia5.timeOver();
        }
        else{
            decrement();
            trivia5.gettimeNum().setText(Integer.toString(trivia5.num));
            
        }
    }

    public void decrement(){
            trivia5.num--;
        }
                
    
}
