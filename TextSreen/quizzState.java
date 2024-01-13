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
        questions[0].text = "OOP stands for Object-Oriented Protocol";
        questions[0].answer = false;// tfanswer

        questions[1] = new setQuestions();
        questions[1].text = "An object is an instance of a class";
        questions[1].answer = true; 

        questions[2] = new setQuestions();
        questions[2].text = " Objects represent real-world entities in OOP";
        questions[2].answer = true;


        questions[3] = new setQuestions();
        questions[3].text = "Java is not an object-oriented programming language";
        questions[3].answer = false;

        questions[4] = new setQuestions();
        questions[4].text = "We can overide the final method ";
        questions[4].answer = false;
        
        questions[5] = new setQuestions();
        questions[5].text = "Abstract classes in Java can be instantiated";
        questions[5].answer = false;

        questions[6] = new setQuestions();
        questions[6].text =  "Interfaces in Java can have method implementations";
        questions[6].answer = false;

        questions[7] = new setQuestions();
        questions[7].text = "The 'super' keyword in Java is used to call \n the constructor of the superclass.";
        questions[7].answer = true;

        questions[8] = new setQuestions();
        questions[8].text = " An object can exist without being an instance of any class";
        questions[8].answer = false;
        
        questions[9] = new setQuestions();
        questions[9].text = "The 'this' keyword in Java refers to the current instance of the class";
        questions[9].answer = true;
        
        questions[10] = new setQuestions();
        questions[10].text = "Static methods in Java belong to instances of a class"; 
        questions[10].answer = false;
        
        questions[11] = new setQuestions();
        questions[11].text = "Composition in OOP is a way to model is-a relationships between classes"; 
        questions[11].answer = false;

        questions[12] = new setQuestions();
        questions[12].text = "Java supports multiple inheritance through class inheritance"; 
        questions[12].answer = false; 

        questions[13] = new setQuestions();
        questions[13].text = " Constructors in Java can have a return type"; 
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
