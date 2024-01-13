package Font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class Fonts {
    private Font f;
    public Fonts() {
        loadFont();
    }
    private void loadFont() {
        try{
            InputStream files = getClass().getResourceAsStream("/Font/text.ttf");
            f =  Font.createFont(Font.TRUETYPE_FONT, files);
           

        }catch(FontFormatException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }        
    }
    public Font getFont(){
        return f;
    }
}
