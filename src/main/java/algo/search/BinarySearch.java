package algo.search;

public class BinarySearch<T extends Comparable<T>> extends Search<T> {

    @Override
    public boolean search(T[] data, T target) {
        // 検索対象がnullは対象外
        if (target == null) {
            return false;
        }
        return binary(data, target);
    }

    /** 二分探索 */
    public boolean binary(T[] data, T target) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            // 中間点
            int middle = (low + high) / 2;
            // 中間点と検索対象を比較
            int compareResult = target.compareTo(data[middle]);
            // 中間点より小さい場合
            if (compareResult < 0) {
                high = middle - 1;

                // 中間点より大きい場合
            } else if (0 < compareResult) {
                low = middle + 1;

                // 検索対象一致
            } else {
                return true;
            }
        }
        return false;
    }

}
