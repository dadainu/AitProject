package algo.sort;

public class InsertSort extends Sort {

    @Override
    public void sort(int[] data) {
        insert(data, 1);
    }

    public void insert(int[] data, int index) {
        // 配列データ外になったら再帰を抜ける
        if (index <= 0 || data.length <= index) {
            return;
        }
        // 前データより小さい場合
        if (data[index] < data[index - 1]) {
            // データ入れ替え
            change(data, index, index - 1);
            // さらに前データとの比較
            insert(data, --index);
        }

        // 後データ比較
        insert(data, ++index);
    }
}
