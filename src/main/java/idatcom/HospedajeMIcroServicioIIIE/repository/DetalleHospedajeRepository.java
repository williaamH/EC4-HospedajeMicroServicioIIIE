package idatcom.HospedajeMIcroServicioIIIE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idatcom.HospedajeMIcroServicioIIIE.model.HospedajeDetalle;

@Repository
public interface DetalleHospedajeRepository extends JpaRepository<HospedajeDetalle, Integer>{

}
