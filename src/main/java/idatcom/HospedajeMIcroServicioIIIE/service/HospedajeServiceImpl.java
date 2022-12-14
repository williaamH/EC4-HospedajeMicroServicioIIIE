package idatcom.HospedajeMIcroServicioIIIE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idatcom.HospedajeMIcroServicioIIIE.client.OpenFeignClient;
import idatcom.HospedajeMIcroServicioIIIE.dto.TuristaDTO;
import idatcom.HospedajeMIcroServicioIIIE.model.Hospedaje;
import idatcom.HospedajeMIcroServicioIIIE.model.HospedajeDetalle;
import idatcom.HospedajeMIcroServicioIIIE.model.TuristaHospedajeFK;
import idatcom.HospedajeMIcroServicioIIIE.repository.DetalleHospedajeRepository;
import idatcom.HospedajeMIcroServicioIIIE.repository.HospedajeRepository;

@Service
public class HospedajeServiceImpl implements HospedajeService {
	
	@Autowired
	private HospedajeRepository turRepo;
	
	@Autowired
	private DetalleHospedajeRepository detalleRepo;
	
	@Autowired
	private OpenFeignClient client;

	@Override
	public void guardarHospedaje(Hospedaje hospedaje) {
		turRepo.save(hospedaje);

	}

	@Override
	public void asignarTuristaHospedaje() {
		
		List<TuristaDTO> listado = client.listarTuristas();
		TuristaHospedajeFK fk = null;
		HospedajeDetalle detalle = null;
		
		for (TuristaDTO turistaDTO : listado) {
			fk = new TuristaHospedajeFK();
			fk.setIdHospedaje(turistaDTO.getCod());
			fk.setIdHospedaje(1);
			
			detalle = new HospedajeDetalle();
			detalle.setFk(fk);
			
			detalleRepo.save(detalle);
		}
		
	}

}
