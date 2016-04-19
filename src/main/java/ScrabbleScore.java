import java.io.Console;

import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class ScrabbleScore {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/scrabbleScoreOutput", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/scrabbleScoreOutput.vtl");

      String inputString = request.queryParams("inputString");
      inputString = calculateScrabbleScore(inputString);
      model.put("inputString", inputString);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }





  public static String calculateScrabbleScore(String word) {
    String loweredWord = word.toLowerCase();
    char[] charWord = loweredWord.toCharArray();
    int finalOutput = 0;
    for (int i = 0; i < charWord.length; i++) {
      if (charWord[i] == 'a' || charWord[i] == 'e' || charWord[i] == 'i' || charWord[i] == 'o' || charWord[i] == 'u' || charWord[i] == 'l' || charWord[i] == 'n' || charWord[i] == 'r' || charWord[i] == 's' || charWord[i] == 't') {
        finalOutput = finalOutput + 1;
      } else if (charWord[i] == 'd' || charWord[i] == 'g') {
        finalOutput = finalOutput + 2;
      } else if (charWord[i] == 'b' || charWord[i] == 'c' || charWord[i] == 'm' || charWord[i] == 'p'){
        finalOutput = finalOutput + 3;
      } else if (charWord[i] == 'f' || charWord[i] == 'h' || charWord[i] == 'v' || charWord[i] == 'w' || charWord[i] == 'y'){
        finalOutput = finalOutput + 4;
      } else if (charWord[i] == 'k'){
        finalOutput = finalOutput + 5;
      } else if (charWord[i] == 'j' || charWord[i] == 'x'){
        finalOutput = finalOutput + 8;
      } else if (charWord[i] == 'q' || charWord[i] == 'z'){
        finalOutput = finalOutput + 10;
      }
    } String hello = String.valueOf(finalOutput);
      return hello;
  }
}
