package net.lacnic.registro.commons.utils;

import java.util.Arrays;
import java.util.List;

public class UtilsEntidades {

	/* -- CODIGO TIPO ENTIDAD -- */
	public static final int COD_NONE = 0;
	public static final int COD_LEGACY = 1;
	public static final int COD_MEMBRO = 2;
	public static final int COD_LEGACY_IPV6 = 3;
	public static final int COD_END_USER_AS = 4;
	public static final int COD_END_USER = 6;
	public static final int COD_END_USER_IPV6 = 6;
	public static final int COD_END_USER_AS_IPV6 = 6;
	public static final int COD_SMALL = 10;
	public static final int COD_MEDIUM = 18;
	public static final int COD_LARGE = 34;
	public static final int COD_EXTRA_LARGE = 66;
	public static final int COD_XX_LARGE = 130;
	public static final int COD_SMALL_MICRO = 258;
	public static final int COD_ACTIVO_B = 512;
	public static final int COD_IPV6 = 518;

	/***
	 * ES IMPORTANTE HAY NUEVAS CATEGORIAS TENEMOS QUE REVISAR TODAS LAS APP QUE
	 * UTILIZAN ESTOS CODIGOS DISTINCT(E.TIPORENOVACAO) 0 NONE 1 legacy 2 ipv6 3
	 * legacy|ipv6 3 legacy 4 end-user-AS 6 end-user 6 end-user|ipv6 6
	 * end-user-AS|ipv6 10 small 18 medium 34 large 66 extra-large 130 xx-large
	 * 258 small/micro 512 activo-b 518 ipv6
	 */

	/** -- TIPO ENTIDAD -- */
	public static final String NONE = "none";
	public static final String LEGACY = "legacy";
	public static final String LEGACY_IPV6 = "legacy|ipv6";
	public static final String ACTIVO_B = "activo-b";
	public static final String SMALL_MICRO = "small/micro";
	public static final String SMALL = "small";
	public static final String MEDIUM = "medium";
	public static final String LARGE = "large";
	public static final String EXTRA_LARGE = "extra-large";
	public static final String XX_LARGE = "xx-large";
	public static final String END_USER = "end-user";
	public static final String END_USER_IPV6 = "end-user|ipv6";
	public static final String END_USER_AS = "end-user-AS";
	public static final String END_USER_AS_IPV6 = "end-user-AS|ipv6";
	public static final String IPV6 = "ipv6";

	/* -- VOTOS ENTIDAD -- */
	public static final int VOTOS_LEGACY_IPV6 = 1;
	public static final int VOTOS_ACTIVO_B = 1;
	public static final int VOTOS_SMALL_MICRO = 1;
	public static final int VOTOS_SMALL = 1;
	public static final int VOTOS_MEDIUM = 2;
	public static final int VOTOS_LARGE = 3;
	public static final int VOTOS_EXTRA_LARGE = 4;
	public static final int VOTOS_XX_LARGE = 5;
	public static final int VOTOS_END_USER = 1;
	public static final int VOTOS_END_USER_AS = 0;
	public static final int VOTOS_END_USER_IPV6 = 1;
	public static final int VOTOS_END_USER_AS_IPV6 = 1;
	public static final int VOTOS_IPV6 = 1;

	/* -- limite para ser considerado moroso -- */
	public static int indiceMorosidad(long tipoRenovacao) {
		if (tipoRenovacao == COD_LEGACY_IPV6 || tipoRenovacao == COD_END_USER_AS || tipoRenovacao == COD_END_USER_IPV6 || tipoRenovacao == COD_END_USER_AS_IPV6 || tipoRenovacao == COD_END_USER || tipoRenovacao == COD_IPV6 || tipoRenovacao == COD_MEMBRO)
			return 50;
		if (tipoRenovacao == COD_SMALL_MICRO)
			return 50;
		if (tipoRenovacao == COD_SMALL)
			return 100;
		if (tipoRenovacao == COD_MEDIUM)
			return 100;
		if (tipoRenovacao == COD_LARGE)
			return 200;
		if (tipoRenovacao == COD_EXTRA_LARGE)
			return 200;
		if (tipoRenovacao == COD_XX_LARGE)
			return 500;

		return 10000;
	}

	public static int indiceMorosidad(String pCategoria) {
		if (esDeCategoria(LEGACY_IPV6, pCategoria))
			return 50;
		if (esDeCategoria(ACTIVO_B, pCategoria))
			return 10000;

		if (esDeCategoria(SMALL_MICRO, pCategoria))
			return 50;
		if (esDeCategoria(SMALL, pCategoria))
			return 50;
		if (esDeCategoria(MEDIUM, pCategoria))
			return 100;
		if (esDeCategoria(LARGE, pCategoria))
			return 100;
		if (esDeCategoria(EXTRA_LARGE, pCategoria))
			return 200;
		if (esDeCategoria(XX_LARGE, pCategoria))
			return 500;

		if (esDeCategoria(END_USER, pCategoria))
			return 50;
		if (esDeCategoria(END_USER_AS, pCategoria))
			return 50;
		if (esDeCategoria(END_USER_IPV6, pCategoria))
			return 50;
		if (esDeCategoria(END_USER_AS_IPV6, pCategoria))
			return 50;

		if (esDeCategoria(IPV6, pCategoria))
			return 50;

		return 1000;
	}

