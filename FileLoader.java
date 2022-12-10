import java.io.*;
import java.util.Scanner;	

public class FileLoader {
	public static String readData(String filename) throws IOException {
		FileReader fileReader = new FileReader(filename);
		Scanner scan = new Scanner(fileReader);
		StringBuilder string = new StringBuilder();
		while(scan.hasNextLine()){
			string.append(scan.nextLine());
		}
		fileReader.close();
		scan.close();
		return string.toString();
	}

	public static void writeData(String data) throws IOException{
		File file = new File("result.txt");
		FileWriter writer = new FileWriter(file, false);
		writer.write(data);
		writer.close();
	}
}