package exepciones;

public class YaExiste extends RuntimeException {
    public YaExiste() {
        super("Ya existe");
    }
}
