package br.com.sari.config;

import org.dozer.CustomFieldMapper;
import org.dozer.classmap.ClassMap;
import org.dozer.fieldmap.FieldMap;
import org.hibernate.collection.spi.PersistentCollection;

public class LazyLoadSensitiveMapper implements CustomFieldMapper {
	@Override
	public boolean mapField(final Object source,
			final Object destination,
			final Object sourceFieldValue,
			final ClassMap classMap,
			final FieldMap fieldMapping) {
		// If field is initialized, Dozer will continue mapping
		boolean stopMapping = false;

		if (sourceFieldValue instanceof PersistentCollection) {
			stopMapping = !((PersistentCollection) sourceFieldValue).wasInitialized();
		}

		return stopMapping;
	}
}