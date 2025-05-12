package com.simarel.onemorepetclinic.config.adapter.inmemory

import com.simarel.onemorepetclinic.adapter.output.inmemory.InMemoryPetAdapter
import com.simarel.onemorepetclinic.port.output.pet.FetchAllPetsPort
import com.simarel.onemorepetclinic.port.output.pet.FetchPetPort
import com.simarel.onemorepetclinic.port.output.pet.RemovePetPort
import com.simarel.onemorepetclinic.port.output.pet.SavePetPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PetInMemoryAdapterConfig {

    @Bean
    fun inMemoryPetAdapter(): InMemoryPetAdapter {
        return InMemoryPetAdapter()
    }

    @Bean
    fun savePetPort(adapter: InMemoryPetAdapter): SavePetPort {
        return adapter.savePetPort()
    }

    @Bean
    fun fetchPetPort(adapter: InMemoryPetAdapter): FetchPetPort {
        return adapter.fetchPetPort()
    }

    @Bean
    fun fetchAllPetsPort(adapter: InMemoryPetAdapter): FetchAllPetsPort {
        return adapter.fetchAllPetsPort()
    }

    @Bean
    fun removePetPort(adapter: InMemoryPetAdapter): RemovePetPort {
        return adapter.removePetPort()
    }
}
