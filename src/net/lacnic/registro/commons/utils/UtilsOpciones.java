package net.lacnic.registro.commons.utils;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class UtilsOpciones {
	
	/* -- IDIOMAS --*/
	private static final String[] IDIOMAS = new String[] { "SP", "PT", "EN" };
	
	public static List<String> getIdiomas() {
		return Arrays.asList(IDIOMAS);
	}

	public static String getIdioma(int idioma) {
		return IDIOMAS[idioma];
	}

	public static long getIdioma(String idioma) {
		for (int i = 0; i < IDIOMAS.length; i++) {
			if (IDIOMAS[i].compareToIgnoreCase(idioma) == 0) {
				return i;
			}
		}
		return -1;
	}
	/* -- IDIOMAS --*/
	
	/* -- HOTEL --*/
	public static final String HOTEL_NO_APLICA = "No aplica para el viatico";
	public static final String HOTEL_INCLUIDO = "Incluido";
	public static final String HOTEL_COSTOSO = "Costoso";

	private static final String[] OPCIONES_HOTEL = new String[] { HOTEL_NO_APLICA, HOTEL_INCLUIDO, HOTEL_COSTOSO };

	public static String[] getOpcionesHotel() {
		return OPCIONES_HOTEL;
	}

	public static List<String> getOpcionesHotelList() {
		return Arrays.asList(OPCIONES_HOTEL);
	}
	
	public static int getOpcionHotel(String opcion) {
		for (int i = 0; i < OPCIONES_HOTEL.length; i++) {
			if(OPCIONES_HOTEL[i].compareTo(opcion)==0) return i;
		}
		
		return -1;
	}
	
	public static String getOpcionHotel(int opcion) {
		return OPCIONES_HOTEL[opcion];
	}
	
	public static boolean esHotelCostoso(String tipoHotel){
		return HOTEL_COSTOSO.compareTo(tipoHotel) == 0;
	}
	
	public static boolean esHotelCostoso(int tipoHotel){
		return HOTEL_COSTOSO.compareTo(getOpcionHotel(tipoHotel)) == 0;
	}
	/* -- HOTEL --*/
	
	/* -- VIATICOS --*/
	public static final String PAGO_VIATICO_CHEQUE = "Cheque";
	public static final String PAGO_VIATICO_TRANSFERENCIA = "Transferencia Bancaria";

	private static final String[] OPCIONES_PAGO_VIATICO = new String[] { PAGO_VIATICO_CHEQUE, PAGO_VIATICO_TRANSFERENCIA };

	public static String[] getOpcionesPagoViatico() {
		return OPCIONES_PAGO_VIATICO;
	}

	public static List<String> getOpcionesPagoViaticoList() {
		return Arrays.asList(OPCIONES_PAGO_VIATICO);
	}
	
	public static int getOpcionPagoViatico(String opcion) {
		for (int i = 0; i < OPCIONES_PAGO_VIATICO.length; i++) {
			if(OPCIONES_PAGO_VIATICO[i].compareTo(opcion)==0) return i;
		}
		
		return -1;
	}
	
	public static String getOpcionPagoViatico(int opcion) {
		return OPCIONES_PAGO_VIATICO[opcion];
	}
	/* -- VIATICOS --*/
	
	/* -- FILTROS SOLICITUDES --*/
	public static final int SOLICITUD_FILTRO_ACEPTADAS = 0;
	public static final int SOLICITUD_FILTRO_ANALISIS = 1;
	public static final int SOLICITUD_FILTRO_RECHAZADAS = 2;
	/* -- FILTROS SOLICITUDES --*/
	
	/* -- TEXTO SI/NO --*/
	public static final int SINO_NO = 0;
	public static final int SINO_SI = 1;
	
	public static String getSiNo(int opcion){
		if(opcion == SINO_NO) return "NO";
		if(opcion == SINO_SI) return "SI";		
		return "ERROR";
	}
	
	public static String getSiNo(boolean opcion){
		if(opcion) return "SI";
		return "NO";
	}	
	/* -- TEXTO SI/NO --*/
	
	/* -- TIPO IP --*/
	public static String getVersionIp(long versionIp){
		int version = BigInteger.valueOf(versionIp).intValue();
		
		switch (version) {
			case 4:
				return "IPv4";
				
			case 6:
				return "IPv6";
	
			default:
				return "";
		}
	}
	/* -- TIPO IP --*/
	
	/* -- CONECTORES BUSQUEDAS --*/
	public static final String BUSQUEDA_AND = "y";
	public static final String BUSQUEDA_OR = "o";

	private static final String[] OPCIONES_BUSQUEDA = new String[] { BUSQUEDA_AND, BUSQUEDA_OR };

	public static String[] getOpcionesBusqueda() {
		return OPCIONES_BUSQUEDA;
	}

	public static List<String> getOpcionesBusquedaList() {
		return Arrays.asList(OPCIONES_BUSQUEDA);
	}
	
	public static int getOpcionBusqueda(String opcion) {
		for (int i = 0; i < OPCIONES_BUSQUEDA.length; i++) {
			if(OPCIONES_BUSQUEDA[i].compareTo(opcion)==0) return i;
		}
		
		return -1;
	}
	
	public static String getOpcionBusqueda(int opcion) {
		return OPCIONES_BUSQUEDA[opcion];
	}
	
	public static String obtenerConector(String conector){
		if(conector.compareTo(BUSQUEDA_AND)==0) return "AND";
		if(conector.compareTo(BUSQUEDA_OR)==0) return "OR";
		
		return "";
	}
	
	/* -- CONECTORES BUSQUEDAS --*/
	
	/* -- OPCIONES MIEMBROS --*/
	public static final String MIEMBROS_FILTRO_TODOS = "Todos";
	public static final String MIEMBROS_FILTRO_SI = "Si";
	public static final String MIEMBROS_FILTRO_NO = "No";

	private static final String[] OPCIONES_FILTRO_MIEMBROS = new String[] { MIEMBROS_FILTRO_TODOS, MIEMBROS_FILTRO_SI, MIEMBROS_FILTRO_NO };

	public static String[] getOpcionesFiltroMiembros() {
		return OPCIONES_FILTRO_MIEMBROS;
	}

	public static List<String> getOpcionesFiltroMiembrosList() {
		return Arrays.asList(OPCIONES_FILTRO_MIEMBROS);
	}
	
	public static int getOpcionFiltroMiembros(String opcion) {
		for (int i = 0; i < OPCIONES_FILTRO_MIEMBROS.length; i++) {
			if(OPCIONES_FILTRO_MIEMBROS[i].compareTo(opcion)==0) return i;
		}
		
		return -1;
	}
	
	public static String getOpcionFiltroMiembros(int opcion) {
		return OPCIONES_FILTRO_MIEMBROS[opcion];
	}
	/* -- OPCIONES MIEMBROS --*/
}