package ec.edu.ups.ejemplo.modelo;

public class Libro {
    private int id;
    private String name;
    private String autor;

    public Libro() {
    }

    public Libro(int id, String name, String autor) {
        this.id = id;
        this.name = name;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
