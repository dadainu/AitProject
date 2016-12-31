package threeD;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Hello3D_Step01 extends Applet {

    private static final long serialVersionUID = 1L;

    // 頂点データ
    final double[][] VERTEX_DATA = { { -1, 0, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 1, 0, 0 },
            { 0, 0, 1 }, { 0, -1, 0 } };
    // 面データ
    final int[][] FACE_DATA = { { 1, 4, 2 }, { 1, 0, 4 }, { 1, 2, 0 }, { 3, 2, 4 }, { 0, 5, 4 },
            { 4, 5, 3 }, { 3, 5, 2 }, { 2, 5, 0 } };
    ArrayList<Vertex> vertices; // 頂点列を保持する
    ArrayList<Face> faces; // 面（三角形）列を保持する
    Point center; // アプレットの中心座標
    double scale; // モデル描画時のスケール
    Dimension appletSize; // アプレットサイズ

    public void init() {
        // アプレットサイズの取得
        appletSize = getSize();

        // アプレットの中心座標の取得
        center = new Point(appletSize.width / 2, appletSize.height / 2);

        // 描画スケールの設定
        scale = appletSize.width * 0.8 / 2;

        // モデルデータの設定
        setModelData();
    }

    public void paint(Graphics g) {
        drawModel(g);
    }

    // モデルデータの設定
    public void setModelData() {
        vertices = new ArrayList<Vertex>(); // 頂点列を初期化
        faces = new ArrayList<Face>(); // 面列を初期化

        // 頂点の作成
        for (int i = 0; i < VERTEX_DATA.length; i++) {
            vertices.add(new Vertex(VERTEX_DATA[i][0], VERTEX_DATA[i][1], VERTEX_DATA[i][2]));
        }

        // 面の作成
        for (int i = 0; i < FACE_DATA.length; i++) {
            faces.add(new Face((Vertex) vertices.get(FACE_DATA[i][0]),
                    (Vertex) vertices.get(FACE_DATA[i][1]),
                    (Vertex) vertices.get(FACE_DATA[i][2])));
        }
    }

    // モデルの描画
    private void drawModel(Graphics g) {
        // 描画色を黒に設定
        g.setColor(Color.black);

        // 各面の描画
        for (int i = 0; i < faces.size(); i++) {
            Face face = (Face) faces.get(i);

            // 面の輪郭線の描画
            for (int j = 0; j < 3; j++) {
                int x0 = (int) (center.x + face.v[j].x * scale);
                int y0 = (int) (center.y - face.v[j].y * scale);
                int x1 = (int) (center.x + face.v[(j + 1) % 3].x * scale);
                int y1 = (int) (center.y - face.v[(j + 1) % 3].y * scale);

                g.drawLine(x0, y0, x1, y1);
            }
        }
    }
}
