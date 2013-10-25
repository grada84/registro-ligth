package net.lacnic.registro.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsFechas {
	private final static long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día
	public final static SimpleDateFormat formatDateFecha = new SimpleDateFormat("dd/MM/yyyy");
	public final static SimpleDateFormat formatDateFechaNumerica = new SimpleDateFormat("yyyyMMdd");
	public final static SimpleDateFormat formatDateFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat formatDateFechaConsultaSQLInicio = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	public final static SimpleDateFormat formatDateFechaConsultaSQLFin = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	public final static SimpleDateFormat formatDateFechaHoraMinutos = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public static long diferenciaEnDias(Date fechaFin, Date fechaIni){
		return (fechaFin.getTime() - fechaIni.getTime()) / MILLSECS_PER_DAY;
	}
	
	public static String fechaNula(Date date){
		if(date == null) return "";
		
		return formatDateFecha.format(date);
	}
}
