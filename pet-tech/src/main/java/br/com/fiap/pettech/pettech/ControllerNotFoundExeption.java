package br.com.fiap.pettech.pettech;

public class ControllerNotFoundExeption extends RuntimeException{
    public ControllerNotFoundExeption(String mesage) {
        super(mesage);
    }
}
