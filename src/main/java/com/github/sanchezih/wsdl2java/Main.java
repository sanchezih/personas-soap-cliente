package com.github.sanchezih.wsdl2java;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class Main {

	public static void main(final String[] args) throws MalformedURLException, Exception_Exception {

		String endpoint = "http://localhost:8080/personas-soap-service/services/PersonasServiceImplPort";

		URL url = URI.create(endpoint).toURL();

		PersonasServiceImplService service = new PersonasServiceImplService(url);

		PersonasSEI personasSEI = service.getPersonasServiceImplPort();

		/*----------------------------------------------------------------------------*/

		Persona maria = new Persona();
		maria.setNombre("Maria");
		maria.setApellido("Gomez");

		Persona juan = new Persona();
		juan.setNombre("Juan");
		juan.setApellido("Perez");

		// Se agregan personas al conjunto
		personasSEI.addPersona(maria);
		personasSEI.addPersona(juan);

		/*----------------------------------------------------------------------------*/

		// Se obtienen todas las personas del conjunto
		List<Persona> personas = personasSEI.getPersonas();
		for (Persona persona : personas) {
			System.out.println(persona.getNombre());
		}

		/*----------------------------------------------------------------------------*/

	}
}