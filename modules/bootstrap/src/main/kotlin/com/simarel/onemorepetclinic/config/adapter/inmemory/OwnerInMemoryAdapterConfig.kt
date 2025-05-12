package com.simarel.onemorepetclinic.config.adapter.inmemory

import com.simarel.onemorepetclinic.adapter.output.inmemory.InMemoryOwnerAdapter
import com.simarel.onemorepetclinic.port.output.owner.FetchAllOwnersPort
import com.simarel.onemorepetclinic.port.output.owner.FetchOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.RemoveOwnerPort
import com.simarel.onemorepetclinic.port.output.owner.SaveOwnerPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OwnerInMemoryAdapterConfig {

    @Bean
    fun inMemoryOwnerAdapter(): InMemoryOwnerAdapter {
        return InMemoryOwnerAdapter()
    }

    @Bean
    fun saveOwnerPort(adapter: InMemoryOwnerAdapter): SaveOwnerPort {
        return adapter.saveOwnerPort()
    }

    @Bean
    fun fetchOwnerPort(adapter: InMemoryOwnerAdapter): FetchOwnerPort {
        return adapter.fetchOwnerPort()
    }

    @Bean
    fun fetchAllOwnersPort(adapter: InMemoryOwnerAdapter): FetchAllOwnersPort {
        return adapter.fetchAllOwnersPort()
    }

    @Bean
    fun removeOwnerPort(adapter: InMemoryOwnerAdapter): RemoveOwnerPort {
        return adapter.removeOwnerPort()
    }
}
