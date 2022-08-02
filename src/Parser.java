import java.io.File;  // Import the File class
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class Parser {
    // TODO : Add doc everywhere and change comment in french to english
    String folder_levels = "";

    public Parser(String folder_le) {
        folder_levels = folder_le;
    }

    public List<? extends Serializable> build_levels() {
        Case[] maplevel = new Case[0];

        String file_path = folder_levels + "/Level1.txt"; // TODO : Get from config file

        File file = new File(file_path);
        int x = 0, y = 0;
        int i = 0;

        int xMaxMap = 0, yMaxMap = 0, xPosPlayeur = 0, yPosPlayeur = 0;


        try (FileReader fr = new FileReader(file))
        {
            int content;
            char content_char, type_case;

            /*
            We browse the first 4 lines of the file to retrieve the necessary data.
             We skip every tow round of the loop to avoid taking into account newlines
             (\n in ASCII form or 10 in number form) as we read character by character.
             */
            for(int j=0 ; j <= 7 ; j++){
                content_char = (char) fr.read();
                if (j == 0){
                    xMaxMap = Character.getNumericValue(content_char);
                } else if (j == 2){
                    yMaxMap = Character.getNumericValue(content_char);
                } else if (j == 4) {
                    xPosPlayeur = Character.getNumericValue(content_char);
                } else if (j == 6) {
                    yPosPlayeur = Character.getNumericValue(content_char);
                }
            }

            // Initialize the size of the array to store the map
            maplevel = new Case[xMaxMap*yMaxMap];

            System.out.println(maplevel.length);

            // We retrieve the values of the map
            while ((content = fr.read()) != -1) {
                type_case = (char) content;

                System.out.print(type_case);

                /*
                  If we reach the end of the line, we reset the positions
                  Otherwise we add the Case in the array of the map
                */
                if (content == 10){
                    y++;
                    x = 0;
                    System.out.print("\n");
                } else {

                    System.out.print("|");
                    maplevel[i] = new Case(x, y, type_case);
                    x++;
                    i++;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Arrays.asList(xPosPlayeur, yPosPlayeur, xMaxMap, yMaxMap, maplevel);
    }
}
