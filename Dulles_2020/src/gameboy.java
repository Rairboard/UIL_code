import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class gameboy {
    public static void main(String[] args) throws Exception {
        new gameboy().run();
    }

    public void run() throws Exception {
        out.println(" ___________________________\n" +
                "| ________________________  |\n" +
                "| |                       | |\n" +
                "| |       ____            | |\n" +
                "| |      /   o\\           | |\n" +
                "| |     /   ___\\          | |\n" +
                "| |     \\  \\   0   0  0   | |\n" +
                "| |      \\__\\             | |\n" +
                "| |                       | |\n" +
                "| |_______________________| |\n" +
                "|                  ////     |\n" +
                "|                  ////     |\n" +
                "|     _         _     _     |\n" +
                "|   _| |_      / \\   / \\    |\n" +
                "|  |_   _|    | A | | B |   |\n" +
                "|    |_|       \\_/   \\_/    |\n" +
                "|___________________________|");
    }
}
