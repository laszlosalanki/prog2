class CarParent {
    protected String rendszam;
    protected String gyarto;
    protected String tipus;

    public void setRendszam(String rndszm) {
        rendszam = rndszm;
    }

    public void setGyarto(String gyrt) {
        gyarto = gyrt;
    }

    public void setTipus(String tps) {
        tipus = tps;
    }

    public String getRendszam() {
        return rendszam;
    }
}

class CarChild extends CarParent { 
    public String getGyarto() {
        return gyarto;
    }
}

class CarMain {
    public static void main(String[] args) {
        CarParent cp = new CarChild();
        cp.setRendszam("ABC-123");
        cp.setGyarto("Ford");
        cp.setTipus("Fiesta");

        CarChild cc = new CarChild();
        cc.setRendszam("ZYX");
        cc.setGyarto("Opel");
        cc.setTipus("Astra");

        System.out.println(cc.getRendszam() + " " + cp.getRendszam());
        System.out.println(cc.getGyarto() + " " + cp.getGyarto());
    }
}