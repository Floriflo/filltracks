import java.io.File;  // Import the File class
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    String folder_levels = "";

    public Parser(String folder_le) {
        folder_levels = folder_le;
    }

    public String[] build_levels() {
        String[] level={""};

        String file_path = folder_levels + "/Level1.txt";


        File file = new File(file_path);
        int a =9;
        int x = 0, y = 0;

        int xMaxMap = 0, yMaxMap = 0, xPosPlayeur = 0, yPosPlayeur = 0;


        try (FileReader fr = new FileReader(file))
        {
            int content;
            char content_char;

            /*
            We browse the first 4 lines of the file to retrieve the necessary data.
             We skip every tow round of the loop to avoid taking into account newlines
             (\n in ASCII form or 10 in number form) as we read character by character.
             */
            for(int i=0 ; i <= 7 ; i++){
                content_char = (char) fr.read();
                if (i == 0){
                    xMaxMap = Character.getNumericValue(content_char);
                } else if (i == 2){
                    yMaxMap = Character.getNumericValue(content_char);
                } else if (i == 4) {
                    xPosPlayeur = Character.getNumericValue(content_char);
                } else if (i == 6) {
                    yPosPlayeur = Character.getNumericValue(content_char);
                }
            }

            // We retrieve the values of the map
            while ((content = fr.read()) != -1) {
                content_char = (char) content;

                System.out.print(content_char);

                x ++;
                if (content == 10){
                    y++;
                    x = 0;
                    System.out.print("\n");
                } else {
                    System.out.print("|");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return level;
    }
}
