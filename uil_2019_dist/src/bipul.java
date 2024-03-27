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

public class bipul {
    public static void main(String[] args) throws Exception {
        new bipul().run();
    }

    public void run() throws Exception {
        out.println("|");
        int hash = 1;
        for (int i = 0; i < 5; i++) {
            out.println("|"+"#".repeat(hash)+"\\");
            hash+=2;
        }
        hash=2;
        for (int i = 0; i < 8; i++) {
            out.println("|" + "#".repeat(hash++)+"\\");
        }
    }
}
