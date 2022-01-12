package zyt.pashwamroo.km;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("zyt.pashwamroo.km");

        noClasses()
            .that()
            .resideInAnyPackage("zyt.pashwamroo.km.service..")
            .or()
            .resideInAnyPackage("zyt.pashwamroo.km.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..zyt.pashwamroo.km.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
