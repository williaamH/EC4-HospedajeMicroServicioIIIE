package idatcom.HospedajeMIcroServicioIIIE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idatcom.HospedajeMIcroServicioIIIE.model.Hospedaje;

@Repository
public interface HospedajeRepository extends JpaRepository<Hospedaje, Integer>{

}
