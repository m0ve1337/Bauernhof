package Loesung;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DecisionData {
  private final List<String> decisions;
  private final Random random;
  
  public DecisionData() {
    decisions = new ArrayList<String>();
    random = new Random();
  }
  
  public AddOperationResult addDecision(String input) {
    AddOperationResult returnValue = new AddOperationResult();
    String text = input.trim();
    if (text.isEmpty()) {
      returnValue.addErrorMessage("Nichts eigegeben");
    } else if (decisions.contains(text)) {
      returnValue.addErrorMessage("Eintrag schon vorhanden");
    } else {
      decisions.add(text);
    }
    return returnValue;
  }

  public String getRandomDecision() {
    if (decisions.isEmpty()) {
      return "keine Einträge";
    }
    int randomIndex = random.nextInt(decisions.size());
    return decisions.get(randomIndex);
  }
}
