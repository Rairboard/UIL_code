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

public class adela {
    public static void main(String[] args) throws Exception {
        new adela().run();
    }

    public void run() throws Exception {
        for (int i = 0; i < 9; i++) {
            out.println("*".repeat(i+1));
        }
        for(int i = 8;i > 0;i--){
            out.println("*".repeat(i));
        }
    }
}
