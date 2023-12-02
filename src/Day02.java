import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day02 {

  Map<String, Integer> cubeConstraints = new HashMap<>();
  Map<Integer, List<String>> gameSummaries = new HashMap<>();

  public static void main (String[] args) {
    Day02 day2 = new Day02();
    day2.doTheNeedful();
  }

  public void doTheNeedful() {
    createCubeConstraints();
    createGameSummariesFromTestData(getTestInputs1());
    printGameSummaries();
  }

  void createGameSummariesFromTestData(List<String> inputs) {
    inputs.forEach(game -> {
      String[] gameParts = game.split(":"); // Split game number from results
      String[] gameNumber = gameParts[0].split(" "); // Split "Game" from game number
      String[] gameResults = gameParts[1].split(";"); // Split individual games

      gameSummaries.put(Integer.parseInt(gameNumber[1]), Arrays.asList(gameResults));
    });
  }

  private void printGameSummaries() {
    gameSummaries.forEach((key, value) -> {
      System.out.println("Game " + key);
      value.forEach(game -> {
        System.out.println("  " + game);
      });
    });
  };

  private void createCubeConstraints() {
    cubeConstraints.put("red", 12);
    cubeConstraints.put("green", 13);
    cubeConstraints.put("blue", 14);
  }


  List<String> getTestInputs1() {
    return Arrays.asList(
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
    );

  }

}
