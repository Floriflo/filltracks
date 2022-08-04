package com.filltracks;

import java.io.File;  // Import the File class
import java.io.FileReader;
import java.io.IOException;


public class Parser {
    // TODO : Add doc everywhere and change comment in french to english
    String folder_levels = "";
    boolean verboseDebug = true; // TODO : Add to config -> put in logger

    public Parser(String folder_le) {
        this.folder_levels = folder_le;
    }

    public void buildLevel(int levelNumber, Field field, Player player) {
        Case[][] maplevel = new Case[0][0];

        // TODO : Get from config file + loop on all files levels (in another func ?)
        String file_path = this.folder_levels + "/Level" + levelNumber + ".txt";

        File file = new File(file_path);
        int x = 0, y = 0;
        //int i = 0;

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
            for(int j=0 ; j <= 3 ; j++){
                content_char = (char) fr.read();
                if (j == 0){
                    yMaxMap = Character.getNumericValue(content_char);
                } else if (j == 2){
                    xMaxMap = Character.getNumericValue(content_char);
                } /*else if (j == 4) {
                    yPosPlayeur = Character.getNumericValue(content_char);
                } else if (j == 6) {
                    xPosPlayeur = Character.getNumericValue(content_char);
                }*/
            }

            // Initialize the size of the array to store the map
            maplevel = new Case[yMaxMap][xMaxMap];

            // We retrieve the values of the map
            while ((content = fr.read()) != -1) {
                type_case = (char) content;

                /*
                  If we reach the end of the line, we reset the positions
                  Otherwise we add the com.filltracks.Case in the array of the map
                */
                if (content == 10){
                    y++;
                    x = 0;
                    if (this.verboseDebug){
                        System.out.print("\n");
                    }
                } else {
                    if (this.verboseDebug) {
                        System.out.print(type_case + "|");
                    }

                    if (type_case == 'j') {
                        yPosPlayeur = y;
                        xPosPlayeur = x;
                    }

                    maplevel[y][x] = new Case(x, y, type_case);
                    x++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.position.setX(xPosPlayeur);
        player.position.setY(yPosPlayeur);
        field.Field(xMaxMap, yMaxMap, maplevel);
    }
}
