package com.primus.server;

import com.primus.server.enumeration.Status;
import com.primus.server.model.Server;
import com.primus.server.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepo serverRepo){
		return args -> {
			serverRepo.save(new Server(null,"192.168.1.160","Ubuntu","16 GB","Personal",
					"http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
			serverRepo.save(new Server(null,"192.168.1.161","Windows","8 GB","Work",
					"http://localhost:8080/server/image/server2.png", Status.SERVER_UP));
			serverRepo.save(new Server(null,"192.168.1.162","Mac","32 GB","Backup",
					"http://localhost:8080/server/image/server3.png", Status.SERVER_DOWN));

		};
	}

}
