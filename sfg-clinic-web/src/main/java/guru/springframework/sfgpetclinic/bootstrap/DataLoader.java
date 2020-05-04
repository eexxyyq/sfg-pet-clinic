package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType fish = new PetType();
        dog.setName("Fish");
        PetType savedFishPetType = petTypeService.save(fish);


        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Carrot");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Lisa");
        owner2.setLastName("Backlog");

        ownerService.save(owner2);

        System.out.println("LOADING OWNERS...");


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Tourney");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Amanda");
        vet2.setLastName("Kingdom");

        vetService.save(vet2);

        System.out.println("LOADING VETS...");
    }
}
