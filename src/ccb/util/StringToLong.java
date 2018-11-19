package ccb.util;

public class StringToLong
{
  public static long ipToNum(String ip)
  {
    long num = 0L;
    String[] sections = ip.split("\\.");
    int i = 3;
    for (String str : sections) {
      num += (Long.parseLong(str) << i * 8);
      i--;
    }
    System.out.println(num);
    return num;
  }

  public static String compare(String iptest)
  {
    long id1 = ipToNum("192.168.1.128");
    //long id2 = ipToNum("100.0.0.2");
    long id = ipToNum(iptest);
    if (id > id1) {
      return "big";
    }
    return "small";
  }
}