import java.util.*;
import java.io.*;

public class lucky {
    public static void main(String[] args) throws Exception {
        new lucky().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("lucky.dat"));
        //Scanner f = new Scanner(System.in);
		System.out.println("*************************\n" +
				"*                       *\n" +
				"*********************  **\n" +
				"********************  ***\n" +
				"*******************  ****\n" +
				"******************  *****\n" +
				"*****************  ******\n" +
				"****************  *******\n" +
				"***************  ********\n" +
				"**************  *********\n" +
				"*************  **********\n" +
				"************  ***********\n" +
				"***********  ************\n" +
				"**********  *************\n" +
				"*********  **************\n" +
				"********  ***************\n" +
				"*******  ****************\n" +
				"******  *****************\n" +
				"*****  ******************\n" +
				"****  *******************\n" +
				"***  ********************\n" +
				"**  *********************\n" +
				"*  **********************\n" +
				"*************************");
        f.close();
    }
}
