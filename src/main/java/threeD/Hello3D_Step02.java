package threeD;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/*
<applet code="Hello3D_Step2" width=300 height=300>
</applet>
*/
public class Hello3D_Step02 extends Applet implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    // 頂点データ
    final double[][] VERTEX_DATA = { { -1, 0, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 1, 0, 0 },
            { 0, 0, 1 }, { 0, -1, 0 } };
    // 面データ
    final int[][] FACE_DATA = { { 1, 4, 2 }, { 1, 0, 4 }, { 1, 2, 0 }, { 3, 2, 4 }, { 0, 5, 4 },
            { 4, 5, 3 }, { 3, 5, 2 }, { 2, 5, 0 } };
    ArrayList<Vertex02> vertices; // 頂点列を保持する
    ArrayList<Face02> faces; // 面（三角形）列を保持する
    Point center; // アプレットの中心座標
    Point mousePosition; // マウス位置
    double scale; // モデル描画時のスケール
    double phi; // x軸周りの回転角
    double theta; // y軸周りの回転角
    Image bufferImage; // ダブルバッファリング用のイメージ
    Dimension appletSize; // アプレットサイズ

    public void init() {
        // イベントリスナの登録
        addMouseMotionListener(this);
        addMouseListener(this);

        // アプレットサイズの取得
        appletSize = getSize();

        // アプレットの中心座標の取得
        center = new Point(appletSize.width / 2, appletSize.height / 2);

        // マウス位置の初期化
        mousePosition = new Point(0, 0);

        // 描画スケールの設定
        scale = appletSize.width * 0.8 / 2;

        // 回転角の初期化
        phi = 0.0;
        theta = 0.0;

        // モデルデータの設定
        setModelData();

        // 頂点のスクリーン座標の設定
        setScreenPosition();
    }

    public void paint(Graphics g) {
        // ダブルバッファリング用のイメージを作成
        if (bufferImage == null) {
            bufferImage = createImage(appletSize.width, appletSize.height);
        }

        // バッファにモデルを描画
        drawModel(bufferImage.getGraphics());

        // バッファイメージをアプレットに描画
        g.drawImage(bufferImage, 0, 0, this);
    }

    // 描画更新時に背景の塗りつぶし処理を行わないためのオーバーライド
    public void update(Graphics g) {
        paint(g);
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        // 回転角の更新
        theta += (e.getX() - mousePosition.x) * 0.01;
        phi += (e.getY() - mousePosition.y) * 0.01;

        // x軸周りの回転角に上限を設定
        phi = Math.min(phi, Math.PI / 2);
        phi = Math.max(phi, -Math.PI / 2);

        // マウス位置の更新
        mousePosition.setLocation(e.getX(), e.getY());

        // 頂点のスクリーン座標の更新
        setScreenPosition();

        // 描画更新
        repaint();
    }

    public void mousePressed(MouseEvent e) {
        // マウス位置の更新
        mousePosition.setLocation(e.getX(), e.getY());
    }

    // モデルデータの設定
    public void setModelData() {
        vertices = new ArrayList<Vertex02>(); // 頂点列を初期化
        faces = new ArrayList<Face02>(); // 面列を初期化

        // 頂点の作成
        for (int i = 0; i < VERTEX_DATA.length; i++) {
            vertices.add(new Vertex02(VERTEX_DATA[i][0], VERTEX_DATA[i][1], VERTEX_DATA[i][2]));
        }

        // 面の作成
        for (int i = 0; i < FACE_DATA.length; i++) {
            faces.add(new Face02((Vertex02) vertices.get(FACE_DATA[i][0]),
                    (Vertex02) vertices.get(FACE_DATA[i][1]),
                    (Vertex02) vertices.get(FACE_DATA[i][2])));
        }
    }

    // 頂点のスクリーン座標を更新する
    private void setScreenPosition() {
        for (int i = 0; i < vertices.size(); i++) {
            Vertex02 v = (Vertex02) vertices.get(i);

            // 回転後の座標値の算出
            v.rx = v.x * Math.cos(theta) + v.z * Math.sin(theta);
            v.ry = v.x * Math.sin(phi) * Math.sin(theta) + v.y * Math.cos(phi)
                    - v.z * Math.sin(phi) * Math.cos(theta);
            v.rz = -v.x * Math.cos(phi) * Math.sin(theta) + v.y * Math.sin(phi)
                    + v.z * Math.cos(phi) * Math.cos(theta);

            // スクリーン座標の算出
            v.screenX = (int) (center.x + scale * v.rx);
            v.screenY = (int) (center.y - scale * v.ry);
        }
    }

    // モデルの描画
    private void drawModel(Graphics g) {
        // 白色で全体をクリア
        g.setColor(Color.white);
        g.fillRect(0, 0, appletSize.width, appletSize.height);

        // 各面の描画
        for (int i = 0; i < faces.size(); i++) {
            Face02 face = (Face02) faces.get(i);

            // 面の輪郭線の描画
            g.setColor(Color.black);
            for (int j = 0; j < 3; j++) {
                g.drawLine(face.v[j].screenX, face.v[j].screenY, face.v[(j + 1) % 3].screenX,
                        face.v[(j + 1) % 3].screenY);
            }
        }
    }
}

// 面クラス
class Face02 {

    public Vertex02[] v = new Vertex02[3]; // 面を構成する3つの頂点

    public Face02(Vertex02 v0, Vertex02 v1, Vertex02 v2) {
        v[0] = v0;
        v[1] = v1;
        v[2] = v2;
    }
}

// 頂点クラス
class Vertex02 {

    public double x, y, z; // モデルの頂点座標
    public double rx, ry, rz; // 回転させた後の座標
    public int screenX, screenY; // スクリーン上の座標

    public Vertex02(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

}
