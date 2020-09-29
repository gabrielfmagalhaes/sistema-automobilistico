package com.sistema.automobilistico.boleto.service;

import com.sistema.automobilistico.boleto.model.Boleto;
import com.sistema.automobilistico.boleto.model.dto.BoletoRequestDto;
import com.sistema.automobilistico.boleto.model.dto.BoletoResponseDto;
import com.sistema.automobilistico.boleto.repository.BoletoRepository;

import org.springframework.stereotype.Service;

@Service
public class BoletoService {

	private BoletoRepository boletoRepository;

	public BoletoService(BoletoRepository boletoRepository) {
		this.boletoRepository = boletoRepository;
	}

	public Boleto save(Boleto boleto) {
		return boletoRepository.save(boleto);
	}
	
	public BoletoResponseDto gerarBoleto(BoletoRequestDto boletoRequestDto) {
		Boleto boleto = boletoRequestDto.transformaParaObjeto(boletoRequestDto);
		Boleto novoBoleto = this.save(boleto);
		
		return new BoletoResponseDto().transformaParaDto(novoBoleto);
	}
}
