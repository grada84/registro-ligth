package net.lacnic.registro.commons.utils;

import static net.ripe.ipresource.IpResource.parse;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.lacnic.domain.mysql.AutonomousSystem;
import net.lacnic.domain.mysql.AutonomousSystemAllLACNIC;
import net.lacnic.domain.mysql.BlocosIP;
import net.lacnic.domain.mysql.BlocosIPArin;
import net.lacnic.exception.UtilsBusinessException;
import net.ripe.ipresource.Asn;
import net.ripe.ipresource.IpRange;
import net.ripe.ipresource.IpResource;
import net.ripe.ipresource.IpResourceSet;
import net.ripe.ipresource.Ipv4Address;
import net.ripe.ipresource.Ipv6Address;

public class Convertidor {

	public Convertidor() {
	}

	public static IpResourceSet convertListBlocosIPInIpResourceSet(List<BlocosIP> listaBlocosIP) throws UtilsBusinessException {
		try {
			IpResourceSet resourcesLacnic = new IpResourceSet();
			for (int xx = 0; xx < listaBlocosIP.size(); xx++) {
				IpRange iprange = null;
				BigInteger ipini = null;
				BigInteger ipfin = null;
				if (listaBlocosIP.get(xx).getVersion() == 4) {
					ipini = listaBlocosIP.get(xx).getIpIncial();
					ipfin = listaBlocosIP.get(xx).getIpFinal();
					Ipv4Address ipv4ini = new Ipv4Address(ipini);
					Ipv4Address ipv4fin = new Ipv4Address(ipfin);
					iprange = IpRange.range(ipv4ini, ipv4fin);
				} else {
					BigInteger conversor = new BigInteger("18446744073709551616");
					ipini = listaBlocosIP.get(xx).getIpIncial();
					ipfin = listaBlocosIP.get(xx).getIpFinal();
					ipini = ipini.multiply(conversor);
					ipfin = ipfin.add(BigInteger.ONE);
					ipfin = ipfin.multiply(conversor);
					ipfin = ipfin.subtract(BigInteger.ONE);
					Ipv6Address ipv6ini = new Ipv6Address(ipini);
					Ipv6Address ipv6fin = new Ipv6Address(ipfin);
					iprange = IpRange.range(ipv6ini, ipv6fin);
				}
				resourcesLacnic.add(iprange);
			}
			return resourcesLacnic;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UtilsBusinessException(e);
		}
	}

	public static IpResourceSet convertListBlocosObjectIPInIpResourceSet(List<Object[]> listaBlocosIP) throws UtilsBusinessException {
		try {

			/**
			 * [0]= version, [1]= ip ini, [2]= ip fin
			 */
			IpResourceSet resourcesLacnic = new IpResourceSet();
			int size = listaBlocosIP.size();
			for (int xx = 0; xx < size; xx++) {
				IpRange iprange = null;
				BigInteger ipini = (BigInteger) listaBlocosIP.get(xx)[1];
				BigInteger ipfin = (BigInteger) listaBlocosIP.get(xx)[2];
				if ((Integer) listaBlocosIP.get(xx)[0] == 4) {

					Ipv4Address ipv4ini = new Ipv4Address(ipini);
					Ipv4Address ipv4fin = new Ipv4Address(ipfin);
					iprange = IpRange.range(ipv4ini, ipv4fin);
				} else {
					BigInteger conversor = new BigInteger("18446744073709551616");
					ipini = ipini.multiply(conversor);
					ipfin = ipfin.add(BigInteger.ONE);
					ipfin = ipfin.multiply(conversor);
					ipfin = ipfin.subtract(BigInteger.ONE);
					Ipv6Address ipv6ini = new Ipv6Address(ipini);
					Ipv6Address ipv6fin = new Ipv6Address(ipfin);
					iprange = IpRange.range(ipv6ini, ipv6fin);
				}
				resourcesLacnic.add(iprange);
			}
			return resourcesLacnic;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UtilsBusinessException(e);
		}
	}

