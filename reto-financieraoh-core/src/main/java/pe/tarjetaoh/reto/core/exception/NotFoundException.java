package pe.tarjetaoh.reto.core.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super("Error: " + message);
    }
}
