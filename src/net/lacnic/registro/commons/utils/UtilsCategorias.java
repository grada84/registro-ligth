package net.lacnic.registro.commons.utils;

import java.util.ArrayList;
import java.util.List;

import net.lacnic.domain.mysql.BlocosIP;

import org.joda.time.DateTime;

public class UtilsCategorias {
	public static final String SMALL_MICRO = "small/micro";
	public static final String SMALL = "small";
	public static final String MEDIUM = "medium";
	public static final String LARGE = "large";
	public static final String EXTRA_LARGE = "extra-large";
	public static final String MAYOR = "xx-large";
	public static final String NONE = "none";

	public static final String END_USER_ASN = "end-user-AS";
	public static final String END_USER = "end-user";
	public static final String LEGACY = "legacy";

	public static Object[] getCategoriaISPNuevaPolitica(List<BlocosIP> listaBlocosIp) {
		List<BlocosIP> listaBlocosCategoriaISP= new ArrayList<BlocosIP>();
		for (int i = 0; i < listaBlocosIp.size(); i++) // RECORRO PARA LA
			// CATEGORIA Y CHEKEO no
			// reallocated ni
			// reassigned
		{
			BlocosIP blocosIP = listaBlocosIp.get(i);
			if (!UtilsBloques.getOpcionEstadoBloques(blocosIP.getStatus()).equals(UtilsBloques.ESTADO_BLOQUES_RE_ALLOCATED) && !UtilsBloques.getOpcionEstadoBloques(blocosIP.getStatus()).equals(UtilsBloques.ESTADO_BLOQUES_RE_ASSIGNED)) {
					listaBlocosCategoriaISP.add(blocosIP);
			}

		}
		UtilsRecursos util = new UtilsRecursos();
		String slashsIPV4 = util.totalesSlash(listaBlocosCategoriaISP, 4);
		String slashsIPV6 = util.totalesSlash(listaBlocosCategoriaISP, 6);
		int barraMaximoIPV4 = slashsIPV4.equals("") ? 33 : Integer.valueOf(slashsIPV4.split("\\/")[1].trim());
		int barraMaximoIPV6 = slashsIPV6.equals("") ? 129 : Integer.valueOf(slashsIPV6.split("\\/")[1].trim());

		if ((barraMaximoIPV4 > 20 && barraMaximoIPV4<33) && (barraMaximoIPV6 == 129 || barraMaximoIPV6 > 32 || slashsIPV6.equals(" /32")))
		// TIENE ipv4 menor a /20 e ipv6 hasta /32 inclusive
		{
			return new Object[]{SMALL_MICRO, false};
		}
		// mayor o igual a /20, hasta /19 inclusive e ipv6 hasta /32 inclusive
		else if ((barraMaximoIPV4 > 19 || slashsIPV4.equals(" /19")) && (barraMaximoIPV6 > 32 || slashsIPV6.equals(" /32"))) {

			return new Object[]{SMALL, false};
		}
		// mayor a /19 y menor que /16, e ipv6 mayor a /32 y menor que /30
		else if (barraMaximoIPV4 > 16 && barraMaximoIPV6 > 30) {
			return new Object[]{MEDIUM, false};
		}
		// mayor o igual a /16 y menor que /14, e ipv6 mayor o igual a /30 y
		// menor que /28
		else if (barraMaximoIPV4 > 14 && barraMaximoIPV6 > 28) {
			return new Object[]{LARGE, false};
		}
		// Mayor o igual /14 y menor /11, e ipv6 mayor o igual /28 menor /26
		else if (barraMaximoIPV4 > 11 && barraMaximoIPV6 > 26) {
			return new Object[]{EXTRA_LARGE, false};
		}
		// mayor o igual a /11, e ipv6 mayor o igual a /26
		else if (barraMaximoIPV4 <= 11 || barraMaximoIPV6 <= 26) {
			return new Object[]{MAYOR, false};
		} else {
			return new Object[]{NONE, false};
		}
	}
	public static Object[] getCategoriaNuevaPoliticaEndUsers(List<BlocosIP> listaBlocosIp, long asnsize, boolean legacyipv6) {
		UtilsRecursos util = new UtilsRecursos();
		int i = 0;
		boolean tieneAllocated = false;
		boolean tieneAssigned = false;
		boolean tieneASN = false;
		boolean tieneIPV6 = false;

		while (i < listaBlocosIp.size() && !tieneAllocated) {
			BlocosIP actual = listaBlocosIp.get(i);
			if (actual.getVersion() == 6) {
				tieneIPV6 = true;
			}
			if (UtilsBloques.getOpcionEstadoBloques(actual.getStatus()).equals(UtilsBloques.ESTADO_BLOQUES_ALLOCATED)&& new DateTime(actual.getDataCadastro()).isAfter(new DateTime(1997, 12, 28, 0, 0))) {
				tieneAllocated = true;
			}																																								/**/
			if (UtilsBloques.getOpcionEstadoBloques(actual.getStatus()).equals(UtilsBloques.ESTADO_BLOQUES_ASSIGNED) && new DateTime(actual.getDataCadastro()).isAfter(new DateTime(1997, 12, 28, 0, 0))) {
				tieneAssigned = true;
			}
			i++;
		}
		tieneASN = asnsize != 0;
		if (!tieneAllocated) {
			if (tieneASN && !tieneAssigned) // SOLO TIENE ASN Y
											// NO ES LEGACY NI
											// TIENE ASSIGNED
			{
				return new Object[]{END_USER_ASN, tieneAllocated};
			} else {
				return new Object[]{END_USER, tieneAllocated};
			}
		} else {
			List<BlocosIP> listaBlocosCategoriaISP = new ArrayList<BlocosIP>();
			for (i = 0; i < listaBlocosIp.size(); i++) // RECORRO PARA LA
														// CATEGORIA Y CHEKEO no
														// reallocated ni
														// reassigned
			{
				BlocosIP blocosIP = listaBlocosIp.get(i);
				if (!UtilsBloques.getOpcionEstadoBloques(blocosIP.getStatus()).equals(UtilsBloques.ESTADO_BLOQUES_RE_ALLOCATED) && !UtilsBloques.getOpcionEstadoBloques(blocosIP.getStatus()).equals(UtilsBloques.ESTADO_BLOQUES_RE_ASSIGNED)) {
					listaBlocosCategoriaISP.add(blocosIP);
				}

			}
			return getCategoriaISPNuevaPolitica(listaBlocosCategoriaISP);
		}
		
	}

