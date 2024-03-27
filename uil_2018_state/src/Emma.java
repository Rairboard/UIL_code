import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Emma {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("emma.dat"));

		while(file.hasNextInt()) {
			int x = file.nextInt();
			
			for(int i = 0;i<x;i++) {
				for(int l=0;l<x;l++) {
					System.out.print("*");
				}
				for(int l=0;l<x;l++) {
					System.out.print(" ");
				}
				for(int l=0;l<x;l++) {
					System.out.print("*");
				}
				System.out.println();
			}
			int min = 0;
			int max = x-1;
			for(int i =0;i<x;i++) {
				
				for(int l=0;l<x;l++) {
					System.out.print(" ");
				}
				for(int l=0;l<x;l++) {
					if(l==min || l==max) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
				for(int l=0;l<x;l++) {
					System.out.print(" ");
				}
				min++;
				max--;
				System.out.println();
			}
			for(int i = 0;i<x;i++) {
				for(int l=0;l<x;l++) {
					System.out.print("*");
				}
				for(int l=0;l<x;l++) {
					System.out.print(" ");
				}
				for(int l=0;l<x;l++) {
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.println("==========");
		}
	}

}
