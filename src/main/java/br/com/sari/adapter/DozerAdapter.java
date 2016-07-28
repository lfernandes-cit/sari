package br.com.sari.adapter;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import br.com.sari.config.LazyLoadSensitiveMapper;

public class DozerAdapter {

	private DozerBeanMapper mapper;

	public DozerAdapter() {
		mapper = new DozerBeanMapper();
		final LazyLoadSensitiveMapper customFieldMapper = new LazyLoadSensitiveMapper();
		mapper.setCustomFieldMapper(customFieldMapper);
	}

	public DozerBeanMapper getMapper() {
		return mapper;
	}

	public void setMapper(final DozerBeanMapper mapper) {
		this.mapper = mapper;
	}

	public void converter(final Object fonte, final Object destino) {
		mapper.map(fonte, destino);
	}

	public Object converter(final Object fonte, final Class classeDestino) {
		return mapper.map(fonte, classeDestino);
	}

	public <T, U> List<U> converterLista(final List<T> source, final Class<U> destType) {

		final List<U> dest = new ArrayList<>();

		for (final T element : source) {
			dest.add(mapper.map(element, destType));
		}

		return dest;
	}

}
