package pl.malinowski.cpuinfo.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.malinowski.cpuinfo.db.entity.CpuInfoEntity;

@Repository
public interface CpuInfoRepository extends JpaRepository<CpuInfoEntity, Long> {

}
