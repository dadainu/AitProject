package threeD;

public class Vertex {

    // モデル座標点
    public double x, y, z;

    public double rx, ry, rz; // 回転させた後の座標
    public int screenX, screenY; // スクリーン上の座標

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

    }
}
