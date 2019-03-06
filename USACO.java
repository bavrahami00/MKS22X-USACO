import java.util.*;
import java.io.*;
public class USACO {
  public static void main(String[] args) {
    int[][] board = open("in.txt");
    for (int x = 0; x < board.length; x++) {
      for (int i = 0; i < board[x].length; i++) {
        System.out.print(board[x][i]+",");
      }
      System.out.println();
    }
  }
  public static int[][] open(String file) {
    try {
      File f = new File(file);
      Scanner s = new Scanner(f);
      String t = s.nextLine();
      int lines = convert(t)[0];
      int[][] ans = new int[lines][];
      for (int x = 0; x < lines; x++) {
        t = s.nextLine();
        ans[x] = convert(t);
      }
      return ans;
    }
    catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    int[][] dummy = new int[1][1];
    return dummy;
  }
  public static int[] convert(String in) {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    String s = "";
    for (int x = 0; x < in.length(); x++) {
      if (in.charAt(x) == ' ') {
        ans.add(Integer.parseInt(s));
        s = "";
      }
      else {
        s += in.charAt(x);
      }
    }
    ans.add(Integer.parseInt(s));
    int[] re = new int[ans.size()];
    for (int x = 0; x < re.length; x++) {
      re[x] = ans.get(x);
    }
    return re;
  }
  public static int[][] stomp (int[][] board) {
    
  }
}
