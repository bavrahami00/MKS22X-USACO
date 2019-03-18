import java.util.*;
import java.io.*;
public class USACO {
  public static int bronze(String filename) {
    try {
      int[][] board = open(filename);
      File f = new File(filename);
      Scanner s = new Scanner(f);
      String t = s.nextLine();
      int count = 0;
      int[] line;
      while (s.hasNext()) {
        if (count < board.length) {
          t = s.nextLine();
          count++;
        }
        else {
          t = s.nextLine();
          line = convert(t);
          board = stomp(board,line[0],line[1],line[2]);
        }
      }
      s = new Scanner(f);
      t = s.nextLine();
      int deep = convert(t)[2];
      return count(board,deep);
    }
    catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return 0;
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
  public static int[][] stomp (int[][] board, int row, int col, int depth) {
    int top = board[row][col];
    for (int x = row-1; x < row+2; x++) {
      for (int i = col-1; i < col+2; i++) {
        top = Math.max(top,board[x][i]);
      }
    }
    for (int x = row-1; x < row+2; x++) {
      for (int i = col-1; i < col+2; i++) {
        board[x][i] = Math.min(board[x][i],top-depth);
      }
    }
    return board;
  }
  public static int count(int[][] board, int depth) {
    int ans = 0;
    for (int x = 0; x < board.length; x++) {
      for (int i = 0; i < board[x].length; i++) {
        ans += Math.max(0,depth-board[x][i]);
      }
    }
    return ans*72*72;
  }
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
}
