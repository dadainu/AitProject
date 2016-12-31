package threeD;

public class Face {

    // 面を構成する3つの頂点
    public Vertex[] v = new Vertex[3];

    public Face(Vertex v0, Vertex v1, Vertex v2) {
        v[0] = v0;
        v[1] = v1;
        v[2] = v2;
    }
}
