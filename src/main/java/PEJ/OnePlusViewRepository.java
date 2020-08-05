package PEJ;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OnePlusViewRepository extends CrudRepository<OnePlusView, Long> {

    List<OnePlusView> findByPrdId(String prdId);

}