//package poly.datn.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import poly.datn.entity.Services;
//import poly.datn.service.IServiceService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/rest")
//public class ServiceController {
//
//    @Autowired
//    IServiceService iServiceService;
//    @PostMapping("/services")
//    public ResponseEntity <Services> create(@ModelAttribute Services services) {
//        return ResponseEntity.ok(iServiceService.save(services));
//    }
//    @GetMapping("/services")
//    public ResponseEntity<List<Services>>  getAll() {
//        return ResponseEntity.ok().body(iServiceService.findAll());
//    }
//    @GetMapping("/services/{id}")
//    public Services getById(@PathVariable("id") Integer id) {
//        return iServiceService.findById(id);
//    }
//
//    @PutMapping("/services/{id}")
//    public ResponseEntity<Services> update(@PathVariable("id") Integer id , @ModelAttribute Services services) {
//        return ResponseEntity.ok(iServiceService.update(services));
//    }
//
//    @PutMapping("/services/delete/{id}")
//    public ResponseEntity<Services> Delete(@PathVariable("id") Integer id ) {
//        Services services = iServiceService.getById(id);
//        return ResponseEntity.ok(iServiceService.update(services));
//    }
//}
