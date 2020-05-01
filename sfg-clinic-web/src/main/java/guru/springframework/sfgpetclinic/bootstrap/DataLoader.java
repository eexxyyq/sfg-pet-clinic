package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("FIRST_FIRST_NAME");
        owner1.setLastName("FIRST_LAST_NAME");
        owner1.setId(1L);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("SECOND_FIRST_NAME");
        owner2.setLastName("SECOND_LAST_NAME");
        owner2.setId(2L);

        ownerService.save(owner2);

        System.out.println("LOADING OWNERS...");


        Vet vet1 = new Vet();
        vet1.setFirstName("FIRST_FIRST_NAME");
        vet1.setLastName("FIRST_LAST_NAME");
        vet1.setId(1L);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("SECOND_FIRST_NAME");
        vet2.setLastName("SECOND_LAST_NAME");
        vet2.setId(1L);

        vetService.save(vet2);

        System.out.println("LOADING VETS...");
    }
}
