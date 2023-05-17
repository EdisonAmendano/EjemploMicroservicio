package ec.edu.ups.ejemplo.ejemplo;

import ec.edu.ups.ejemplo.modelo.Libro;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/libro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Singleton
public class LibroController {

    List<Libro> listLibros = new ArrayList<>();
    public LibroController() {
        Libro l = new Libro();
        l.setId(123);
        l.setAutor("Arturo");
        l.setName("Distribuidos para nobs");
        listLibros.add(l);
    }

    @GET
    public List<Libro> mostrarLibros(){
        return listLibros;
    }

    @GET
    @Path("/{id}")
    public Libro obtenerPorId(@PathParam("id") int id){
        Libro lib = buscarLibro(id);
        return lib;
    }

    @POST
    public void guardarLibro(Libro l){
        listLibros.add(l);
    }

    @PUT
    @Path("/{id}")
    public void editarLibro(@PathParam("id") int id, Libro l){
        Libro lib = buscarLibro(id);
        lib.setAutor(l.getAutor());
        lib.setName(l.getName());

        for(int i = 0; i<listLibros.size();i++){
            if(listLibros.get(i).getId() == id){
                listLibros.set(i, lib);
                break;
            }
        }

    }

    @DELETE
    @Path("/{id}")
    public void eliminarLibro(@PathParam("id") int id){
        Libro lib = buscarLibro(id);
        listLibros.remove(lib);
    }

    public Libro buscarLibro(int id){
        Libro lib = new Libro();
        for(int i = 0; i<listLibros.size();i++){
            if(listLibros.get(i).getId() == id){
                lib = listLibros.get(i);
                break;
            }
        }
        return lib;
    }

}
