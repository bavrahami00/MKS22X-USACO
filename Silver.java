import java.util.*;
import java.io.*;
public class Silver {
  public static void main(String[] args) {
    char[][] field = start("in.txt");
    for (int x = 0; x < field.length; x++) {
      for (int i = 0; i < field[x].length; i++) {
        System.out.print(field[x][i]);
      }
      System.out.println();
    }
  }
  public static char[][] start(String filename) {
    try {
      File f = new File(filename);
      Scanner s = new Scanner(f);
      String t = s.nextLine();
      int[] size = convert(t);
      char[][] ans = new char[size[0]][size[1]];
      int count = 0;
      while (s.hasNext() && count < size[0]) {
        t = s.nextLine();
        for (int x = 0; x < t.length(); x++) {
          ans[count][x] = t.charAt(x);
        }
        count++;
      }
      return ans;
    }
    catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    char[][] dummy = new char[1][1];
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
}