	public static List<IpResource> convertListBlocosObjectIPInListIpResource(List<Object[]> listaBlocosIP) throws UtilsBusinessException {
		try {

			/**
			 * [0]= version, [1]= ip ini, [2]= ip fin
			 */
			ArrayList<IpResource> ipResources = new ArrayList<IpResource>();

			// IpResourceSet resourcesLacnic = new IpResourceSet();
			int size = listaBlocosIP.size();
			for (int xx = 0; xx < size; xx++) {
				IpRange iprange = null;
				BigInteger ipini = (BigInteger) listaBlocosIP.get(xx)[1];
				BigInteger ipfin = (BigInteger) listaBlocosIP.get(xx)[2];
				if ((Integer) listaBlocosIP.get(xx)[0] == 4) {

					Ipv4Address ipv4ini = new Ipv4Address(ipini);
					Ipv4Address ipv4fin = new Ipv4Address(ipfin);
					iprange = IpRange.range(ipv4ini, ipv4fin);
				} else {
					BigInteger conversor = new BigInteger("18446744073709551616");
					ipini = ipini.multiply(conversor);
					ipfin = ipfin.add(BigInteger.ONE);
					ipfin = ipfin.multiply(conversor);
					ipfin = ipfin.subtract(BigInteger.ONE);
					Ipv6Address ipv6ini = new Ipv6Address(ipini);
					Ipv6Address ipv6fin = new Ipv6Address(ipfin);
					iprange = IpRange.range(ipv6ini, ipv6fin);
				}
				ipResources.add(iprange);
			}
			return ipResources;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UtilsBusinessException(e);
		}
	}

	public static List<Object[]> convertListBlocosObjectIPInListIpResourceConPais(List<Object[]> listaBlocosIP) throws UtilsBusinessException {
		try {

			/**
			 * [0]= version, [1]= ip ini, [2]= ip fin
			 */
			ArrayList<Object[]> ipResourcesyPais = new ArrayList<Object[]>();

			// IpResourceSet resourcesLacnic = new IpResourceSet();
			int size = listaBlocosIP.size();
			for (int xx = 0; xx < size; xx++) {
				IpRange iprange = null;
				BigInteger ipini = (BigInteger) listaBlocosIP.get(xx)[1];
				BigInteger ipfin = (BigInteger) listaBlocosIP.get(xx)[2];
				if ((Integer) listaBlocosIP.get(xx)[0] == 4) {

					Ipv4Address ipv4ini = new Ipv4Address(ipini);
					Ipv4Address ipv4fin = new Ipv4Address(ipfin);
					iprange = IpRange.range(ipv4ini, ipv4fin);
				} else {
					BigInteger conversor = new BigInteger("18446744073709551616");
					ipini = ipini.multiply(conversor);
					ipfin = ipfin.add(BigInteger.ONE);
					ipfin = ipfin.multiply(conversor);
					ipfin = ipfin.subtract(BigInteger.ONE);
					Ipv6Address ipv6ini = new Ipv6Address(ipini);
					Ipv6Address ipv6fin = new Ipv6Address(ipfin);
					iprange = IpRange.range(ipv6ini, ipv6fin);
				}
				Object[] obj = new Object[2];
				obj[0] = listaBlocosIP.get(xx)[3];
				obj[1] = (iprange);
				ipResourcesyPais.add(obj);
			}
			return ipResourcesyPais;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UtilsBusinessException(e);
		}
	}

	public static IpResourceSet convertListBlocosIPArinInIpResourceSet(List<BlocosIPArin> listaBlocosIP) throws UtilsBusinessException {
		try {
			IpResourceSet resourcesLacnic = new IpResourceSet();
			for (int xx = 0; xx < listaBlocosIP.size(); xx++) {
				IpRange iprange = null;
				BigInteger ipini = null;
				BigInteger ipfin = null;
				if (listaBlocosIP.get(xx).getVersion() == 4) {
					ipini = listaBlocosIP.get(xx).getIpIncial();
					ipfin = listaBlocosIP.get(xx).getIpFinal();
					Ipv4Address ipv4ini = new Ipv4Address(ipini);
					Ipv4Address ipv4fin = new Ipv4Address(ipfin);
					iprange = IpRange.range(ipv4ini, ipv4fin);
				} else {
					BigInteger conversor = new BigInteger("18446744073709551616");
					ipini = listaBlocosIP.get(xx).getIpIncial();
					ipfin = listaBlocosIP.get(xx).getIpFinal();
					ipini = ipini.multiply(conversor);
					ipfin = ipfin.add(BigInteger.ONE);
					ipfin = ipfin.multiply(conversor);
					ipfin = ipfin.subtract(BigInteger.ONE);
					Ipv6Address ipv6ini = new Ipv6Address(ipini);
					Ipv6Address ipv6fin = new Ipv6Address(ipfin);
					iprange = IpRange.range(ipv6ini, ipv6fin);
				}
				resourcesLacnic.add(iprange);
			}
			return resourcesLacnic;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UtilsBusinessException(e);
		}
	}