	/* -- TIPO ENTIDAD -- */
//	private static final String[] OPCIONES_CATEGORIAS_VIEJAS = new String[]{XX_LARGE, EXTRA_LARGE, LARGE, MEDIUM, SMALL, SMALL_MICRO, ACTIVO_B, END_USER, END_USER_AS, END_USER_IPV6, END_USER_AS_IPV6, LEGACY, LEGACY_IPV6, IPV6};
	private static final String[] OPCIONES_CATEGORIAS = new String[]{XX_LARGE, EXTRA_LARGE, LARGE, MEDIUM, SMALL, SMALL_MICRO, ACTIVO_B, END_USER, END_USER_AS, LEGACY};

	public static String[] getOpcionesCategorias() {
		return OPCIONES_CATEGORIAS;
	}

	public static List<String> getOpcionesCategoriasList() {
		return Arrays.asList(OPCIONES_CATEGORIAS);
	}
	/* -- TIPO ENTIDAD -- */

	public static boolean esISP(long tipoRenovacao) {
		return tipoRenovacao == COD_SMALL || tipoRenovacao == COD_MEDIUM || tipoRenovacao == COD_LARGE || tipoRenovacao == COD_EXTRA_LARGE || tipoRenovacao == COD_XX_LARGE || tipoRenovacao == COD_SMALL_MICRO;
	}
	public static boolean esEndUser(long tipoRenovacao) {
		return tipoRenovacao == COD_MEMBRO || tipoRenovacao == COD_LEGACY_IPV6 || tipoRenovacao == COD_END_USER || tipoRenovacao == COD_END_USER_AS_IPV6 || tipoRenovacao == COD_IPV6 || tipoRenovacao == COD_END_USER_IPV6;
	}

	public static boolean esActivobLegado(long tipoRenovacao) {
		return tipoRenovacao == COD_NONE || tipoRenovacao == COD_LEGACY || tipoRenovacao == COD_ACTIVO_B;
	}

	/* -- CANTIDAD VOTOS -- */
	public static int getCantidadVotos(String pCategoria) {
		if (esDeCategoria(LEGACY_IPV6, pCategoria))
			return VOTOS_LEGACY_IPV6;
		if (esDeCategoria(ACTIVO_B, pCategoria))
			return VOTOS_ACTIVO_B;
		if (esDeCategoria(SMALL_MICRO, pCategoria))
			return VOTOS_SMALL_MICRO;
		if (esDeCategoria(SMALL, pCategoria))
			return VOTOS_SMALL;
		if (esDeCategoria(MEDIUM, pCategoria))
			return VOTOS_MEDIUM;
		if (esDeCategoria(LARGE, pCategoria))
			return VOTOS_LARGE;
		if (esDeCategoria(EXTRA_LARGE, pCategoria))
			return VOTOS_EXTRA_LARGE;
		if (esDeCategoria(XX_LARGE, pCategoria))
			return VOTOS_XX_LARGE;
		if (esDeCategoria(END_USER, pCategoria))
			return VOTOS_END_USER;
		if (esDeCategoria(END_USER_AS, pCategoria))
			return VOTOS_END_USER_AS;
		if (esDeCategoria(END_USER_IPV6, pCategoria))
			return VOTOS_END_USER_IPV6;
		if (esDeCategoria(END_USER_AS_IPV6, pCategoria))
			return VOTOS_END_USER_AS_IPV6;
		if (esDeCategoria(IPV6, pCategoria))
			return VOTOS_IPV6;

		return 0;
	}

	private static boolean esDeCategoria(String categoria, String pCategoria) {
		return categoria.compareToIgnoreCase(pCategoria) == 0;
	}
	/* -- CANTIDAD VOTOS -- */
	
	public static boolean esISPo3Cliente(String cat)
	{
		if(cat.equals(SMALL_MICRO) || cat.equals(SMALL) || cat.equals(MEDIUM) || cat.equals(LARGE) || cat.equals(EXTRA_LARGE) || cat.equals(XX_LARGE))
		{
			return true;
		}
		else
			return false;
	}
	
	public static boolean esEndUsero3Cliente(String cat)
	{
		if(cat.equals(END_USER) || cat.equals(END_USER_IPV6) || cat.equals(END_USER_AS) || cat.equals(END_USER_AS_IPV6) || cat.equals(IPV6))
		{
			return true;
		}
		else
			return false;
	}
	public static boolean esLegacyo3Cliente(String cat)
	{
		return cat.equals(LEGACY);
	}
	public static boolean esLegacyIPV6o3Cliente(String cat)
	{
		return cat.equals(LEGACY_IPV6);
	}
	
	

}