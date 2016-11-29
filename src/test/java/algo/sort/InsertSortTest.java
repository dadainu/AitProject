package algo.sort;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InsertSortTest extends SortBaseTest {

    private InsertSort insert = new InsertSort();

    private int[] data;

    @Before
    public void setUp() throws Exception {
        System.out.println("---------------------");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("---------------------");
    }

    /** 重複ありデータ(データ個数：10,桁数：1) */
    @Test
    public void test0001() {
        try {
            data = dataOverlap(10, 1);
            printData(data);
            insert.sort(data);
            printData(data);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        assertEquals(true, checkData(data));
    }

    /** 重複なしデータ(データ個数：10,桁数：1) */
    @Test
    public void test0002() {
        try {
            data = dataNotOverlap(10, 1);
            printData(data);
            insert.sort(data);
            printData(data);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        assertEquals(true, checkData(data));
    }

    /** 重複ありデータ(データ個数：50,桁数：2) */
    @Test
    public void test0003() {
        try {
            data = dataOverlap(50, 2);
            printData(data);
            insert.sort(data);
            printData(data);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        assertEquals(true, checkData(data));
    }

    /** 重複なしデータ(データ個数：50,桁数：2) */
    @Test
    public void test0004() {
        try {
            data = dataNotOverlap(50, 2);
            printData(data);
            insert.sort(data);
            printData(data);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        assertEquals(true, checkData(data));
    }

    /** 重複ありデータ(データ個数：100,桁数：3) */
    @Test
    public void test0005() {
        try {
            data = dataOverlap(100, 3);
            printData(data);
            insert.sort(data);
            printData(data);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        assertEquals(true, checkData(data));
    }

    /** 重複なしデータ(データ個数：100,桁数：3) */
    @Test
    public void test0006() {
        try {
            data = dataNotOverlap(100, 3);
            printData(data);
            insert.sort(data);
            printData(data);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        assertEquals(true, checkData(data));
    }

    /** 重複ありデータ(データ個数：1000,桁数：4) */
    @Test
    public void test0007() {
        try {
            data = dataOverlap(1000, 4);
            printData(data);
            insert.sort(data);
            printData(data);
            fail();
        } catch (StackOverflowError e) {
        }
    }

    /** 重複なしデータ(データ個数：1000,桁数：4) */
    @Test
    public void test0008() {
        try {
            data = dataNotOverlap(1000, 4);
            printData(data);
            insert.sort(data);
            printData(data);
            fail();
        } catch (StackOverflowError e) {
        }
    }

}
