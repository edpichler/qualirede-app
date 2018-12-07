package com.qualirede;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

/**
 * @author Eduardo
 */
@SpringBootApplication()
public class QualiredeApplication {

    public static void main(String[] args) {
        SpringApplication.run(QualiredeApplication.class, args);
//        checkIfAdminExists();
    }

//    private static UserRepository repo;
//
//    @Autowired
//    public void setRepository(UserRepository param) {
//        this.repo = param;
//    }
//    private static MongoTemplate template;
//
//    @Autowired
//    public void setMongoTemplate(MongoTemplate param) {
//        this.template = param;
//    }
//
//    /**
//     * Checks if at least one user with ADMIN role exists, if not, one is created.
//     * PS: I know that this is the most beautiful place to put this method. But I am doing here to keep it simple.
//     **/
//    private static void checkIfAdminExists() {
//        final Optional<User> found = repo.findFirstByPerfil(Perfil.ADMIN);
//        if (found.isPresent() == false) {
//            //creates an ADMIN user.
//            User admin = new User();
//            admin.setEmail("admin@qualirede.com");
//            admin.setSenha("admin");
//            admin.setPerfil(Perfil.ADMIN);
//            admin.setNome("Admin qualirede");
//            admin.setEndereco("Endereço...");
//            repo.save(admin);
//            System.out.println("####################");
//            System.out.println("");
//            System.out.println("An admin user was created, use this credentials: \n - User: " + admin.getEmail());
//            System.out.println(" - Password: " + admin.getSenha());
//        }
//    }
}