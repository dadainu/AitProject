package algo.sort;

public abstract class Sort {

    /** ソート */
    public abstract void sort(int[] data);

    /** データ表示 */
    public void printData(int[] data) {
        for (int i : data) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    /** 入れ替え */
    public void change(int[] data, int left, int right) {
        int tmp = data[left];
        data[left] = data[right];
        data[right] = tmp;
    }

    /** 分割 */
    public void pertition(int[] data) {

    }
}