	public static IpResourceSet convertListObjectIPsIpResourceSet(List<Object[]> listaBlocosIP) throws UtilsBusinessException {
		try {
			IpResourceSet resourcesLacnic = new IpResourceSet();
			for (int xx = 0; xx < listaBlocosIP.size(); xx++) {
				IpRange iprange = null;
				BigInteger ipini = null;
				BigInteger ipfin = null;
				ipini = (BigInteger) listaBlocosIP.get(xx)[1];
				ipfin = (BigInteger) listaBlocosIP.get(xx)[2];
				if ((Integer) listaBlocosIP.get(xx)[0] == 4) {
					Ipv4Address ipv4ini = new Ipv4Address(ipini);
					Ipv4Address ipv4fin = new Ipv4Address(ipfin);
					iprange = IpRange.range(ipv4ini, ipv4fin);
				} else {
					BigInteger conversor = new BigInteger("18446744073709551616");
					ipini = ipini.multiply(conversor);
					ipfin = ipfin.add(BigInteger.ONE);
					ipfin = ipfin.multiply(conversor);
					ipfin = ipfin.subtract(BigInteger.ONE);
					Ipv6Address ipv6ini = new Ipv6Address(ipini);
					Ipv6Address ipv6fin = new Ipv6Address(ipfin);
					iprange = IpRange.range(ipv6ini, ipv6fin);
				}
				resourcesLacnic.add(iprange);
			}
			return resourcesLacnic;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UtilsBusinessException(e);
		}
	}

	public static IpResourceSet convertASNToIpResourceSet(List<AutonomousSystem> listAsn) throws UtilsBusinessException {
		try {
			IpResourceSet resources = new IpResourceSet();
			int xx = 0;
			int yy = listAsn.size();
			System.out.print(yy);
			for (xx = 0; xx < yy; xx++) {
				BigInteger asn = BigInteger.valueOf(listAsn.get(xx).getId());

				Asn asnAux = new Asn(asn);
				resources.add(parse(asnAux.toString()));
				System.out.print(listAsn.get(xx).getId());
			}
			return resources;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UtilsBusinessException(e);
		}
	}

	public static IpResourceSet convertASNObjectToIpResourceSet(List<Long> listAsn) throws UtilsBusinessException {
		try {
			IpResourceSet resources = new IpResourceSet();
			int xx = 0;
			int yy = listAsn.size();
			System.out.print(yy);
			for (xx = 0; xx < yy; xx++) {
				BigInteger asn = BigInteger.valueOf(listAsn.get(xx));

				Asn asnAux = new Asn(asn);
				resources.add(parse(asnAux.toString()));
				System.out.print(listAsn.get(xx));
			}
			return resources;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UtilsBusinessException(e);
		}
	}

	public static List<IpResource> convertASNObjectToListIpResource(List<Long> listAsn) throws UtilsBusinessException {
		try {
			ArrayList<IpResource> ipResources = new ArrayList<IpResource>();

			// IpResourceSet resources = new IpResourceSet();
			// int xx = 0;
			// int yy = listAsn.size();
			// System.out.print(yy);
			for (long asn : listAsn) {
				// BigInteger asn = BigInteger.valueOf(listAsn.get(xx));
				// Asn asnAux = new Asn(asn);
				ipResources.add(parse("AS" + asn));
				// System.out.print(listAsn.get(xx));
			}
			return ipResources;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UtilsBusinessException(e);
		}
	}

	public static IpResourceSet convertASNAllLACNICToIpResourceSet(List<AutonomousSystemAllLACNIC> listAsn) throws UtilsBusinessException {
		try {
			IpResourceSet resources = new IpResourceSet();
			int xx = 0;
			int yy = listAsn.size();
			System.out.print(yy);
			for (AutonomousSystemAllLACNIC asn : listAsn) {
				resources.add(parse(asn.getAsn()));
			}
			return resources;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UtilsBusinessException(e);
		}
	}

}
