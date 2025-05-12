package com.simarel.onemorepetclinic.config.application

import com.simarel.onemorepetclinic.application.usecase.vet.create.CreateVetUseCase
import com.simarel.onemorepetclinic.application.usecase.vet.delete.DeleteVetUseCase
import com.simarel.onemorepetclinic.application.usecase.vet.list.ListVetUseCase
import com.simarel.onemorepetclinic.application.usecase.vet.read.ReadVetUseCase
import com.simarel.onemorepetclinic.application.usecase.vet.update.UpdateVetUseCase
import com.simarel.onemorepetclinic.port.input.vet.CreateVetPort
import com.simarel.onemorepetclinic.port.input.vet.DeleteVetPort
import com.simarel.onemorepetclinic.port.input.vet.ListVetPort
import com.simarel.onemorepetclinic.port.input.vet.ReadVetPort
import com.simarel.onemorepetclinic.port.input.vet.UpdateVetPort
import com.simarel.onemorepetclinic.port.output.vet.FetchAllVetsPort
import com.simarel.onemorepetclinic.port.output.vet.FetchVetPort
import com.simarel.onemorepetclinic.port.output.vet.RemoveVetPort
import com.simarel.onemorepetclinic.port.output.vet.SaveVetPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class VetConfig {

    @Bean
    fun createVetPort(saveVetPort: SaveVetPort): CreateVetPort {
        return CreateVetUseCase(saveVetPort)
    }

    @Bean
    fun deleteVetPort(removeVetPort: RemoveVetPort): DeleteVetPort {
        return DeleteVetUseCase(removeVetPort)
    }

    @Bean
    fun listVetPort(fetchAllVetsPort: FetchAllVetsPort): ListVetPort {
        return ListVetUseCase(fetchAllVetsPort)
    }

    @Bean
    fun readVetPort(fetchVetPort: FetchVetPort): ReadVetPort {
        return ReadVetUseCase(fetchVetPort)
    }

    @Bean
    fun updateVetPort(saveVetPort: SaveVetPort): UpdateVetPort {
        return UpdateVetUseCase(saveVetPort)
    }
}
