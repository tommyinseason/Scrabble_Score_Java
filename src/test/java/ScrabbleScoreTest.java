import org.junit.*;
import static org.junit.Assert.*;

public class ScrabbleScoreTest {

  @Test
  public void calculateScrabbleScore_ReturnScoreForSingleLetter_1(){
    ScrabbleScore testScrabbleScore = new ScrabbleScore();
    assertEquals((Integer)1, testScrabbleScore.calculateScrabbleScore("A"));
  }
  @Test
  public void calculateScrabbleScore_SumofLetters_Integer() {
    ScrabbleScore testScrabbleScore = new ScrabbleScore();
    assertEquals((Integer)4, testScrabbleScore.calculateScrabbleScore("aga"));
  }
}
