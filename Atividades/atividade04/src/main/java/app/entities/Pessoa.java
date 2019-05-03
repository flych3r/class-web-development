package app.entities;

import java.util.Arrays;
import java.util.List;

public class Pessoa {

    private String nome;
    private String time;
    private List<String> hobbies;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = Arrays.asList(hobbies);
    }

}
