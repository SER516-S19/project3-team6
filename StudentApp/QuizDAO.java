import org.json.JSONObject;

public class QuizDAO
{
    private static QuizDAO ourInstance = new QuizDAO();

    public String json = "{\n" +
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
    JSONObject obj = null;

    public static QuizDAO getInstance() {
        return ourInstance;
    }

    private QuizDAO()
    {
        obj = new JSONObject(json);
    }

    public String getQuestion(int questionNumber)
    {
        return obj.getString("Question"+questionNumber);
    }//getQuestion

    public String getOptionA(int answerNumber)
    {
        return obj.getJSONObject("answer"+answerNumber).getString("A");
    }//getOptionA
    public String getOptionB(int answerNumber)
    {
        return obj.getJSONObject("answer"+answerNumber).getString("B");
    }//getOptionB
    public String getOptionC(int answerNumber)
    {
        return obj.getJSONObject("answer"+answerNumber).getString("C");
    }//getOptionC
    public String getOptionD(int answerNumber)
    {
        return obj.getJSONObject("answer"+answerNumber).getString("D");
    }//getOptionDAO
}
