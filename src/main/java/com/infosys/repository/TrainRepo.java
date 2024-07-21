package com.infosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Route;
import com.infosys.entity.Train;

@Repository
public interface TrainRepo extends CrudRepository<Train, Integer>{

	
	@Query(value = "select * from train t where t.id =?1", nativeQuery = true)
	List<Train> getTrainDetailsById(Integer id);

	@Query(value = "select * from train where id in(with rws as (\r\n" + 
			"  select trainlist str from ROUTE where DESTINATION =?2 and \r\n" + 
			"SOURCE=?1\r\n" + 
			")\r\n" + 
			"  select regexp_substr (\r\n" + 
			"           str,\r\n" + 
			"           '[^,]+',\r\n" + 
			"           1,\r\n" + 
			"           level\r\n" + 
			"         ) value\r\n" + 
			"  from   rws\r\n" + 
			"  connect by level <= \r\n" + 
			"    length ( trim ( both ',' from str ) ) - \r\n" + 
			"    length ( replace ( str, ',' ) ) + 1)", nativeQuery = true)
	List<Train> getTrainDetailsById(String source, String destination);


	
}
