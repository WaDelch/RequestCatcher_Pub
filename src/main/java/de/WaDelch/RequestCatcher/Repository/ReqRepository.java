package de.WaDelch.RequestCatcher.Repository;

import de.WaDelch.RequestCatcher.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;



public interface ReqRepository extends CrudRepository<Request, Long> {
    Request findById(long id);
//    List<Request> findAll();
//    long count();
//    Request save(Request req);
}