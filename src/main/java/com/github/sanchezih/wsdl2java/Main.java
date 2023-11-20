package com.github.sanchezih.wsdl2java;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Main {

	public static void main(final String[] args) throws MalformedURLException, Exception_Exception {

		final String endpoint = "http://localhost:8080/personas-soap-service/services/PersonasServiceImplPort";

		final URL url = URI.create(endpoint).toURL();

		final PersonasServiceImplService service = new PersonasServiceImplService(url);

		final PersonasSEI soap = service.getPersonasServiceImplPort();

		Persona persona = soap.getPersona("Juan");

		System.out.println("El apellido es: " + persona.apellido);

	}
}