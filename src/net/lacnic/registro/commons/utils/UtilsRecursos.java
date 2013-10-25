package net.lacnic.registro.commons.utils;

import java.util.Arrays;
import java.util.List;

import net.lacnic.domain.mysql.BlocosIP;
import net.ripe.ipresource.IpRange;

public class UtilsRecursos {

	private boolean[] checkSlash;
	
	public UtilsRecursos(){
		checkSlash = new boolean[32];
	}
	
	private boolean getEstadoSlash(int prefijo){
		if(prefijo == 0) return checkSlash[prefijo];
		
		return checkSlash[prefijo-1];
	}
	private void setEstadoSlash(int prefijo, boolean estado){
		if(prefijo == 0) checkSlash[prefijo] = estado;
		
		checkSlash[prefijo-1] = estado;
	}
	
	public String totalesSlash(List<BlocosIP> listaBlocosIp, int version){		
		if(version == 6) checkSlash = new boolean[128];
		
		for (BlocosIP blocoIp : listaBlocosIp) {
			IpRange rango = UtilsBloques.formatBloque(blocoIp);
			
			if(blocoIp.getVersion() == version)
				totalSlashBloque(rango.getPrefixLength());			
		}
				
		String slashs = "";
		for (int i = 0; i < checkSlash.length-1; i++) {
			if(getEstadoSlash(i)) slashs += " /" + i;
		}
		
		return slashs;
	}

	private void totalSlashBloque(int prefijo) {
		
		if(getEstadoSlash(prefijo)){			
			setEstadoSlash(prefijo, false);
			totalSlashBloque(prefijo-1);			
		}else{			
			setEstadoSlash(prefijo, true);			
		}
	}
	
	public int[][] obtenerCuentaSlashs(List<BlocosIP> lista, int version)
	{
		int[][] mapaSlashs = new int[128][2];
		for(int i=0;i<127;i++)
		{
			mapaSlashs[i] = new int[]{128 - i,0};
		}
		for(int i=0;i<lista.size();i++)
		{
			BlocosIP b = lista.get(i);
			IpRange rango = UtilsBloques.formatBloque(b);
			if(b.getVersion() == version)
				mapaSlashs[128 - rango.getPrefixLength()][1]++;
		}
		return mapaSlashs;
	}
	
	public double totalDireccionesIP(List<BlocosIP> listaBlocosIp , int version){
		double total = 0;
		
		for (BlocosIP blocoIp : listaBlocosIp) {
			IpRange rango = UtilsBloques.formatBloque(blocoIp);
			
			if(blocoIp.getVersion() == version && version == 4)
				total += Math.pow(2,32 - rango.getPrefixLength());
			
			if(blocoIp.getVersion() == version && version == 6)
				total += Math.pow(2,128 - rango.getPrefixLength());
		}
		
		return total;
	}
	
	/* -- OPCIONES LAME DELEGATION --*/
	public static final String DELEGATION_AA = "AA";
	public static final int DELEGATION_COD_AA = 1000;
	public static final String DELEGATION_TIMEOUT = "TIMEOUT";
	public static final int DELEGATION_COD_TIMEOUT = 1100;
	public static final String DELEGATION_NOAA = "NOAA";
	public static final int DELEGATION_COD_NOAA = 1300;
	public static final String DELEGATION_UDN = "UDN";
	public static final int DELEGATION_COD_UDN = 1301;
	public static final String DELEGATION_UH = "UH";
	public static final int DELEGATION_COD_UH = 1302;
	public static final String DELEGATION_FAIL = "FAIL";
	public static final int DELEGATION_COD_FAIL = 1303;
	public static final String DELEGATION_QREFUSED = "QREFUSED";
	public static final int DELEGATION_COD_QREFUSED = 1304;
	public static final String DELEGATION_ERR = "ERR";
	public static final int DELEGATION_COD_ERR = 1305;
	public static final String DELEGATION_CREFUSED = "CREFUSED";
	public static final int DELEGATION_COD_CREFUSED = 1306;
	public static final String DELEGATION_CNAME = "CNAME";
	public static final int DELEGATION_COD_CNAME = 1308;
	public static final String DELEGATION_SOAVER = "SOAVER";
	public static final int DELEGATION_COD_SOAVER = 1309;

	
	private static final String[] OPCIONES_DELEGATION = new String[] { DELEGATION_AA, DELEGATION_TIMEOUT, DELEGATION_NOAA, DELEGATION_UDN, DELEGATION_UH, DELEGATION_FAIL, DELEGATION_QREFUSED, DELEGATION_ERR, DELEGATION_CREFUSED, DELEGATION_CNAME, DELEGATION_SOAVER };

	public static String[] getOpcionesEstadoBloques() {
		return OPCIONES_DELEGATION;
	}

	public static List<String> getOpcionesEstadoBloquesList() {
		return Arrays.asList(OPCIONES_DELEGATION);
	}

	public static String getOpcionDelegation(int pCodigo) {
		switch (pCodigo) {
			case DELEGATION_COD_AA:
				return DELEGATION_AA;
			case DELEGATION_COD_TIMEOUT:
				return DELEGATION_TIMEOUT;
			case DELEGATION_COD_NOAA:
				return DELEGATION_NOAA;
			case DELEGATION_COD_UDN:
				return DELEGATION_UDN;
			case DELEGATION_COD_UH:
				return DELEGATION_UH;
			case DELEGATION_COD_FAIL:
				return DELEGATION_FAIL;
			case DELEGATION_COD_QREFUSED:
				return DELEGATION_QREFUSED;
			case DELEGATION_COD_ERR:
				return DELEGATION_ERR;
			case DELEGATION_COD_CREFUSED:
				return DELEGATION_CREFUSED;
			case DELEGATION_COD_CNAME:
				return DELEGATION_CNAME;
			case DELEGATION_COD_SOAVER:
				return DELEGATION_SOAVER;
				
			default:
				return "ERROR. CONTACT SOFTWARE AREA.";
		}
	}
	/* -- OPCIONES LAME DELEGATION --*/
}
