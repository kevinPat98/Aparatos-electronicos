package com.uptc.frw.electronicDevices.controller;

import com.uptc.frw.electronicDevices.entity.Repair;
import com.uptc.frw.electronicDevices.services.RepairServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RepairController {
    @Autowired
    private RepairServices repairServices;

    @QueryMapping
    public List<Repair> getReparations() {
        return repairServices.getRepairts();
    }
    @QueryMapping
    public Optional<Repair> getReparationId(@Argument("id") Long id) {
        return repairServices.getRepairt(id);
    }
    @MutationMapping
    public Repair saveReparation(@Argument Long customerId,@Argument Long deviceId,@Argument Repair repairRequest) {
        return repairServices.saveReparation(customerId,deviceId,repairRequest);
    }
    @MutationMapping
    public Repair updateReparation(@Argument Long id, @Argument Repair repairRequest) {
        return repairServices.updateReparation(id, repairRequest);
    }
    @MutationMapping
    public void deleteReparation(@Argument Long id) {
        repairServices.deleteRepair(id);
    }
}