	private static void main() {
		
		
		// WritableWorkbook libro = Workbook.createWorkbook(archivo);
		// WritableSheet hoja = libro.createSheet("Agenda",0);
		//
		// int posicion = 1;
		//
		// hoja.addCell(new Label(0, 0, "ORG-ID"));
		// hoja.addCell(new Label(1, 0, "NOMBRE"));
		// hoja.addCell(new Label(2, 0, "TIPO CLIENTE"));
		// hoja.addCell(new Label(3, 0, "PRODUCTO"));
		// hoja.addCell(new Label(4, 0, "RECURSO"));
		//
		// for (Object[] datos : listaEntidades) {
		// hoja.addCell(new Label(0, posicion, datos[0].toString()));
		// hoja.addCell(new Label(1, posicion, datos[1].toString()));
		// // hoja.addCell(new Label(2, posicion,
		// UtilsEntidades.getCategoria(Long.parseLong(datos[2].toString()))));
		// hoja.addCell(new Label(2, posicion, datos[2].toString()));
		// hoja.addCell(new Label(3, posicion, datos[3].toString()));
		//
		// IpRange bloque =
		// UtilsBloques.formatBloque(Integer.parseInt(datos[3].toString()), new
		// BigInteger(datos[4].toString()), new
		// BigInteger(datos[5].toString()));
		// hoja.addCell(new Label(4, posicion, bloque.toString()));
		//
		// posicion++;
		// }
		//
		// //le digo a cada columna que se ajuste al texto
		// CellView cellView = new CellView();
		// cellView.setAutosize(true);
		//
		// for (int i = 0; i < 5; i++) {
		// hoja.setColumnView(i, cellView);
		// }
		//
		// libro.write();
		// libro.close();
		//
		// return UtilsFiles.getBytesFromFile(archivo);
	}

