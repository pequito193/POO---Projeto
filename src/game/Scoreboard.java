package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utils.IntegerAscendingComparator;
import utils.Utils;

public class Scoreboard {
	private static final String FILE = "scoreboard.txt";
	
	public static void saveScore(int time) {
		try {
			List<Integer> savedScores = readAllScores();
			PrintWriter writer = new PrintWriter(new File(FILE));
			savedScores.add(time);
			
			for (int score : savedScores) {
				writer.println(score);
			}
			
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> getHighscores() {
		List<String> allScoresString = new ArrayList<>();
		List<Integer> allScores = readAllScores();
		
		allScores.sort(new IntegerAscendingComparator());
		
		int length = allScores.size() < 10 ? allScores.size() : 10;
		
		for (int i = 0; i < length; i++) {
			String scoreString = Utils.timeToString(allScores.get(i));
			allScoresString.add(scoreString);
		}
		
		return allScoresString;
	}
	
	private static List<Integer> readAllScores() {
		List<Integer> timeList = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File(FILE));
			
			while(scanner.hasNextLine()) {
				String time = scanner.nextLine();
				timeList.add(Integer.parseInt(time));
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return timeList;
	}
}