package io.github.thudari.aula02sb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.thudari.aula02sb.domain.entity.Cliente;
import io.github.thudari.aula02sb.domain.repository.Clientes;

@SpringBootApplication
public class Aula02sbApplication {
	
	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			clientes.salvar(new Cliente("Dougllas"));
			clientes.salvar(new Cliente("Outro Cliente"));
			
			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Aula02sbApplication.class, args);
	}

}
