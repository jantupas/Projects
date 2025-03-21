
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;


public class Trivia3 extends javax.swing.JFrame {

    int question = 1, points = 0;
    private static int DELAY = 1000;
    private static int PERIOD = 1000;
    Timer timer;
    int num = 75;
    
    
    public Trivia3() {
        initComponents();
        setLocationRelativeTo(null);
    }
    public void question1(){
            hardQues.setText("Where did the name of the Philippines come from?");
            op1.setText("King Philip 1 of Spain");
            op2.setText("Queen Elizabeth");
            op3.setText("King Philip II of Spain");   
            op4.setText("King Philip II of Macedon");         
    }
    public void question2(){
            hardQues.setText("Who is the first editor of La Solidaridad?");
            op1.setText("Graciano Lopez Jaena");
            op2.setText("Emilio Aguinaldo");
            op3.setText("Marcelo H. Del Pilar");   
            op4.setText("Antonio Luna");   
    }
    public void question3(){
            hardQues.setText("Which of the following is the pen name used by Marcelo H. Del Pilar?");
            op1.setText("Taga-ilog");
            op2.setText("Dimasilaw");
            op3.setText("Dimasalang");   
            op4.setText("Plaridel");       
    }
    public void question4(){
            hardQues.setText("Which of the following was the first Filipino Chief Justice of the Supreme Court?");
            op1.setText("Diosdado Peralta");
            op2.setText("Cayetano Arellano");
            op3.setText("Maria Lourdes Sereno");   
            op4.setText("Val Ancheta");
    }
    public void question5(){
            hardQues.setText("The newspaper of the Katipunan was known as?");
            op1.setText("Kaginhawaan");
            op2.setText("Kapayapaan");
            op3.setText("Karangalan");   
            op4.setText("Kalayaan");        
    }
    public void timeOver(){
            int result = JOptionPane.showConfirmDialog(null,"You ran out of time!\nYour total score is " + points + "\nDo you want to play again?","Game over!",JOptionPane.YES_NO_OPTION);
            if(result == 0){
                Trivia3 trivia3 = new Trivia3();
                trivia3.show();
                
                dispose();
            }
            else{
            question = 1;
            points = 0;
            Home home = new Home();
            home.show();
        
            dispose();
            }
    }
    public void gameOver(){
            int result = JOptionPane.showConfirmDialog(null,"Thank you for playing Trivia!\nYour total score is: " + points + "\nDo you want to play again?","Game over!",JOptionPane.YES_NO_OPTION);
            if(result == 0){
                Trivia3 trivia3 = new Trivia3();
                trivia3.show();
                
                dispose();
            }
            else{
            question = 1;
            points = 0;
            Home home = new Home();
            home.show();
        
            dispose();
            }
    }


        


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeNum = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        op1 = new javax.swing.JButton();
        op3 = new javax.swing.JButton();
        op2 = new javax.swing.JButton();
        op4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        hardQues = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        triviaMenu = new javax.swing.JMenuBar();
        difficulty = new javax.swing.JMenu();
        triv3Easy = new javax.swing.JMenuItem();
        triv3Ave = new javax.swing.JMenuItem();
        triv3Hard = new javax.swing.JMenuItem();
        triviaExit = new javax.swing.JMenu();
        triviaReturn = new javax.swing.JMenuItem();
        triviaClose = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(770, 540));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeNum.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        timeNum.setText("75");
        getContentPane().add(timeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel4.setText("Philippine History Trivia");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 350, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 370, 50));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Difficulty: Hard");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(new java.awt.GridLayout(2, 2));

        op1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        op1.setText("Emilio Aguinaldo");
        op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1ActionPerformed(evt);
            }
        });
        jPanel1.add(op1);

        op3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        op3.setText("Apolinario Mabini");
        op3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op3ActionPerformed(evt);
            }
        });
        jPanel1.add(op3);

        op2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        op2.setText("Andres Bonifacio");
        op2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op2ActionPerformed(evt);
            }
        });
        jPanel1.add(op2);

        op4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        op4.setText("Jose Rizal");
        op4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op4ActionPerformed(evt);
            }
        });
        jPanel1.add(op4);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 560, 180));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 3));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hardQues.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        hardQues.setText("Who was the first president of the Philippines?");
        jPanel2.add(hardQues, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 730, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trivia final.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -20, 880, 510));

        difficulty.setText("Difficulty");

        triv3Easy.setText("Easy");
        triv3Easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triv3EasyActionPerformed(evt);
            }
        });
        difficulty.add(triv3Easy);

        triv3Ave.setText("Medium");
        triv3Ave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triv3AveActionPerformed(evt);
            }
        });
        difficulty.add(triv3Ave);

        triv3Hard.setText("Hard");
        triv3Hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triv3HardActionPerformed(evt);
            }
        });
        difficulty.add(triv3Hard);

        triviaMenu.add(difficulty);

        triviaExit.setText("Exit");

        triviaReturn.setText("Return to Home");
        triviaReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triviaReturnActionPerformed(evt);
            }
        });
        triviaExit.add(triviaReturn);

        triviaClose.setText("Exit Arcade");
        triviaExit.add(triviaClose);

        triviaMenu.add(triviaExit);

        setJMenuBar(triviaMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
        public void go(){
            TimerTask task = new triviaTimer3(this);
            timer = new Timer();
            timer.schedule(task,DELAY,PERIOD);
            }

    
    private void op1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op1ActionPerformed
        switch (question) {
            case 2:
                points ++;
                JOptionPane.showMessageDialog(null,"Very good! Your answer is correct!","Good Job!",JOptionPane.PLAIN_MESSAGE);
                question3();
                question = 3;
                break;
            case 1:
            case 3:
            case 4:
                JOptionPane.showMessageDialog(null,"Aw snap! Your answer is incorrect!","Nice Try!",JOptionPane.PLAIN_MESSAGE);
        switch (question) {
            case 1:
                question2();
                question = 2;
                break;
            case 2:
                question3();
                question = 3;
                break;
            case 3:
                question4();
                question = 4;
                break;
            case 4:
                question5();
                question = 5;
                break;
            default:
                break;
        }
            break;
            default:
                timer.cancel();
                JOptionPane.showMessageDialog(null,"Aw snap! Your answer is incorrect!","Nice Try!",JOptionPane.PLAIN_MESSAGE);
                gameOver();
                break;
        }
            
            
    }//GEN-LAST:event_op1ActionPerformed

    private void op2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op2ActionPerformed
        switch (question) {
            case 4:
                points ++;
                JOptionPane.showMessageDialog(null,"Very good! Your answer is correct!","Good Job!",JOptionPane.PLAIN_MESSAGE);
                question5();
                question = 5;
                break;
            case 1:
            case 2:
            case 3:
                JOptionPane.showMessageDialog(null,"Aw snap! Your answer is incorrect!","Nice Try!",JOptionPane.PLAIN_MESSAGE);
        switch (question) {
            case 1:
                question2();
                question = 2;
                break;
            case 2:
                question3();
                question = 3;
                break;
            case 3:
                question4();
                question = 4;
                break;
            case 4:
                question5();
                question = 5;
                break;
            case 5:
                question1();
                question = 1;
                break;
            default:
                break;
        }
        break;
            default:
                timer.cancel();
                JOptionPane.showMessageDialog(null,"Aw snap! Your answer is incorrect!","Nice Try!",JOptionPane.PLAIN_MESSAGE);
                gameOver();
                break;
        }
        
    }//GEN-LAST:event_op2ActionPerformed

    private void op4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op4ActionPerformed
        switch (question) {
            case 3:
                points ++;
                JOptionPane.showMessageDialog(null,"Very good! Your answer is correct!","Good Job!",JOptionPane.PLAIN_MESSAGE);
                question4();
                question = 4;
                break;
            case 5:
                timer.cancel();
                points ++;
                JOptionPane.showMessageDialog(null,"Very good! Your answer is correct!","Good Job!",JOptionPane.PLAIN_MESSAGE);
                gameOver();
                break;
            case 1:
            case 2:
            case 4:
                JOptionPane.showMessageDialog(null,"Aw snap! Your answer is incorrect!","Nice Try!",JOptionPane.PLAIN_MESSAGE);
                if(question == 1){
                    question2();
                    question = 2;
                }
                else if(question == 2){
                    question3();
                    question = 3;
                }
                else if(question == 3){
                    question4();
                    question = 4;
                }
                else if(question == 4){
                    question5();
                    question = 5;
                }    break;
            default:
                break;
        }
    }//GEN-LAST:event_op4ActionPerformed

    private void op3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op3ActionPerformed
        switch (question) {
            case 1:
                points ++;
                JOptionPane.showMessageDialog(null,"Very good! Your answer is correct!","Good Job!",JOptionPane.PLAIN_MESSAGE);
                question2();
                question = 2;
                break;
            case 2:
            case 3:
            case 4:
                JOptionPane.showMessageDialog(null,"Aw snap! Your answer is incorrect!","Nice Try!",JOptionPane.PLAIN_MESSAGE);
        switch (question) {
            case 1:
                question2();
                question = 2;
                break;
            case 2:
                question3();
                question = 3;
                break;
            case 3:
                question4();
                question = 4;
                break;
            case 4:
                question5();
                question = 5;
                break;
            default:
                break;
        }
            break;
            default:
                timer.cancel();
                JOptionPane.showMessageDialog(null,"Aw snap! Your answer is incorrect!","Nice Try!",JOptionPane.PLAIN_MESSAGE);
                gameOver();
                break;
        }
    }//GEN-LAST:event_op3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        go();
        question1();
    }//GEN-LAST:event_formWindowOpened

    private void triviaReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triviaReturnActionPerformed
                timer.cancel();
                Home home = new Home();
                home.show();
        
                dispose();
    }//GEN-LAST:event_triviaReturnActionPerformed

    private void triv3EasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triv3EasyActionPerformed
                timer.cancel();
                Trivia trivia = new Trivia();
                trivia.show();
        
                dispose();
    }//GEN-LAST:event_triv3EasyActionPerformed

    private void triv3AveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triv3AveActionPerformed
                timer.cancel();
                Trivia2 trivia2 = new Trivia2();
                trivia2.show();
        
                dispose();
    }//GEN-LAST:event_triv3AveActionPerformed

    private void triv3HardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triv3HardActionPerformed
                timer.cancel();
                Trivia3 trivia3 = new Trivia3();
                trivia3.show();
        
                dispose();
    }//GEN-LAST:event_triv3HardActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Trivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trivia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trivia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu difficulty;
    private javax.swing.JLabel hardQues;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton op1;
    private javax.swing.JButton op2;
    private javax.swing.JButton op3;
    private javax.swing.JButton op4;
    private javax.swing.JLabel timeNum;
    private javax.swing.JMenuItem triv3Ave;
    private javax.swing.JMenuItem triv3Easy;
    private javax.swing.JMenuItem triv3Hard;
    private javax.swing.JMenuItem triviaClose;
    private javax.swing.JMenu triviaExit;
    private javax.swing.JMenuBar triviaMenu;
    private javax.swing.JMenuItem triviaReturn;
    // End of variables declaration//GEN-END:variables
    public javax.swing.JLabel gettimeNum() {
        return timeNum;
    }
    public void settimeNum(javax.swing.JLabel jLabel1) {
        this.timeNum = jLabel1;
    }


}
