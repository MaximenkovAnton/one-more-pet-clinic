package com.simarel.onemorepetclinic.config.application

import com.simarel.onemorepetclinic.application.usecase.owner.create.CreateOwnerUseCase
import com.simarel.onemorepetclinic.application.usecase.owner.delete.DeleteOwnerUseCase
import com.simarel.onemorepetclinic.application.usecase.owner.list.ListOwnerUseCase
import com.simarel.onemorepetclinic.application.usecase.owner.read.ReadOwnerUseCase
import com.simarel.onemorepetclinic.application.usecase.owner.update.UpdateOwnerUseCase
import com.simarel.onemorepetclinic.port.input.owner.CreateOwnerPort
import com.simarel.onemorepetclinic.port.input.owner.DeleteOwnerPort
import com.simarel.onemorepetclinic.port.input.owner.ListOwnerPort
import com.simarel.onemorepetclinic.port.input.owner.ReadOwnerPort
import com.simarel.onemorepetclinic.port.input.owner.UpdateOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.FetchAllOwnersPort
import com.simarel.onemorepetclinic.port.output.owner.FetchOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.RemoveOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.SaveOwnerPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OwnerConfig {

    @Bean
    fun createOwnerPort(saveOwnerPort: SaveOwnerPort): CreateOwnerPort {
        return CreateOwnerUseCase(saveOwnerPort)
    }

    @Bean
    fun deleteOwnerPort(removeOwnerPort: RemoveOwnerPort): DeleteOwnerPort {
        return DeleteOwnerUseCase(removeOwnerPort)
    }

    @Bean
    fun listOwnerPort(fetchAllOwnersPort: FetchAllOwnersPort): ListOwnerPort {
        return ListOwnerUseCase(fetchAllOwnersPort)
    }

    @Bean
    fun readOwnerPort(fetchOwnerPort: FetchOwnerPort): ReadOwnerPort {
        return ReadOwnerUseCase(fetchOwnerPort)
    }

    @Bean
    fun updateOwnerPort(saveOwnerPort: SaveOwnerPort): UpdateOwnerPort {
        return UpdateOwnerUseCase(saveOwnerPort)
    }
}
