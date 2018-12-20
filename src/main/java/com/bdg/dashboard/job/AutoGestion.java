package com.bdg.dashboard.job;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bdg.dashboard.model.CustomMessage;
import com.bdg.dashboard.model.Tablet;
import com.bdg.dashboard.service.TabletService;

@Component
public class AutoGestion {

	private static final Logger log = LoggerFactory.getLogger(AutoGestion.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	@Autowired
	TabletService tabletService;

	@Autowired
	Producer producer;

	@Scheduled(fixedRate = 10000)
	public void reportCurrentTime() {
		//log.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

		List<Tablet> tablets;
		final CustomMessage<List<Tablet>> mensaje;
		
		try {
			
			tablets = tabletService.getAllTablet();
			mensaje = new CustomMessage<List<Tablet>>("Enviando la lista de OFICINAS", tablets, new Random().nextInt(50), false);
			producer.sendMessage(mensaje);
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			log.error("Ha ocurrido un error: " + ex.getMessage(), AutoGestion.class);
		}

	}
}
