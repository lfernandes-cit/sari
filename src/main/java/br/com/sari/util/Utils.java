package br.com.sari.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

	private static String basepath;

	/**
	 * Delete string.
	 *
	 * @param sb the sb
	 * @param s the s
	 */
	public static void deleteString(final StringBuilder sb, final String s) {
		final int start = sb.indexOf(s);
		if(start < 0) {
			return;
		}

		sb.delete(start, start + s.length());
	}

	/**
	 * Converte String para Date.
	 *
	 * @param str s
	 * @return Date
	 * @throws ParseException parse
	 */
	public static Date stringToDate(final String str) throws ParseException {
		DateFormat formatter;
		Date date;
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		date = formatter.parse(str);

		return date;
	}

	/**
	 * Converte String para Date.
	 *
	 * @param str s
	 * @return Date
	 * @throws ParseException parse
	 */
	public static Date stringToDateTime(final String str) throws ParseException {
		DateFormat formatter;
		Date date;
		formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		date = formatter.parse(str);

		return date;
	}

	public static Date getDateTimeAtual() throws ParseException {
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		final Date date = new Date();

		return stringToDateTime(dateFormat.format(date));


	}
	public static Date getDateAtual() throws ParseException {
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		final Date date = new Date();

		return stringToDate(dateFormat.format(date));


	}


	public static Long diferencaDataEmHoras(final Date dataInicial, final Date dataFinal) {
		// Data inicial
		final Calendar calInicio = Calendar.getInstance();
		calInicio.setTime(dataInicial);

		final Calendar calFim = Calendar.getInstance();
		calFim.setTime(dataFinal);

		// Calcula a diferença entre hoje e da data de inicio
		final long diferenca = calFim.getTimeInMillis() -
				calInicio.getTimeInMillis();
		// Quantidade de milissegundos em um dia
		final int tempoDia = 1000 * 60 * 60;
		final long horasDiferenca = diferenca / tempoDia;

		return horasDiferenca;
	}

	public static Long diferencaDataEmMinutos(final Date dataInicial, final Date dataFinal) {
		// Data inicial
		final Calendar calInicio = Calendar.getInstance();
		calInicio.setTime(dataInicial);

		final Calendar calFim = Calendar.getInstance();
		calFim.setTime(dataFinal);

		// Calcula a diferença entre hoje e da data de inicio
		final long diferenca = calFim.getTimeInMillis() -
				calInicio.getTimeInMillis();
		// Quantidade de milissegundos em um dia
		final int tempoDia = 1000 * 60 ;
		final long minutosDiferenca = diferenca / tempoDia;

		return minutosDiferenca;
	}

	public static Date getDataUltimoMinutoDia(final Date data) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(data);

		cal.set(Calendar.HOUR_OF_DAY,24);
		cal.set(Calendar.MINUTE,00);
		cal.set(Calendar.SECOND,00);

		return cal.getTime();

	}


	public static Integer arredondaInteger(BigDecimal valor) {

		if (valor != null) {
			valor = valor.setScale(0, BigDecimal.ROUND_HALF_EVEN);
			return valor.intValue();
		}

		return null;
	}



}
