package com.simarel.onemorepetclinic.config.application

import com.simarel.onemorepetclinic.application.usecase.pet.create.CreatePetUseCase
import com.simarel.onemorepetclinic.application.usecase.pet.delete.DeletePetUseCase
import com.simarel.onemorepetclinic.application.usecase.pet.list.ListPetUseCase
import com.simarel.onemorepetclinic.application.usecase.pet.read.ReadPetUseCase
import com.simarel.onemorepetclinic.application.usecase.pet.update.UpdatePetUseCase
import com.simarel.onemorepetclinic.port.input.pet.CreatePetPort
import com.simarel.onemorepetclinic.port.input.pet.DeletePetPort
import com.simarel.onemorepetclinic.port.input.pet.ListPetPort
import com.simarel.onemorepetclinic.port.input.pet.ReadPetPort
import com.simarel.onemorepetclinic.port.input.pet.UpdatePetPort
import com.simarel.onemorepetclinic.port.output.pet.FetchAllPetsPort
import com.simarel.onemorepetclinic.port.output.pet.FetchPetPort
import com.simarel.onemorepetclinic.port.output.pet.RemovePetPort
import com.simarel.onemorepetclinic.port.output.pet.SavePetPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PetConfig {

    @Bean
    fun createPetPort(savePetPort: SavePetPort): CreatePetPort {
        return CreatePetUseCase(savePetPort)
    }

    @Bean
    fun deletePetPort(removePetPort: RemovePetPort): DeletePetPort {
        return DeletePetUseCase(removePetPort)
    }

    @Bean
    fun listPetPort(fetchAllPetsPort: FetchAllPetsPort): ListPetPort {
        return ListPetUseCase(fetchAllPetsPort)
    }

    @Bean
    fun readPetPort(fetchPetPort: FetchPetPort): ReadPetPort {
        return ReadPetUseCase(fetchPetPort)
    }

    @Bean
    fun updatePetPort(savePetPort: SavePetPort): UpdatePetPort {
        return UpdatePetUseCase(savePetPort)
    }
}
