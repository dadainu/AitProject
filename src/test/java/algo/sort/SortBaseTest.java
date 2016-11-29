package algo.sort;

public class SortBaseTest extends Sort {

    /** 重複ありデータ作成 */
    public static int[] dataOverlap(int num, int numDig) {
        int[] data = new int[num];
        for (int i = 0; i < num; i++) {
            data[i] = (int) (Math.random() * (Math.pow(10, numDig)));
        }
        return data;
    }

    /** 重複なしデータ作成 */
    public static int[] dataNotOverlap(int num, int numDig) {
        int[] data = new int[num];
        int random;
        boolean noOverlap;
        for (int i = 0; i < num; i++) {
            while (true) {
                noOverlap = true;
                random = (int) (Math.random() * (Math.pow(10, numDig)));
                for (int j = 0; j < i; j++) {
                    if (random == data[j]) {
                        noOverlap = false;
                        break;
                    }
                }
                if (noOverlap) {
                    break;
                }
            }
            data[i] = random;
        }
        return data;
    }

    /** データチェック */
    public boolean checkData(int[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i] < data[i - 1]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void sort(int[] data) {
    }
}
