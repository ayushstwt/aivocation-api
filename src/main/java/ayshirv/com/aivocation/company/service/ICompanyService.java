package ayshirv.com.aivocation.company.service;

import ayshirv.com.aivocation.company.dto.CompanyDto;
import ayshirv.com.aivocation.company.entity.Company;

import java.util.List;

public interface ICompanyService {

    List<CompanyDto> getAllCompanies();
}
