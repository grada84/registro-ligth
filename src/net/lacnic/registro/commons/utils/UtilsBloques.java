package net.lacnic.registro.commons.utils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import net.lacnic.domain.mysql.BlocosIP;
import net.ripe.ipresource.IpRange;
import net.ripe.ipresource.IpResourceSet;
import net.ripe.ipresource.Ipv4Address;
import net.ripe.ipresource.Ipv6Address;

public class UtilsBloques {

	public static BigInteger conversorIPv6 = new BigInteger("18446744073709551616");

	public static IpRange formatBloque(BlocosIP blocoIp) {
		return UtilsBloques.formatBloque(blocoIp.getVersion(), blocoIp.getIpIncial(), blocoIp.getIpFinal());
	}

	public static IpRange formatBloque(int version, BigInteger ipInicial, BigInteger ipFinal) {
		IpRange iprange;
		BigInteger ipini;
		BigInteger ipfin;
		if (version == 4) {
			ipini = ipInicial;
			ipfin = ipFinal;
			Ipv4Address ipv4ini = new Ipv4Address(ipini.longValue());
			Ipv4Address ipv4fin = new Ipv4Address(ipfin.longValue());
			iprange = IpRange.range(ipv4ini, ipv4fin);
		} else {
			ipini = ipInicial;
			ipfin = ipFinal;
			ipini = ipini.multiply(conversorIPv6);
			ipfin = ipfin.add(BigInteger.ONE);
			ipfin = ipfin.multiply(conversorIPv6);
			ipfin = ipfin.subtract(BigInteger.ONE);
			Ipv6Address ipv6ini = new Ipv6Address(ipini);
			Ipv6Address ipv6fin = new Ipv6Address(ipfin);
			iprange = IpRange.range(ipv6ini, ipv6fin);
		}
		return iprange;
	}
	
	public static IpRange parseBloque(int version, BigInteger ipInicial, BigInteger ipFinal) {
		IpRange iprange;
		if (version == 4) {
			Ipv4Address ipv4ini = new Ipv4Address(ipInicial.longValue());
			Ipv4Address ipv4fin = new Ipv4Address(ipFinal.longValue());
			iprange = IpRange.range(ipv4ini, ipv4fin);
		} else {
			Ipv6Address ipv6ini = new Ipv6Address(ipInicial);
			Ipv6Address ipv6fin = new Ipv6Address(ipFinal);
			iprange = IpRange.range(ipv6ini, ipv6fin);
		}
		return iprange;
	}

	/* -- OPCIONES ESTADO BLOQUES --*/
	public static final String ESTADO_BLOQUES_ALLOCATED = "allocated";
	public static final String ESTADO_BLOQUES_ASSIGNED = "assigned";
	public static final String ESTADO_BLOQUES_RE_ALLOCATED = "re-allocated";
	public static final String ESTADO_BLOQUES_RE_ASSIGNED = "re-assigned";
	
	private static final String[] OPCIONES_ESTADO_BLOQUES = new String[] { ESTADO_BLOQUES_ALLOCATED, ESTADO_BLOQUES_ASSIGNED, ESTADO_BLOQUES_RE_ALLOCATED, "Estado 3", ESTADO_BLOQUES_RE_ASSIGNED };

	public static String[] getOpcionesEstadoBloques() {
		return OPCIONES_ESTADO_BLOQUES;
	}

	public static List<String> getOpcionesEstadoBloquesList() {
		return Arrays.asList(OPCIONES_ESTADO_BLOQUES);
	}

	public static int getOpcionEstadoBloques(String opcion) {
		for (int i = 0; i < OPCIONES_ESTADO_BLOQUES.length; i++) {
			if(OPCIONES_ESTADO_BLOQUES[i].compareTo(opcion)==0) return i;
		}
		
		return -1;
	}

	public static String getOpcionEstadoBloques(long pOpcion) {
		int opcion = BigInteger.valueOf(pOpcion).intValue();
		return OPCIONES_ESTADO_BLOQUES[opcion];
	}
	/* -- OPCIONES ESTADO BLOQUES --*/
	
	
//	public static void main(String[] args)
//	{
//		IpResourceSet miip1 = IpResourceSet.parse("179.27.32.0/18");
//		IpResourceSet miip2 = IpResourceSet.parse("179.27.64.0/19");
//		miip1.addAll(miip2);
//		System.out.println(miip1);
//		IpResourceSet miip3 = IpResourceSet.parse("201.217.128.0/19");
//		IpResourceSet miip4 = IpResourceSet.parse("201.217.160.0/19");
//		miip3.addAll(miip4);
//		System.out.println(miip3);
//		IpResourceSet miip5 = IpResourceSet.parse("201.217.0.0/19");
//		IpResourceSet miip6 = IpResourceSet.parse("201.217.32.0/19");
//		miip5.addAll(miip6);
//		System.out.println(miip5);
//		
//		
//		
//	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
