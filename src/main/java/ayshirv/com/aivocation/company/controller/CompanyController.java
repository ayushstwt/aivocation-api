package ayshirv.com.aivocation.company.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @GetMapping(version = "1.0.0")
    public String getCompanyList() {
        return "Company API - Version 1.0.0";
    }
}
