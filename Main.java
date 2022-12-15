import java.util.Scanner;
import java.io.*;
import javax.swing.JFrame;
import java.util.*;

public class Main {
	public static void main(String[] args){
		try {
			int keySize = Integer.parseInt(args[1]);
			String action = args[0];
			String fileName = args[2];
			String isDrawHis = args[3];
			int[][] key = new int[keySize][keySize];
			Scanner in = new Scanner(System.in);
			System.out.println("input key:");
			for(int i = 0; i < keySize; i++){
				for(int j = 0; j < keySize; j++){
					key[i][j]= in.nextInt();
				}
				System.out.println();
			}
			in.close();
			System.out.println("key: ");
			for(int i = 0; i < keySize; i++) {
				for(int j = 0; j < keySize; j++ ){
					System.out.print(key[i][j] + " ");
				}
				System.out.println();	
			}
			Hills hill = new Hills(key);
			String input = FileLoader.readData(fileName);
			String output = "";
			if (action.equals("-d")) {
				System.out.println("start decrypt");
				output = hill.cipher(input, false);
				FileLoader.writeData(output);
			} else if(action.equals("-e")){
				System.out.println("start encrypt");
				output = hill.cipher(input, true);
				FileLoader.writeData(output);
			} else {
				System.out.println("the action key is not recognized");
			}
			if (isDrawHis.equals("-y")) {
				JFrame window = new JFrame();
				Histogram histogram = new Histogram(input.toCharArray(), output.toCharArray());
				window.add(histogram);
				window.pack();
				window.setVisible(true);
			} else if(isDrawHis.equals("-n")) {
				System.out.println("without histograms");
			} else {
				System.out.println("the histogram key is not recognized");
			}
		} catch(IOException exception) {
			exception.printStackTrace();
		}

	}
}
