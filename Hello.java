package external_classes;

public class Hello {
    public void print() {
        System.out.println("Custom loader: " + this.getClass().getClassLoader());
    }
}