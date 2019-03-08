import java.util.*;
import java.io.*;
public class Silver {
  public static int silver(String filename) {
    return count(start(filename),length(filename));
  }
  public static int count(char[][] field, int time) {
    int[][] prev = new int[field.length][field[0].length];
    int[][] now = new int[field.length][field[0].length];
    for (int x = 0; x < field.length; x++) {
      for (int i = 0; i < field.length; i++) {
        if (field[x][i] == 'S') {
          prev[x][i] = 1;
        }
      }
    }
    int t = 0;
    while (t < time) {
      for (int x = 0; x < field.length; x++) {
        for (int i = 0; i < field[x].length; i++) {
          if (field[x][i] != '*') {
            int path = 0;
            try {
              path += prev[x-1][i];
            }
            catch (ArrayIndexOutOfBoundsException a) {}
            try {
              path += prev[x+1][i];
            }
            catch (ArrayIndexOutOfBoundsException a) {}
            try {
              path += prev[x][i-1];
            }
            catch (ArrayIndexOutOfBoundsException a) {}
            try {
              path += prev[x][i+1];
            }
            catch (ArrayIndexOutOfBoundsException a) {}
            now[x][i] = path;
          }
        }
      }
      prev = now;
      now = new int[field.length][field[0].length];
      t++;
    }
    for (int x = 0; x < field.length; x++) {
      for (int i = 0; i < field[x].length; i++) {
        if (field[x][i] == 'E') {
          return prev[x][i];
        }
      }
    }
    return -1;
  }
  public static int length(String filename) {
    try {
      File f = new File(filename);
      Scanner s = new Scanner(f);
      return convert(s.nextLine())[2];
    }
    catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return 0;
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
      size = convert(s.nextLine());
      ans[size[0]-1][size[1]-1] = 'S';
      ans[size[2]-1][size[3]-1] = 'E';
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
