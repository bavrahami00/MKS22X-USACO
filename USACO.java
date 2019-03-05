public class USACO {
  public static int[][] open(String file) {
    File f = new File(t);
    Scanner s = new Scanner(f);
  }
  public static ArrayList<Integer> convert(String in) {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    String s = "";
    for (int x = 0; x < in.length(); x++) {
      if (in.charAt(x) == ' ') {
        ans.add(s);
        s = "";
      }
      else {
        s += in.charAt(x);
      }
    }
    ans.add(s);
    return ans;
  }
}
