import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class stringFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("Type command: 'search <pattern> <file>'");
			String command = scan.nextLine();
			String[] words = command.split("\\s+"); 
			if (!words[0].equalsIgnoreCase("search") || words.length != 3) {
				System.out.println("" + words[0] + " is not a command. Please try using 'search'");
			} else {
				File file = new File(words[2]);
				String name = words[1];
				Scanner scanner;
				try {
					scanner = new Scanner(file);
					int line = 0;
					while (scanner.hasNextLine()) {
						line++;
						final String lineFromFile = scanner.nextLine();
						if (lineFromFile.toLowerCase().contains(name.toLowerCase())) {
							// a match!
							
							System.out.println("I found " + name + " in file " + file.getName() + " on line " + line);
							
						}
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Given file was not found");
				}
			}
		}
	}

}
