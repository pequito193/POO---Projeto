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
	public static enum Stage {
		ONE,
		TWO,
		THREE,
	};
	
	public static void saveScore(Stage stage, int time) {
		try {
			PrintWriter writer = new PrintWriter(new File("scores.txt"));
			List<Integer> savedScores = readAllScores(stage);
			savedScores.add(time);
			
			for (int score : savedScores) {
				writer.println(score);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> getHighscores(Stage stage) {
		List<String> allScoresString = new ArrayList<>();
		List<Integer> allScores = readAllScores(stage);
		
		allScores.sort(new IntegerAscendingComparator());
		
		for (int i = 0; i < 10; i++) {
			String scoreString = Utils.timeToString(allScores.get(i));
			allScoresString.add(scoreString);
		}
		
		return allScoresString;
	}
	
	private static List<Integer> readAllScores(Stage stage) {
		List<Integer> timeList = new ArrayList<>();
		try {
			String filename = getScoreFile(stage);
			Scanner scanner = new Scanner(new File(filename));
			
			while(scanner.hasNextLine()) {
				timeList.add(scanner.nextInt());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return timeList;
	}
	
	private static String getScoreFile(Stage stage) {		
		switch(stage) {
			case ONE:
				return "stage1_scores.txt";
			case TWO:
				return "stage2_scores.txt";
			default:
				return "stage3_scores.txt";
		}
	}
}