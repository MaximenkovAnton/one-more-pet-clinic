package com.simarel.onemorepetclinic.config.application

import com.simarel.onemorepetclinic.application.usecase.visit.create.CreateVisitUseCase
import com.simarel.onemorepetclinic.application.usecase.visit.delete.DeleteVisitUseCase
import com.simarel.onemorepetclinic.application.usecase.visit.list.ListVisitUseCase
import com.simarel.onemorepetclinic.application.usecase.visit.read.ReadVisitUseCase
import com.simarel.onemorepetclinic.application.usecase.visit.update.UpdateVisitUseCase
import com.simarel.onemorepetclinic.port.input.visit.CreateVisitPort
import com.simarel.onemorepetclinic.port.input.visit.DeleteVisitPort
import com.simarel.onemorepetclinic.port.input.visit.ListVisitPort
import com.simarel.onemorepetclinic.port.input.visit.ReadVisitPort
import com.simarel.onemorepetclinic.port.input.visit.UpdateVisitPort
import com.simarel.onemorepetclinic.port.output.visit.FetchAllVisitsPort
import com.simarel.onemorepetclinic.port.output.visit.FetchVisitPort
import com.simarel.onemorepetclinic.port.output.visit.RemoveVisitPort
import com.simarel.onemorepetclinic.port.output.visit.SaveVisitPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class VisitConfig {

    @Bean
    fun createVisitPort(saveVisitPort: SaveVisitPort): CreateVisitPort {
        return CreateVisitUseCase(saveVisitPort)
    }

    @Bean
    fun deleteVisitPort(removeVisitPort: RemoveVisitPort): DeleteVisitPort {
        return DeleteVisitUseCase(removeVisitPort)
    }

    @Bean
    fun listVisitPort(fetchAllVisitsPort: FetchAllVisitsPort): ListVisitPort {
        return ListVisitUseCase(fetchAllVisitsPort)
    }

    @Bean
    fun readVisitPort(fetchVisitPort: FetchVisitPort): ReadVisitPort {
        return ReadVisitUseCase(fetchVisitPort)
    }

    @Bean
    fun updateVisitPort(saveVisitPort: SaveVisitPort): UpdateVisitPort {
        return UpdateVisitUseCase(saveVisitPort)
    }
}
