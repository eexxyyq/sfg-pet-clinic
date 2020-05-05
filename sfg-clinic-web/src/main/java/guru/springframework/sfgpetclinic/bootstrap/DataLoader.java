package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Carrot");
        owner1.setAddress("123 Bicker St");
        owner1.setCity("Miami");
        owner1.setTelephone("+10 123 23434");

        Pet johnPet = new Pet();
        johnPet.setPetType(savedDogPetType);
        johnPet.setName("Fluffy");
        johnPet.setBirthDate(LocalDate.now());
        johnPet.setOwner(owner1);
        owner1.getPets().add(johnPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Lisa");
        owner2.setLastName("Backlog");
        owner1.setAddress("123 Bickerer St");
        owner1.setCity("Toronto");
        owner1.setTelephone("+10 123 23434");

        Pet lisaPet = new Pet();
        lisaPet.setPetType(savedCatPetType);
        lisaPet.setName("Kitty");
        lisaPet.setBirthDate(LocalDate.now());
        lisaPet.setOwner(owner2);
        owner2.getPets().add(lisaPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(lisaPet);
        catVisit.setDescription("Kitty visit");

        visitService.save(catVisit);

        System.out.println("LOADING OWNERS...");


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Tourney");
        vet1.getSpecialties().add(savedRadiology);
        vet1.getSpecialties().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Amanda");
        vet2.setLastName("Kingdom");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("LOADING VETS...");
    }
}
