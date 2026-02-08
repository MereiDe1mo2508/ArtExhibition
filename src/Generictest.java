public class Generictest <T>{
    T thingtoPrint;
    public Generictest(T thingtoPrint) {
        this.thingtoPrint = thingtoPrint;
    }
    public void print() {
        System.out.println(thingtoPrint);
    }
}
