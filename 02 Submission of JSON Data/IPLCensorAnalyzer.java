import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
public class IPLCensorAnalyzer {
   public static void main(String[] args) throws Exception {
       System.out.println("Processing JSON...");
       processJson("input.json", "output.json");
       System.out.println("JSON processed. Output written to output.json\n");
       System.out.println("Processing CSV...");
       processCsv("input.csv", "output.csv");
       System.out.println("CSV processed. Output written to output.csv");
   }
   static String censorTeam(String team) {
       int spaceIndex = team.indexOf(' ');
       return (spaceIndex != -1) ? team.substring(0, spaceIndex) + " ***" : team;
   }
   static void processJson(String inputPath, String outputPath) throws Exception {
       String content = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(inputPath)));
       JSONArray inputArray = new JSONArray(content);
       JSONArray outputArray = new JSONArray();
       for (int i = 0; i < inputArray.length(); i++) {
           JSONObject match = inputArray.getJSONObject(i);
           JSONObject newMatch = new JSONObject();
           newMatch.put("match_id", match.getInt("match_id"));
           newMatch.put("team1", censorTeam(match.getString("team1")));
           newMatch.put("team2", censorTeam(match.getString("team2")));
           JSONObject newScore = new JSONObject();
           JSONObject oldScore = match.getJSONObject("score");
           for (String team : oldScore.keySet()) {
               newScore.put(censorTeam(team), oldScore.getInt(team));
           }
           newMatch.put("score", newScore);
           newMatch.put("winner", censorTeam(match.getString("winner")));
           newMatch.put("player_of_match", "REDACTED");
           outputArray.put(newMatch);
       }
       try (FileWriter fw = new FileWriter(outputPath)) {
           fw.write(outputArray.toString(2));
       }
       System.out.println(outputArray.toString(2));
   }
   static void processCsv(String inputPath, String outputPath) throws Exception {
       BufferedReader reader = new BufferedReader(new FileReader(inputPath));
       BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
       String header = reader.readLine();
       writer.write(header);
       writer.newLine();
       System.out.println(header);
       String line;
       while ((line = reader.readLine()) != null) {
           String[] parts = line.split(",");
           parts[1] = censorTeam(parts[1]);
           parts[2] = censorTeam(parts[2]);
           parts[5] = censorTeam(parts[5]);
           parts[6] = "REDACTED";
           String outputLine = String.join(",", parts);
           writer.write(outputLine);
           writer.newLine();
           System.out.println(outputLine);
       }
       reader.close();
       writer.close();
   }
}
