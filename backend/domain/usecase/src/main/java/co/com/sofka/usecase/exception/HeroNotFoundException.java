package co.com.sofka.usecase.exception;

public class HeroNotFoundException extends RuntimeException{

    public HeroNotFoundException(String message) {
        super(message);
    }
}
