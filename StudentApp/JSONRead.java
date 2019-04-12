import org.json.JSONArray;
import org.json.JSONObject;

public class JSONRead {
    static String json = "{\n" +
            "  \"Question1\": \"Which korea is the best korea?\",\n" +
            "  \"answer1\": {\n" +
            "    \"A\":\"North\",\n" +
            "    \"B\":\"South\",\n" +
            "    \"C\":\"East\",\n" +
            "    \"D\":\"West\"\n" +
            "  },\n" +
            "\n" +
            "  \"Question2\": \"Who proposed E=mc^2?\",\n" +
            "  \"answer2\": {\n" +
            "  \"A\": \"Donald Trump\",\n" +
            "  \"B\": \"Billy Joe Jimbob\",\n" +
            "  \"C\": \"Einstein\",\n" +
            "  \"D\": \"KimK\"\n" +
            "   },\n" +
            "\n" +
            "  \"Question3\": \"Who can defeat chuck norris?\",\n" +
            "  \"answer3\": {\n" +
            "    \"A\": \"Sheldon Cooper\",\n" +
            "    \"B\": \"Donald Trump\",\n" +
            "    \"C\": \"Arnold Schwarzenegger\",\n" +
            "    \"D\": \"Jocko Willink\"\n" +
            "  }\n" +
            "}";

    public static void main(String[] args) {
        System.out.println("JSON : " + json);
        JSONObject obj = new JSONObject(json);
        String question1 = obj.getString("Question1");
        String question2 = obj.getString("Question2");
        String question3 = obj.getString("Question3");
        String answer1A = obj.getJSONObject("answer1").getString("A");
        String answer1B = obj.getJSONObject("answer1").getString("B");
        String answer1C = obj.getJSONObject("answer1").getString("C");
        String answer1D = obj.getJSONObject("answer1").getString("D");
        String answer2A = obj.getJSONObject("answer2").getString("A");
        String answer2B = obj.getJSONObject("answer2").getString("B");
        String answer2C = obj.getJSONObject("answer2").getString("C");
        String answer2D = obj.getJSONObject("answer2").getString("D");
        String answer3A = obj.getJSONObject("answer3").getString("A");
        String answer3B = obj.getJSONObject("answer3").getString("B");
        String answer3C = obj.getJSONObject("answer3").getString("C");
        String answer3D = obj.getJSONObject("answer3").getString("D");
    }
}