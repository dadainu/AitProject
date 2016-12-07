package utility;

import algo.search.BinarySearch;

public class DataUtil<T extends Comparable<T>> {

    private char[] strList = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    /** データ作成(数値)(重複有) */
    public Integer[] createOverlapIntData(int size, int numDig) {
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = getRandom(numDig);
        }
        return data;
    }

    /** データ作成(数値)(重複無) */
    public Integer[] createNotOverlapIntData(int size, int numDig) {
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = 0;
        }
        // データ内に同じ値がない場合追加
        for (int index = 0; index < size; index++) {
            addNotOverlapNum(data, index, numDig);
        }
        return data;
    }

    /** データ作成（文字列）（重複有） */
    public String[] createOverlapStrData(int size, int numDig) {
        String[] data = new String[size];
        String tmp = "";
        int index;
        for (int i = 0; i < size; i++) {
            // 適当な文字列追加
            for (int j = 0; j < numDig; j++) {
                // 文字列データ範囲内のインデックス
                do {
                    index = getRandom(2);
                } while (index < 0 || strList.length <= index);
                tmp += strList[index];
            }
            data[i] = tmp;
            tmp = "";
        }
        return data;
    }

    /** 乱数取得 */
    public int getRandom(int numDig) {
        return (int) (Math.random() * Math.pow(10, numDig));
    }

    /** 重複しないデータ追加 */
    public void addNotOverlapNum(Integer[] data, int addIndex, int numDig) {
        int random;
        boolean addFlag;
        BinarySearch<Integer> search = new BinarySearch<Integer>();
        while (true) {
            addFlag = true;
            random = getRandom(numDig);
            // 配列内検索
            if (search.search(data, random)) {
                addFlag = false;
            }
            // 重複データなければ追加
            if (addFlag) {
                data[addIndex] = random;
                break;
            }
        }
    }

    /** データ内容表示 */
    public void printArray(T[] data) {
        for (T aT : data) {
            System.out.println(aT + ",");
        }
        System.out.println();
    }
}
