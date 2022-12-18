
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.
import java.util.*;

public class Huawei {
    public static List<Integer> phoneList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int total = 0;
        while (in.hasNextInt()) {
            phoneList.add(in.nextInt());

        }
        Metod2();
        in.close();

    }

    private static void Metod2() {
        phoneList.sort(Comparator.reverseOrder());
        int TotalServer = 1;
        int TotalNuma = 1;
        int totalLessOneNuma = 0;

        for (int i = 0; i < phoneList.size(); i++) {
            // System.out.println("temp: " + phoneList.get(i));
          //  System.out.println(totalLessOneNuma + "," + TotalNuma + "," + TotalServer);
            if (totalLessOneNuma + phoneList.get(i) > 32) {// 这一台手机无法在当前Numa内,尝试找到可填充剩余的手机

                // 分配新Numa
                TotalNuma++;
                SqueezeRes(32 - totalLessOneNuma);
                totalLessOneNuma = phoneList.get(i);
                phoneList.remove(i);
                          
               

            } else {
                totalLessOneNuma += phoneList.get(i);
                phoneList.remove(i);
            
            }
            if (TotalNuma > 4) {
                TotalServer++;// 分配一个新服务器
                TotalNuma = 1;// 把这个多出来的手机放到新服务器中
                totalLessOneNuma = 0;
             
            }
            i = -1;
            System.out.println(totalLessOneNuma + ", TotalNuma:" + TotalNuma + ", TotalServer" + TotalServer);
            System.out.println(phoneList.toString());

        }
        System.out.println(TotalServer);
    }

    private static void SqueezeRes(int res) {
        List<Integer> resList = new ArrayList<>();
        for (int i = phoneList.size() - 1; i >= 0; i--) {
            if (res - phoneList.get(i) >= 0) {
                resList.add(phoneList.get(i));
                res -= phoneList.get(i);
                phoneList.remove(i);

                i = phoneList.size() - 1;
            } else {
                System.out.println("resList:" + resList.toString());
                return;
            }
        }
    }

    private static int Metod1(List<Integer> phoneList) {
        Collections.sort(phoneList);
        int TotalServer = 1;
        int TotalNuma = 1;
        int totalLessOneNuma = 0;
        if (phoneList.size() == 0) {
            TotalServer = 0;
            System.out.println(TotalServer);
        } else {
            for (int temp : phoneList) {
                if (totalLessOneNuma + temp > 32) {// 这一台手机无法在当前Numa内
                    // 分配新Numa
                    TotalNuma++;
                    totalLessOneNuma = temp;
                } else {
                    totalLessOneNuma += temp;
                }
                if (TotalNuma > 4) {
                    TotalServer++;// 分配一个新服务器
                    TotalNuma = 1;// 把这个多出来的手机放到新服务器中
                    totalLessOneNuma = temp;

                }

                // System.out.println(totalLessOneNuma + "," + TotalNuma + "," + TotalServer);
            }
            if (TotalServer == 0 && TotalNuma >= 1) {
                System.out.println(1);
            } else {
                System.out.println(TotalServer);
            }
        }
        return TotalServer;
    }

}
