package co.edu.uniquindio.unitravel.servicios;

import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorio.CiudadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServicioImp implements CiudadServicio{

    @Autowired
    private CiudadRepo ciudadRepo;

    public CiudadServicioImp(CiudadRepo ciudadRepo) {
        this.ciudadRepo = ciudadRepo;
    }

    /**
     * @param c
     * @return
     * @throws Exception
     */
    @Override
    public Ciudad registrarCiudad(Ciudad c) throws Exception {
        Ciudad buscado = obtenerCiudad(c.getCodigo());
        //Usuario usuarioEmail= bus
        if (buscado != null) {
            throw new Exception("La cédula del usuario ya está registrada");
        }
        if(buscado!=null){

        }
        return ciudadRepo.save(c);
    }

    /**
     * @param codigo
     * @return
     * @throws Exception
     */
    @Override
    public Ciudad obtenerCiudad(Integer codigo) throws Exception {
        return ciudadRepo.findByCodigo(codigo);
    }

    /**
     * @param c
     * @return
     * @throws Exception
     */
    @Override
    public Ciudad actualizarCiudad(Ciudad c) throws Exception {
        Ciudad buscado = obtenerCiudad(c.getCodigo());
        if (buscado == null) {
            throw new Exception("El usuario no existe");
        }
        return ciudadRepo.save(c);
    }

    /**
     * @return
     */
    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

    /**
     * @param codigo
     * @throws Exception
     */
    @Override
    public void elimiarCiudad(Integer codigo) throws Exception {
        Ciudad ciudad = obtenerCiudad(codigo);

        if (ciudad == null) {
            throw new Exception("El usuario no existe");
        }
        ciudadRepo.delete(ciudad);
    }

    /**
     * @param ciudadList
     * @throws Exception
     */
    @Override
    public void elimiarCiudades(List<Ciudad> ciudadList) throws Exception {

        for(Ciudad ciudad: ciudadList){
            Ciudad ciudadBuscada = obtenerCiudad(ciudad.getCodigo());

            if (ciudad == null) {
                throw new Exception("El usuario no existe");
            }
            ciudadRepo.delete(ciudadBuscada);
        }

    }
}
