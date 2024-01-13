package TextSreen;

import java.awt.Graphics2D;
import java.util.Random;

import Events.Quizz_Events;
import Events.SuperEvent;
import KeyBoard.keyControl;
import TextSreen.quizz.setQuestions;
import main.GamePanel;

public class quizzState extends SuperUI {
    private Quizz_Events events;
    public setQuestions questions[] = new setQuestions[15];
    private Random random = new Random();
    private int i = random.nextInt(10);
    private int z = getRandom(10, 13);


    public quizzState(GamePanel gp, keyControl keyBoard) {
        super(gp, g2);
        events = new Quizz_Events();
        setup();
        sub_text = "press T or F";
        word_length = 20;
        // set up i random questions, or default
    }
    public void setup() {
        // questions
        questions[0] = new setQuestions();
        questions[0].text = "Final varible or final method can not be change";
        questions[0].answer = true;// fanswer

        questions[1] = new setQuestions();
        questions[1].text = "int a = 4%2 \n the result  a is 2 ";
        questions[1].answer = false; 

        questions[2] = new setQuestions();
        questions[2].text = " High-level modules should depend on abstractions \n rather than concrete implementations";
        questions[2].answer = true;//


        questions[3] = new setQuestions();
        questions[3].text = "int a = 2 \n int b  = ++a + a; \n The result of b is 4  ";
        questions[3].answer = false;

        questions[4] = new setQuestions();
        questions[4].text = "We can overide the final method ";
        questions[4].answer = false;
        
        questions[5] = new setQuestions();
        questions[5].text = "You can extends abstract class \n without using abstract methods";
        questions[5].answer = false;

        questions[6] = new setQuestions();
        questions[6].text =  "Client should be forced to depend on methods it does not use";
        questions[6].answer = true;

        questions[7] = new setQuestions();
        questions[7].text = "1+5=6";
        questions[7].answer = true;

        questions[8] = new setQuestions();
        questions[8].text = "A software Class or module should be open for \n modification but closed for extension  ";
        questions[8].answer = false;
        
        questions[9] = new setQuestions();
        questions[9].text = "public class Student {\n public void registerStudent() { // some logic } \n public void calculate_Student_Results() { // some logic }} \n This is a good desgin";
        questions[9].answer = false;
        
        questions[10] = new setQuestions();
        questions[10].text = "You can use overide method without exntending class"; 
        questions[10].answer = true;
        
        questions[11] = new setQuestions();
        questions[11].text = "141570 can be devided by 5 "; 
        questions[11].answer = true;

        questions[12] = new setQuestions();
        questions[12].text = "The Top-most class in java is the superclass that you create "; 
        questions[12].answer = false; 

        questions[13] = new setQuestions();
        questions[13].text = " Molecules are smaller than electrons"; 
        questions[13].answer = false; 

       
    }

    public void draw(Graphics2D g2) {
        SuperUI.g2 = g2;

        if (gp.gamestate == gp.quizzState) {
            drawScreen(questions[i].text);
        }
    }

    /* */
    public void update() {
        if (gp.gamestate == gp.quizzState) {
            gp.player.isMove = false;
            if ((SuperEvent.getObjectName()=="monster"||SuperEvent.getObjectName()=="doll")&&events.getObjectIndex()!=35){
                i = z;
            }
            else if(events.getObjectIndex()==35){
                i = 10;
            }
            if(keyControl.tPress==true){
                    if(questions[i].answer == true){
                        System.out.println(i+" "+questions[i].answer);
                        events.correct();
                        i = random.nextInt(10);
                        z = getRandom(10, 13);
                        System.out.println("clear");
                        // i = random.nextInt(6);


                    }
                    else if(questions[i].answer == false){
                        System.out.println(i+" "+questions[i].answer);
                        events.wrong();
                        i = random.nextInt(11);
                        z = getRandom(10, 13);


                    }
                    keyControl.tPress = false;

                }
                if(keyControl.fPress==true){
                    if(questions[i].answer == true){
                        System.out.println(i+" "+questions[i].answer);

                        events.wrong();
                        i = random.nextInt(10);

                    }
                    else if(questions[i].answer == false){
                        System.out.println(i+" "+questions[i].answer);

                        events.correct();

                        i = random.nextInt(11);

                    }
                    keyControl.fPress = false;
                }
                }
                if(events.teleport == true&&keyControl.isSpace==true) {
                    events.teleport();
                    events.teleport = false;
                }


            }

    // do something
    // reset i to zero in order out of array

    /* Events */
    private static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max+1 - min) + min;
    }

}
