package com.simarel.onemorepetclinic.config.adapter.inmemory

import com.simarel.onemorepetclinic.adapter.output.inmemory.InMemoryVisitAdapter
import com.simarel.onemorepetclinic.port.output.visit.FetchAllVisitsPort
import com.simarel.onemorepetclinic.port.output.visit.FetchVisitPort
import com.simarel.onemorepetclinic.port.output.visit.RemoveVisitPort
import com.simarel.onemorepetclinic.port.output.visit.SaveVisitPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class VisitInMemoryAdapterConfig {

    @Bean
    fun inMemoryVisitAdapter(): InMemoryVisitAdapter {
        return InMemoryVisitAdapter()
    }

    @Bean
    fun saveVisitPort(adapter: InMemoryVisitAdapter): SaveVisitPort {
        return adapter.saveVisitPort()
    }

    @Bean
    fun fetchVisitPort(adapter: InMemoryVisitAdapter): FetchVisitPort {
        return adapter.fetchVisitPort()
    }

    @Bean
    fun fetchAllVisitsPort(adapter: InMemoryVisitAdapter): FetchAllVisitsPort {
        return adapter.fetchAllVisitsPort()
    }

    @Bean
    fun removeVisitPort(adapter: InMemoryVisitAdapter): RemoveVisitPort {
        return adapter.removeVisitPort()
    }
}
