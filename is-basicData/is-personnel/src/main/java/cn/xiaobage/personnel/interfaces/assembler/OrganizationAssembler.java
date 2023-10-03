package cn.xiaobage.personnel.interfaces.assembler;

import cn.xiaobage.personnel.domain.organization.entity.Organization;
import cn.xiaobage.personnel.interfaces.dto.OrganizationDTO;

public class OrganizationAssembler {


    public static OrganizationDTO toDTO(Organization employee){
        OrganizationDTO dto = new OrganizationDTO();
        return dto;
    }
}
