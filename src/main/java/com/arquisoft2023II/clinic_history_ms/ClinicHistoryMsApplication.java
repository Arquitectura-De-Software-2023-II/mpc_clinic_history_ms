package com.arquisoft2023II.clinic_history_ms;

import com.arquisoft2023II.clinic_history_ms.model.*;
import com.arquisoft2023II.clinic_history_ms.repository.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class ClinicHistoryMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicHistoryMsApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PetRepository repository, MongoTemplate mongoTemplate){
		return args -> {
			List<Disease> diseases = List.of(
					new Disease(
							"disease5",
							LocalDateTime.now(),
							"lorem ipsum"
					),
					new Disease(
							"disease2",
							LocalDateTime.now(),
							"lorem ipsum"
					),
					new Disease(
							"disease3",
							LocalDateTime.now(),
							"lorem ipsum"
					)

			);
			List<Vaccine> vaccines = List.of(
					new Vaccine(
							"vaccine1",
							LocalDateTime.now(),
							"lorem ipsum",
							5
					),
					new Vaccine(
							"vaccine5",
							LocalDateTime.now(),
							"lorem ipsum",
							5
					),
					new Vaccine(
							"vaccine2",
							LocalDateTime.now(),
							"lorem ipsum",
							5
					)
			);

			PetInfo petInfo = new PetInfo(
					9.5f,
					5,
					diseases,
					vaccines
			);
			List<VeterinaryAppointment> veterinaryAppointments = List.of(
					new VeterinaryAppointment(
							LocalDateTime.now(),
							"dr2id",
							"lorem ipsum"
					),
					new VeterinaryAppointment(
							LocalDateTime.now().minusDays(1),
							"dr1id",
							"lorem ipsum"
					),
					new VeterinaryAppointment(
							LocalDateTime.now().minusMonths(1),
							"dr5id",
							"lorem ipsum"
					)
			);
			String usersDBId = "pet4";
			Pet pet = new Pet(
					usersDBId,
					petInfo,
					veterinaryAppointments
			);

			//UsingMongoTemplateAndQuery(repository, mongoTemplate, usersDBId, pet);
			repository.findPetByUsersDBId(usersDBId)
					.ifPresentOrElse(
							pet1 -> {
								System.out.println("pet already exists:");
								System.out.println(pet1.toString());
							},
							() -> {
								repository.insert(pet);
								System.out.println("pet inserted");
							}
					);
		};
	}

	private static void UsingMongoTemplateAndQuery(PetRepository repository, MongoTemplate mongoTemplate, String usersDBId, Pet pet) {
		Query query = new Query();
		query.addCriteria(Criteria.where("usersDBId").is(usersDBId));

		List<Pet> pets = mongoTemplate.find(query, Pet.class);

		if(pets.size() > 1){
			throw new IllegalStateException("there are more than one pet with the same usersDBId: '" + usersDBId +"'");
		}
		if(pets.isEmpty()){
			repository.insert(pet);
			System.out.println("pet inserted");
		}
		else {
			System.out.println("pet already exists:");
			System.out.println(pets.toString());
		}
	}

	@GetMapping("/")
	public GreetResponse greet(){
		return new GreetResponse("hello");
	}

	record GreetResponse(String greet){}
}
