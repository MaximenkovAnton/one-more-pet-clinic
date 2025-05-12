package com.simarel.onemorepetclinic.config.adapter.inmemory

import com.simarel.onemorepetclinic.adapter.output.inmemory.InMemoryVetAdapter
import com.simarel.onemorepetclinic.port.output.vet.FetchAllVetsPort
import com.simarel.onemorepetclinic.port.output.vet.FetchVetPort
import com.simarel.onemorepetclinic.port.output.vet.RemoveVetPort
import com.simarel.onemorepetclinic.port.output.vet.SaveVetPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class VetInMemoryAdapterConfig {

    @Bean
    fun inMemoryVetAdapter(): InMemoryVetAdapter {
        return InMemoryVetAdapter()
    }

    @Bean
    fun saveVetPort(adapter: InMemoryVetAdapter): SaveVetPort {
        return adapter.saveVetPort()
    }

    @Bean
    fun fetchVetPort(adapter: InMemoryVetAdapter): FetchVetPort {
        return adapter.fetchVetPort()
    }

    @Bean
    fun fetchAllVetsPort(adapter: InMemoryVetAdapter): FetchAllVetsPort {
        return adapter.fetchAllVetsPort()
    }

    @Bean
    fun removeVetPort(adapter: InMemoryVetAdapter): RemoveVetPort {
        return adapter.removeVetPort()
    }
}