	public static String getCategoriaISP(List<BlocosIP> listaBlocosIp) {
		List<BlocosIP> listaBlocosCategoriaISP= new ArrayList<BlocosIP>();
		for (int i = 0; i < listaBlocosIp.size(); i++) // RECORRO PARA LA
			// CATEGORIA Y CHEKEO no
			// reallocated ni
			// reassigned
		{
			BlocosIP blocosIP = listaBlocosIp.get(i);
			if (!UtilsBloques.getOpcionEstadoBloques(blocosIP.getStatus()).equals(UtilsBloques.ESTADO_BLOQUES_RE_ALLOCATED) && !UtilsBloques.getOpcionEstadoBloques(blocosIP.getStatus()).equals(UtilsBloques.ESTADO_BLOQUES_RE_ASSIGNED)) {
					listaBlocosCategoriaISP.add(blocosIP);
			}

		}
		UtilsRecursos util = new UtilsRecursos();
		String slashsIPV4 = util.totalesSlash(listaBlocosCategoriaISP, 4);
		String slashsIPV6 = util.totalesSlash(listaBlocosCategoriaISP, 6);
		// int barraMaximoIPV4 = slashsIPV4.equals("") ? 33 :
		// Integer.valueOf(slashsIPV4.substring(2,4));
		// int barraMaximoIPV6 = slashsIPV6.equals("") ? 129 :
		// Integer.valueOf(slashsIPV6.substring(2,4));
		int barraMaximoIPV4 = slashsIPV4.equals("") ? 33 : Integer.valueOf(slashsIPV4.split("\\/")[1].trim());
		int barraMaximoIPV6 = slashsIPV6.equals("") ? 129 : Integer.valueOf(slashsIPV6.split("\\/")[1].trim());

		if ((barraMaximoIPV4 > 20) /*
									 * && (barraMaximoIPV6==129 ||
									 * slashsIPV6.equals(" /32"))
									 */)
		// menor a /20 e ipv6 no existe
		{
			return SMALL_MICRO;
		}
		// mayor o igual a /20, hasta /19 inclusive e ipv6 hasta /32 inclusive
		else if ((barraMaximoIPV4 > 19 || slashsIPV4.equals(" /19")) /*
																	 * && (
																	 * barraMaximoIPV6
																	 * >32 ||
																	 * slashsIPV6
																	 * .
																	 * equals(" /32"
																	 * ))
																	 */) {

			return SMALL;
		}
		// mayor a /19 y menor que /16, e ipv6 mayor a /32 y menor que /30
		else if (barraMaximoIPV4 > 16 /* && barraMaximoIPV6>30 */) {
			return MEDIUM;
		}
		// mayor o igual a /16 y menor que /14, e ipv6 mayor o igual a /30 y
		// menor que /28
		else if (barraMaximoIPV4 > 14 /* && barraMaximoIPV6 > 28 */) {
			return LARGE;
		}
		// Mayor o igual /14 y menor /11, e ipv6 mayor o igual /28 menor /26
		else if (barraMaximoIPV4 > 11 /* && barraMaximoIPV6 > 26 */) {
			return EXTRA_LARGE;
		}
		// mayor o igual a /11, e ipv6 mayor o igual a /26
		else if ((barraMaximoIPV4 <= 11/*
										 * && (barraMaximoIPV6<26 ||
										 * slashsIPV6.equals(" /26"))
										 */)) {
			return MAYOR;
		} else {
			return NONE;
		}
	}

	public static String getCategoriaISP(int prefijoIPV4) {

		if ((prefijoIPV4 > 20) /*
								 * && (barraMaximoIPV6==129 ||
								 * slashsIPV6.equals(" /32")))
								 */)
		// menor a /20 e ipv6 no existe
		{
			return SMALL_MICRO;
		}
		// mayor o igual a /20, hasta /19 inclusive e ipv6 hasta /32 inclusive
		else if ((prefijoIPV4 >= 19) /*
									 * && (barraMaximoIPV6>32 ||
									 * slashsIPV6.equals(" /32"))
									 */) {
			return SMALL;
		}
		// mayor a /19 y menor que /16, e ipv6 mayor a /32 y menor que /30
		else if (prefijoIPV4 > 16 /* && barraMaximoIPV6>30 */) {
			return MEDIUM;
		}
		// mayor o igual a /16 y menor que /14, e ipv6 mayor o igual a /30 y
		// menor que /28
		else if (prefijoIPV4 > 14 /* && barraMaximoIPV6 > 28 */) {
			return LARGE;
		}
		// Mayor o igual /14 y menor /11, e ipv6 mayor o igual /28 menor /26
		else if (prefijoIPV4 > 11 /* && barraMaximoIPV6 > 26 */) {
			return EXTRA_LARGE;
		}
		// mayor o igual a /11, e ipv6 mayor o igual a /26
		else if ((prefijoIPV4 <= 11/*
									 * && (barraMaximoIPV6<26 ||
									 * slashsIPV6.equals(" /26"))
									 */)) {
			return MAYOR;
		} else {
			return NONE;
		}
	}

	public static String obtenerCategoriaTexto(int prefijoIPV4, String tipoCliente) {
		if ((tipoCliente.equals("xx-large") || tipoCliente.equals("extra-large") || tipoCliente.equals("small") || tipoCliente.equals("medium") || tipoCliente.equals("large") || tipoCliente.equals("small/micro"))) {
			if (prefijoIPV4 == 20) {
				return SMALL;
			} else if (prefijoIPV4 == 19) {
				return MEDIUM;
			} else if (prefijoIPV4 == 16) {
				return LARGE;
			} else if (prefijoIPV4 == 14) {
				return EXTRA_LARGE;
			} else if (prefijoIPV4 == 11) {
				return MAYOR;
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
}
