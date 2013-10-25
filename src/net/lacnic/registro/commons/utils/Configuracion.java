package net.lacnic.registro.commons.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public class Configuracion implements Serializable {

	private static final long serialVersionUID = -7616513013834509366L;
	
//	private static String RUTAARCHIVOCONFIGURACION = getJbossURI().concat("/conf/conf-email.properties");
//	private static String RUTADATAPORTLETS = getJbossURI().concat("/data/portlets/");
//	private static String JBOSSCONFURI = System.getProperty("jboss.server.home.url").substring(5);
//	private static String RUTAARCHIVOCONFIGURACION = getJbossURI().concat("/conf/conf-email.properties");
	private static String RUTAARCHIVOCONFIGURACION = System.getProperty("jboss.server.config.url").substring(5).concat("/conf-email.properties");;

//	private static String RUTADATAPORTLETS = getJbossURI().concat("/data/portlets/");
	private static String RUTADATAPORTLETS = System.getProperty("jboss.server.data.dir").concat("/portlets/");;

	
//	public static final String getJbossURI() {
//		try {
//			FileInputStream fis = new FileInputStream("/etc/jbosshidden/jboss.properties");
//			Properties properties = new Properties();
//			properties.load(fis);
//			return properties.getProperty("jboss");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
//	public static final String getJbossURI() {
//
//		return JBOSSCONFURI;
//	}
	
	public static final FileInputStream getConfigEmail() {
		try {
			return new FileInputStream(RUTAARCHIVOCONFIGURACION);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static final String getServidorSMTP() {
		try {
			FileInputStream fis = getConfigEmail();
			Properties properties = new Properties();
			properties.load(fis);
			return properties.getProperty("email.smtp.server");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static final String getUsuarioSMTP() {
		try {
			FileInputStream fis = getConfigEmail();
			Properties properties = new Properties();
			properties.load(fis);
			return properties.getProperty("email.smtp.usr");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static final String getPassSMTP() {
		try {
			FileInputStream fis = getConfigEmail();
			Properties properties = new Properties();
			properties.load(fis);
			return properties.getProperty("email.smtp.pass");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static final String getRemitenteEstandar() {
		try {
			FileInputStream fis = getConfigEmail();
			Properties properties = new Properties();
			properties.load(fis);
			return properties.getProperty("viajes.email.remitenteEstandar");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static final String getURIAeropuerto(){
    	return RUTADATAPORTLETS.concat("AeropuertosMundiales.csv");
	}
	
	public static final String getURIFormatoJRSolViaticosViajes(boolean conNombre){
		String ruta = RUTADATAPORTLETS.concat("formatos/");
		
		if(conNombre)
			return ruta.concat("solViaticosViajes.jrxml");
		else
			return ruta;
	}
	
	public static final String getURIFormatoJRInformeViajes(boolean conNombre){
		String ruta = RUTADATAPORTLETS.concat("formatos/");
		
		if(conNombre)
			return ruta.concat("informeViaje.jrxml");
		else
			return ruta;
	}
	
	public static final String getURIListas(){
		return RUTADATAPORTLETS.concat("listas/");
	}
	
	public static final String getURIModeloViaticosViejo(){
		return RUTADATAPORTLETS.concat("MODELO_informe_viaticos.xls");
	}
}
