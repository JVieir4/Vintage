package vintage;

public class malas {
    private boolean premium;
    private int dimx;
    private int dimy;
    private String material;
    private int data;

    public malas(boolean prem, int x, int y, String mat, int ano) {
        this.premium = prem;
        this.dimx = x;
        this.dimy = y;
        this.material = mat;
        this.data = ano;
    }

    public malas(malas m) {
        this.premium = m.getPrem();
        this.dimx = m.getDimx();
        this.dimy = m.getDimy();
        this.material = m.getMaterial();
        this.data = m.getData();
    }

    public int getData() {
        return this.data;
    }

    public void setData(int a) {
        this.data = a;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String m) {
        this.material = m;
    }

    public int getDimy() {
        return this.dimy;
    }

    public void setDimy(int y) {
        this.dimy = y;
    }

    public int getDimx() {
        return this.dimx;
    }

    public void setDimx(int x) {
        this.dimx = x;
    }

    public boolean getPrem() {
        return this.premium;
    }

    public void setPrem(boolean p) {
        this.premium = p;
    }
}
