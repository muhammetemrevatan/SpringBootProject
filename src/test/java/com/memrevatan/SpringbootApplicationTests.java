package com.memrevatan;

import com.memrevatan.data.entity.EmployeeEntity;
import com.memrevatan.data.repository.EmployeeRepository;
import com.memrevatan.test.TestCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class SpringbootApplicationTests /*implements TestCrud*/ {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    @Override
//    public void testList() {
//        List<EmployeeEntity> list = employeeRepository.findAll();
//        // eger sifirdan buyukse liste doludur.
//        assertThat(list).size().isGreaterThan(0);
//    }
//
//    @Test
//    @Override
//    public void testFindById() {
//        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
//        // FirstName alanı Emre Test olan kayıt var mı yok mu onu kontrol ediyoruz.
//        assertEquals("Emre test", employeeEntity.getFirstName());
//    }
//
//    @Test
//    @Override
//    public void testCreate() {
//        EmployeeEntity employeeEntity = EmployeeEntity.
//                builder()
//                .firstName("Emre test")
//                .lastName("vatan test")
//                .emailId("emrevatan@gmail.com")
//                .build();
//        employeeRepository.save(employeeEntity);
//        //nesne null ise assertionError hatasi döndürsün
//        assertNotNull(employeeRepository.findById(1L).get());
//    }
//
//    @Test
//    @Override
//    public void testUpdate() {
//        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
//        employeeEntity.setFirstName("Muhammet Test");
//        employeeRepository.save(employeeEntity);
//        // esit degilse bir sorun olmayacak ama esitse hata fırlatır
//        assertNotEquals("Emre Test", employeeRepository.findById(1L).get().getFirstName());
//    }
//
//    @Test
//    @Override
//    public void testDelete() {
//        employeeRepository.deleteById(1L);
//        assertThat(employeeRepository.existsById(1L)).isFalse();
//    }
}
