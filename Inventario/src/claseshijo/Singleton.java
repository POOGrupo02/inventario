package claseshijo;

public class Singleton {

    private static Singleton instancia;

    private int idUsuario;

    private Singleton() {
        this.idUsuario = 0;
    }

    public static Singleton getInstancia() {
        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int valor) {
        this.idUsuario = valor;
    }
}

