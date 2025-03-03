public class Main {
  public static void main(String[] args) {
    String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    String bestCase = "A"; // Best-case: First character matches

    long startTime = System.nanoTime(); // Initialize startTime
    int index = match(text, bestCase);
    long endTime = System.nanoTime(); // Initialize endTime
    long elapsedTime = endTime - startTime; // Calculate elapsedTime
    
    if (index >= 0)
      System.out.println("best-case input matched at index " + index);
    else
      System.out.println("best-case input unmatched");   
    System.out.println("Elapsed time for best-case: " + elapsedTime + " ns");

    String worstCase = "9"; // Worst-case: Last character matches (full scan required)
    
    startTime = System.nanoTime(); // Initialize startTime
    index = match(text, worstCase);
    endTime = System.nanoTime(); // Initialize endTime
    elapsedTime = endTime - startTime; // Calculate elapsedTime
    
    if (index >= 0)
      System.out.println("worst-case input matched at index " + index);
    else
      System.out.println("worst-case input unmatched");  
    System.out.println("Elapsed time for worst-case: " + elapsedTime + " ns");
  }

  // Return the index of the first match. -1 otherwise.
  public static int match(String text, String pattern) {
    for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
      if (isMatched(i, text, pattern))
        return i;
    }
    return -1;
  }
  
  // Test if pattern matches text starting at index i
  private static boolean isMatched(int i, String text, 
      String pattern) {
    for (int k = 0; k < pattern.length(); k++) {
      if (pattern.charAt(k) != text.charAt(i + k)) {
        return false;
      }
    }
    return true;
  }
}